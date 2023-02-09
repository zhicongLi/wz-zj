package com.ims.wz.cg.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 类描述：    word导出工具类
 * 开发人员：李志聪
 * 创建时间：2019年9月28日
 * @version
 */
public class ExportWordUtil {
	/**
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(ExportWordUtil.class);


	/**
	 * 方法描述：   金属试验委托单word导出
	 * 开发人员：李志聪
	 * 创建时间：2019年9月28日
	 * @param response   输出流
	 */
	public void exportProfessionalExperiment(
			HttpServletResponse response) {

		InputStream is=null;
		OutputStream os =null;
		try{
			Map<String, Object> docparams = new HashMap<String, Object>();
			Map<String, Object> tableparams = new HashMap<String, Object>();
			XWPFDocument doc;
			String filePath = "caigou.docx";
			is = getClass().getClassLoader().getResourceAsStream(filePath);
			doc = new XWPFDocument(is);
			tableparams.put("${purchaser}","123");


			//替换文本变量
			WordExport.replaceInPara(doc, tableparams);
			//替换表格里面的变量
			//WordExport.replaceInTable(doc, tableparams);
		    os = response.getOutputStream();
			response.setContentType("application/vnd.ms-excel");
			// 防止文件名中文时乱码
			String fileName = "123456" + ".docx";
			response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
//			response.setContentType("application/vnd.ms-excel");
			//防止文件名中文时乱码
//			String uncod=URLDecoder.decode(safe.getTitle()+".docx","UTF-8");
//			String fileName = new String(uncod.getBytes("UTF-8"), "iso-8859-1");
//			response.setHeader("Content-disposition","attachment;filename="+fileName);
			doc.write(os);
			os.flush();
			WordExport.close(is,os);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}finally{
			//WordExport.close(is,os);
		}
	}

//	/**
//	 * 方法描述：   技术监督异常情况word导出
//	 * 开发人员：李志聪
//	 * 创建时间：2019年9月28日
//	 * @param professionalExperiment 专业试验实体
//	 * @param response   输出流
//	 */
//	public void exportExceptionWarning(ExceptionWarning exceptionWarning, HttpServletResponse response) {
//		InputStream is=null;
//		OutputStream os =null;
//		try{
//			Map<String, Object> docparams = new HashMap<String, Object>();
//			Map<String, Object> tableparams = new HashMap<String, Object>();
//			XWPFDocument doc;
//			String filePath = "word/ExceptionWarning.docx";
//			is = getClass().getClassLoader().getResourceAsStream(filePath);
//			doc = new XWPFDocument(is);
//			tableparams.put("${identifier}", exceptionWarning.getIdentifier());
//			tableparams.put("${category}", exceptionWarning.getCategory());
//			tableparams.put("${noticeTime}", exceptionWarning.getNoticeTime());
//			tableparams.put("${companyName}", exceptionWarning.getCompanyName());
//			tableparams.put("${equipmentName}", exceptionWarning.getEquipmentName());
//			tableparams.put("${abnormalSituation}", exceptionWarning.getAbnormalSituation());
//			tableparams.put("${consequence}", exceptionWarning.getConsequence());
//			tableparams.put("${rectificationProposals}", exceptionWarning.getRectificationProposals());
//			tableparams.put("${rectificationTime}", exceptionWarning.getRectificationTime());
//			tableparams.put("${proposeCompany}", exceptionWarning.getProposeCompany());
//			tableparams.put("${lessuePeople}", exceptionWarning.getLessuePeople());
//			tableparams.put("${fillPeople}", exceptionWarning.getFillPeople());
//			tableparams.put("${examinePeople}", exceptionWarning.getExaminePeople());
//			//替换文本变量
//			WordExport.replaceInPara(doc, docparams);
//			//替换表格里面的变量
//			WordExport.replaceInTable(doc, tableparams);
//		    os = response.getOutputStream();
//			response.setContentType("application/vnd.ms-excel");
//			// 防止文件名中文时乱码
//			String fileName = "技术监督异常情况预警通知单" + ".docx";
//			response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
////			response.setContentType("application/vnd.ms-excel");
//			//防止文件名中文时乱码
////			String uncod=URLDecoder.decode(safe.getTitle()+".docx","UTF-8");
////			String fileName = new String(uncod.getBytes("UTF-8"), "iso-8859-1");
////			response.setHeader("Content-disposition","attachment;filename="+fileName);
//			doc.write(os);
//			os.flush();
//			WordExport.close(is,os);
//		}catch(Exception e){
//			logger.error(e.getMessage(),e);
//		}
//		//WordExport.close(is,os);
//	}
//	/**
//	 * 方法描述：  定期工作详细word导出
//	 * 开发人员：李志聪
//	 * 创建时间：2019年10月8日
//	 * @param regularWork 定期工作实体
//	 * @param response   输出流
//	 */
//	public void exportRegularWork(RegularWork regularWork, HttpServletResponse response) {
//		InputStream is=null;
//		OutputStream os =null;
//		try{
//			Map<String, Object> docparams = new HashMap<String, Object>();
//			Map<String, Object> tableparams = new HashMap<String, Object>();
//			XWPFDocument doc;
//			String filePath = "word/RegularWork.docx";
//			is = getClass().getClassLoader().getResourceAsStream(filePath);
//			doc = new XWPFDocument(is);
//			tableparams.put("${major}", regularWork.getMajor());
//			tableparams.put("${superviseProject}", regularWork.getSuperviseProject());
//			tableparams.put("${lastTime}", regularWork.getLastTime());
//			tableparams.put("${startPlanTime}", regularWork.getStartPlanTime());
//			tableparams.put("${moneyPlan}", regularWork.getMoneyPlan());
//			tableparams.put("${superviseContent}", regularWork.getSuperviseContent());
//			tableparams.put("${target}", regularWork.getTarget());
//			tableparams.put("${personLiable}", regularWork.getPersonLiable());
//			tableparams.put("${executionTime}", regularWork.getExecutionTime());
//			tableparams.put("${result}", regularWork.getResult());
//			tableparams.put("${remark}", regularWork.getRemark());
//			//替换文本变量
//			WordExport.replaceInPara(doc, docparams);
//			//替换表格里面的变量
//			WordExport.replaceInTable(doc, tableparams);
//		    os = response.getOutputStream();
//			response.setContentType("application/vnd.ms-excel");
//			// 防止文件名中文时乱码
//			String fileName = "定期工作详细" + ".docx";
//			response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
//			doc.write(os);
//			os.flush();
//			WordExport.close(is,os);
//		}catch(Exception e){
//			logger.error(e.getMessage(),e);
//		}
//	}
}
