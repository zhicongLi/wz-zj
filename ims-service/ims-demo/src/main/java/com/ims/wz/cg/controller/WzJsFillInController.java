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

import com.ims.wz.cg.entity.WzJsFillIn;
import com.ims.wz.cg.service.IWzJsFillInService;

/**
 * 江苏公司填报Controller
 * @author lizhicong
 * @version 2022-08-19
 */
@Controller
@RequestMapping(value = "/wz/wzJsFillIn")
public class WzJsFillInController extends WebController<IWzJsFillInService,WzJsFillIn> {

 	@ImsPreAuth("wz:wzJsFillIn:view")
	@RequestMapping(value = "list")
	public String list(WzJsFillIn wzJsFillIn, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzJsFillInList";
	}

    @ImsPreAuth("wz:wzJsFillIn:view")
	@RequestMapping(value = "form")
	public String form(WzJsFillIn wzJsFillIn, Model model) {
	    String formView = wzJsFillIn.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzJsFillInForm";
	}

    @ImsPreAuth("wz:wzJsFillIn:view")
	@RequestMapping(value = "lov")
	public String lov(WzJsFillIn wzJsFillIn, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzJsFillInList";
	}

    @ImsPreAuth("wz:wzJsFillIn:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzJsFillIn wzJsFillIn, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzJsFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzJsFillIn:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzJsFillIn wzJsFillIn, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzJsFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzJsFillIn:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzJsFillIn wzJsFillIn, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzJsFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzJsFillIn:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzJsFillIn wzJsFillIn, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzJsFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzJsFillIn:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzJsFillIn wzJsFillIn, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzJsFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzJsFillIn:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzJsFillIn wzJsFillIn, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzJsFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzJsFillIn:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzJsFillIn wzJsFillIn, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzJsFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzJsFillIn:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzJsFillIn wzJsFillIn, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzJsFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzJsFillIn:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzJsFillIn wzJsFillIn,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzJsFillIn,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzJsFillIn:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzJsFillIn wzJsFillIn, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzJsFillIn,request,response );
	}

}