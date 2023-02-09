/**
 *
 */
package com.ims.wz.cg.entity;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;

import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * wz_form_approvalEntity
 * @author yx
 * @version 2021-10-20
 */
public class WzFormApproval extends DataEntity<WzFormApproval> {

	private static final long serialVersionUID = 1L;

	private String projectName0;	//表单的项目名称
	private String formNumber;		// 表单编号
	private String planNumber;		// 计划编号
	private String formType;		// 表单类型
	private String planWriter;		// 计划填报人
	private String planUnit;		// 计划填报单位
	private String planApproveTime;		// 计划审批时间
	private String purchaser;		// 采购人
	private String projectName;		// 标的名称\采购项目名称
	private Date reviewTime;		// 审查时间
	private String reviewTlace;		// 审查地点
	private String projectBudget;		// 标的概算\项目预算
	private String costSource;		// 费用来源
	private String procurementRange;		// 采购范围
	private String performance;		// 资质业绩条件
	private String qualifications;		// 资质要求
	private String creditStanding;		// 资信要求
	private String gradingMethods;		// 评分方法
	private String contentImproved;		// 审查提出需要修改完善的内容
	private String participants;		// 参加人员
	private String purchaseReason;		// 单一来源采购理由
	private String supplier;		// 供应商名称及联系方式
	private String selectReason;		// 选择原因
	private String purchaserDemandOp;		// 采购人-需求部门意见
	private Date purchaserDemandOpTime;		// 采购人-需求部门意见-时间
	private String purchaserMajorOp;		// 采购人-专业归口部门意见
	private Date purchaserMajorOpTime;		// 采购人-专业归口部门意见-时间
	private String purchaserPurchaseOp;		// 采购人-采购管理部门意见
	private Date purchaserPurchaseOpTime;		// 采购人-采购管理部门意见-时间
	private String purchaserLeaderOp;		// 采购人-分管领导意见
	private Date purchaserLeaderOpTime;		// 采购人-分管领导意见-时间
	private String purchaserMainOp;		// 采购人-主要领导意见
	private Date purchaserMainOpTime;		// 采购人-主要领导意见-时间
	private String jsMajorOp;		// 江苏公司-专业归口部门初审意见
	private Date jsMajorOpTime;		// 江苏公司-专业归口部门初审意见-时间
	private String jsMajorLeaderOp;		// 江苏公司-专业归口部门负责人意见
	private Date jsMajorLeaderOpTime;		// 江苏公司-专业归口部门负责人意见-时间
	private String jsPurchaseOp;		// 江苏公司-采购管理部门初审意见
	private Date jsPurchaseOpTime;		// 江苏公司-采购管理部门初审意见-时间
	private String jsPurchaseLeaderOp;		// 江苏公司-采购管理部门负责人意见
	private Date jsPurchaseLeaderOpTime;		// 江苏公司-采购管理部门负责人意见-时间
	private String finalDemandOp;		// 终审意见-业务部门初审意见
	private Date finalDemandOpTime;		// 终审意见-业务部门初审意见-时间
	private String finalPurchaseOp;		// 终审意见-采购部门初审意见
	private Date finalPurchaseOpTime;		// 终审意见-采购部门初审意见-时间
	private String finalDemandLeaderOp;		// 终审意见-业务部门负责人意见
	private Date finalDemandLeaderOpTime;		// 终审意见-业务部门负责人意见-时间
	private String finalPurchaseLeaderOp;		// 终审意见-采购部门负责人意见
	private Date finalPurchaseLeaderOpTime;		// 终审意见-采购部门负责人意见-时间
	private String tenantId;		// 租户id
	private String affiliatedUnit; //所属单位
	private String potentialInvestors; //潜在投资人
	private String inquiryNum;	//询价单号
	private String purchasePack;	//采购标包号
	private String firDealSup;	//首选成交供应商
	private String firDealSupPri;	//首选成交供应商价格
	private String secDealSup;	//备选成交供应商
	private String secDealSupPri;	//备选成交供应商价格
	private boolean isUseSecSup;	//是否选用备选成交供应商
	private String reasonDiscardFir;	//弃用首选供应商原因
	private String resultDiscardFir;	//弃用首选供应商核查结果
	private String finalDealPriSec;	//与备选成交供应商最终成交价
	private String secProDel;	//备选供应商承诺交货期
	private boolean isReExamined;	//是否重新审定
	private boolean isRePur;	//是否重新采购
	private boolean isReReview;	//是否重新评审
	private String repurReason;	//重新采购原因
	private String purFailAnalysis;	//采购失败分析
	private String purFailCorrect;	//采购失败纠正措施
	private String purFailImpro;	//采购失败文件完善意见
	private boolean isStopPlan;	//是否终止计划
	private boolean isCancelPlan;	//是否取消计划
	private String stopPurReason;	//终止采购原因
	private String stopPurAnalysis;	//终止采购失败原因分析
	private String stopPurCorrect;	//终止采购失败纠正错误
	private String classification;	//项目分类
	private String category;	//标的类别
	private String plate;	//专业板块
	//招标文件审查
	private String projectName2;
	private Date reviewnTime2;
	private String reviewPlace2;
	private String projectBudget2;
	private String purchaser2;
	private String affiliatedUnit2;
	private String procurementRange2;
	private String qualifications2;
	private String potentialInvestors2;
	private String gradingMethods2;
	private String contentImproved2;
	private String participants2;

	private String purchaserDemandOp2;
	private Date purchaserdEmandOpTime2;
	private String purchaseOp2;
	private Date purchaseOpTime2;
	private String purchaserMajorOp2;
	private Date purchaserMajorOpTime2;

	private String finalPurchaseOp2;
	private Date finalPurchaseOpTime2;
	private String finalPurchaseLeaderOp2;
	private Date finalPurchaseLeaderOpTime2;
	private String finalDemandOp2;
	private Date finalDemandOpTime2;
	private String finalDemandLeaderOp2;
	private Date finalDemandLeaderOpTime2;

	private String purchaser3; //采购人
	private String projectName3; //采购项目名称
	private String projectBudget3; //项目预算
	private String costSource3; //费用来源
	private String procurementRange3; //采购内容
	private String qualifications3; //资质要求
	private String performance3; //业绩要求
	private String creditStanding3; //资信要求
	private String purchaseReason3; //单一来源采购理由
	private String supplier3; //供应商名称及联系方式
	private String selectReason3; //选择原因
	private String purchaserDemandOp3; //采购人_需求部门意见
	private Date purchaserDemandOpTime3; //采购人_需求部门意见_日期
	private String purchaserMajorOp3; //采购人_专业部门意见
	private Date purchaserMajorOpTime3; //采购人_专业部门意见_日期
	private String purchaserPurchaseOp3; //采购人_采购部门意见
	private Date purchaserPurchaseOpTime3; //采购人_采购部门意见_日期
	private String purchaserLeaderOp3; //采购人_需求部门分管领导意见
	private Date purchaserLeaderOpTime3; //采购人_需求部门分管领导意见_日期
	private String purchaserMainOp3; //采购人_领导意见
	private Date purchaserMainOpTime3; //采购人_领导意见_日期
	private String jsMajorOp3; //江苏公司_专业_初审意见
	private Date jsMajorOpTime3; //江苏公司_专业_初审意见_时间
	private String jsMajorLeaderOp3; //江苏公司_专业_部门意见
	private Date jsMajorLeaderOpTime3; //江苏公司_专业_部门意见_时间
	private String jsPurchaseOp3; //江苏公司_采购_初审意见
	private Date jsPurchaseOpTime3; //江苏公司_采购_初审意见_时间
	private String jsPurchaseLeaderOp3; //江苏公司_采购_部门意见
	private Date jsPurchaseLeaderOpTime3; //江苏公司_采购_部门意见_时间

	private String purchaser4; //采购人
	private String projectName4; //采购项目名称
	private String projectBudget4; //项目预算
	private String costSource4; //费用来源
	private String procurementRange4; //采购内容
	private String qualifications4; //资质要求
	private String performance4; //业绩要求
	private String creditStanding4; //资信要求
	private String purchaseReason4; //单一来源采购理由
	private String supplier4; //供应商名称及联系方式
	private String selectReason4; //选择原因
	private String purchaserDemandOp4; //采购人_需求部门意见
	private Date purchaserDemandOpTime4; //采购人_需求部门意见_日期
	private String purchaserMajorOp4; //采购人_专业部门意见
	private Date purchaserMajorOpTime4; //采购人_专业部门意见_日期
	private String purchaserPurchaseOp4; //采购人_采购部门意见
	private Date purchaserPurchaseOpTime4; //采购人_采购部门意见_日期
	private String purchaserLeaderOp4; //采购人_需求部门分管领导意见
	private Date purchaserLeaderOpTime4; //采购人_需求部门分管领导意见_日期
	private String purchaserMainOp4; //采购人_领导意见
	private Date purchaserMainOpTime4; //采购人_领导意见_日期
	private String jsMajorOp4; //江苏公司_专业_初审意见
	private Date jsMajorOpTime4; //江苏公司_专业_初审意见_时间
	private String jsMajorLeaderOp4; //江苏公司_专业_部门意见
	private Date jsMajorLeaderOpTime4; //江苏公司_专业_部门意见_时间
	private String jsPurchaseOp4; //江苏公司_采购_初审意见
	private Date jsPurchaseOpTime4; //江苏公司_采购_初审意见_时间
	private String jsPurchaseLeaderOp4; //江苏公司_采购_部门意见
	private Date jsPurchaseLeaderOpTime4; //江苏公司_采购_部门意见_时间

