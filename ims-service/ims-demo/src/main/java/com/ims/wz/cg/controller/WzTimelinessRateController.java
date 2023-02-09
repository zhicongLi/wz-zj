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

import com.ims.wz.cg.entity.WzTimelinessRate;
import com.ims.wz.cg.service.IWzTimelinessRateService;

/**
 * 采购申请及时率基础表Controller
 * @author lizhicong
 * @version 2022-07-19
 */
@Controller
@RequestMapping(value = "/wz/wzTimelinessRate")
public class WzTimelinessRateController extends WebController<IWzTimelinessRateService,WzTimelinessRate> {

 	@ImsPreAuth("wz:wzTimelinessRate:view")
	@RequestMapping(value = "list")
	public String list(WzTimelinessRate wzTimelinessRate, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTimelinessRateList";
	}

    @ImsPreAuth("wz:wzTimelinessRate:view")
	@RequestMapping(value = "form")
	public String form(WzTimelinessRate wzTimelinessRate, Model model) {
	    String formView = wzTimelinessRate.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTimelinessRateForm";
	}

    @ImsPreAuth("wz:wzTimelinessRate:view")
	@RequestMapping(value = "lov")
	public String lov(WzTimelinessRate wzTimelinessRate, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTimelinessRateList";
	}

    @ImsPreAuth("wz:wzTimelinessRate:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzTimelinessRate wzTimelinessRate, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzTimelinessRate,request,response,model);
	}

    @ImsPreAuth("wz:wzTimelinessRate:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzTimelinessRate wzTimelinessRate, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzTimelinessRate,request,response,model);
	}

    @ImsPreAuth("wz:wzTimelinessRate:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzTimelinessRate wzTimelinessRate, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzTimelinessRate,request,response,model);
	}

    @ImsPreAuth("wz:wzTimelinessRate:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzTimelinessRate wzTimelinessRate, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzTimelinessRate,request,response,model);
	}

    @ImsPreAuth("wz:wzTimelinessRate:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzTimelinessRate wzTimelinessRate, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzTimelinessRate,request,response,model);
	}

    @ImsPreAuth("wz:wzTimelinessRate:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzTimelinessRate wzTimelinessRate, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzTimelinessRate,request,response,model);
	}

    @ImsPreAuth("wz:wzTimelinessRate:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzTimelinessRate wzTimelinessRate, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzTimelinessRate,request,response,model);
	}

    @ImsPreAuth("wz:wzTimelinessRate:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzTimelinessRate wzTimelinessRate, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzTimelinessRate,request,response,model);
	}

    @ImsPreAuth("wz:wzTimelinessRate:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzTimelinessRate wzTimelinessRate,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzTimelinessRate,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzTimelinessRate:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzTimelinessRate wzTimelinessRate, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzTimelinessRate,request,response );
	}

}