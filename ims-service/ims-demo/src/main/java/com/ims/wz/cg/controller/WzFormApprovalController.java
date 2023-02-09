/**
 *
 */
package com.ims.wz.cg.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ims.system.auth.ImsPreAuth;
import com.ims.wz.cg.entity.WzPlan;
import com.ims.wz.cg.entity.WzTopics;
import com.ims.wz.cg.service.IWzPlanService;
import com.ims.wz.cg.service.IWzTopicsService;
import com.ims.wz.cg.service.impl.WzFormApprovalServiceImpl;
//import org.apache.xmlbeans.impl.common.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;


import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;

import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;

import com.ims.wz.cg.entity.WzFormApproval;
import com.ims.wz.cg.service.IWzFormApprovalService;

/**
 * wz_form_approvalController
 * @author yx
 * @version 2021-10-20
 */
@Controller
@RequestMapping(value = "/wz/wzFormApproval")
public class WzFormApprovalController extends WebController<IWzFormApprovalService,WzFormApproval> {

	@Autowired
	WzFormApprovalServiceImpl wzFormApprovalService;
	@Autowired
	IWzPlanService wzPlanService;
	@Autowired
	IWzTopicsService wzTopicsService;

	private String fileName;

 	@ImsPreAuth("wz:wzFormApproval:view")
	@RequestMapping(value = "list")
	public String list(WzFormApproval wzFormApproval, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzFormApprovalList";
	}

    @ImsPreAuth("wz:wzFormApproval:view")
	@RequestMapping(value = "form")
	public String form(WzFormApproval wzFormApproval, Model model) {
	    String formView = wzFormApproval.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzFormApprovalForm";
	}

    @ImsPreAuth("wz:wzFormApproval:view")
	@RequestMapping(value = "lov")
	public String lov(WzFormApproval wzFormApproval, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzFormApprovalList";
	}

    @ImsPreAuth("wz:wzFormApproval:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzFormApproval wzFormApproval, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzFormApproval,request,response,model);
	}

    @ImsPreAuth("wz:wzFormApproval:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzFormApproval wzFormApproval, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzFormApproval,request,response,model);
	}

    @ImsPreAuth("wz:wzFormApproval:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzFormApproval wzFormApproval, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzFormApproval,request,response,model);
	}

    @ImsPreAuth("wz:wzFormApproval:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzFormApproval wzFormApproval, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzFormApproval,request,response,model);
	}

    @ImsPreAuth("wz:wzFormApproval:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzFormApproval wzFormApproval, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzFormApproval,request,response,model);
	}

    @ImsPreAuth("wz:wzFormApproval:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzFormApproval wzFormApproval, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzFormApproval,request,response,model);
	}

    @ImsPreAuth("wz:wzFormApproval:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzFormApproval wzFormApproval, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzFormApproval,request,response,model);
	}

    @ImsPreAuth("wz:wzFormApproval:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzFormApproval wzFormApproval, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzFormApproval,request,response,model);
	}

    @ImsPreAuth("wz:wzFormApproval:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzFormApproval wzFormApproval,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzFormApproval,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzFormApproval:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzFormApproval wzFormApproval, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzFormApproval,request,response );
	}