	private String purchaser5; //采购人
	private String projectName5; //采购项目名称
	private Date reviewnTime5; //审查时间
	private String projectBudget5; //标的概算
	private String costSource5; //费用来源
	private String procurementRange5; //采购内容
	private String performance5; //资质业绩要求
	private String qualifications5; //资质要求
	private String perReq5; //业绩要求
	private String creditStanding5; //资信要求
	private String gradingMethods5; //评分方法
	private String purchaseReason5; //单一来源采购理由
	private String supplier5; //供应商名称及联系方式
	private String selectReason5; //选择原因
	private String contentImproved5; //审查提出需要完善的内容
	private String participants5; //参加人员
	private String purchaserDemandOp5; //采购人_需求部门意见
	private Date purchaserDemandOpTime5; //采购人_需求部门意见_日期
	private String purchaserMajorOp5; //采购人_专业部门意见
	private Date purchaserMajorOpTime5; //采购人_专业部门意见_日期
	private String purchaserPurchaseOp5; //采购人_采购部门意见
	private Date purchaserPurchaseOpTime5; //采购人_采购部门意见_日期
	private String purchaserLeaderOp5; //采购人_需求部门分管领导意见
	private Date purchaserLeaderOpTime5; //采购人_需求部门分管领导意见_日期
	private String purchaserMainOp5; //采购人_领导意见
	private Date purchaserMainOpTime5; //采购人_领导意见_日期
	private String jsMajorOp5; //江苏公司_专业_初审意见
	private Date jsMajorOpTime5; //江苏公司_专业_初审意见_时间
	private String jsMajorLeaderOp5; //江苏公司_专业_部门意见
	private Date jsMajorLeaderOpTime5; //江苏公司_专业_部门意见_时间
	private String jsPurchaseOp5; //江苏公司_采购_初审意见
	private Date jsPurchaseOpTime5; //江苏公司_采购_初审意见_时间
	private String jsPurchaseLeaderOp5; //江苏公司_采购_部门意见
	private Date jsPurchaseLeaderOpTime5; //江苏公司_采购_部门意见_时间

	private String purchaser6; //采购人
	private String projectName6; //采购项目名称
	private Date reviewnTime6; //审查时间
	private String projectBudget6; //标的概算
	private String costSource6; //费用来源
	private String procurementRange6; //采购内容
	private String performance6; //资质业绩要求
	private String qualifications6; //资质要求
	private String perReq6; //业绩要求
	private String creditStanding6; //资信要求
	private String gradingMethods6; //评分方法
	private String purchaseReason6; //单一来源采购理由
	private String supplier6; //供应商名称及联系方式
	private String selectReason6; //选择原因
	private String contentImproved6; //审查提出需要完善的内容
	private String participants6; //参加人员
	private String purchaserDemandOp6; //采购人_需求部门意见
	private Date purchaserDemandOpTime6; //采购人_需求部门意见_日期
	private String purchaserMajorOp6; //采购人_专业部门意见
	private Date purchaserMajorOpTime6; //采购人_专业部门意见_日期
	private String purchaserPurchaseOp6; //采购人_采购部门意见
	private Date purchaserPurchaseOpTime6; //采购人_采购部门意见_日期
	private String purchaserLeaderOp6; //采购人_需求部门分管领导意见
	private Date purchaserLeaderOpTime6; //采购人_需求部门分管领导意见_日期
	private String purchaserMainOp6; //采购人_领导意见
	private Date purchaserMainOpTime6; //采购人_领导意见_日期
	private String jsMajorOp6; //江苏公司_专业_初审意见
	private Date jsMajorOpTime6; //江苏公司_专业_初审意见_时间
	private String jsMajorLeaderOp6; //江苏公司_专业_部门意见
	private Date jsMajorLeaderOpTime6; //江苏公司_专业_部门意见_时间
	private String jsPurchaseOp6; //江苏公司_采购_初审意见
	private Date jsPurchaseOpTime6; //江苏公司_采购_初审意见_时间
	private String jsPurchaseLeaderOp6; //江苏公司_采购_部门意见
	private Date jsPurchaseLeaderOpTime6; //江苏公司_采购_部门意见_时间

	private String purchaser7; //采购人
	private String projectName7; //项目名称
	private String projectBudget7; //项目预算
	private String purchaserDemandOp7; //采购人_需求部门意见
	private Date purchaserDemandOpTime7; //采购人_需求部门意见_日期
	private String purchaserMajorOp7; //采购人_专业部门意见
	private Date purchaserMajorOpTime7; //采购人_专业部门意见_日期
	private String purchaserPurchaseOp7; //采购人_采购部门意见
	private Date purchaserPurchaseOpTime7; //采购人_采购部门意见_日期
	private String purchaserLeaderOp7; //采购人_需求部门分管领导意见
	private Date purchaserLeaderOpTime7; //采购人_需求部门分管领导意见_日期
	private String purchaserMainOp7; //采购人_领导意见
	private Date purchaserMainOpTime7; //采购人_领导意见_日期
	private String jsMajorOp7; //江苏公司_专业_初审意见
	private Date jsMajorOpTime7; //江苏公司_专业_初审意见_时间
	private String jsMajorLeaderOp7; //江苏公司_专业_部门意见
	private Date jsMajorLeaderOpTime7; //江苏公司_专业_部门意见_时间
	private String jsPurchaseOp7; //江苏公司_采购_初审意见
	private Date jsPurchaseOpTime7; //江苏公司_采购_初审意见_时间
	private String jsPurchaseLeaderOp7; //江苏公司_采购_部门意见
	private Date jsPurchaseLeaderOpTime7; //江苏公司_采购_部门意见_时间
	private String zygkId;	//专业归口审批人id

	private String flag;	//流程状态
	private String participantsIds;	//参会人员ids

	private Boolean ifNeedMajor;	//是否需要专业归口的人
	private String formStatus;	//表单状态

	private String projectName8;	//项目名称
	private String projectBname8;	//标的物名称
	private Date planTime8;		//计划签约时间
	private String projectDeptName8;	//项目单位
	private String sonCompany8;		//子公司名称
	private String plate8;		//专业板块
	private String planNumber8;		//计划编号
	private String stage8;	//项目阶段
	private String twoCategory8;	//二级分类
	private String projectBcategory8;	//标的物类别
	private String projectBudget8;		//概算/预算（万元）
	private String procumentMethod8;	//采购方式
	private String jurisdiction8;		//采购管理权限
	private String moneyResource8;		//采购依据，资金来源
	private String projectDescribe8;	//项目简介
	private String workload8;		//工作量
	private String duration8;		//工期
	private String peopleSituation8;	//人员状况
	private String purchaserDemandOp8;	//需求部门意见
	private Date purchaserdEmandOpTime8;	//需求部门审批时间
	private String purchaseOp8;		//采购部门审批意见
	private Date purchaseOpTime8;		//采购部门审批时间
	private String purchaserMajorOp8;	//分管领导及主要负责人审批意见
	private Date purchaserMajorOpTime8;	//分管领导及主要负责人审批时间
	private String finalDemandLeaderOp8;	//业务部门审批意见
	private Date finalDemandLeaderOpTime8;	//业务部门审批时间
	private String finalPurchaseLeaderOp8;		//采购部门意见
	private Date finalPurchaseLeaderOpTime8;	//采购部门审批时间
	private String jsPurchaserLeaderOp8;		//分管领导意见
	private Date jsPurchaserLeaderOpTime8;	//分管领导审批时间
	private String iszbsp;		//是否是招标审批
	private String checkId;		//需求部门审批人id
	private String checkMan;	//需求部门审批人name
	private String checkZygkId;		//专业归口审批人id
	private String checkZygkMan;	//专业归口审批人name
	private String checkFgldId;		//分管领导审批人id
	private String checkFgldMan;	//分管领导审批人name
	private String zygkCharge;		//专业归口部门负责人
	private String cgglCharge;		//采购管理部门负责人
	private String zygkChargeId;	//专业归口部门负责人id
	private String cgglChargeId;	//采购管理部门负责人id
	private String stopReason;		//终止原因
	private String fgldName;		//江苏公司专业归口分管领导
	private String fgldId;			//江苏公司专业归口分管领导ID
	private String jsZygkName;		//江苏公司专业归口审批人name
	private String jsZygkId;		//江苏公司专业归口审批人ID
	private Date approvalEndTime;	//江苏采购部门审批时间

	@JSONField(format = "yyyy-MM-dd")
	public Date getApprovalEndTime() {
		return approvalEndTime;
	}

	public void setApprovalEndTime(Date approvalEndTime) {
		this.approvalEndTime = approvalEndTime;
	}

	public String getJsZygkName() {
		return jsZygkName;
	}

	public void setJsZygkName(String jsZygkName) {
		this.jsZygkName = jsZygkName;
	}

	public String getJsZygkId() {
		return jsZygkId;
	}

	public void setJsZygkId(String jsZygkId) {
		this.jsZygkId = jsZygkId;
	}

	public String getFgldName() {
		return fgldName;
	}

	public void setFgldName(String fgldName) {
		this.fgldName = fgldName;
	}

	public String getFgldId() {
		return fgldId;
	}

