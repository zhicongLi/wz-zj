/**
 *
 */
package com.ims.wz.cg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.system.auth.ImsPreAuth;
import com.ims.wz.cg.entity.WzIndexValue;
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

import com.ims.wz.cg.entity.WzProcurement;
import com.ims.wz.cg.service.IWzProcurementService;

/**
 * wz_procurementController
 * @author lizhicong
 * @version 2022-06-28
 */
@Controller
@RequestMapping(value = "/wz/wzProcurement")
public class WzProcurementController extends WebController<IWzProcurementService,WzProcurement> {

	@Autowired
	private IWzProcurementService wzProcurementService;

 	@ImsPreAuth("wz:wzProcurement:view")
	@RequestMapping(value = "list")
	public String list(WzProcurement wzProcurement, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzProcurementList";
	}

    @ImsPreAuth("wz:wzProcurement:view")
	@RequestMapping(value = "form")
	public String form(WzProcurement wzProcurement, Model model) {
	    String formView = wzProcurement.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzProcurementForm";
	}

    @ImsPreAuth("wz:wzProcurement:view")
	@RequestMapping(value = "lov")
	public String lov(WzProcurement wzProcurement, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzProcurementList";
	}

    @ImsPreAuth("wz:wzProcurement:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzProcurement wzProcurement, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzProcurement,request,response,model);
	}

    @ImsPreAuth("wz:wzProcurement:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzProcurement wzProcurement, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzProcurement,request,response,model);
	}

    @ImsPreAuth("wz:wzProcurement:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzProcurement wzProcurement, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzProcurement,request,response,model);
	}

    @ImsPreAuth("wz:wzProcurement:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzProcurement wzProcurement, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzProcurement,request,response,model);
	}

    @ImsPreAuth("wz:wzProcurement:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzProcurement wzProcurement, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzProcurement,request,response,model);
	}

    @ImsPreAuth("wz:wzProcurement:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzProcurement wzProcurement, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzProcurement,request,response,model);
	}

    @ImsPreAuth("wz:wzProcurement:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzProcurement wzProcurement, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzProcurement,request,response,model);
	}

    @ImsPreAuth("wz:wzProcurement:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzProcurement wzProcurement, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzProcurement,request,response,model);
	}

    @ImsPreAuth("wz:wzProcurement:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzProcurement wzProcurement,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzProcurement,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzProcurement:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzProcurement wzProcurement, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzProcurement,request,response );
	}

	//参数：指标编号 时间
	@RequestMapping(value = "getSelectIndexValue")
	@ResponseBody
	public List<WzProcurement> getSelectIndexValue(String time){
		return wzProcurementService.getSelectIndexValue(time);
	}

	//参数：指标编号 时间
	@RequestMapping(value = "getSelectDate")
	@ResponseBody
	public List<WzProcurement> getSelectDate(){
 		return wzProcurementService.getSelectDate();
	}
}