	@RequestMapping(value = "exportWord")
	@ResponseBody
	public String exportWord(HttpServletRequest request,HttpServletResponse response,String id){
		 fileName = null;
		try {
			fileName = wzFormApprovalService.downOrPreviewPDF(request,response,id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

/*	@RequestMapping(value = "readWord")
	@ResponseBody
	public String readWord(HttpServletRequest request,HttpServletResponse response) throws IOException{
		 ServletOutputStream out = null;
		 FileInputStream ips = null;
		 if (fileName.contains("_")){
			 String arr[] = fileName.split("_");
			 if ("1".equals(arr[1])){
				 fileName = arr[0] + ".pdf";
				 String url = "/file/" + fileName;
				 try {
					 File file = new File(url);
					 if (!file.exists()){
						 return null;
					 }
					 ips = new FileInputStream(file);
					 response.setContentType("application/force-download");
					 response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
					 response.setContentLength((int)file.length());
					 out = response.getOutputStream();
					 int len = 0;
					 byte[] buffer = new byte[1024*10];
					 while((len = ips.read(buffer))!=-1){
						 out.write(buffer,0,len);
					 }
					 out.flush();

				 }catch (Exception e){
					 e.printStackTrace();
				 }finally {
					 out.close();
					 ips.close();
				 }
			 }else{
			 	try{
					for (int i = 0; i < 2; i++){
						fileName = arr[i] + ".pdf";
						String url = "/file/" + fileName;
						File file = new File(url);
						if (!file.exists()){
							return null;
						}
						ips = new FileInputStream(file);
						response.setContentType("application/force-download");
						response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
						response.setContentLength((int)file.length());
						out = response.getOutputStream();
						int len = 0;
						byte[] buffer = new byte[1024*10];
						while((len = ips.read(buffer))!=-1){
							out.write(buffer,0,len);
						}
						out.flush();
					}
				}catch(Exception e){
			 		e.printStackTrace();
				}finally {
			 		if(out != null){
			 			out.close();
					}
			 		if(ips != null){
			 			out.close();
					}
				}

			 }
		 }

		 return null;
	}*/

	@RequestMapping(value = "readWord")
	@ResponseBody
	public String readWord(HttpServletRequest request,HttpServletResponse response,String fileNamepdf) throws IOException{
		ServletOutputStream out = null;
		FileInputStream ips = null;
		String fileNamePdf = fileNamepdf + ".pdf";
		try{
			String url = "/file/" + fileNamePdf;
			File file = new File(url);
			if (!file.exists()){
				return null;
			}
			ips = new FileInputStream(file);
			response.setContentType("application/force-download");
			response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileNamePdf,"UTF-8"));
			response.setContentLength((int)file.length());
			out = response.getOutputStream();
			int len = 0;
			byte[] buffer = new byte[1024*10];
			while((len = ips.read(buffer))!=-1){
				out.write(buffer,0,len);
			}
			out.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out != null){
				out.close();
			}
			if(ips != null){
				out.close();
			}
		}
		return null;
	}



	@RequestMapping(value = "saveOrUpdate")
	@ResponseBody
	public Boolean saveOrUpdate(String data){
		WzFormApproval wzFormApproval = JSONObject.parseObject(data,WzFormApproval.class);
		return wzFormApprovalService.saveOrUpdate(wzFormApproval);
	}

	@RequestMapping(value = "stopReason")
	@ResponseBody
	public Boolean stopReason(String id,String reason){
		WzFormApproval wzFormApproval = wzFormApprovalService.get(id);
		wzFormApproval.setStopReason(reason);
		wzFormApproval.setFlag("xmzz");
		wzFormApproval.setFormStatus("xmzz");
		return wzFormApprovalService.saveOrUpdate(wzFormApproval);
	}

	@RequestMapping(value = "checkIsPlan")
	@ResponseBody
	public Boolean checkIsPlan(String planNumber){
		List<WzPlan> list = wzPlanService.getSelectPlan(planNumber);
		WzPlan wzPlan = list.get(0);
		if("2".equals(wzPlan.getIsgenerate())){
			return true;
		}
		WzTopics wzTopics = wzTopicsService.get(wzPlan.getId());
		if(wzTopics != null){
			//议题生成的情况下判断上会状态
			if("0".equals(wzTopics.getIspass())){
				return true;
			}
			return false;
		}
		return false;
	}

	@RequestMapping(value = "selectPlanId")
	@ResponseBody
	public String selectPlanId(String planNumber){
		List<WzPlan> list = wzPlanService.getSelectPlan(planNumber);
		return list.get(0).getId();
	}

	@RequestMapping(value = "selectPlan")
	@ResponseBody
	public WzPlan selectPlan(String planNumber){
		List<WzPlan> list = wzPlanService.getSelectPlan(planNumber);
		if(list.size() != 0) {return list.get(0);}
		return null;
	}
}
