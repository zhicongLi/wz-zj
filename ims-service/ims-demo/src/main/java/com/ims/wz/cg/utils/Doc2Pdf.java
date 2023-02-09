package com.ims.wz.cg.utils;

import com.aspose.words.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.*;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;

//import static com.ims.et.contract.utils.ExportWord.delFileWord;

public class Doc2Pdf {
	private static String waterMarkName = "江苏能源监管办监制";

   public static boolean getLicense() {
		boolean result = false;
		try {
			InputStream is = Doc2Pdf.class.getClassLoader().getResourceAsStream("license.xml");
			License aposeLic = new License();
			aposeLic.setLicense(is);
			result = true;
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

   public static void doc2pdf(String worfpath, HttpServletRequest request, HttpServletResponse response,String fileName,int type,String temDir) throws Exception {
	   if (!getLicense()) {          // 验证License 若不验证则转化出的pdf文档会有水印产生
		   return;
	   }

	   try {

		   long old = System.currentTimeMillis();
		   Document doc = new Document(worfpath);
		   //sourcerFile是将要被转化的word文档
		   String path=temDir + fileName + ".pdf";
		   File file = new File(path);
		   FileOutputStream fileOutputStream = new FileOutputStream(file);
		   //FontSettings.getDefaultInstance().setFontsFolder("/usr/share/fonts/windows",false);
		   doc.save(fileOutputStream, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
		   fileOutputStream.close();
		   long now = System.currentTimeMillis();
		   System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");  //转化用时
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally  {
		   //delFileWord(temDir,fileName+".docx");//这一步看具体需求，要不要删
	   }
   }


	public static void waterMark(String inputFile,String fileName, String waterMarkName,int type,HttpServletRequest request,HttpServletResponse response) {
		try {
			//切记这里的参数是文件的路径 ，路径必须是双斜杠的如F:\\test.pdf，不能是F:/test.pdf 或者F:\test.pdf
			//inputFile = "D:\\template\\202111015招标文件审查记录.pdf";
			PdfReader reader = new PdfReader(inputFile);
			ServletOutputStream outputStream = response.getOutputStream();
			PdfStamper stamper = new PdfStamper(reader, outputStream);

			BaseFont base = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H",BaseFont.EMBEDDED);
			PdfGState gs = new PdfGState();
			gs.setFillOpacity(0.2f);//改透明度
			gs.setStrokeOpacity(0.4f);
			int total = reader.getNumberOfPages() + 1;

			JLabel label = new JLabel();
			label.setText(waterMarkName);

			PdfContentByte under;
			// 仅添加一个水印
			for (int i = 1; i < total; i++) {
//				under = stamper.getOverContent(i);// 在内容上方加水印
				under = stamper.getUnderContent(i);//在内容下方加水印
				gs.setFillOpacity(0.2f);
				under.setGState(gs);
				under.beginText();
				under.setColorFill(BaseColor.DARK_GRAY);//改变颜色
				under.setFontAndSize(base, 50);//改水印文字大小
				under.setTextMatrix(50, 200);
				//后3个参数，x坐标，y坐标，角度
				under.showTextAligned(Element.ALIGN_CENTER, waterMarkName, 320, 420, 42);

				under.endText();
			}
			String userAgent = request.getHeader("User-Agent");
			String finalName = URLEncoder.encode(fileName, "UTF-8");
			if (userAgent != null) {
				if (userAgent.toLowerCase().indexOf("firefox") > -1) {
					finalName = "=?UTF-8?B?" + new String(Base64.encodeBase64(fileName.getBytes("UTF-8"))) + "?=";
				} else if (userAgent.toLowerCase().indexOf("safari") > -1) {
					finalName = new String(finalName.getBytes("UTF-8"), "ISO8859-1");
				}
			}
			response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.addHeader("Pragma", "no-cache");
			response.addHeader("Expires", "0");
			response.addHeader("charset", "utf-8");
			response.addHeader("Content-Disposition","inline;filename="+finalName+".pdf");
			stamper.close();
			reader.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {

			//delFileWord(inputFile,fileName+".pdf");//这一步看具体需求，要不要删
		}
	}


}
