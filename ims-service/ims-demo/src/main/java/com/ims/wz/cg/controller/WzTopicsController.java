/**
 *
 */
package com.ims.wz.cg.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ims.core.persistence.Page;
import com.ims.core.persistence.WebMsg;
import com.ims.core.utils.Encodes;
import com.ims.core.utils.ImsException;
import com.ims.core.utils.SysUtils;
import com.ims.core.utils.excel.ExportExcel;
import com.ims.system.auth.ImsPreAuth;
import com.ims.wz.cg.entity.WzNoticeMain;
import com.ims.wz.cg.entity.WzPlan;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springblade.core.tool.utils.StringUtil;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;

import com.ims.wz.cg.entity.WzTopics;
import com.ims.wz.cg.service.IWzTopicsService;

/**
 * wz_topicsController
 * @author lizhicong
 * @version 2021-09-23
 */
@Controller
@RequestMapping(value = "/wz/wzTopics")
public class WzTopicsController extends WebController<IWzTopicsService,WzTopics> {

	@Autowired
	private IWzTopicsService wzTopicsService;

 	@ImsPreAuth("wz:wzTopics:view")
	@RequestMapping(value = "list")
	public String list(WzTopics wzTopics, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTopicsList";
	}

    @ImsPreAuth("wz:wzTopics:view")
	@RequestMapping(value = "form")
	public String form(WzTopics wzTopics, Model model) {
	    String formView = wzTopics.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTopicsForm";
	}

    @ImsPreAuth("wz:wzTopics:view")
	@RequestMapping(value = "lov")
	public String lov(WzTopics wzTopics, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzTopicsList";
	}

    @ImsPreAuth("wz:wzTopics:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzTopics wzTopics, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return super.getData(wzTopics,request,response,model);
	}


    @ImsPreAuth("wz:wzTopics:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzTopics wzTopics, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzTopics,request,response,model);
	}

    @ImsPreAuth("wz:wzTopics:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzTopics wzTopics, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzTopics,request,response,model);
	}

    @ImsPreAuth("wz:wzTopics:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzTopics wzTopics, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzTopics,request,response,model);
	}

    @ImsPreAuth("wz:wzTopics:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzTopics wzTopics, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzTopics,request,response,model);
	}

    @ImsPreAuth("wz:wzTopics:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzTopics wzTopics, Model model,  HttpServletRequest request, HttpServletResponse response) {
		 return super.save(wzTopics,request,response,model);
	}

    @ImsPreAuth("wz:wzTopics:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzTopics wzTopics, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzTopics,request,response,model);
	}

    @ImsPreAuth("wz:wzTopics:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzTopics wzTopics, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzTopics,request,response,model);
	}

    @ImsPreAuth("wz:wzTopics:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(WzTopics wzTopics,MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(wzTopics,excelFile,null,request,response);
	}

    @ImsPreAuth("wz:wzTopics:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzTopics wzTopics, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzTopics,request,response );
	}

	@RequestMapping(value = "updateBath")
	@ResponseBody
	public Boolean updateBath(String wzTopicsList) throws Exception {
		List<WzTopics> list = JSONArray.parseArray(wzTopicsList,WzTopics.class);
		return wzTopicsService.updateBatchById(list);
	}
	@RequestMapping(value = "submit")
	@ResponseBody
	public Boolean submit(String submitData){
 		WzTopics wzTopics = JSONObject.parseObject(submitData,WzTopics.class);
 		return wzTopicsService.save(wzTopics);
	}
	@RequestMapping(value = "findListOfMeet")
	@ResponseBody
	public List<WzTopics> findListOfMeet(WzTopics wzTopics, HttpServletRequest request) {
		String baseFilter = request.getParameter("baseFilter");
		String baseQuery = (String) request.getAttribute("baseQuery");
		wzTopics.getSqlMap().put("baseQuery", baseQuery);
		wzTopics.getSqlMap().put("bf", baseFilter);
		if (StringUtils.equals(baseQuery.charAt(baseQuery.length() - 2) + "", "1") || StringUtils.equals(baseQuery.charAt(baseQuery.length() - 2) + "", "5")) {
			wzTopics.getSqlMap().put("orderBy", "a.stage_fzb = '0' DESC,a.stage_fzb = '1' DESC,a.stage_fzb = '2' DESC,a.stage_fzb = '3' DESC,a.category = '1' DESC,a.category = '2' DESC,a.category = '0' DESC");
		}else if (StringUtils.equals(baseQuery.charAt(baseQuery.length() - 2) + "", "6")) {
			wzTopics.getSqlMap().put("orderBy", "a.topics_type = '2' DESC,a.topics_type = '3' DESC,a.topics_type = '6' DESC");
		}
		return  wzTopicsService.findListOfMeet(wzTopics);
	}
	@RequestMapping(value = "exportExcel", method= RequestMethod.POST)
	@ResponseBody
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
		String fileName = request.getParameter("fileName");
		String columnsJson = request.getParameter("columns");
		String wzTopicsList = request.getParameter("wzTopics");
		List<WzTopics> list = JSONArray.parseArray(wzTopicsList,WzTopics.class);
		try {
			new ExportExcel("导出", columnsJson).setDataListM(list, columnsJson).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ImsException(e.getMessage(), e);
		} finally {
			afterProcess();
		}
	}
	@RequestMapping(value = "ZbToWord", method= RequestMethod.POST)
	@ResponseBody
	public Boolean ZbToWord(String wzTopicsList, HttpServletResponse response) {
		return wzTopicsService.ZbToWord(wzTopicsList, response);
	}
	@RequestMapping(value = "FzbToWord", method= RequestMethod.POST)
	@ResponseBody
	public Boolean FzbToWord(String wzTopicsList, HttpServletResponse response) {
		return wzTopicsService.FzbToWord(wzTopicsList, response);
	}
	@RequestMapping(value = "downLoadToWord", method= RequestMethod.GET)
	@ResponseBody
	public void downLoadToWord(HttpServletRequest request, HttpServletResponse response,String topicsType) {
		System.out.println("========================输出参数值" +  request.getParameter("topicsType"));
		try {
			String filePath = "/zb.docx";
			if (StringUtil.equals(request.getParameter("topicsType"),"1"))filePath = "/fzb.docx";
			// filePath是指欲下载的文件的路径。
			File file = new File(filePath);
			// 以流的形式下载文件。
			InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.setContentType("application/octet-stream; charset=utf-8");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(request.getParameter("fileName").getBytes("utf-8"), "ISO-8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = response.getOutputStream();
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
			file.delete();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "stopReason")
	@ResponseBody
	public Boolean stopReason(String id,String reason){
		WzTopics wzTopics = wzTopicsService.get(id);
		wzTopics.setTopicsStatus("xmzz");
		wzTopics.setStopReason(reason);
		return wzTopicsService.saveOrUpdate(wzTopics);
	}
}
