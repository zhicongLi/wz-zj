package com.ims.wz.cg.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 类描述：    word导出工具类
 * 开发人员：周煜臣
 * 创建时间：2019年5月8日
 * @version
 */
public class WordExport {

    private String tempLocalPath;
    private XWPFDocument xwpfDocument = null;
    private FileInputStream inputStream = null;
    private OutputStream outputStream = null;

	/**
	 * * 替换段落里面的变量 * * @param doc 要替换的文档 * @param params 参数
	 */
	public static void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
		Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
		XWPFParagraph para;
		while (iterator.hasNext()) {
			para = iterator.next();
			replaceInPara(para, params);
		}
	}

	/**
	 * 替换段落里面的变量
	 *
	 * @param para
	 *            要替换的段落
	 * @param params
	 *            参数
	 */
	private static void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
		List<XWPFRun> runs;
		if (matcher(para.getParagraphText()).find()) {
			runs = para.getRuns();
			int start = -1;
			int end = -1;
			String str = "";
			for (int i = 0; i < runs.size(); i++) {
				XWPFRun run = runs.get(i);
				String runText = run.toString();
				if ('$' == runText.charAt(0) && '{' == runText.charAt(1)) {
					start = i;
				}
				if ((start != -1)) {
					str += runText;
				}
				if ('}' == runText.charAt(runText.length() - 1)) {
					if (start != -1) {
						end = i;
						break;
					}
				}
			}
			for (int i = start; i <= end; i++) {
				para.removeRun(i);
				i--;
				end--;
			}
			for (String key : params.keySet()) {
				if (str.equals(key)) {
					para.createRun().setText((String) params.get(key));
					break;
				}
			}
		}
	}

	/** * 替换表格里面的变量 * * @param doc 要替换的文档 * @param params 参数 */
	public static void replaceInTable(XWPFDocument doc, Map<String, Object> params) {
		Iterator<XWPFTable> iterator = doc.getTablesIterator();
		XWPFTable table;
		List<XWPFTableRow> rows;
		List<XWPFTableCell> cells;
		List<XWPFParagraph> paras;
		while (iterator.hasNext()) {
			table = iterator.next();
			rows = table.getRows();
			for (XWPFTableRow row : rows) {
				cells = row.getTableCells();
				for (XWPFTableCell cell : cells) {
					paras = cell.getParagraphs();
					for (XWPFParagraph para : paras) {
						replaceInPara(para, params);
					}
				}
			}
		}
	}

	/** * 正则匹配字符串 * * @param str * @return */
	private static Matcher matcher(String str) {
		Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher;
	}

	 /**
     * 循环填充表格内容
     * @param xwpfDocument
     * @param params
     * @param tableIndex
     * @throws Exception
     */
    private   void insertValueToTable(XWPFDocument xwpfDocument, List<Map<String,String>> params, int tableIndex) throws Exception {
        List<XWPFTable> tableList = xwpfDocument.getTables();
        if(tableList.size()<=tableIndex){
            throw new Exception("tableIndex对应的表格不存在");
        }
        XWPFTable table = tableList.get(tableIndex);
        List<XWPFTableRow> rows = table.getRows();
        if(rows.size()<2){
            throw new Exception("tableIndex对应表格应该为2行");
        }
        //模板的那一行
        XWPFTableRow tmpRow = rows.get(1);
        List<XWPFTableCell> tmpCells = null;
        List<XWPFTableCell> cells = null;
        XWPFTableCell tmpCell = null;
        tmpCells = tmpRow.getTableCells();


        String cellText = null;
        String cellTextKey = null;
        Map<String,Object> totalMap = null;
        for (int i = 0, len = params.size(); i < len; i++) {
            Map<String,String> map = params.get(i);
            // 创建新的一行
            XWPFTableRow row = table.createRow();
            // 获取模板的行高 设置为新一行的行高
            row.setHeight(tmpRow.getHeight());
            cells = row.getTableCells();
            for (int k = 0, klen = cells.size(); k < klen; k++) {
                tmpCell = tmpCells.get(k);
                XWPFTableCell cell = cells.get(k);
                cellText = tmpCell.getText();
                if (StringUtils.isNotBlank(cellText)) {
                    //转换为mapkey对应的字段
                    cellTextKey = cellText.replace("$", "").replace("{", "").replace("}", "");
                    if (map.containsKey(cellTextKey)) {
                        // 填充内容 并且复制模板行的属性
                        setCellText(tmpCell,cell,map.get(cellTextKey));
                    }
                }
            }

        }
        // 删除模版行
        table.removeRow(1);
    }

    /**
     *  复制模板行的属性
     * @param tmpCell
     * @param cell
     * @param text
     * @throws Exception
     */
    private void setCellText(XWPFTableCell tmpCell, XWPFTableCell cell,String text) throws Exception {

        CTTc cttc2 = tmpCell.getCTTc();
        CTTcPr ctPr2 = cttc2.getTcPr();
        CTTc cttc = cell.getCTTc();
        CTTcPr ctPr = cttc.addNewTcPr();
        if (ctPr2.getTcW() != null) {
            ctPr.addNewTcW().setW(ctPr2.getTcW().getW());
        }
        if (ctPr2.getVAlign() != null) {
            ctPr.addNewVAlign().setVal(ctPr2.getVAlign().getVal());
        }
        if (cttc2.getPList().size() > 0) {
            CTP ctp = cttc2.getPList().get(0);
            if (ctp.getPPr() != null) {
                if (ctp.getPPr().getJc() != null) {
                    cttc.getPList().get(0).addNewPPr().addNewJc()
                            .setVal(ctp.getPPr().getJc().getVal());
                }
            }
        }

        XWPFParagraph tmpP = tmpCell.getParagraphs().get(0);
        XWPFParagraph cellP = cell.getParagraphs().get(0);
        XWPFRun tmpR = null;
        if (tmpP.getRuns() != null && tmpP.getRuns().size() > 0) {
            tmpR = tmpP.getRuns().get(0);
        }
        XWPFRun cellR = cellP.createRun();
        cellR.setText(text);
        // 复制字体信息
        if (tmpR != null) {
                if(!cellR.isBold()){
                    cellR.setBold(tmpR.isBold());
                }
                cellR.setItalic(tmpR.isItalic());
                cellR.setUnderline(tmpR.getUnderline());
                cellR.setColor(tmpR.getColor());
                cellR.setTextPosition(tmpR.getTextPosition());
                if (tmpR.getFontSize() != -1) {
                    cellR.setFontSize(tmpR.getFontSize());
                }
                if (tmpR.getFontFamily() != null) {
                    cellR.setFontFamily(tmpR.getFontFamily());
                }
                if (tmpR.getCTR() != null) {
                    if (tmpR.getCTR().isSetRPr()) {
                        CTRPr tmpRPr = tmpR.getCTR().getRPr();
                        if (tmpRPr.isSetRFonts()) {
                            CTFonts tmpFonts = tmpRPr.getRFonts();
                            CTRPr cellRPr = cellR.getCTR().isSetRPr() ? cellR
                                    .getCTR().getRPr() : cellR.getCTR().addNewRPr();
                            CTFonts cellFonts = cellRPr.isSetRFonts() ? cellRPr
                                    .getRFonts() : cellRPr.addNewRFonts();
                            cellFonts.setAscii(tmpFonts.getAscii());
                            cellFonts.setAsciiTheme(tmpFonts.getAsciiTheme());
                            cellFonts.setCs(tmpFonts.getCs());
                            cellFonts.setCstheme(tmpFonts.getCstheme());
                            cellFonts.setEastAsia(tmpFonts.getEastAsia());
                            cellFonts.setEastAsiaTheme(tmpFonts.getEastAsiaTheme());
                            cellFonts.setHAnsi(tmpFonts.getHAnsi());
                            cellFonts.setHAnsiTheme(tmpFonts.getHAnsiTheme());
                        }
                    }
                }

        }
        // 复制段落信息
        cellP.setAlignment(tmpP.getAlignment());
        cellP.setVerticalAlignment(tmpP.getVerticalAlignment());
        cellP.setBorderBetween(tmpP.getBorderBetween());
        cellP.setBorderBottom(tmpP.getBorderBottom());
        cellP.setBorderLeft(tmpP.getBorderLeft());
        cellP.setBorderRight(tmpP.getBorderRight());
        cellP.setBorderTop(tmpP.getBorderTop());
        cellP.setPageBreak(tmpP.isPageBreak());
        if (tmpP.getCTP() != null) {
            if (tmpP.getCTP().getPPr() != null) {
                CTPPr tmpPPr = tmpP.getCTP().getPPr();
                CTPPr cellPPr = cellP.getCTP().getPPr() != null ? cellP
                        .getCTP().getPPr() : cellP.getCTP().addNewPPr();
                // 复制段落间距信息
                CTSpacing tmpSpacing = tmpPPr.getSpacing();
                if (tmpSpacing != null) {
                    CTSpacing cellSpacing = cellPPr.getSpacing() != null ? cellPPr
                            .getSpacing() : cellPPr.addNewSpacing();
                    if (tmpSpacing.getAfter() != null) {
                        cellSpacing.setAfter(tmpSpacing.getAfter());
                    }
                    if (tmpSpacing.getAfterAutospacing() != null) {
                        cellSpacing.setAfterAutospacing(tmpSpacing
                                .getAfterAutospacing());
                    }
                    if (tmpSpacing.getAfterLines() != null) {
                        cellSpacing.setAfterLines(tmpSpacing.getAfterLines());
                    }
                    if (tmpSpacing.getBefore() != null) {
                        cellSpacing.setBefore(tmpSpacing.getBefore());
                    }
                    if (tmpSpacing.getBeforeAutospacing() != null) {
                        cellSpacing.setBeforeAutospacing(tmpSpacing
                                .getBeforeAutospacing());
                    }
                    if (tmpSpacing.getBeforeLines() != null) {
                        cellSpacing.setBeforeLines(tmpSpacing.getBeforeLines());
                    }
                    if (tmpSpacing.getLine() != null) {
                        cellSpacing.setLine(tmpSpacing.getLine());
                    }
                    if (tmpSpacing.getLineRule() != null) {
                        cellSpacing.setLineRule(tmpSpacing.getLineRule());
                    }
                }
                // 复制段落缩进信息
                CTInd tmpInd = tmpPPr.getInd();
                if (tmpInd != null) {
                    CTInd cellInd = cellPPr.getInd() != null ? cellPPr.getInd()
                            : cellPPr.addNewInd();
                    if (tmpInd.getFirstLine() != null) {
                        cellInd.setFirstLine(tmpInd.getFirstLine());
                    }
                    if (tmpInd.getFirstLineChars() != null) {
                        cellInd.setFirstLineChars(tmpInd.getFirstLineChars());
                    }
                    if (tmpInd.getHanging() != null) {
                        cellInd.setHanging(tmpInd.getHanging());
                    }
                    if (tmpInd.getHangingChars() != null) {
                        cellInd.setHangingChars(tmpInd.getHangingChars());
                    }
                    if (tmpInd.getLeft() != null) {
                        cellInd.setLeft(tmpInd.getLeft());
                    }
                    if (tmpInd.getLeftChars() != null) {
                        cellInd.setLeftChars(tmpInd.getLeftChars());
                    }
                    if (tmpInd.getRight() != null) {
                        cellInd.setRight(tmpInd.getRight());
                    }
                    if (tmpInd.getRightChars() != null) {
                        cellInd.setRightChars(tmpInd.getRightChars());
                    }
                }
            }
        }
    }

    /**
     *  收尾方法
     * @param outDocPath
     * @return
     * @throws IOException
     */
    public boolean generate(String outDocPath) throws IOException{
        outputStream = new FileOutputStream(outDocPath);
        xwpfDocument.write(outputStream);
        this.close(inputStream,outputStream);
        return true;
    }

	/**
	 * 方法描述：   流关闭
	 * 开发人员：周煜臣
	 * 创建时间：2019年5月8日
	 * @param is  输入流
	 * @param os  输出流
	 */
	public static void close(InputStream is,OutputStream os){
		//关闭输入流
		if(is!=null){
			try{
				is.close();
			}catch(Exception e){

			}
		}
		//关闭输出流
		if(os!=null){
			try{
				os.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
