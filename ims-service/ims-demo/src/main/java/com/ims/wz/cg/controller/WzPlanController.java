/**
 *
 */
package com.ims.wz.cg.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ims.core.controller.WebController;
import com.ims.core.utils.StringUtils;
import com.ims.system.auth.ImsPreAuth;
import com.ims.wz.cg.entity.WzPlan;
import com.ims.wz.cg.entity.WzTopics;
import com.ims.wz.cg.service.IWzPlanService;
import com.ims.wz.cg.service.IWzTopicsService;
import com.ims.wz.cg.service.impl.WzPlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 物资采购计划Controller
 * @author lizhicong
 * @version 2021-09-09
 */
@Controller
@RequestMapping(value = "/wz/wzPlan")
public class WzPlanController extends WebController<IWzPlanService,WzPlan> {

	@Autowired
	private IWzPlanService wzPlanService;
	@Autowired
	private IWzTopicsService wzTopicsService;
	@Autowired
	private WzPlanServiceImpl wzPlanService1;

 	@ImsPreAuth("wz:wzPlan:view")
	@RequestMapping(value = "list")
	public String list(WzPlan wzPlan, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanList";
	}

    @ImsPreAuth("wz:wzPlan:view")
	@RequestMapping(value = "form")
	public String form(WzPlan wzPlan, Model model) {
	    String formView = wzPlan.getFormView();
	    if(StringUtils.isNotBlank(formView)){
			return "cg/"+formView;
		}
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanForm";
	}

    @ImsPreAuth("wz:wzPlan:view")
	@RequestMapping(value = "lov")
	public String lov(WzPlan wzPlan, Model model) {
		return "cg/wz-cg${wz_cg_suffix}/wz/wzPlanList";
	}

    @ImsPreAuth("wz:wzPlan:view")
	@RequestMapping(value = "data")
	@ResponseBody
	public String getData(WzPlan wzPlan, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getData(wzPlan,request,response,model);
	}

    @ImsPreAuth("wz:wzPlan:view")
	@RequestMapping(value = "allData")
	@ResponseBody
	public String getAllData(WzPlan wzPlan, HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        return  super.getAllData(wzPlan,request,response,model);
	}

    @ImsPreAuth("wz:wzPlan:view")
	@RequestMapping(value = "get")
	@ResponseBody
	public String get(WzPlan wzPlan, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return  super.get(wzPlan,request,response,model);
	}

    @ImsPreAuth("wz:wzPlan:edit")
	@RequestMapping(value = "initInsert")
	@ResponseBody
	public String initInsert(WzPlan wzPlan, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.initInsert(wzPlan,request,response,model);
	}

    @ImsPreAuth("wz:wzPlan:edit")
	@RequestMapping(value = "checkSave")
	@ResponseBody
	public String checkSave(WzPlan wzPlan, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkSave(wzPlan,request,response,model);
	}

    @ImsPreAuth("wz:wzPlan:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(WzPlan wzPlan, Model model,  HttpServletRequest request, HttpServletResponse response) {
 		return super.save(wzPlan,request,response,model);
	}

    @ImsPreAuth("wz:wzPlan:remove")
	@RequestMapping(value = "checkRemove")
	@ResponseBody
	public String checkRemove(WzPlan wzPlan, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.checkRemove(wzPlan,request,response,model);
	}

    @ImsPreAuth("wz:wzPlan:remove")
	@RequestMapping(value = "remove")
	@ResponseBody
	public String remove(WzPlan wzPlan, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.remove(wzPlan,request,response,model);
	}

