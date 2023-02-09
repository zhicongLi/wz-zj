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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;


import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Map;

import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;

import com.ims.wz.cg.entity.WzFillIn;
import com.ims.wz.cg.service.IWzFillInService;

/**
 * 电厂填报表Controller
 * @author lizhicong
 * @version 2022-08-18
 */
@Controller
@RequestMapping(value = "/wz/wzFillIn")
public class WzFillInController extends WebController<IWzFillInService,WzFillIn> {

	@Autowired
	private IWzFillInService wzFillInService;

 	@ImsPreAuth("wz:wzFillIn:view")
	@RequestMapping(value = "list")
	public String list(WzFillIn wzFillIn, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzFillInList";
	}

    @ImsPreAuth("wz:wzFillIn:view")
	@RequestMapping(value = "form")
	public String form(WzFillIn wzFillIn, Model model) {
	    String formView = wzFillIn.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzFillInForm";
	}

    @ImsPreAuth("wz:wzFillIn:view")
	@RequestMapping(value = "lov")
	public String lov(WzFillIn wzFillIn, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzFillInList";
	}

    @ImsPreAuth("wz:wzFillIn:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzFillIn wzFillIn, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzFillIn:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzFillIn wzFillIn, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzFillIn:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzFillIn wzFillIn, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzFillIn:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzFillIn wzFillIn, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzFillIn:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzFillIn wzFillIn, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzFillIn:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzFillIn wzFillIn, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzFillIn:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzFillIn wzFillIn, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzFillIn:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzFillIn wzFillIn, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzFillIn,request,response,model);
	}

    @ImsPreAuth("wz:wzFillIn:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzFillIn wzFillIn,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzFillIn,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzFillIn:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzFillIn wzFillIn, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzFillIn,request,response );
	}

	//参数：指标编号，组织id,时间
	@RequestMapping(value = "getSelectIndexValue")
	@ResponseBody
	public Float getSelectIndexValue(String indexCode, String orgId, String time){
		return wzFillInService.getSelectIndexValue(indexCode,orgId,time);
	}
}
