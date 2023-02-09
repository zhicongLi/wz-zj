/**
 *
 */
package com.ims.wz.cg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ims.system.auth.ImsPreAuth;
import com.ims.wz.cg.entity.WzTopics;
import com.ims.wz.cg.service.IWzTopicsService;
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
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;

import com.ims.wz.cg.entity.WzTopicsMetting;
import com.ims.wz.cg.service.IWzTopicsMettingService;

/**
 * wz_topics_mettingController
 * @author lizhicong
 * @version 2021-09-28
 */
@Controller
@RequestMapping(value = "/wz/wzTopicsMetting")
public class WzTopicsMettingController extends WebController<IWzTopicsMettingService,WzTopicsMetting> {

	@Autowired
	private IWzTopicsService wzTopicsService;

	@Autowired
	private IWzTopicsMettingService wzTopicsMettingService;

 	@ImsPreAuth("wz:wzTopicsMetting:view")
	@RequestMapping(value = "list")
	public String list(WzTopicsMetting wzTopicsMetting, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTopicsMettingList";
	}

    @ImsPreAuth("wz:wzTopicsMetting:view")
	@RequestMapping(value = "form")
	public String form(WzTopicsMetting wzTopicsMetting, Model model) {
	    String formView = wzTopicsMetting.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTopicsMettingForm";
	}

    @ImsPreAuth("wz:wzTopicsMetting:view")
	@RequestMapping(value = "lov")
	public String lov(WzTopicsMetting wzTopicsMetting, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTopicsMettingList";
	}

    @ImsPreAuth("wz:wzTopicsMetting:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzTopicsMetting wzTopicsMetting, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzTopicsMetting,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsMetting:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzTopicsMetting wzTopicsMetting, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzTopicsMetting,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsMetting:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzTopicsMetting wzTopicsMetting, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzTopicsMetting,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsMetting:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzTopicsMetting wzTopicsMetting, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzTopicsMetting,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsMetting:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzTopicsMetting wzTopicsMetting, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzTopicsMetting,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsMetting:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzTopicsMetting wzTopicsMetting, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzTopicsMetting,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsMetting:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzTopicsMetting wzTopicsMetting, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzTopicsMetting,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsMetting:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzTopicsMetting wzTopicsMetting, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
 		//删除前清除与议题关联
		List<WzTopics> wzTopicsList = wzTopicsService.queryList(wzTopicsMetting.getId());
		for(WzTopics wz : wzTopicsList){
			wz.setStatus("0");
			wz.setMettingNumber("");
		}
		wzTopicsService.updateBatchById(wzTopicsList);
		return super.remove(wzTopicsMetting,request,response,model);
	}

    @ImsPreAuth("wz:wzTopicsMetting:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzTopicsMetting wzTopicsMetting,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzTopicsMetting,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzTopicsMetting:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzTopicsMetting wzTopicsMetting, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzTopicsMetting,request,response );
	}

	@RequestMapping(value = "updateById", method= RequestMethod.POST)
	@ResponseBody
	public Boolean updateById(String wzTopicsMettingList) throws Exception {
		List<WzTopicsMetting> list = JSONArray.parseArray(wzTopicsMettingList,WzTopicsMetting.class);
		return wzTopicsMettingService.updateById(list.get(0));
	}

}
