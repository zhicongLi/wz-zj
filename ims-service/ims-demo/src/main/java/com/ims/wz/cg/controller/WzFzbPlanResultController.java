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

import com.ims.wz.cg.entity.WzFzbPlanResult;
import com.ims.wz.cg.service.IWzFzbPlanResultService;

/**
 * 非招标采购结果议题审批Controller
 * @author lizhicong
 * @version 2022-12-15
 */
@Controller
@RequestMapping(value = "/wz/wzFzbPlanResult")
public class WzFzbPlanResultController extends WebController<IWzFzbPlanResultService,WzFzbPlanResult> {

 	@ImsPreAuth("wz:wzFzbPlanResult:view")
	@RequestMapping(value = "list")
	public String list(WzFzbPlanResult wzFzbPlanResult, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzFzbPlanResultList";
	}

    @ImsPreAuth("wz:wzFzbPlanResult:view")
	@RequestMapping(value = "form")
	public String form(WzFzbPlanResult wzFzbPlanResult, Model model) {
	    String formView = wzFzbPlanResult.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzFzbPlanResultForm";
	}

    @ImsPreAuth("wz:wzFzbPlanResult:view")
	@RequestMapping(value = "lov")
	public String lov(WzFzbPlanResult wzFzbPlanResult, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzFzbPlanResultList";
	}

    @ImsPreAuth("wz:wzFzbPlanResult:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzFzbPlanResult wzFzbPlanResult, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzFzbPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzFzbPlanResult:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzFzbPlanResult wzFzbPlanResult, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzFzbPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzFzbPlanResult:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzFzbPlanResult wzFzbPlanResult, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzFzbPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzFzbPlanResult:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzFzbPlanResult wzFzbPlanResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzFzbPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzFzbPlanResult:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzFzbPlanResult wzFzbPlanResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzFzbPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzFzbPlanResult:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzFzbPlanResult wzFzbPlanResult, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzFzbPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzFzbPlanResult:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzFzbPlanResult wzFzbPlanResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzFzbPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzFzbPlanResult:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzFzbPlanResult wzFzbPlanResult, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzFzbPlanResult,request,response,model);
	}

    @ImsPreAuth("wz:wzFzbPlanResult:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzFzbPlanResult wzFzbPlanResult,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzFzbPlanResult,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzFzbPlanResult:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzFzbPlanResult wzFzbPlanResult, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzFzbPlanResult,request,response );
	}

}