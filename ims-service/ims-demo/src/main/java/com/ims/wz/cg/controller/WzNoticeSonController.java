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

import com.ims.wz.cg.entity.WzNoticeSon;
import com.ims.wz.cg.service.IWzNoticeSonService;

/**
 * wz_notice_mainController
 * @author lizhicong
 * @version 2021-12-27
 */
@Controller
@RequestMapping(value = "/wz/wzNoticeSon")
public class WzNoticeSonController extends WebController<IWzNoticeSonService,WzNoticeSon> {

	@Autowired
	private IWzNoticeSonService wzNoticeSonService;

 	@ImsPreAuth("wz:wzNoticeSon:view")
	@RequestMapping(value = "list")
	public String list(WzNoticeSon wzNoticeSon, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzNoticeSonList";
	}

    @ImsPreAuth("wz:wzNoticeSon:view")
	@RequestMapping(value = "form")
	public String form(WzNoticeSon wzNoticeSon, Model model) {
	    String formView = wzNoticeSon.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzNoticeSonForm";
	}

    @ImsPreAuth("wz:wzNoticeSon:view")
	@RequestMapping(value = "lov")
	public String lov(WzNoticeSon wzNoticeSon, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzNoticeSonList";
	}

    @ImsPreAuth("wz:wzNoticeSon:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzNoticeSon wzNoticeSon, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzNoticeSon,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeSon:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzNoticeSon wzNoticeSon, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzNoticeSon,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeSon:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzNoticeSon wzNoticeSon, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzNoticeSon,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeSon:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzNoticeSon wzNoticeSon, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzNoticeSon,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeSon:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzNoticeSon wzNoticeSon, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzNoticeSon,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeSon:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzNoticeSon wzNoticeSon, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzNoticeSon,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeSon:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzNoticeSon wzNoticeSon, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzNoticeSon,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeSon:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzNoticeSon wzNoticeSon, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzNoticeSon,request,response,model);
	}

    @ImsPreAuth("wz:wzNoticeSon:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzNoticeSon wzNoticeSon,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
		return super.importFile(wzNoticeSon,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzNoticeSon:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzNoticeSon wzNoticeSon, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzNoticeSon,request,response );
	}

	@RequestMapping(value = "downLoad")
	public String downLoad(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return wzNoticeSonService.downLoad(request,response);
	}
}
