package com.ims.wz.cg.utils;

import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;
public class ExportWord {
    /**
     * 导出word
     * <p>第一步生成替换后的word文件，只支持docx</p>
     * <p>第二步下载生成的文件</p>
     * <p>第三步删除生成的临时文件</p>
     * 模版变量中变量格式：{{foo}}
     * @param templatePath word模板地址
     * @param temDir 生成临时文件存放地址
     * @param fileName 文件名
     * @param params 替换的参数
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public static void exportWord(String templatePath, String temDir, String fileName, Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {

        Assert.notNull(templatePath,"模板路径不能为空");
        Assert.notNull(temDir,"临时文件路径不能为空");
        Assert.notNull(fileName,"导出文件名不能为空");
        if (!temDir.endsWith("/")){
            temDir = temDir + File.separator;
        }
        File dir = new File(temDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(templatePath, params);

            String tmpPath = temDir+fileName+".docx";
            FileOutputStream fos = new FileOutputStream(tmpPath,false);
            doc.write(fos);

            Doc2Pdf.doc2pdf(tmpPath,request,response,fileName,1,temDir);

			doc.close();
			fos.close();
			//res(tmpPath,request,response,fileName,1,temDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            //delFileWord(temDir,fileName+".docx");//这一步看具体需求，要不要删
        }
    }

	public static void res(String worfpath, HttpServletRequest request, HttpServletResponse response,String fileName,int type,String temDir){
		File file = new File(worfpath);
		InputStream in = null;
		try {
			in = new FileInputStream(file);

			response.reset();
			response.setContentType("");
		}catch (Exception e){

		}
	}

    /**
     * 删除零时生成的文件
     */
    public static void delFileWord(String filePath, String fileName){
        File file =new File(filePath+fileName);
        File file1 =new File(filePath);
        file.delete();
        file1.delete();
    }
}
