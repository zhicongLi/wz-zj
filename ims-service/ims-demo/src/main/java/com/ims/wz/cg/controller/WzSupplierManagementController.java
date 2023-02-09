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

import com.ims.wz.cg.entity.WzSupplierManagement;
import com.ims.wz.cg.service.IWzSupplierManagementService;

/**
 * 失信供应商处置Controller
 * @author lizhicong
 * @version 2022-07-22
 */
@Controller
@RequestMapping(value = "/wz/wzSupplierManagement")
public class WzSupplierManagementController extends WebController<IWzSupplierManagementService,WzSupplierManagement> {

 	@ImsPreAuth("wz:wzSupplierManagement:view")
	@RequestMapping(value = "list")
	public String list(WzSupplierManagement wzSupplierManagement, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzSupplierManagementList";
	}

    @ImsPreAuth("wz:wzSupplierManagement:view")
	@RequestMapping(value = "form")
	public String form(WzSupplierManagement wzSupplierManagement, Model model) {
	    String formView = wzSupplierManagement.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzSupplierManagementForm";
	}

    @ImsPreAuth("wz:wzSupplierManagement:view")
	@RequestMapping(value = "lov")
	public String lov(WzSupplierManagement wzSupplierManagement, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzSupplierManagementList";
	}

    @ImsPreAuth("wz:wzSupplierManagement:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzSupplierManagement wzSupplierManagement, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzSupplierManagement,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierManagement:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzSupplierManagement wzSupplierManagement, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzSupplierManagement,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierManagement:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzSupplierManagement wzSupplierManagement, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzSupplierManagement,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierManagement:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzSupplierManagement wzSupplierManagement, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzSupplierManagement,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierManagement:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzSupplierManagement wzSupplierManagement, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzSupplierManagement,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierManagement:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzSupplierManagement wzSupplierManagement, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzSupplierManagement,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierManagement:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzSupplierManagement wzSupplierManagement, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzSupplierManagement,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierManagement:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzSupplierManagement wzSupplierManagement, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzSupplierManagement,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierManagement:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzSupplierManagement wzSupplierManagement,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzSupplierManagement,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzSupplierManagement:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzSupplierManagement wzSupplierManagement, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzSupplierManagement,request,response );
	}

}