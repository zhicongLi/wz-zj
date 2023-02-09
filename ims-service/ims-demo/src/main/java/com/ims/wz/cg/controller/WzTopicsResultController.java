/**
 *
 */
package com.ims.wz.cg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.system.auth.ImsPreAuth;
import com.ims.wz.cg.service.impl.WzTopicsResultServiceImpl;
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

import com.ims.wz.cg.entity.WzTopicsResult;
import com.ims.wz.cg.service.IWzTopicsResultService;

/**
 * 非招标采购结果议题审批Controller
 * @author lizhicong
 * @version 2022-10-09
 */
@Controller
@RequestMapping(value = "/wz/wzTopicsResult")
public class WzTopicsResultController extends WebController<IWzTopicsResultService,WzTopicsResult> {

 	@ImsPreAuth("wz:wzTopicsResult:view")
	@RequestMapping(value = "list")
	public String list(WzTopicsResult wzTopicsResult, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTopicsResultList";
	}

    @ImsPreAuth("wz:wzTopicsResult:view")
	@RequestMapping(value = "form")
	public String form(WzTopicsResult wzTopicsResult, Model model) {
	    String formView = wzTopicsResult.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTopicsResultForm";
	}

    @ImsPreAuth("wz:wzTopicsResult:view")
	@RequestMapping(value = "lov")
	public String lov(WzTopicsResult wzTopicsResult, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTopicsResultList";
	}

    @ImsPreAuth("wz:wzTopicsResult:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzTopicsResult wzTopicsResult, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzTopicsResult,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsResult:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzTopicsResult wzTopicsResult, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzTopicsResult,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsResult:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzTopicsResult wzTopicsResult, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzTopicsResult,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsResult:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzTopicsResult wzTopicsResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzTopicsResult,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsResult:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzTopicsResult wzTopicsResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzTopicsResult,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsResult:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzTopicsResult wzTopicsResult, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzTopicsResult,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsResult:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzTopicsResult wzTopicsResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzTopicsResult,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsResult:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzTopicsResult wzTopicsResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzTopicsResult,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsResult:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzTopicsResult wzTopicsResult,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzTopicsResult,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzTopicsResult:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzTopicsResult wzTopicsResult, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzTopicsResult,request,response );
	}

}
