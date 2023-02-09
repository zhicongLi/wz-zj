/**
 *
 */
package com.ims.wz.cg.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.system.auth.ImsPreAuth;
import com.ims.wz.cg.entity.WzTopics;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;

import com.ims.wz.cg.entity.WzItem;
import com.ims.wz.cg.service.IWzItemService;

/**
 * wz_itemController
 * @author lizhicong
 * @version 2022-05-06
 */
@Controller
@RequestMapping(value = "/wz/wzItem")
public class WzItemController extends WebController<IWzItemService,WzItem> {

	@Autowired
	private IWzItemService wzItemService;

 	@ImsPreAuth("wz:wzItem:view")
	@RequestMapping(value = "list")
	public String list(WzItem wzItem, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzItemList";
	}

    @ImsPreAuth("wz:wzItem:view")
	@RequestMapping(value = "form")
	public String form(WzItem wzItem, Model model) {
	    String formView = wzItem.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzItemForm";
	}

    @ImsPreAuth("wz:wzItem:view")
	@RequestMapping(value = "lov")
	public String lov(WzItem wzItem, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzItemList";
	}

    @ImsPreAuth("wz:wzItem:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzItem wzItem, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzItem,request,response,model);
	}

    @ImsPreAuth("wz:wzItem:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzItem wzItem, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzItem,request,response,model);
	}

    @ImsPreAuth("wz:wzItem:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzItem wzItem, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzItem,request,response,model);
	}

    @ImsPreAuth("wz:wzItem:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzItem wzItem, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzItem,request,response,model);
	}

    @ImsPreAuth("wz:wzItem:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzItem wzItem, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzItem,request,response,model);
	}

    @ImsPreAuth("wz:wzItem:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzItem wzItem, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzItem,request,response,model);
	}

    @ImsPreAuth("wz:wzItem:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzItem wzItem, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzItem,request,response,model);
	}

    @ImsPreAuth("wz:wzItem:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzItem wzItem, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzItem,request,response,model);
	}

    @ImsPreAuth("wz:wzItem:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzItem wzItem,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzItem,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzItem:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzItem wzItem, HttpServletRequest request, HttpServletResponse response) {
 		super.exportFile(wzItem,request,response );
	}

	@RequestMapping(value = "exportWord")
	@ResponseBody
	public String exportWord(HttpServletRequest request,HttpServletResponse response,String id){
		return wzItemService.exportWord(request,response,id);
	}

	@RequestMapping(value = "readWord")
	@ResponseBody
	public String readWord(HttpServletRequest request,HttpServletResponse response,String fileNamepdf) throws IOException{
		ServletOutputStream out = null;
		FileInputStream ips = null;
		String fileNamePdf = fileNamepdf + ".pdf";
		try{
			String url = "/file/" + fileNamePdf;
			File file = new File(url);
			if (!file.exists()){
				return null;
			}
			ips = new FileInputStream(file);
			response.setContentType("application/force-download");
			response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileNamePdf,"UTF-8"));
			response.setContentLength((int)file.length());
			out = response.getOutputStream();
			int len = 0;
			byte[] buffer = new byte[1024*10];
			while((len = ips.read(buffer))!=-1){
				out.write(buffer,0,len);
			}
			out.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out != null){
				out.close();
			}
			if(ips != null){
				out.close();
			}
		}
		return null;
	}

	@RequestMapping(value = "stopReason")
	@ResponseBody
	public Boolean stopReason(String id,String reason){
		WzItem wzItem =	wzItemService.get(id);
		wzItem.setPlanStatus("xmzz");
		wzItem.setStatus("xmzz");
		wzItem.setStopReason(reason);
		return wzItemService.saveOrUpdate(wzItem);
	}

	@RequestMapping(value = "updateIsgenerate")
	@ResponseBody
	public Boolean updateIsgenerate(String id){
		WzItem wzItem = wzItemService.get(id);
		wzItem.setIsgenerate("1");
		return wzItemService.saveOrUpdate(wzItem);
	}
}