	public void setFgldId(String fgldId) {
		this.fgldId = fgldId;
	}

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}

	public String getZygkChargeId() {
		return zygkChargeId;
	}

	public void setZygkChargeId(String zygkChargeId) {
		this.zygkChargeId = zygkChargeId;
	}

	public String getCgglChargeId() {
		return cgglChargeId;
	}

	public void setCgglChargeId(String cgglChargeId) {
		this.cgglChargeId = cgglChargeId;
	}

	public String getZygkCharge() {
		return zygkCharge;
	}

	public void setZygkCharge(String zygkCharge) {
		this.zygkCharge = zygkCharge;
	}

	public String getCgglCharge() {
		return cgglCharge;
	}

	public void setCgglCharge(String cgglCharge) {
		this.cgglCharge = cgglCharge;
	}

	public String getCheckZygkId() {
		return checkZygkId;
	}

	public void setCheckZygkId(String checkZygkId) {
		this.checkZygkId = checkZygkId;
	}

	public String getCheckZygkMan() {
		return checkZygkMan;
	}

	public void setCheckZygkMan(String checkZygkMan) {
		this.checkZygkMan = checkZygkMan;
	}

	public String getCheckFgldId() {
		return checkFgldId;
	}

	public void setCheckFgldId(String checkFgldId) {
		this.checkFgldId = checkFgldId;
	}

	public String getCheckFgldMan() {
		return checkFgldMan;
	}

	public void setCheckFgldMan(String checkFgldMan) {
		this.checkFgldMan = checkFgldMan;
	}

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public String getCheckMan() {
		return checkMan;
	}

	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}

	public String getIszbsp() {
		return iszbsp;
	}

	public void setIszbsp(String iszbsp) {
		this.iszbsp = iszbsp;
	}

	public String getProjectName8() {
		return projectName8;
	}

	public void setProjectName8(String projectName8) {
		this.projectName8 = projectName8;
	}

	public String getProjectBname8() {
		return projectBname8;
	}

	public void setProjectBname8(String projectBname8) {
		this.projectBname8 = projectBname8;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPlanTime8() {
		return planTime8;
	}

	public void setPlanTime8(Date planTime8) {
		this.planTime8 = planTime8;
	}

	public String getProjectDeptName8() {
		return projectDeptName8;
	}

	public void setProjectDeptName8(String projectDeptName8) {
		this.projectDeptName8 = projectDeptName8;
	}

	public String getSonCompany8() {
		return sonCompany8;
	}

	public void setSonCompany8(String sonCompany8) {
		this.sonCompany8 = sonCompany8;
	}

	public String getPlate8() {
		return plate8;
	}

	public void setPlate8(String plate8) {
		this.plate8 = plate8;
	}

	public String getPlanNumber8() {
		return planNumber8;
	}

	public void setPlanNumber8(String planNumber8) {
		this.planNumber8 = planNumber8;
	}

	public String getStage8() {
		return stage8;
	}

	public void setStage8(String stage8) {
		this.stage8 = stage8;
	}

	public String getTwoCategory8() {
		return twoCategory8;
	}

	public void setTwoCategory8(String twoCategory8) {
		this.twoCategory8 = twoCategory8;
	}

	public String getProjectBcategory8() {
		return projectBcategory8;
	}

	public void setProjectBcategory8(String projectBcategory8) {
		this.projectBcategory8 = projectBcategory8;
	}

	public String getProjectBudget8() {
		return projectBudget8;
	}

	public void setProjectBudget8(String projectBudget8) {
		this.projectBudget8 = projectBudget8;
	}

	public String getProcumentMethod8() {
		return procumentMethod8;
	}

	public void setProcumentMethod8(String procumentMethod8) {
		this.procumentMethod8 = procumentMethod8;
	}

	public String getJurisdiction8() {
		return jurisdiction8;
	}

	public void setJurisdiction8(String jurisdiction8) {
		this.jurisdiction8 = jurisdiction8;
	}

	public String getMoneyResource8() {
		return moneyResource8;
	}

	public void setMoneyResource8(String moneyResource8) {
		this.moneyResource8 = moneyResource8;
	}

	public String getProjectDescribe8() {
		return projectDescribe8;
	}

	public void setProjectDescribe8(String projectDescribe8) {
		this.projectDescribe8 = projectDescribe8;
	}

	public String getWorkload8() {
		return workload8;
	}

	public void setWorkload8(String workload8) {
		this.workload8 = workload8;
	}

	public String getDuration8() {
		return duration8;
	}

	public void setDuration8(String duration8) {
		this.duration8 = duration8;
	}

	public String getPeopleSituation8() {
		return peopleSituation8;
	}

	public void setPeopleSituation8(String peopleSituation8) {
		this.peopleSituation8 = peopleSituation8;
	}

	public String getPurchaserDemandOp8() {
		return purchaserDemandOp8;
	}

	public void setPurchaserDemandOp8(String purchaserDemandOp8) {
		this.purchaserDemandOp8 = purchaserDemandOp8;
	}


	public String getPurchaseOp8() {
		return purchaseOp8;
	}

	public void setPurchaseOp8(String purchaseOp8) {
		this.purchaseOp8 = purchaseOp8;
	}


	public String getPurchaserMajorOp8() {
		return purchaserMajorOp8;
	}

	public void setPurchaserMajorOp8(String purchaserMajorOp8) {
		this.purchaserMajorOp8 = purchaserMajorOp8;
	}

	public String getFinalDemandLeaderOp8() {
		return finalDemandLeaderOp8;
	}

	public void setFinalDemandLeaderOp8(String finalDemandLeaderOp8) {
		this.finalDemandLeaderOp8 = finalDemandLeaderOp8;
	}

	public String getFinalPurchaseLeaderOp8() {
		return finalPurchaseLeaderOp8;
	}

	public void setFinalPurchaseLeaderOp8(String finalPurchaseLeaderOp8) {
		this.finalPurchaseLeaderOp8 = finalPurchaseLeaderOp8;
	}

	public String getJsPurchaserLeaderOp8() {
		return jsPurchaserLeaderOp8;
	}

	public void setJsPurchaserLeaderOp8(String jsPurchaserLeaderOp8) {
		this.jsPurchaserLeaderOp8 = jsPurchaserLeaderOp8;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserdEmandOpTime8() {
		return purchaserdEmandOpTime8;
	}
	public void setPurchaserdEmandOpTime8(Date purchaserdEmandOpTime8) {
		this.purchaserdEmandOpTime8 = purchaserdEmandOpTime8;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaseOpTime8() {
		return purchaseOpTime8;
	}
	public void setPurchaseOpTime8(Date purchaseOpTime8) {
		this.purchaseOpTime8 = purchaseOpTime8;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMajorOpTime8() {
		return purchaserMajorOpTime8;
	}

	public void setPurchaserMajorOpTime8(Date purchaserMajorOpTime8) {
		this.purchaserMajorOpTime8 = purchaserMajorOpTime8;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getFinalDemandLeaderOpTime8() {
		return finalDemandLeaderOpTime8;
	}

	public void setFinalDemandLeaderOpTime8(Date finalDemandLeaderOpTime8) {
		this.finalDemandLeaderOpTime8 = finalDemandLeaderOpTime8;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getFinalPurchaseLeaderOpTime8() {
		return finalPurchaseLeaderOpTime8;
	}

	public void setFinalPurchaseLeaderOpTime8(Date finalPurchaseLeaderOpTime8) {
		this.finalPurchaseLeaderOpTime8 = finalPurchaseLeaderOpTime8;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaserLeaderOpTime8() {
		return jsPurchaserLeaderOpTime8;
	}
	public void setJsPurchaserLeaderOpTime8(Date jsPurchaserLeaderOpTime8) {
		this.jsPurchaserLeaderOpTime8 = jsPurchaserLeaderOpTime8;
	}

	public String getZygkId() {
		return zygkId;
	}

	public void setZygkId(String zygkId) {
		this.zygkId = zygkId;
	}

	public String getProjectName0() {
		return projectName0;
	}

	public void setProjectName0(String projectName0) {
		this.projectName0 = projectName0;
	}

	public WzFormApproval() {
		super();
	}

	public WzFormApproval(String id){
		super(id);
	}

	public String getFormNumber() {
		return formNumber;
	}

	public void setFormNumber(String formNumber) {
		this.formNumber = formNumber;
	}
	public String getPlanNumber() {
		return planNumber;
	}

	public void setPlanNumber(String planNumber) {
		this.planNumber = planNumber;
	}
	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getPlanWriter() {
		return planWriter;
	}

	public void setPlanWriter(String planWriter) {
		this.planWriter = planWriter;
	}
	public String getPlanUnit() {
		return planUnit;
	}


	public void setPlanUnit(String planUnit) {
		this.planUnit = planUnit;
	}

	public String getPlanApproveTime() {
		return planApproveTime;
	}

	public void setPlanApproveTime(String planApproveTime) {
		this.planApproveTime = planApproveTime;
	}

	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	public String getReviewTlace() {
		return reviewTlace;
	}

	public void setReviewTlace(String reviewTlace) {
		this.reviewTlace = reviewTlace;
	}
	public String getProjectBudget() {
		return projectBudget;
	}

	public void setProjectBudget(String projectBudget) {
		this.projectBudget = projectBudget;
	}
	public String getCostSource() {
		return costSource;
	}

	public void setCostSource(String costSource) {
		this.costSource = costSource;
	}
	public String getProcurementRange() {
		return procurementRange;
	}

	public void setProcurementRange(String procurementRange) {
		this.procurementRange = procurementRange;
	}
	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public String getCreditStanding() {
		return creditStanding;
	}

	public void setCreditStanding(String creditStanding) {
		this.creditStanding = creditStanding;
	}
	public String getGradingMethods() {
		return gradingMethods;
	}

	public void setGradingMethods(String gradingMethods) {
		this.gradingMethods = gradingMethods;
	}
	public String getContentImproved() {
		return contentImproved;
	}

	public void setContentImproved(String contentImproved) {
		this.contentImproved = contentImproved;
	}
	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}
	public String getPurchaseReason() {
		return purchaseReason;
	}

	public void setPurchaseReason(String purchaseReason) {
		this.purchaseReason = purchaseReason;
	}
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getSelectReason() {
		return selectReason;
	}

	public void setSelectReason(String selectReason) {
		this.selectReason = selectReason;
	}
	public String getPurchaserDemandOp() {
		return purchaserDemandOp;
	}

	public void setPurchaserDemandOp(String purchaserDemandOp) {
		this.purchaserDemandOp = purchaserDemandOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserDemandOpTime() {
		return purchaserDemandOpTime;
	}

	public void setPurchaserDemandOpTime(Date purchaserDemandOpTime) {
		this.purchaserDemandOpTime = purchaserDemandOpTime;
	}
	public String getPurchaserMajorOp() {
		return purchaserMajorOp;
	}

	public void setPurchaserMajorOp(String purchaserMajorOp) {
		this.purchaserMajorOp = purchaserMajorOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMajorOpTime() {
		return purchaserMajorOpTime;
	}

	public void setPurchaserMajorOpTime(Date purchaserMajorOpTime) {
		this.purchaserMajorOpTime = purchaserMajorOpTime;
	}
	public String getPurchaserPurchaseOp() {
		return purchaserPurchaseOp;
	}

	public void setPurchaserPurchaseOp(String purchaserPurchaseOp) {
		this.purchaserPurchaseOp = purchaserPurchaseOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserPurchaseOpTime() {
		return purchaserPurchaseOpTime;
	}

	public void setPurchaserPurchaseOpTime(Date purchaserPurchaseOpTime) {
		this.purchaserPurchaseOpTime = purchaserPurchaseOpTime;
	}
	public String getPurchaserLeaderOp() {
		return purchaserLeaderOp;
	}

	public void setPurchaserLeaderOp(String purchaserLeaderOp) {
		this.purchaserLeaderOp = purchaserLeaderOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserLeaderOpTime() {
		return purchaserLeaderOpTime;
	}

	public void setPurchaserLeaderOpTime(Date purchaserLeaderOpTime) {
		this.purchaserLeaderOpTime = purchaserLeaderOpTime;
	}

	public String getPurchaserMainOp() {
		return purchaserMainOp;
	}

	public void setPurchaserMainOp(String purchaserMainOp) {
		this.purchaserMainOp = purchaserMainOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMainOpTime() {
		return purchaserMainOpTime;
	}

	public void setPurchaserMainOpTime(Date purchaserMainOpTime) {
		this.purchaserMainOpTime = purchaserMainOpTime;
	}
	public String getJsMajorOp() {
		return jsMajorOp;
	}

	public void setJsMajorOp(String jsMajorOp) {
		this.jsMajorOp = jsMajorOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorOpTime() {
		return jsMajorOpTime;
	}

	public void setJsMajorOpTime(Date jsMajorOpTime) {
		this.jsMajorOpTime = jsMajorOpTime;
	}
	public String getJsMajorLeaderOp() {
		return jsMajorLeaderOp;
	}

	public void setJsMajorLeaderOp(String jsMajorLeaderOp) {
		this.jsMajorLeaderOp = jsMajorLeaderOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorLeaderOpTime() {
		return jsMajorLeaderOpTime;
	}

	public void setJsMajorLeaderOpTime(Date jsMajorLeaderOpTime) {
		this.jsMajorLeaderOpTime = jsMajorLeaderOpTime;
	}
	public String getJsPurchaseOp() {
		return jsPurchaseOp;
	}

	public void setJsPurchaseOp(String jsPurchaseOp) {
		this.jsPurchaseOp = jsPurchaseOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseOpTime() {
		return jsPurchaseOpTime;
	}

	public void setJsPurchaseOpTime(Date jsPurchaseOpTime) {
		this.jsPurchaseOpTime = jsPurchaseOpTime;
	}
	public String getJsPurchaseLeaderOp() {
		return jsPurchaseLeaderOp;
	}

	public void setJsPurchaseLeaderOp(String jsPurchaseLeaderOp) {
		this.jsPurchaseLeaderOp = jsPurchaseLeaderOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseLeaderOpTime() {
		return jsPurchaseLeaderOpTime;
	}

	public void setJsPurchaseLeaderOpTime(Date jsPurchaseLeaderOpTime) {
		this.jsPurchaseLeaderOpTime = jsPurchaseLeaderOpTime;
	}
	public String getFinalDemandOp() {
		return finalDemandOp;
	}

	public void setFinalDemandOp(String finalDemandOp) {
		this.finalDemandOp = finalDemandOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getFinalDemandOpTime() {
		return finalDemandOpTime;
	}

	public void setFinalDemandOpTime(Date finalDemandOpTime) {
		this.finalDemandOpTime = finalDemandOpTime;
	}
	public String getFinalPurchaseOp() {
		return finalPurchaseOp;
	}

	public void setFinalPurchaseOp(String finalPurchaseOp) {
		this.finalPurchaseOp = finalPurchaseOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getFinalPurchaseOpTime() {
		return finalPurchaseOpTime;
	}

	public void setFinalPurchaseOpTime(Date finalPurchaseOpTime) {
		this.finalPurchaseOpTime = finalPurchaseOpTime;
	}
	public String getFinalDemandLeaderOp() {
		return finalDemandLeaderOp;
	}

	public void setFinalDemandLeaderOp(String finalDemandLeaderOp) {
		this.finalDemandLeaderOp = finalDemandLeaderOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getFinalDemandLeaderOpTime() {
		return finalDemandLeaderOpTime;
	}

	public void setFinalDemandLeaderOpTime(Date finalDemandLeaderOpTime) {
		this.finalDemandLeaderOpTime = finalDemandLeaderOpTime;
	}
	public String getFinalPurchaseLeaderOp() {
		return finalPurchaseLeaderOp;
	}

	public void setFinalPurchaseLeaderOp(String finalPurchaseLeaderOp) {
		this.finalPurchaseLeaderOp = finalPurchaseLeaderOp;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getFinalPurchaseLeaderOpTime() {
		return finalPurchaseLeaderOpTime;
	}

	public void setFinalPurchaseLeaderOpTime(Date finalPurchaseLeaderOpTime) {
		this.finalPurchaseLeaderOpTime = finalPurchaseLeaderOpTime;
	}
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getAffiliatedUnit() {
		return affiliatedUnit;
	}

	public void setAffiliatedUnit(String affiliatedUnit) {
		this.affiliatedUnit = affiliatedUnit;
	}

	public String getPotentialInvestors() {
		return potentialInvestors;
	}

	public void setPotentialInvestors(String potentialInvestors) {
		this.potentialInvestors = potentialInvestors;
	}

	public String getInquiryNum() {
		return inquiryNum;
	}

	public void setInquiryNum(String inquiryNum) {
		this.inquiryNum = inquiryNum;
	}

	public String getPurchasePack() {
		return purchasePack;
	}

	public void setPurchasePack(String purchasePack) {
		this.purchasePack = purchasePack;
	}

	public String getFirDealSup() {
		return firDealSup;
	}

	public void setFirDealSup(String firDealSup) {
		this.firDealSup = firDealSup;
	}

	public String getFirDealSupPri() {
		return firDealSupPri;
	}

	public void setFirDealSupPri(String firDealSupPri) {
		this.firDealSupPri = firDealSupPri;
	}

	public String getSecDealSup() {
		return secDealSup;
	}

	public void setSecDealSup(String secDealSup) {
		this.secDealSup = secDealSup;
	}

	public String getSecDealSupPri() {
		return secDealSupPri;
	}

	public void setSecDealSupPri(String secDealSupPri) {
		this.secDealSupPri = secDealSupPri;
	}

	public Boolean getIsUseSecSup() {
		return isUseSecSup;
	}

	public void setIsUseSecSup(Boolean isUseSecSup) {
		this.isUseSecSup = isUseSecSup;
	}

	public String getReasonDiscardFir() {
		return reasonDiscardFir;
	}

	public void setReasonDiscardFir(String reasonDiscardFir) {
		this.reasonDiscardFir = reasonDiscardFir;
	}

	public String getResultDiscardFir() {
		return resultDiscardFir;
	}

	public void setResultDiscardFir(String resultDiscardFir) {
		this.resultDiscardFir = resultDiscardFir;
	}

	public String getFinalDealPriSec() {
		return finalDealPriSec;
	}

	public void setFinalDealPriSec(String finalDealPriSec) {
		this.finalDealPriSec = finalDealPriSec;
	}

	public String getSecProDel() {
		return secProDel;
	}

	public void setSecProDel(String secProDel) {
		this.secProDel = secProDel;
	}

	public Boolean getIsReExamined() {
		return isReExamined;
	}

	public void setIsReExamined(Boolean isReExamined) {
		this.isReExamined = isReExamined;
	}

	public Boolean getIsRePur() {
		return isRePur;
	}

	public void setIsRePur(Boolean isRePur) {
		this.isRePur = isRePur;
	}

	public Boolean getIsReReview() {
		return isReReview;
	}

	public void setIsReReview(Boolean isReReview) {
		this.isReReview = isReReview;
	}

	public String getRepurReason() {
		return repurReason;
	}

	public void setRepurReason(String repurReason) {
		this.repurReason = repurReason;
	}

	public String getPurFailAnalysis() {
		return purFailAnalysis;
	}

	public void setPurFailAnalysis(String purFailAnalysis) {
		this.purFailAnalysis = purFailAnalysis;
	}

	public String getPurFailCorrect() {
		return purFailCorrect;
	}

	public void setPurFailCorrect(String purFailCorrect) {
		this.purFailCorrect = purFailCorrect;
	}

	public String getPurFailImpro() {
		return purFailImpro;
	}

	public void setPurFailImpro(String purFailImpro) {
		this.purFailImpro = purFailImpro;
	}

	public Boolean getIsStopPlan() {
		return isStopPlan;
	}

	public void setIsStopPlan(Boolean isStopPlan) {
		this.isStopPlan = isStopPlan;
	}

	public Boolean getIsCancelPlan() {
		return isCancelPlan;
	}

	public void setIsCancelPlan(Boolean isCancelPlan) {
		this.isCancelPlan = isCancelPlan;
	}

	public String getStopPurReason() {
		return stopPurReason;
	}

	public void setStopPurReason(String stopPurReason) {
		this.stopPurReason = stopPurReason;
	}

	public String getStopPurAnalysis() {
		return stopPurAnalysis;
	}

	public void setStopPurAnalysis(String stopPurAnalysis) {
		this.stopPurAnalysis = stopPurAnalysis;
	}

	public String getStopPurCorrect() {
		return stopPurCorrect;
	}

	public void setStopPurCorrect(String stopPurCorrect) {
		this.stopPurCorrect = stopPurCorrect;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getProjectName2() {
		return projectName2;
	}

	public void setProjectName2(String projectName2) {
		this.projectName2 = projectName2;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getReviewnTime2() {
		return reviewnTime2;
	}

	public void setReviewnTime2(Date reviewnTime2) {
		this.reviewnTime2 = reviewnTime2;
	}

	public String getReviewPlace2() {
		return reviewPlace2;
	}

	public void setReviewPlace2(String reviewPlace2) {
		this.reviewPlace2 = reviewPlace2;
	}

	public String getProjectBudget2() {
		return projectBudget2;
	}

	public void setProjectBudget2(String projectBudget2) {
		this.projectBudget2 = projectBudget2;
	}

	public String getPurchaser2() {
		return purchaser2;
	}

	public void setPurchaser2(String purchaser2) {
		this.purchaser2 = purchaser2;
	}

	public String getAffiliatedUnit2() {
		return affiliatedUnit2;
	}

	public void setAffiliatedUnit2(String affiliatedUnit2) {
		this.affiliatedUnit2 = affiliatedUnit2;
	}

	public String getProcurementRange2() {
		return procurementRange2;
	}

	public void setProcurementRange2(String procurementRange2) {
		this.procurementRange2 = procurementRange2;
	}

	public String getQualifications2() {
		return qualifications2;
	}

	public void setQualifications2(String qualifications2) {
		this.qualifications2 = qualifications2;
	}

	public String getPotentialInvestors2() {
		return potentialInvestors2;
	}

	public void setPotentialInvestors2(String potentialInvestors2) {
		this.potentialInvestors2 = potentialInvestors2;
	}

	public String getGradingMethods2() {
		return gradingMethods2;
	}

	public void setGradingMethods2(String gradingMethods2) {
		this.gradingMethods2 = gradingMethods2;
	}

	public String getContentImproved2() {
		return contentImproved2;
	}

	public void setContentImproved2(String contentImproved2) {
		this.contentImproved2 = contentImproved2;
	}

	public String getParticipants2() {
		return participants2;
	}

	public void setParticipants2(String participants2) {
		this.participants2 = participants2;
	}

	public String getPurchaserDemandOp2() {
		return purchaserDemandOp2;
	}

	public void setPurchaserDemandOp2(String purchaserDemandOp2) {
		this.purchaserDemandOp2 = purchaserDemandOp2;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserdEmandOpTime2() {
		return purchaserdEmandOpTime2;
	}

	public void setPurchaserdEmandOpTime2(Date purchaserdEmandOpTime2) {
		this.purchaserdEmandOpTime2 = purchaserdEmandOpTime2;
	}

	public String getPurchaseOp2() {
		return purchaseOp2;
	}

	public void setPurchaseOp2(String purchaseOp2) {
		this.purchaseOp2 = purchaseOp2;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaseOpTime2() {
		return purchaseOpTime2;
	}

	public void setPurchaseOpTime2(Date purchaseOpTime2) {
		this.purchaseOpTime2 = purchaseOpTime2;
	}

	public String getPurchaserMajorOp2() {
		return purchaserMajorOp2;
	}

	public void setPurchaserMajorOp2(String purchaserMajorOp2) {
		this.purchaserMajorOp2 = purchaserMajorOp2;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMajorOpTime2() {
		return purchaserMajorOpTime2;
	}

	public void setPurchaserMajorOpTime2(Date purchaserMajorOpTime2) {
		this.purchaserMajorOpTime2 = purchaserMajorOpTime2;
	}

	public String getFinalPurchaseOp2() {
		return finalPurchaseOp2;
	}

	public void setFinalPurchaseOp2(String finalPurchaseOp2) {
		this.finalPurchaseOp2 = finalPurchaseOp2;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getFinalPurchaseOpTime2() {
		return finalPurchaseOpTime2;
	}

	public void setFinalPurchaseOpTime2(Date finalPurchaseOpTime2) {
		this.finalPurchaseOpTime2 = finalPurchaseOpTime2;
	}

	public String getFinalPurchaseLeaderOp2() {
		return finalPurchaseLeaderOp2;
	}

	public void setFinalPurchaseLeaderOp2(String finalPurchaseLeaderOp2) {
		this.finalPurchaseLeaderOp2 = finalPurchaseLeaderOp2;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getFinalPurchaseLeaderOpTime2() {
		return finalPurchaseLeaderOpTime2;
	}

	public void setFinalPurchaseLeaderOpTime2(Date finalPurchaseLeaderOpTime2) {
		this.finalPurchaseLeaderOpTime2 = finalPurchaseLeaderOpTime2;
	}

	public String getFinalDemandOp2() {
		return finalDemandOp2;
	}

	public void setFinalDemandOp2(String finalDemandOp2) {
		this.finalDemandOp2 = finalDemandOp2;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getFinalDemandOpTime2() {
		return finalDemandOpTime2;
	}

	public void setFinalDemandOpTime2(Date finalDemandOpTime2) {
		this.finalDemandOpTime2 = finalDemandOpTime2;
	}

	public String getFinalDemandLeaderOp2() {
		return finalDemandLeaderOp2;
	}

	public void setFinalDemandLeaderOp2(String finalDemandLeaderOp2) {
		this.finalDemandLeaderOp2 = finalDemandLeaderOp2;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getFinalDemandLeaderOpTime2() {
		return finalDemandLeaderOpTime2;
	}

	public void setFinalDemandLeaderOpTime2(Date finalDemandLeaderOpTime2) {
		this.finalDemandLeaderOpTime2 = finalDemandLeaderOpTime2;
	}

	public String getPurchaser3() {
		return purchaser3;
	}

	public void setPurchaser3(String purchaser3) {
		this.purchaser3 = purchaser3;
	}

	public String getProjectName3() {
		return projectName3;
	}

	public void setProjectName3(String projectName3) {
		this.projectName3 = projectName3;
	}

	public String getProjectBudget3() {
		return projectBudget3;
	}

	public void setProjectBudget3(String projectBudget3) {
		this.projectBudget3 = projectBudget3;
	}

	public String getCostSource3() {
		return costSource3;
	}

	public void setCostSource3(String costSource3) {
		this.costSource3 = costSource3;
	}

	public String getProcurementRange3() {
		return procurementRange3;
	}

	public void setProcurementRange3(String procurementRange3) {
		this.procurementRange3 = procurementRange3;
	}

	public String getQualifications3() {
		return qualifications3;
	}

	public void setQualifications3(String qualifications3) {
		this.qualifications3 = qualifications3;
	}

	public String getPerformance3() {
		return performance3;
	}

	public void setPerformance3(String performance3) {
		this.performance3 = performance3;
	}

	public String getCreditStanding3() {
		return creditStanding3;
	}

	public void setCreditStanding3(String creditStanding3) {
		this.creditStanding3 = creditStanding3;
	}

	public String getPurchaseReason3() {
		return purchaseReason3;
	}

	public void setPurchaseReason3(String purchaseReason3) {
		this.purchaseReason3 = purchaseReason3;
	}

	public String getSupplier3() {
		return supplier3;
	}

	public void setSupplier3(String supplier3) {
		this.supplier3 = supplier3;
	}

	public String getSelectReason3() {
		return selectReason3;
	}

	public void setSelectReason3(String selectReason3) {
		this.selectReason3 = selectReason3;
	}

	public String getPurchaserDemandOp3() {
		return purchaserDemandOp3;
	}

	public void setPurchaserDemandOp3(String purchaserDemandOp3) {
		this.purchaserDemandOp3 = purchaserDemandOp3;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserDemandOpTime3() {
		return purchaserDemandOpTime3;
	}

	public void setPurchaserDemandOpTime3(Date purchaserDemandOpTime3) {
		this.purchaserDemandOpTime3 = purchaserDemandOpTime3;
	}

	public String getPurchaserMajorOp3() {
		return purchaserMajorOp3;
	}

	public void setPurchaserMajorOp3(String purchaserMajorOp3) {
		this.purchaserMajorOp3 = purchaserMajorOp3;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMajorOpTime3() {
		return purchaserMajorOpTime3;
	}

	public void setPurchaserMajorOpTime3(Date purchaserMajorOpTime3) {
		this.purchaserMajorOpTime3 = purchaserMajorOpTime3;
	}

	public String getPurchaserPurchaseOp3() {
		return purchaserPurchaseOp3;
	}

	public void setPurchaserPurchaseOp3(String purchaserPurchaseOp3) {
		this.purchaserPurchaseOp3 = purchaserPurchaseOp3;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserPurchaseOpTime3() {
		return purchaserPurchaseOpTime3;
	}

	public void setPurchaserPurchaseOpTime3(Date purchaserPurchaseOpTime3) {
		this.purchaserPurchaseOpTime3 = purchaserPurchaseOpTime3;
	}

	public String getPurchaserLeaderOp3() {
		return purchaserLeaderOp3;
	}

	public void setPurchaserLeaderOp3(String purchaserLeaderOp3) {
		this.purchaserLeaderOp3 = purchaserLeaderOp3;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserLeaderOpTime3() {
		return purchaserLeaderOpTime3;
	}

	public void setPurchaserLeaderOpTime3(Date purchaserLeaderOpTime3) {
		this.purchaserLeaderOpTime3 = purchaserLeaderOpTime3;
	}

	public String getPurchaserMainOp3() {
		return purchaserMainOp3;
	}

	public void setPurchaserMainOp3(String purchaserMainOp3) {
		this.purchaserMainOp3 = purchaserMainOp3;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMainOpTime3() {
		return purchaserMainOpTime3;
	}

	public void setPurchaserMainOpTime3(Date purchaserMainOpTime3) {
		this.purchaserMainOpTime3 = purchaserMainOpTime3;
	}

	public String getJsMajorOp3() {
		return jsMajorOp3;
	}

	public void setJsMajorOp3(String jsMajorOp3) {
		this.jsMajorOp3 = jsMajorOp3;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorOpTime3() {
		return jsMajorOpTime3;
	}

	public void setJsMajorOpTime3(Date jsMajorOpTime3) {
		this.jsMajorOpTime3 = jsMajorOpTime3;
	}

	public String getJsMajorLeaderOp3() {
		return jsMajorLeaderOp3;
	}

	public void setJsMajorLeaderOp3(String jsMajorLeaderOp3) {
		this.jsMajorLeaderOp3 = jsMajorLeaderOp3;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorLeaderOpTime3() {
		return jsMajorLeaderOpTime3;
	}

	public void setJsMajorLeaderOpTime3(Date jsMajorLeaderOpTime3) {
		this.jsMajorLeaderOpTime3 = jsMajorLeaderOpTime3;
	}

	public String getJsPurchaseOp3() {
		return jsPurchaseOp3;
	}

	public void setJsPurchaseOp3(String jsPurchaseOp3) {
		this.jsPurchaseOp3 = jsPurchaseOp3;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseOpTime3() {
		return jsPurchaseOpTime3;
	}

	public void setJsPurchaseOpTime3(Date jsPurchaseOpTime3) {
		this.jsPurchaseOpTime3 = jsPurchaseOpTime3;
	}

	public String getJsPurchaseLeaderOp3() {
		return jsPurchaseLeaderOp3;
	}

	public void setJsPurchaseLeaderOp3(String jsPurchaseLeaderOp3) {
		this.jsPurchaseLeaderOp3 = jsPurchaseLeaderOp3;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseLeaderOpTime3() {
		return jsPurchaseLeaderOpTime3;
	}

	public void setJsPurchaseLeaderOpTime3(Date jsPurchaseLeaderOpTime3) {
		this.jsPurchaseLeaderOpTime3 = jsPurchaseLeaderOpTime3;
	}

	public String getPurchaser4() {
		return purchaser4;
	}

	public void setPurchaser4(String purchaser4) {
		this.purchaser4 = purchaser4;
	}

	public String getProjectName4() {
		return projectName4;
	}

	public void setProjectName4(String projectName4) {
		this.projectName4 = projectName4;
	}

	public String getProjectBudget4() {
		return projectBudget4;
	}

	public void setProjectBudget4(String projectBudget4) {
		this.projectBudget4 = projectBudget4;
	}

	public String getCostSource4() {
		return costSource4;
	}

	public void setCostSource4(String costSource4) {
		this.costSource4 = costSource4;
	}

	public String getProcurementRange4() {
		return procurementRange4;
	}

	public void setProcurementRange4(String procurementRange4) {
		this.procurementRange4 = procurementRange4;
	}

	public String getQualifications4() {
		return qualifications4;
	}

	public void setQualifications4(String qualifications4) {
		this.qualifications4 = qualifications4;
	}

	public String getPerformance4() {
		return performance4;
	}

	public void setPerformance4(String performance4) {
		this.performance4 = performance4;
	}

	public String getCreditStanding4() {
		return creditStanding4;
	}

	public void setCreditStanding4(String creditStanding4) {
		this.creditStanding4 = creditStanding4;
	}

	public String getPurchaseReason4() {
		return purchaseReason4;
	}

	public void setPurchaseReason4(String purchaseReason4) {
		this.purchaseReason4 = purchaseReason4;
	}

	public String getSupplier4() {
		return supplier4;
	}

	public void setSupplier4(String supplier4) {
		this.supplier4 = supplier4;
	}

	public String getSelectReason4() {
		return selectReason4;
	}

	public void setSelectReason4(String selectReason4) {
		this.selectReason4 = selectReason4;
	}

	public String getPurchaserDemandOp4() {
		return purchaserDemandOp4;
	}

	public void setPurchaserDemandOp4(String purchaserDemandOp4) {
		this.purchaserDemandOp4 = purchaserDemandOp4;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserDemandOpTime4() {
		return purchaserDemandOpTime4;
	}

	public void setPurchaserDemandOpTime4(Date purchaserDemandOpTime4) {
		this.purchaserDemandOpTime4 = purchaserDemandOpTime4;
	}

	public String getPurchaserMajorOp4() {
		return purchaserMajorOp4;
	}

	public void setPurchaserMajorOp4(String purchaserMajorOp4) {
		this.purchaserMajorOp4 = purchaserMajorOp4;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMajorOpTime4() {
		return purchaserMajorOpTime4;
	}

	public void setPurchaserMajorOpTime4(Date purchaserMajorOpTime4) {
		this.purchaserMajorOpTime4 = purchaserMajorOpTime4;
	}

	public String getPurchaserPurchaseOp4() {
		return purchaserPurchaseOp4;
	}

	public void setPurchaserPurchaseOp4(String purchaserPurchaseOp4) {
		this.purchaserPurchaseOp4 = purchaserPurchaseOp4;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserPurchaseOpTime4() {
		return purchaserPurchaseOpTime4;
	}

	public void setPurchaserPurchaseOpTime4(Date purchaserPurchaseOpTime4) {
		this.purchaserPurchaseOpTime4 = purchaserPurchaseOpTime4;
	}

	public String getPurchaserLeaderOp4() {
		return purchaserLeaderOp4;
	}

	public void setPurchaserLeaderOp4(String purchaserLeaderOp4) {
		this.purchaserLeaderOp4 = purchaserLeaderOp4;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserLeaderOpTime4() {
		return purchaserLeaderOpTime4;
	}

	public void setPurchaserLeaderOpTime4(Date purchaserLeaderOpTime4) {
		this.purchaserLeaderOpTime4 = purchaserLeaderOpTime4;
	}

	public String getPurchaserMainOp4() {
		return purchaserMainOp4;
	}

	public void setPurchaserMainOp4(String purchaserMainOp4) {
		this.purchaserMainOp4 = purchaserMainOp4;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMainOpTime4() {
		return purchaserMainOpTime4;
	}

	public void setPurchaserMainOpTime4(Date purchaserMainOpTime4) {
		this.purchaserMainOpTime4 = purchaserMainOpTime4;
	}

	public String getJsMajorOp4() {
		return jsMajorOp4;
	}

	public void setJsMajorOp4(String jsMajorOp4) {
		this.jsMajorOp4 = jsMajorOp4;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorOpTime4() {
		return jsMajorOpTime4;
	}

	public void setJsMajorOpTime4(Date jsMajorOpTime4) {
		this.jsMajorOpTime4 = jsMajorOpTime4;
	}

	public String getJsMajorLeaderOp4() {
		return jsMajorLeaderOp4;
	}

	public void setJsMajorLeaderOp4(String jsMajorLeaderOp4) {
		this.jsMajorLeaderOp4 = jsMajorLeaderOp4;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorLeaderOpTime4() {
		return jsMajorLeaderOpTime4;
	}

	public void setJsMajorLeaderOpTime4(Date jsMajorLeaderOpTime4) {
		this.jsMajorLeaderOpTime4 = jsMajorLeaderOpTime4;
	}

	public String getJsPurchaseOp4() {
		return jsPurchaseOp4;
	}

	public void setJsPurchaseOp4(String jsPurchaseOp4) {
		this.jsPurchaseOp4 = jsPurchaseOp4;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseOpTime4() {
		return jsPurchaseOpTime4;
	}

	public void setJsPurchaseOpTime4(Date jsPurchaseOpTime4) {
		this.jsPurchaseOpTime4 = jsPurchaseOpTime4;
	}

	public String getJsPurchaseLeaderOp4() {
		return jsPurchaseLeaderOp4;
	}

	public void setJsPurchaseLeaderOp4(String jsPurchaseLeaderOp4) {
		this.jsPurchaseLeaderOp4 = jsPurchaseLeaderOp4;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseLeaderOpTime4() {
		return jsPurchaseLeaderOpTime4;
	}

	public void setJsPurchaseLeaderOpTime4(Date jsPurchaseLeaderOpTime4) {
		this.jsPurchaseLeaderOpTime4 = jsPurchaseLeaderOpTime4;
	}

	public String getPurchaser5() {
		return purchaser5;
	}

	public void setPurchaser5(String purchaser5) {
		this.purchaser5 = purchaser5;
	}

	public String getProjectName5() {
		return projectName5;
	}

	public void setProjectName5(String projectName5) {
		this.projectName5 = projectName5;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getReviewnTime5() {
		return reviewnTime5;
	}

	public void setReviewnTime5(Date reviewnTime5) {
		this.reviewnTime5 = reviewnTime5;
	}

	public String getProjectBudget5() {
		return projectBudget5;
	}

	public void setProjectBudget5(String projectBudget5) {
		this.projectBudget5 = projectBudget5;
	}

	public String getCostSource5() {
		return costSource5;
	}

	public void setCostSource5(String costSource5) {
		this.costSource5 = costSource5;
	}

	public String getProcurementRange5() {
		return procurementRange5;
	}

	public void setProcurementRange5(String procurementRange5) {
		this.procurementRange5 = procurementRange5;
	}

	public String getPerformance5() {
		return performance5;
	}

	public void setPerformance5(String performance5) {
		this.performance5 = performance5;
	}

	public String getQualifications5() {
		return qualifications5;
	}

	public void setQualifications5(String qualifications5) {
		this.qualifications5 = qualifications5;
	}

	public String getPerReq5() {
		return perReq5;
	}

	public void setPerReq5(String perReq5) {
		this.perReq5 = perReq5;
	}

	public String getCreditStanding5() {
		return creditStanding5;
	}

	public void setCreditStanding5(String creditStanding5) {
		this.creditStanding5 = creditStanding5;
	}

	public String getGradingMethods5() {
		return gradingMethods5;
	}

	public void setGradingMethods5(String gradingMethods5) {
		this.gradingMethods5 = gradingMethods5;
	}

	public String getPurchaseReason5() {
		return purchaseReason5;
	}

	public void setPurchaseReason5(String purchaseReason5) {
		this.purchaseReason5 = purchaseReason5;
	}

	public String getSupplier5() {
		return supplier5;
	}

	public void setSupplier5(String supplier5) {
		this.supplier5 = supplier5;
	}

	public String getSelectReason5() {
		return selectReason5;
	}

	public void setSelectReason5(String selectReason5) {
		this.selectReason5 = selectReason5;
	}

	public String getContentImproved5() {
		return contentImproved5;
	}

	public void setContentImproved5(String contentImproved5) {
		this.contentImproved5 = contentImproved5;
	}

	public String getParticipants5() {
		return participants5;
	}

	public void setParticipants5(String participants5) {
		this.participants5 = participants5;
	}

	public String getPurchaserDemandOp5() {
		return purchaserDemandOp5;
	}

	public void setPurchaserDemandOp5(String purchaserDemandOp5) {
		this.purchaserDemandOp5 = purchaserDemandOp5;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserDemandOpTime5() {
		return purchaserDemandOpTime5;
	}

	public void setPurchaserDemandOpTime5(Date purchaserDemandOpTime5) {
		this.purchaserDemandOpTime5 = purchaserDemandOpTime5;
	}

	public String getPurchaserMajorOp5() {
		return purchaserMajorOp5;
	}

	public void setPurchaserMajorOp5(String purchaserMajorOp5) {
		this.purchaserMajorOp5 = purchaserMajorOp5;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMajorOpTime5() {
		return purchaserMajorOpTime5;
	}

	public void setPurchaserMajorOpTime5(Date purchaserMajorOpTime5) {
		this.purchaserMajorOpTime5 = purchaserMajorOpTime5;
	}

	public String getPurchaserPurchaseOp5() {
		return purchaserPurchaseOp5;
	}

	public void setPurchaserPurchaseOp5(String purchaserPurchaseOp5) {
		this.purchaserPurchaseOp5 = purchaserPurchaseOp5;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserPurchaseOpTime5() {
		return purchaserPurchaseOpTime5;
	}

	public void setPurchaserPurchaseOpTime5(Date purchaserPurchaseOpTime5) {
		this.purchaserPurchaseOpTime5 = purchaserPurchaseOpTime5;
	}

	public String getPurchaserLeaderOp5() {
		return purchaserLeaderOp5;
	}

	public void setPurchaserLeaderOp5(String purchaserLeaderOp5) {
		this.purchaserLeaderOp5 = purchaserLeaderOp5;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserLeaderOpTime5() {
		return purchaserLeaderOpTime5;
	}

	public void setPurchaserLeaderOpTime5(Date purchaserLeaderOpTime5) {
		this.purchaserLeaderOpTime5 = purchaserLeaderOpTime5;
	}

	public String getPurchaserMainOp5() {
		return purchaserMainOp5;
	}

	public void setPurchaserMainOp5(String purchaserMainOp5) {
		this.purchaserMainOp5 = purchaserMainOp5;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMainOpTime5() {
		return purchaserMainOpTime5;
	}

	public void setPurchaserMainOpTime5(Date purchaserMainOpTime5) {
		this.purchaserMainOpTime5 = purchaserMainOpTime5;
	}

	public String getJsMajorOp5() {
		return jsMajorOp5;
	}

	public void setJsMajorOp5(String jsMajorOp5) {
		this.jsMajorOp5 = jsMajorOp5;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorOpTime5() {
		return jsMajorOpTime5;
	}

	public void setJsMajorOpTime5(Date jsMajorOpTime5) {
		this.jsMajorOpTime5 = jsMajorOpTime5;
	}

	public String getJsMajorLeaderOp5() {
		return jsMajorLeaderOp5;
	}

	public void setJsMajorLeaderOp5(String jsMajorLeaderOp5) {
		this.jsMajorLeaderOp5 = jsMajorLeaderOp5;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorLeaderOpTime5() {
		return jsMajorLeaderOpTime5;
	}

	public void setJsMajorLeaderOpTime5(Date jsMajorLeaderOpTime5) {
		this.jsMajorLeaderOpTime5 = jsMajorLeaderOpTime5;
	}

	public String getJsPurchaseOp5() {
		return jsPurchaseOp5;
	}

	public void setJsPurchaseOp5(String jsPurchaseOp5) {
		this.jsPurchaseOp5 = jsPurchaseOp5;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseOpTime5() {
		return jsPurchaseOpTime5;
	}

	public void setJsPurchaseOpTime5(Date jsPurchaseOpTime5) {
		this.jsPurchaseOpTime5 = jsPurchaseOpTime5;
	}

	public String getJsPurchaseLeaderOp5() {
		return jsPurchaseLeaderOp5;
	}

	public void setJsPurchaseLeaderOp5(String jsPurchaseLeaderOp5) {
		this.jsPurchaseLeaderOp5 = jsPurchaseLeaderOp5;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseLeaderOpTime5() {
		return jsPurchaseLeaderOpTime5;
	}

	public void setJsPurchaseLeaderOpTime5(Date jsPurchaseLeaderOpTime5) {
		this.jsPurchaseLeaderOpTime5 = jsPurchaseLeaderOpTime5;
	}

	public String getPurchaser6() {
		return purchaser6;
	}

	public void setPurchaser6(String purchaser6) {
		this.purchaser6 = purchaser6;
	}

	public String getProjectName6() {
		return projectName6;
	}

	public void setProjectName6(String projectName6) {
		this.projectName6 = projectName6;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getReviewnTime6() {
		return reviewnTime6;
	}

	public void setReviewnTime6(Date reviewnTime6) {
		this.reviewnTime6 = reviewnTime6;
	}

	public String getProjectBudget6() {
		return projectBudget6;
	}

	public void setProjectBudget6(String projectBudget6) {
		this.projectBudget6 = projectBudget6;
	}

	public String getCostSource6() {
		return costSource6;
	}

	public void setCostSource6(String costSource6) {
		this.costSource6 = costSource6;
	}

	public String getProcurementRange6() {
		return procurementRange6;
	}

	public void setProcurementRange6(String procurementRange6) {
		this.procurementRange6 = procurementRange6;
	}

	public String getPerformance6() {
		return performance6;
	}

	public void setPerformance6(String performance6) {
		this.performance6 = performance6;
	}

	public String getQualifications6() {
		return qualifications6;
	}

	public void setQualifications6(String qualifications6) {
		this.qualifications6 = qualifications6;
	}

	public String getPerReq6() {
		return perReq6;
	}

	public void setPerReq6(String perReq6) {
		this.perReq6 = perReq6;
	}

	public String getCreditStanding6() {
		return creditStanding6;
	}

	public void setCreditStanding6(String creditStanding6) {
		this.creditStanding6 = creditStanding6;
	}

	public String getGradingMethods6() {
		return gradingMethods6;
	}

	public void setGradingMethods6(String gradingMethods6) {
		this.gradingMethods6 = gradingMethods6;
	}

	public String getPurchaseReason6() {
		return purchaseReason6;
	}

	public void setPurchaseReason6(String purchaseReason6) {
		this.purchaseReason6 = purchaseReason6;
	}

	public String getSupplier6() {
		return supplier6;
	}

	public void setSupplier6(String supplier6) {
		this.supplier6 = supplier6;
	}

	public String getSelectReason6() {
		return selectReason6;
	}

	public void setSelectReason6(String selectReason6) {
		this.selectReason6 = selectReason6;
	}

	public String getContentImproved6() {
		return contentImproved6;
	}

	public void setContentImproved6(String contentImproved6) {
		this.contentImproved6 = contentImproved6;
	}

	public String getParticipants6() {
		return participants6;
	}

	public void setParticipants6(String participants6) {
		this.participants6 = participants6;
	}

	public String getPurchaserDemandOp6() {
		return purchaserDemandOp6;
	}

	public void setPurchaserDemandOp6(String purchaserDemandOp6) {
		this.purchaserDemandOp6 = purchaserDemandOp6;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserDemandOpTime6() {
		return purchaserDemandOpTime6;
	}

	public void setPurchaserDemandOpTime6(Date purchaserDemandOpTime6) {
		this.purchaserDemandOpTime6 = purchaserDemandOpTime6;
	}

	public String getPurchaserMajorOp6() {
		return purchaserMajorOp6;
	}

	public void setPurchaserMajorOp6(String purchaserMajorOp6) {
		this.purchaserMajorOp6 = purchaserMajorOp6;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMajorOpTime6() {
		return purchaserMajorOpTime6;
	}

	public void setPurchaserMajorOpTime6(Date purchaserMajorOpTime6) {
		this.purchaserMajorOpTime6 = purchaserMajorOpTime6;
	}

	public String getPurchaserPurchaseOp6() {
		return purchaserPurchaseOp6;
	}

	public void setPurchaserPurchaseOp6(String purchaserPurchaseOp6) {
		this.purchaserPurchaseOp6 = purchaserPurchaseOp6;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserPurchaseOpTime6() {
		return purchaserPurchaseOpTime6;
	}

	public void setPurchaserPurchaseOpTime6(Date purchaserPurchaseOpTime6) {
		this.purchaserPurchaseOpTime6 = purchaserPurchaseOpTime6;
	}

	public String getPurchaserLeaderOp6() {
		return purchaserLeaderOp6;
	}

	public void setPurchaserLeaderOp6(String purchaserLeaderOp6) {
		this.purchaserLeaderOp6 = purchaserLeaderOp6;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserLeaderOpTime6() {
		return purchaserLeaderOpTime6;
	}

	public void setPurchaserLeaderOpTime6(Date purchaserLeaderOpTime6) {
		this.purchaserLeaderOpTime6 = purchaserLeaderOpTime6;
	}

	public String getPurchaserMainOp6() {
		return purchaserMainOp6;
	}

	public void setPurchaserMainOp6(String purchaserMainOp6) {
		this.purchaserMainOp6 = purchaserMainOp6;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMainOpTime6() {
		return purchaserMainOpTime6;
	}

	public void setPurchaserMainOpTime6(Date purchaserMainOpTime6) {
		this.purchaserMainOpTime6 = purchaserMainOpTime6;
	}

	public String getJsMajorOp6() {
		return jsMajorOp6;
	}

	public void setJsMajorOp6(String jsMajorOp6) {
		this.jsMajorOp6 = jsMajorOp6;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorOpTime6() {
		return jsMajorOpTime6;
	}

	public void setJsMajorOpTime6(Date jsMajorOpTime6) {
		this.jsMajorOpTime6 = jsMajorOpTime6;
	}

	public String getJsMajorLeaderOp6() {
		return jsMajorLeaderOp6;
	}

	public void setJsMajorLeaderOp6(String jsMajorLeaderOp6) {
		this.jsMajorLeaderOp6 = jsMajorLeaderOp6;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorLeaderOpTime6() {
		return jsMajorLeaderOpTime6;
	}

	public void setJsMajorLeaderOpTime6(Date jsMajorLeaderOpTime6) {
		this.jsMajorLeaderOpTime6 = jsMajorLeaderOpTime6;
	}

	public String getJsPurchaseOp6() {
		return jsPurchaseOp6;
	}

	public void setJsPurchaseOp6(String jsPurchaseOp6) {
		this.jsPurchaseOp6 = jsPurchaseOp6;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseOpTime6() {
		return jsPurchaseOpTime6;
	}

	public void setJsPurchaseOpTime6(Date jsPurchaseOpTime6) {
		this.jsPurchaseOpTime6 = jsPurchaseOpTime6;
	}

	public String getJsPurchaseLeaderOp6() {
		return jsPurchaseLeaderOp6;
	}

	public void setJsPurchaseLeaderOp6(String jsPurchaseLeaderOp6) {
		this.jsPurchaseLeaderOp6 = jsPurchaseLeaderOp6;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseLeaderOpTime6() {
		return jsPurchaseLeaderOpTime6;
	}

	public void setJsPurchaseLeaderOpTime6(Date jsPurchaseLeaderOpTime6) {
		this.jsPurchaseLeaderOpTime6 = jsPurchaseLeaderOpTime6;
	}

	public String getPurchaser7() {
		return purchaser7;
	}

	public void setPurchaser7(String purchaser7) {
		this.purchaser7 = purchaser7;
	}

	public String getProjectName7() {
		return projectName7;
	}

	public void setProjectName7(String projectName7) {
		this.projectName7 = projectName7;
	}

	public String getProjectBudget7() {
		return projectBudget7;
	}

	public void setProjectBudget7(String projectBudget7) {
		this.projectBudget7 = projectBudget7;
	}

	public String getPurchaserDemandOp7() {
		return purchaserDemandOp7;
	}

	public void setPurchaserDemandOp7(String purchaserDemandOp7) {
		this.purchaserDemandOp7 = purchaserDemandOp7;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserDemandOpTime7() {
		return purchaserDemandOpTime7;
	}

	public void setPurchaserDemandOpTime7(Date purchaserDemandOpTime7) {
		this.purchaserDemandOpTime7 = purchaserDemandOpTime7;
	}

	public String getPurchaserMajorOp7() {
		return purchaserMajorOp7;
	}

	public void setPurchaserMajorOp7(String purchaserMajorOp7) {
		this.purchaserMajorOp7 = purchaserMajorOp7;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMajorOpTime7() {
		return purchaserMajorOpTime7;
	}

	public void setPurchaserMajorOpTime7(Date purchaserMajorOpTime7) {
		this.purchaserMajorOpTime7 = purchaserMajorOpTime7;
	}

	public String getPurchaserPurchaseOp7() {
		return purchaserPurchaseOp7;
	}

	public void setPurchaserPurchaseOp7(String purchaserPurchaseOp7) {
		this.purchaserPurchaseOp7 = purchaserPurchaseOp7;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserPurchaseOpTime7() {
		return purchaserPurchaseOpTime7;
	}

	public void setPurchaserPurchaseOpTime7(Date purchaserPurchaseOpTime7) {
		this.purchaserPurchaseOpTime7 = purchaserPurchaseOpTime7;
	}

	public String getPurchaserLeaderOp7() {
		return purchaserLeaderOp7;
	}

	public void setPurchaserLeaderOp7(String purchaserLeaderOp7) {
		this.purchaserLeaderOp7 = purchaserLeaderOp7;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserLeaderOpTime7() {
		return purchaserLeaderOpTime7;
	}

	public void setPurchaserLeaderOpTime7(Date purchaserLeaderOpTime7) {
		this.purchaserLeaderOpTime7 = purchaserLeaderOpTime7;
	}

	public String getPurchaserMainOp7() {
		return purchaserMainOp7;
	}

	public void setPurchaserMainOp7(String purchaserMainOp7) {
		this.purchaserMainOp7 = purchaserMainOp7;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPurchaserMainOpTime7() {
		return purchaserMainOpTime7;
	}

	public void setPurchaserMainOpTime7(Date purchaserMainOpTime7) {
		this.purchaserMainOpTime7 = purchaserMainOpTime7;
	}

	public String getJsMajorOp7() {
		return jsMajorOp7;
	}

	public void setJsMajorOp7(String jsMajorOp7) {
		this.jsMajorOp7 = jsMajorOp7;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorOpTime7() {
		return jsMajorOpTime7;
	}

	public void setJsMajorOpTime7(Date jsMajorOpTime7) {
		this.jsMajorOpTime7 = jsMajorOpTime7;
	}

	public String getJsMajorLeaderOp7() {
		return jsMajorLeaderOp7;
	}

	public void setJsMajorLeaderOp7(String jsMajorLeaderOp7) {
		this.jsMajorLeaderOp7 = jsMajorLeaderOp7;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsMajorLeaderOpTime7() {
		return jsMajorLeaderOpTime7;
	}

	public void setJsMajorLeaderOpTime7(Date jsMajorLeaderOpTime7) {
		this.jsMajorLeaderOpTime7 = jsMajorLeaderOpTime7;
	}

	public String getJsPurchaseOp7() {
		return jsPurchaseOp7;
	}

	public void setJsPurchaseOp7(String jsPurchaseOp7) {
		this.jsPurchaseOp7 = jsPurchaseOp7;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseOpTime7() {
		return jsPurchaseOpTime7;
	}

	public void setJsPurchaseOpTime7(Date jsPurchaseOpTime7) {
		this.jsPurchaseOpTime7 = jsPurchaseOpTime7;
	}

	public String getJsPurchaseLeaderOp7() {
		return jsPurchaseLeaderOp7;
	}

	public void setJsPurchaseLeaderOp7(String jsPurchaseLeaderOp7) {
		this.jsPurchaseLeaderOp7 = jsPurchaseLeaderOp7;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getJsPurchaseLeaderOpTime7() {
		return jsPurchaseLeaderOpTime7;
	}

	public void setJsPurchaseLeaderOpTime7(Date jsPurchaseLeaderOpTime7) {
		this.jsPurchaseLeaderOpTime7 = jsPurchaseLeaderOpTime7;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getParticipantsIds() {
		return participantsIds;
	}

	public void setParticipantsIds(String participantsIds) {
		this.participantsIds = participantsIds;
	}

	public Boolean getIfNeedMajor() {
		return ifNeedMajor;
	}

	public void setIfNeedMajor(Boolean ifNeedMajor) {
		this.ifNeedMajor = ifNeedMajor;
	}

	public String getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}
}
