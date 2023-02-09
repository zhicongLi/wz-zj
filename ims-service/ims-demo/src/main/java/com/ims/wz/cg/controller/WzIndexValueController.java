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

import com.ims.wz.cg.entity.WzIndexValue;
import com.ims.wz.cg.service.IWzIndexValueService;

/**
 * 指标数据表Controller
 * @author lizhicong
 * @version 2022-06-20
 */
@Controller
@RequestMapping(value = "/wz/wzIndexValue")
public class WzIndexValueController extends WebController<IWzIndexValueService,WzIndexValue> {

	@Autowired
	private IWzIndexValueService wzIndexValueService;

 	@ImsPreAuth("wz:wzIndexValue:view")
	@RequestMapping(value = "list")
	public String list(WzIndexValue wzIndexValue, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzIndexValueList";
	}

    @ImsPreAuth("wz:wzIndexValue:view")
	@RequestMapping(value = "form")
	public String form(WzIndexValue wzIndexValue, Model model) {
	    String formView = wzIndexValue.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzIndexValueForm";
	}

    @ImsPreAuth("wz:wzIndexValue:view")
	@RequestMapping(value = "lov")
	public String lov(WzIndexValue wzIndexValue, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzIndexValueList";
	}

    @ImsPreAuth("wz:wzIndexValue:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzIndexValue wzIndexValue, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzIndexValue,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexValue:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzIndexValue wzIndexValue, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzIndexValue,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexValue:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzIndexValue wzIndexValue, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzIndexValue,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexValue:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzIndexValue wzIndexValue, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzIndexValue,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexValue:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzIndexValue wzIndexValue, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzIndexValue,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexValue:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzIndexValue wzIndexValue, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzIndexValue,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexValue:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzIndexValue wzIndexValue, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzIndexValue,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexValue:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzIndexValue wzIndexValue, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzIndexValue,request,response,model);
	}

    @ImsPreAuth("wz:wzIndexValue:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzIndexValue wzIndexValue,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzIndexValue,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzIndexValue:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzIndexValue wzIndexValue, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzIndexValue,request,response );
	}

	//参数：指标编号，组织id,时间，时间维度
	@RequestMapping(value = "selectIndexValue")
	@ResponseBody
	public List<WzIndexValue> selectIndexValue(String indexCode,String orgId,String time,String timeDimensionality){
 		return wzIndexValueService.selectIndexValue(indexCode,orgId,time,timeDimensionality);
	}

	//参数：指标编号，组织id,时间
	@RequestMapping(value = "getSelectIndexValue")
	@ResponseBody
	public List<WzIndexValue> getSelectIndexValue(String indexCode,String orgId,String time,String timeDimensionality){
		return wzIndexValueService.getSelectIndexValue(indexCode,orgId,time,timeDimensionality);
	}

	//参数：指标编号，组织id,时间
	@RequestMapping(value = "getSelectIndexValueForYear")
	@ResponseBody
	public WzIndexValue getSelectIndexValueForYear(String indexCode){
		return wzIndexValueService.getSelectIndexValueForYear(indexCode).get(0);
	}

}
