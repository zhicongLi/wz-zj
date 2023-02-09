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

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;

import com.ims.wz.cg.entity.WzEstablishment;
import com.ims.wz.cg.service.IWzEstablishmentService;

/**
 * wz_establishmentController
 * @author lizhicong
 * @version 2021-10-11
 */
@Controller
@RequestMapping(value = "/wz/wzEstablishment")
public class WzEstablishmentController extends WebController<IWzEstablishmentService,WzEstablishment> {

 	@ImsPreAuth("wz:wzEstablishment:view")
	@RequestMapping(value = "list")
	public String list(WzEstablishment wzEstablishment, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzEstablishmentList";
	}

    @ImsPreAuth("wz:wzEstablishment:view")
	@RequestMapping(value = "form")
	public String form(WzEstablishment wzEstablishment, Model model) {
	    String formView = wzEstablishment.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzEstablishmentForm";
	}

    @ImsPreAuth("wz:wzEstablishment:view")
	@RequestMapping(value = "lov")
	public String lov(WzEstablishment wzEstablishment, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzEstablishmentList";
	}

    @ImsPreAuth("wz:wzEstablishment:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzEstablishment wzEstablishment, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzEstablishment,request,response,model);
	}

    @ImsPreAuth("wz:wzEstablishment:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzEstablishment wzEstablishment, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzEstablishment,request,response,model);
	}

    @ImsPreAuth("wz:wzEstablishment:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzEstablishment wzEstablishment, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzEstablishment,request,response,model);
	}

    @ImsPreAuth("wz:wzEstablishment:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzEstablishment wzEstablishment, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzEstablishment,request,response,model);
	}

    @ImsPreAuth("wz:wzEstablishment:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzEstablishment wzEstablishment, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzEstablishment,request,response,model);
	}

    @ImsPreAuth("wz:wzEstablishment:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzEstablishment wzEstablishment, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzEstablishment,request,response,model);
	}

    @ImsPreAuth("wz:wzEstablishment:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzEstablishment wzEstablishment, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzEstablishment,request,response,model);
	}

    @ImsPreAuth("wz:wzEstablishment:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzEstablishment wzEstablishment, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzEstablishment,request,response,model);
	}

    @ImsPreAuth("wz:wzEstablishment:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzEstablishment wzEstablishment,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzEstablishment,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzEstablishment:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzEstablishment wzEstablishment, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzEstablishment,request,response );
	}

	@RequestMapping(value="downFile")
	public void downFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
 		String url = "D:/wzcg/TREPS开发手册1.4.5.docx";
 		File file = new File(url);
 		if(!file.exists()){
 			return;
		}
		InputStream inputStream = null;
		OutputStream outputStream = null;

		byte[] b = new byte[1024];
		int len = 0;
		try{
			inputStream = new FileInputStream(file);
			outputStream = response.getOutputStream();
			response.setContentType("application/force-download");
			String filename = file.getName();
			response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(filename,"UTF-8"));
			response.setContentLength((int)file.length());

			while((len = inputStream.read(b)) != -1){
				outputStream.write(b,0,len);
			}
			outputStream.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			outputStream.close();
			inputStream.close();
		}
	}
}
