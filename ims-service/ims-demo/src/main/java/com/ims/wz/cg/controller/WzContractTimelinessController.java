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

import com.ims.wz.cg.entity.WzContractTimeliness;
import com.ims.wz.cg.service.IWzContractTimelinessService;

/**
 * 合同签订及时率基础表Controller
 * @author lizhicong
 * @version 2022-07-20
 */
@Controller
@RequestMapping(value = "/wz/wzContractTimeliness")
public class WzContractTimelinessController extends WebController<IWzContractTimelinessService,WzContractTimeliness> {

 	@ImsPreAuth("wz:wzContractTimeliness:view")
	@RequestMapping(value = "list")
	public String list(WzContractTimeliness wzContractTimeliness, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzContractTimelinessList";
	}

    @ImsPreAuth("wz:wzContractTimeliness:view")
	@RequestMapping(value = "form")
	public String form(WzContractTimeliness wzContractTimeliness, Model model) {
	    String formView = wzContractTimeliness.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzContractTimelinessForm";
	}

    @ImsPreAuth("wz:wzContractTimeliness:view")
	@RequestMapping(value = "lov")
	public String lov(WzContractTimeliness wzContractTimeliness, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzContractTimelinessList";
	}

    @ImsPreAuth("wz:wzContractTimeliness:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzContractTimeliness wzContractTimeliness, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzContractTimeliness,request,response,model);
	}

    @ImsPreAuth("wz:wzContractTimeliness:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzContractTimeliness wzContractTimeliness, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzContractTimeliness,request,response,model);
	}

    @ImsPreAuth("wz:wzContractTimeliness:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzContractTimeliness wzContractTimeliness, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzContractTimeliness,request,response,model);
	}

    @ImsPreAuth("wz:wzContractTimeliness:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzContractTimeliness wzContractTimeliness, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzContractTimeliness,request,response,model);
	}

    @ImsPreAuth("wz:wzContractTimeliness:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzContractTimeliness wzContractTimeliness, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzContractTimeliness,request,response,model);
	}

    @ImsPreAuth("wz:wzContractTimeliness:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzContractTimeliness wzContractTimeliness, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzContractTimeliness,request,response,model);
	}

    @ImsPreAuth("wz:wzContractTimeliness:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzContractTimeliness wzContractTimeliness, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzContractTimeliness,request,response,model);
	}

    @ImsPreAuth("wz:wzContractTimeliness:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzContractTimeliness wzContractTimeliness, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzContractTimeliness,request,response,model);
	}

    @ImsPreAuth("wz:wzContractTimeliness:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzContractTimeliness wzContractTimeliness,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzContractTimeliness,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzContractTimeliness:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzContractTimeliness wzContractTimeliness, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzContractTimeliness,request,response );
	}

}