    @ImsPreAuth("wz:wzPlan:edit")
	@RequestMapping(value = "import",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String importFile(MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
         return super.importFile(excelFile,request,response);
	}

    @ImsPreAuth("wz:wzPlan:view")
	@RequestMapping(value = "export", method= RequestMethod.POST)
	public void exportFile(WzPlan wzPlan, HttpServletRequest request, HttpServletResponse response) {
         super.exportFile(wzPlan,request,response );
	}
	@RequestMapping(value = "updateBath")
	@ResponseBody
	public Boolean updateBath(String wzPlanList) throws Exception {
 		List<WzPlan> list = JSONArray.parseArray(wzPlanList,WzPlan.class);
		return wzPlanService.updateBatchById(list);
	}
	@RequestMapping(value = "saveOrUpdate")
	@ResponseBody
	public Boolean saveOrUpdate(String data){
 		WzPlan wzPlan = JSONObject.parseObject(data,WzPlan.class);
 		return wzPlanService.saveOrUpdate(wzPlan);
	}

	@RequestMapping(value = "stopReason")
	@ResponseBody
	public Boolean stopReason(String id,String reason){
		WzPlan wzPlan = wzPlanService.get(id);
		wzPlan.setStopReason(reason);
		wzPlan.setStatus("xmzz");
		wzPlan.setPlanStatus("xmzz");
		return wzPlanService.saveOrUpdate(wzPlan);
	}

	@RequestMapping(value = "createTopics")
	@ResponseBody
	public void createTopics(String data){
		 List<WzPlan> list = JSONArray.parseArray(data,WzPlan.class);
		 for(WzPlan wzPlan : list){
			 WzTopics wzTopics = new WzTopics();
			 wzTopics.setId(wzPlan.getId());
			 wzTopics.setCreateBy(wzPlan.getCreateBy());
			 wzTopics.setCreateByName(wzPlan.getCreateByName());
			 wzTopics.setCreateCompany(wzPlan.getCreateCompany());
			 wzTopics.setCreateDate(wzPlan.getCreateDate());
			 wzTopics.setCreateDept(wzPlan.getCreateDept());
			 wzTopics.setCreateDeptName(wzPlan.getCreateDeptName());
			 wzTopics.setCreateCompanyName(wzPlan.getCreateCompanyName());
			 //议题编号
			 wzTopics.setCode(wzPlanService.createCode(wzPlan.getCreateDept()));
			 //议题名称
			 wzTopics.setBiddingName("提请采委会审议的招标采购计划");
			 //议题类型
			 wzTopics.setTopicsType("4");
			 //资质业绩
			 wzTopics.setAchievementzb(wzPlan.getAchievement());
			 //采购范围
			 wzTopics.setProjectDescribezb(wzPlan.getProjectDescribe());
			 //分（子）公司名称
			 wzTopics.setSonCompany(wzPlan.getSonCompany());
			 //项目公司名称
			 wzTopics.setCompanyName1(wzPlan.getDept());
			 //招标项目名称
			 wzTopics.setProjectName(wzPlan.getProjectName());
			 //项目阶段
			 wzTopics.setStage(wzPlan.getStage());
			 //标的名称
			 wzTopics.setCategory(wzPlan.getCategory());
			 //概算金额
			 wzTopics.setBudget(wzPlan.getBudget());
			 //招标管理机构
			 wzTopics.setMechanism(wzPlan.getSonCompany());
			 //费用来源
			 wzTopics.setMoneyResource(wzPlan.getMoneyResource());
			 //议题填报人id
			 wzTopics.setWriteBy(wzPlan.getCreateBy());
			 //议题填报人
			 wzTopics.setWriteName(wzPlan.getInitiator());
			 //议题填报单位
			 wzTopics.setWriteDept(wzPlan.getDept());
			 //议题状态
			 wzTopics.setStatus("0");
			 //工期
			 wzTopics.setDuration(wzPlan.getDuration());
			 //所属板块
			 wzTopics.setPlate(wzPlan.getPlate());
			 //备注
			 wzTopics.setRemarkZb(wzPlan.getRemark());
			 //议题填报时间
			 //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 wzTopics.setWriteDate(new Date());
			 wzTopics.setIsNewRecord(true);
			 //议题状态 默认为提交状态
			 wzTopics.setTopicsStatus("0");
			 //采购制度依据
			 wzTopics.setProcurementBasisZb(wzPlan.getProcurementBasis());
			 wzTopicsService.save(wzTopics);
			 wzPlan.setIsgenerate("0");
			 wzPlanService.saveOrUpdate(wzPlan);
		 }
	}

	@RequestMapping(value = "createTopics1")
	@ResponseBody
	public void createTopics1(String data){
		List<WzPlan> list = JSONArray.parseArray(data,WzPlan.class);
		for(WzPlan wzPlan : list){
			WzTopics wzTopics = new WzTopics();
			//id
			wzTopics.setId(wzPlan.getId());
			wzTopics.setCreateBy(wzPlan.getCreateBy());
			wzTopics.setCreateByName(wzPlan.getCreateByName());
			wzTopics.setCreateCompany(wzPlan.getCreateCompany());
			wzTopics.setCreateDate(wzPlan.getCreateDate());
			wzTopics.setCreateDept(wzPlan.getCreateDept());
			wzTopics.setCreateDeptName(wzPlan.getCreateDeptName());
			wzTopics.setCreateCompanyName(wzPlan.getCreateCompanyName());
			//议题编号
			wzTopics.setCode(wzPlanService.createCode(wzPlan.getCreateDept()));
			//议题名称
			wzTopics.setBiddingName("提请采委会审议的非招标采购计划");
			//议题类型
			wzTopics.setTopicsType("5");
			//招标项目名称
			wzTopics.setProjectName(wzPlan.getProjectName());
			//标的名称
			wzTopics.setCategory(wzPlan.getCategory());
			wzTopics.setTypes(wzPlan.getCategory());
			//分（子）公司名称
			wzTopics.setSonCompany1(wzPlan.getSonCompany());
			//项目公司名称
			wzTopics.setCompanyName2(wzPlan.getDept());
			//采购方式
			wzTopics.setProcurementMethod(wzPlan.getProcurementMethod());
			//费用来源
			wzTopics.setMoneyResource1(wzPlan.getMoneyResource());
			//拟推荐供应商
			wzTopics.setSupplier(wzPlan.getSupplier());
			//主要工作内容
			wzTopics.setJobContent(wzPlan.getJobContent());
			//工作量
			wzTopics.setWorkload("项目简介：" + wzPlan.getProjectDescribe() +" 工作量：" + wzPlan.getWorkload());
			//工期
			wzTopics.setDuration1(wzPlan.getDuration());
			//人员情况
			wzTopics.setPeopleSituation(wzPlan.getPeopleSituation());
			//资质业绩
			wzTopics.setAchievement(wzPlan.getAchievement());
			//物资技术规格清单
			wzTopics.setDetailedList(wzPlan.getDetailedList());
			//议题填报人id
			wzTopics.setWriteBy(wzPlan.getCreateBy());
			//议题填报人
			wzTopics.setWriteName(wzPlan.getInitiator());
			//议题填报单位
			wzTopics.setWriteDept(wzPlan.getDept());
			//议题状态
			wzTopics.setStatus("0");
			//预算金额(万元)
			wzTopics.setBudgetFzb(wzPlan.getBudget());
			//非招标采购范围
			wzTopics.setProjectDescribe(wzPlan.getProjectDescribe());
			//非招标项目阶段
			wzTopics.setStageFzb(wzPlan.getStage());
			//议题填报时间
			//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			wzTopics.setWriteDate(new Date());
			//采购制度依据
			wzTopics.setProcurementBasisFzb(wzPlan.getProcurementBasis());
			wzTopics.setIsNewRecord(true);
			//议题状态 默认为提交状态
			wzTopics.setTopicsStatus("0");
			wzTopicsService.save(wzTopics);
			wzPlan.setIsgenerate("0");
			wzPlanService.saveOrUpdate(wzPlan);
		}
	}

}
