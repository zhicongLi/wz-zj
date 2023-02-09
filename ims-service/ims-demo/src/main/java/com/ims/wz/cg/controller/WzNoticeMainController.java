/**
 *
 */
package com.ims.wz.cg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.system.auth.ImsPreAuth;
import com.ims.wz.cg.entity.WzPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;


import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;

import com.ims.wz.cg.entity.WzNoticeMain;
import com.ims.wz.cg.service.IWzNoticeMainService;

/**
 * wz_notice_mainController
 * @author lizhicong
 * @version 2021-12-27
 */
@Controller
@RequestMapping(value = "/wz/wzNoticeMain")
public class WzNoticeMainController extends WebController<IWzNoticeMainService,WzNoticeMain> {

	@Autowired
	IWzNoticeMainService wzNoticeMainService;

 	@ImsPreAuth("wz:wzNoticeMain:view")
	@RequestMapping(value = "list")
	public String list(WzNoticeMain wzNoticeMain, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzNoticeMainList";
	}

    @ImsPreAuth("wz:wzNoticeMain:view")
	@RequestMapping(value = "form")
	public String form(WzNoticeMain wzNoticeMain, Model model) {
	    String formView = wzNoticeMain.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzNoticeMainForm";
	}

    @ImsPreAuth("wz:wzNoticeMain:view")
	@RequestMapping(value = "lov")
	public String lov(WzNoticeMain wzNoticeMain, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzNoticeMainList";
	}

    @ImsPreAuth("wz:wzNoticeMain:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzNoticeMain wzNoticeMain, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzNoticeMain,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeMain:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzNoticeMain wzNoticeMain, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzNoticeMain,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeMain:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzNoticeMain wzNoticeMain, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzNoticeMain,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeMain:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzNoticeMain wzNoticeMain, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzNoticeMain,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeMain:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzNoticeMain wzNoticeMain, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzNoticeMain,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeMain:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzNoticeMain wzNoticeMain, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzNoticeMain,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeMain:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzNoticeMain wzNoticeMain, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzNoticeMain,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeMain:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzNoticeMain wzNoticeMain, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzNoticeMain,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeMain:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzNoticeMain wzNoticeMain,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzNoticeMain,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzNoticeMain:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzNoticeMain wzNoticeMain, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzNoticeMain,request,response );
	}

	@RequestMapping(value = "stopReason")
	@ResponseBody
	public Boolean stopReason(String id,String reason){
		WzNoticeMain wzNoticeMain = wzNoticeMainService.get(id);
		wzNoticeMain.setStopReason(reason);
		wzNoticeMain.setStatus("xmzz");
		wzNoticeMain.setApprovalNode("xmzz");
		return wzNoticeMainService.saveOrUpdate(wzNoticeMain);
	}

}
