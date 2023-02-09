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

import com.ims.wz.cg.entity.WzSupplierScore;
import com.ims.wz.cg.service.IWzSupplierScoreService;

/**
 * 供应商评议打分表Controller
 * @author lizhicong
 * @version 2022-07-21
 */
@Controller
@RequestMapping(value = "/wz/wzSupplierScore")
public class WzSupplierScoreController extends WebController<IWzSupplierScoreService,WzSupplierScore> {

 	@ImsPreAuth("wz:wzSupplierScore:view")
	@RequestMapping(value = "list")
	public String list(WzSupplierScore wzSupplierScore, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzSupplierScoreList";
	}

    @ImsPreAuth("wz:wzSupplierScore:view")
	@RequestMapping(value = "form")
	public String form(WzSupplierScore wzSupplierScore, Model model) {
	    String formView = wzSupplierScore.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzSupplierScoreForm";
	}

    @ImsPreAuth("wz:wzSupplierScore:view")
	@RequestMapping(value = "lov")
	public String lov(WzSupplierScore wzSupplierScore, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzSupplierScoreList";
	}

    @ImsPreAuth("wz:wzSupplierScore:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzSupplierScore wzSupplierScore, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzSupplierScore,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierScore:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzSupplierScore wzSupplierScore, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzSupplierScore,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierScore:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzSupplierScore wzSupplierScore, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzSupplierScore,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierScore:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzSupplierScore wzSupplierScore, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzSupplierScore,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierScore:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzSupplierScore wzSupplierScore, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzSupplierScore,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierScore:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzSupplierScore wzSupplierScore, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzSupplierScore,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierScore:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzSupplierScore wzSupplierScore, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzSupplierScore,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierScore:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzSupplierScore wzSupplierScore, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzSupplierScore,request,response,model);
	}

    @ImsPreAuth("wz:wzSupplierScore:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzSupplierScore wzSupplierScore,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzSupplierScore,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzSupplierScore:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzSupplierScore wzSupplierScore, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzSupplierScore,request,response );
	}

}