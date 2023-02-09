/**
 *
 */
package com.ims.wz.cg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.system.auth.ImsPreAuth;
import com.ims.wz.cg.entity.WzProcurement;
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

import com.ims.wz.cg.entity.WzPurchaseRate;
import com.ims.wz.cg.service.IWzPurchaseRateService;

/**
 * 集中 公开 上网采购率Controller
 * @author lizhicong
 * @version 2022-08-18
 */
@Controller
@RequestMapping(value = "/wz/wzPurchaseRate")
public class WzPurchaseRateController extends WebController<IWzPurchaseRateService,WzPurchaseRate> {

	@Autowired
	private IWzPurchaseRateService wzPurchaseRateService;

 	@ImsPreAuth("wz:wzPurchaseRate:view")
	@RequestMapping(value = "list")
	public String list(WzPurchaseRate wzPurchaseRate, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPurchaseRateList";
	}

    @ImsPreAuth("wz:wzPurchaseRate:view")
	@RequestMapping(value = "form")
	public String form(WzPurchaseRate wzPurchaseRate, Model model) {
	    String formView = wzPurchaseRate.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPurchaseRateForm";
	}

    @ImsPreAuth("wz:wzPurchaseRate:view")
	@RequestMapping(value = "lov")
	public String lov(WzPurchaseRate wzPurchaseRate, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPurchaseRateList";
	}

    @ImsPreAuth("wz:wzPurchaseRate:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzPurchaseRate wzPurchaseRate, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzPurchaseRate,request,response,model);
	}

    @ImsPreAuth("wz:wzPurchaseRate:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzPurchaseRate wzPurchaseRate, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzPurchaseRate,request,response,model);
	}

    @ImsPreAuth("wz:wzPurchaseRate:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzPurchaseRate wzPurchaseRate, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzPurchaseRate,request,response,model);
	}

    @ImsPreAuth("wz:wzPurchaseRate:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzPurchaseRate wzPurchaseRate, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzPurchaseRate,request,response,model);
	}

    @ImsPreAuth("wz:wzPurchaseRate:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzPurchaseRate wzPurchaseRate, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzPurchaseRate,request,response,model);
	}

    @ImsPreAuth("wz:wzPurchaseRate:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzPurchaseRate wzPurchaseRate, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzPurchaseRate,request,response,model);
	}

    @ImsPreAuth("wz:wzPurchaseRate:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzPurchaseRate wzPurchaseRate, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzPurchaseRate,request,response,model);
	}

    @ImsPreAuth("wz:wzPurchaseRate:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzPurchaseRate wzPurchaseRate, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzPurchaseRate,request,response,model);
	}

    @ImsPreAuth("wz:wzPurchaseRate:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzPurchaseRate wzPurchaseRate,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzPurchaseRate,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzPurchaseRate:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzPurchaseRate wzPurchaseRate, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzPurchaseRate,request,response );
	}

	//参数：时间
	@RequestMapping(value = "getSelectIndexValue")
	@ResponseBody
	public List<WzPurchaseRate> getSelectIndexValue(String time) {
		return wzPurchaseRateService.getSelectIndexValue(time);
	}
}
