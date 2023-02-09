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
import java.util.List;

import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;

import com.ims.wz.cg.entity.WzIndexDetailed;
import com.ims.wz.cg.service.IWzIndexDetailedService;

/**
 * 指标详细表Controller
 * @author lizhicong
 * @version 2022-08-24
 */
@Controller
@RequestMapping(value = "/wz/wzIndexDetailed")
public class WzIndexDetailedController extends WebController<IWzIndexDetailedService,WzIndexDetailed> {


 	@ImsPreAuth("wz:wzIndexDetailed:view")
	@RequestMapping(value = "list")
	public String list(WzIndexDetailed wzIndexDetailed, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzIndexDetailedList";
	}

    @ImsPreAuth("wz:wzIndexDetailed:view")
	@RequestMapping(value = "form")
	public String form(WzIndexDetailed wzIndexDetailed, Model model) {
	    String formView = wzIndexDetailed.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzIndexDetailedForm";
	}

    @ImsPreAuth("wz:wzIndexDetailed:view")
	@RequestMapping(value = "lov")
	public String lov(WzIndexDetailed wzIndexDetailed, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzIndexDetailedList";
	}

    @ImsPreAuth("wz:wzIndexDetailed:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzIndexDetailed wzIndexDetailed, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzIndexDetailed,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexDetailed:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzIndexDetailed wzIndexDetailed, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzIndexDetailed,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexDetailed:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzIndexDetailed wzIndexDetailed, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzIndexDetailed,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexDetailed:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzIndexDetailed wzIndexDetailed, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzIndexDetailed,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexDetailed:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzIndexDetailed wzIndexDetailed, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzIndexDetailed,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexDetailed:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzIndexDetailed wzIndexDetailed, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzIndexDetailed,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexDetailed:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzIndexDetailed wzIndexDetailed, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzIndexDetailed,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexDetailed:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzIndexDetailed wzIndexDetailed, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzIndexDetailed,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexDetailed:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzIndexDetailed wzIndexDetailed,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzIndexDetailed,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzIndexDetailed:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzIndexDetailed wzIndexDetailed, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzIndexDetailed,request,response );
	}

}
