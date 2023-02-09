/**
 *
 */
package com.ims.wz.cg.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.ims.system.auth.ImsPreAuth;
import com.ims.wz.cg.entity.*;
import com.ims.wz.cg.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;


import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;

/**
 * 非招标采购结果议题审批Controller
 * @author lizhicong
 * @version 2022-11-15
 */
@Controller
@RequestMapping(value = "/wz/wzPlanResult")
public class WzPlanResultController extends WebController<IWzPlanResultService,WzPlanResult> {

	@Autowired
	private IWzPlanService wzPlanService;
	@Autowired
	private IWzNoticeSonService wzNoticeSonService;
	@Autowired
	private IWzFzbPlanResultService wzFzbPlanResultService;
	@Autowired
	private IWzPlanResultService wzPlanResultService;
	@Autowired
	private IWzNoticeResultService wzNoticeResultService;

 	@ImsPreAuth("wz:wzPlanResult:view")
	@RequestMapping(value = "list")
	public String list(WzPlanResult wzPlanResult, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanResultList";
	}

    @ImsPreAuth("wz:wzPlanResult:view")
	@RequestMapping(value = "form")
	public String form(WzPlanResult wzPlanResult, Model model) {
	    String formView = wzPlanResult.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanResultForm";
	}

    @ImsPreAuth("wz:wzPlanResult:view")
	@RequestMapping(value = "lov")
	public String lov(WzPlanResult wzPlanResult, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanResultList";
	}

    @ImsPreAuth("wz:wzPlanResult:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzPlanResult wzPlanResult, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanResult:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzPlanResult wzPlanResult, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanResult:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzPlanResult wzPlanResult, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanResult:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzPlanResult wzPlanResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanResult:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzPlanResult wzPlanResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanResult:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzPlanResult wzPlanResult, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanResult:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzPlanResult wzPlanResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanResult:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzPlanResult wzPlanResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanResult:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzPlanResult wzPlanResult,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzPlanResult,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzPlanResult:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzPlanResult wzPlanResult, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzPlanResult,request,response );
	}

	@RequestMapping(value = "updateWzPlanBath")
	@ResponseBody
	public Boolean updateWzPlanBath(String ids,String id){
		String[] str = ids.split(",");
		List<WzPlan> list = new ArrayList<>();
		for(String s : str){
			WzPlan wzPlan = wzPlanService.get(s);
			wzPlan.setResultId(id);
			list.add(wzPlan);
		}
		if(list.size() != 0){
			return wzPlanService.updateBatchById(list);
		}
		return null;
	}

	@RequestMapping(value = "updateWzNoticeResult")
	@ResponseBody
	public Boolean updateWzNoticeResult(String ids,String id){
		String[] str = ids.split(",");
		List<WzNoticeSon> list = new ArrayList<>();
		for(String s : str){
			WzNoticeSon wzNoticeSon = wzNoticeSonService.get(s);
			wzNoticeSon.setResultId(id);
			list.add(wzNoticeSon);
		}
		if(list.size() != 0){
			return wzNoticeSonService.updateBatchById(list);
		}
		return null;
	}


	@RequestMapping(value = "delWzFzbPlan")
	@ResponseBody
	public Boolean delWzFzbPlan(String ids) throws Exception {
		String[] str = ids.split(",");
		List<WzPlan> list = new ArrayList<>();
		for(String s : str){
			wzFzbPlanResultService.removeById(s);
			WzPlan wzPlan = wzPlanService.get(s);
			wzPlan.setResultId("");
			list.add(wzPlan);
		}
		if(list.size() != 0){
			return wzPlanService.updateBatchById(list);
		}
		return null;
	}

	@RequestMapping(value = "delWzNotice")
	@ResponseBody
	public Boolean delWzNotice(String ids) throws Exception {
		String[] str = ids.split(",");
		List<WzNoticeSon> list = new ArrayList<>();
		for(String s : str){
			wzNoticeResultService.removeById(s);
			WzNoticeSon WzNoticeSon = wzNoticeSonService.get(s);
			WzNoticeSon.setResultId("");
			list.add(WzNoticeSon);
		}
		if(list.size() != 0){
			return wzNoticeSonService.updateBatchById(list);
		}
		return null;
	}

	@RequestMapping(value = "updateWzNoticeSonBath")
	@ResponseBody
	public Boolean updateWzNoticeSonBath(String wzNoticeSonList) throws Exception {
		List<WzNoticeSon> list = JSONArray.parseArray(wzNoticeSonList,WzNoticeSon.class);
		if(list.size() != 0){
			return wzNoticeSonService.updateBatchById(list);
		}
		return null;
	}

	@RequestMapping(value = "exportWord")
	@ResponseBody
	public String exportWord(HttpServletRequest request,HttpServletResponse response,String id){
		return wzPlanResultService.exportWord(request,response,id);
	}

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
}
