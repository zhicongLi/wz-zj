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

import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;

import com.ims.wz.cg.entity.WzPlanSummary;
import com.ims.wz.cg.service.IWzPlanSummaryService;

/**
 * wz_plan_summaryController
 * @author lizhicong
 * @version 2021-09-18
 */
@Controller
@RequestMapping(value = "/wz/wzPlanSummary")
public class WzPlanSummaryController extends WebController<IWzPlanSummaryService,WzPlanSummary> {

	@Autowired
	private IWzPlanSummaryService wzPlanSummaryService;


 	@ImsPreAuth("wz:wzPlanSummary:view")
	@RequestMapping(value = "list")
	public String list(WzPlanSummary wzPlanSummary, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanSummaryList";
	}

    @ImsPreAuth("wz:wzPlanSummary:view")
	@RequestMapping(value = "form")
	public String form(WzPlanSummary wzPlanSummary, Model model) {
	    String formView = wzPlanSummary.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanSummaryForm";
	}

    @ImsPreAuth("wz:wzPlanSummary:view")
	@RequestMapping(value = "lov")
	public String lov(WzPlanSummary wzPlanSummary, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanSummaryList";
	}

    @ImsPreAuth("wz:wzPlanSummary:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzPlanSummary wzPlanSummary, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzPlanSummary,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanSummary:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzPlanSummary wzPlanSummary, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzPlanSummary,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanSummary:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzPlanSummary wzPlanSummary, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzPlanSummary,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanSummary:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzPlanSummary wzPlanSummary, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzPlanSummary,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanSummary:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzPlanSummary wzPlanSummary, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzPlanSummary,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanSummary:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzPlanSummary wzPlanSummary, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzPlanSummary,request,response,model);
	}

	@RequestMapping(value = "saveSummary")
	@ResponseBody
	public void save(WzPlanSummary wzPlanSummary) {
		wzPlanSummaryService.saveSummary(wzPlanSummary);
	}

    @ImsPreAuth("wz:wzPlanSummary:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzPlanSummary wzPlanSummary, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzPlanSummary,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanSummary:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzPlanSummary wzPlanSummary, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzPlanSummary,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanSummary:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzPlanSummary wzPlanSummary,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzPlanSummary,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzPlanSummary:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzPlanSummary wzPlanSummary, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzPlanSummary,request,response );
	}

}
