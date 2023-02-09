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

import com.ims.wz.cg.entity.WzPlanAccuracy;
import com.ims.wz.cg.service.IWzPlanAccuracyService;

/**
 * 采购计划准确率基础表Controller
 * @author lizhicong
 * @version 2022-07-18
 */
@Controller
@RequestMapping(value = "/wz/wzPlanAccuracy")
public class WzPlanAccuracyController extends WebController<IWzPlanAccuracyService,WzPlanAccuracy> {

 	@ImsPreAuth("wz:wzPlanAccuracy:view")
	@RequestMapping(value = "list")
	public String list(WzPlanAccuracy wzPlanAccuracy, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanAccuracyList";
	}

    @ImsPreAuth("wz:wzPlanAccuracy:view")
	@RequestMapping(value = "form")
	public String form(WzPlanAccuracy wzPlanAccuracy, Model model) {
	    String formView = wzPlanAccuracy.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanAccuracyForm";
	}

    @ImsPreAuth("wz:wzPlanAccuracy:view")
	@RequestMapping(value = "lov")
	public String lov(WzPlanAccuracy wzPlanAccuracy, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanAccuracyList";
	}

    @ImsPreAuth("wz:wzPlanAccuracy:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzPlanAccuracy wzPlanAccuracy, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzPlanAccuracy,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanAccuracy:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzPlanAccuracy wzPlanAccuracy, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzPlanAccuracy,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanAccuracy:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzPlanAccuracy wzPlanAccuracy, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzPlanAccuracy,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanAccuracy:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzPlanAccuracy wzPlanAccuracy, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzPlanAccuracy,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanAccuracy:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzPlanAccuracy wzPlanAccuracy, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzPlanAccuracy,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanAccuracy:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzPlanAccuracy wzPlanAccuracy, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzPlanAccuracy,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanAccuracy:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzPlanAccuracy wzPlanAccuracy, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzPlanAccuracy,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanAccuracy:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzPlanAccuracy wzPlanAccuracy, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzPlanAccuracy,request,response,model);
	}

    @ImsPreAuth("wz:wzPlanAccuracy:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzPlanAccuracy wzPlanAccuracy,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzPlanAccuracy,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzPlanAccuracy:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzPlanAccuracy wzPlanAccuracy, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzPlanAccuracy,request,response );
	}

}