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
import java.util.*;

import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;

import com.ims.wz.cg.entity.WzHangUpBasics;
import com.ims.wz.cg.service.IWzHangUpBasicsService;

/**
 * 非招标一挂基础表Controller
 * @author lizhicong
 * @version 2022-07-14
 */
@Controller
@RequestMapping(value = "/wz/wzHangUpBasics")
public class WzHangUpBasicsController extends WebController<IWzHangUpBasicsService,WzHangUpBasics> {

	@Autowired
	private IWzHangUpBasicsService wzHangUpBasicsService;

 	@ImsPreAuth("wz:wzHangUpBasics:view")
	@RequestMapping(value = "list")
	public String list(WzHangUpBasics wzHangUpBasics, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzHangUpBasicsList";
	}

    @ImsPreAuth("wz:wzHangUpBasics:view")
	@RequestMapping(value = "form")
	public String form(WzHangUpBasics wzHangUpBasics, Model model) {
	    String formView = wzHangUpBasics.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzHangUpBasicsForm";
	}

    @ImsPreAuth("wz:wzHangUpBasics:view")
	@RequestMapping(value = "lov")
	public String lov(WzHangUpBasics wzHangUpBasics, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzHangUpBasicsList";
	}

    @ImsPreAuth("wz:wzHangUpBasics:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzHangUpBasics wzHangUpBasics, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzHangUpBasics,request,response,model);
	}

    @ImsPreAuth("wz:wzHangUpBasics:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzHangUpBasics wzHangUpBasics, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzHangUpBasics,request,response,model);
	}

    @ImsPreAuth("wz:wzHangUpBasics:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzHangUpBasics wzHangUpBasics, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzHangUpBasics,request,response,model);
	}

    @ImsPreAuth("wz:wzHangUpBasics:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzHangUpBasics wzHangUpBasics, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzHangUpBasics,request,response,model);
	}

    @ImsPreAuth("wz:wzHangUpBasics:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzHangUpBasics wzHangUpBasics, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzHangUpBasics,request,response,model);
	}

    @ImsPreAuth("wz:wzHangUpBasics:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzHangUpBasics wzHangUpBasics, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzHangUpBasics,request,response,model);
	}

    @ImsPreAuth("wz:wzHangUpBasics:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzHangUpBasics wzHangUpBasics, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzHangUpBasics,request,response,model);
	}

    @ImsPreAuth("wz:wzHangUpBasics:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzHangUpBasics wzHangUpBasics, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzHangUpBasics,request,response,model);
	}

    @ImsPreAuth("wz:wzHangUpBasics:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzHangUpBasics wzHangUpBasics,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzHangUpBasics,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzHangUpBasics:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzHangUpBasics wzHangUpBasics, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzHangUpBasics,request,response );
	}

}
