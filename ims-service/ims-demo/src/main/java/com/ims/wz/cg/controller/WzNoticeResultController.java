/**
 *
 */
package com.ims.wz.cg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.system.auth.ImsPreAuth;
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

import com.ims.wz.cg.entity.WzNoticeResult;
import com.ims.wz.cg.service.IWzNoticeResultService;

/**
 * 非招标采购结果议题审批Controller
 * @author lizhicong
 * @version 2022-12-27
 */
@Controller
@RequestMapping(value = "/wz/wzNoticeResult")
public class WzNoticeResultController extends WebController<IWzNoticeResultService,WzNoticeResult> {

 	@ImsPreAuth("wz:wzNoticeResult:view")
	@RequestMapping(value = "list")
	public String list(WzNoticeResult wzNoticeResult, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzNoticeResultList";
	}

    @ImsPreAuth("wz:wzNoticeResult:view")
	@RequestMapping(value = "form")
	public String form(WzNoticeResult wzNoticeResult, Model model) {
	    String formView = wzNoticeResult.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzNoticeResultForm";
	}

    @ImsPreAuth("wz:wzNoticeResult:view")
	@RequestMapping(value = "lov")
	public String lov(WzNoticeResult wzNoticeResult, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzNoticeResultList";
	}

    @ImsPreAuth("wz:wzNoticeResult:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzNoticeResult wzNoticeResult, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzNoticeResult,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeResult:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzNoticeResult wzNoticeResult, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzNoticeResult,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeResult:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzNoticeResult wzNoticeResult, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzNoticeResult,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeResult:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzNoticeResult wzNoticeResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzNoticeResult,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeResult:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzNoticeResult wzNoticeResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzNoticeResult,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeResult:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzNoticeResult wzNoticeResult, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzNoticeResult,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeResult:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzNoticeResult wzNoticeResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzNoticeResult,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeResult:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzNoticeResult wzNoticeResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzNoticeResult,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeResult:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzNoticeResult wzNoticeResult,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzNoticeResult,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzNoticeResult:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzNoticeResult wzNoticeResult, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzNoticeResult,request,response );
	}

}