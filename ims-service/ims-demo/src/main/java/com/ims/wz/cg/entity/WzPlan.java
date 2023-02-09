/**
 *
 */
package com.ims.wz.cg.entity;


import com.alibaba.fastjson.annotation.JSONField;
import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * 物资采购计划Entity
 * @author lizhicong
 * @version 2021-09-09
 */
public class WzPlan extends DataEntity<WzPlan> {

	private static final long serialVersionUID = 1L;
	private String code;		// 预审编号
	private String examineDescribe;		// 预审描述
	private String dept;		// 填报单位
	private String sonCompany;		// 所属子公司
	private String projectDescribe;		// 项目描述
	private String plate;		// 专业板块
	private String jurisdiction;		// 采购管理权限
	private String stage;		// 项目阶段
	private String classification;		// 项目分类
	private String category;		// 标的类别
	private String budget;		// 概算/预算
	private String procurementMethod;		// 采购方式
	private String procurementBasis;		// 采购依据
	private String supplier;		// 供应商
	private String reason;		// 选择原因
	private String moneyResource;		// 资金来源
	private String jobContent;		// 工作内容
	private String workload;		// 工作量
	private String duration;		// 工期
	private String peopleSituation;		// 人员情况
	private String achievement;		// 资质业绩
	private String reviewMethod;		// 评审方法
	private String detailedList;		// 物资技术规格清单
	private String specificationsFile;		// 技术规格文件
	private String remark;		// 备注
	private String initiator;		// 审批发起人
	private String billType;		// 单据类型
	private String status;		// 单据审批状态
	private String tenantId;		// 租户id
	private String parentId;		//父类id
	private String projectName;		//项目名称
	private String otherCost;			//费用
	private String scoring;			//权重
	private String whetherMetting;	//是否上会
	private String mettingFile;		//会议文件
	private String paymentMethod;	//付款方式
	private String detailedMoney;	//详细费用
	private String approvalDept;	//专业归口部门id
	private String approvalDeptName;	//专业归口部门姓名
	private String zygkMan;			//江苏公司专业归口审批人
	private Date zygkTime;			//江苏公司专业归口审批时间
	private String zygkApproval;	//江苏公司专业归口审批意见
	private String xqdwMan;			//需求单位采购部门审核人
	private Date xqdwTime;			//需求单位采购部门审核时间
	private String xqdwApproval;	//需求单位采购部门审核意见
	private String cgdlMan;			//代理机构审批人
	private Date cgdlTime;			//代理机构审批时间
	private String cgdlApproval;	//代理机构审批时间
	private String jscgMan;			//江苏公司采购部门意见
	private Date jscgTime;			//江苏公司采购部门审批时间
	private String jscgApproval;	//江苏公司采购部门审批意见
	private String backApproval;	//填报人反馈意见
	private String planStatus;		//单据状态
	private String planTime;		//计划时间
	private String cgzcMan;			//采购专责审批人
	private Date cgzcTime;			//采购专责审批时间
	private String cgzcApproval;	//采购专责审批意见
	private String isgenerate;		//是否生成议题
	private String deptCode;		//江苏公司审批人部门编号
	private String emergencyOrder;	//是否为紧急
	private String systemBasis;		//采购制度依据
	private String priceFormula;	//价格计算公式
	private String rlwzMan;			//江苏公司燃料物资部审核人
	private Date rlwzTime;			//江苏公司燃料物资部审核时间
	private String rlwzApproval;	//江苏公司燃料物资部审核意见
	private String itemId;			//关联立项id
	private String otherTaxrate;	//其他税率
	private String scryMan;			//审查人员
	private Date scryTime;			//审查人员审核时间
	private String scryApproval;	//审查人员审核意见
	private String scryName;		//审查人员姓名
	private String scryId;			//审查人员id
	private String issc;			//是否审查
	private String resultId;		//关联计划结果id
	private String bmzrName;		//部门主任姓名
	private String bmzrId;			//部门主任id
	private String bmzrMan;			//部门主任审批人
	private Date bmzrTime;			//部门主任审批时间
	private String bmzrApproval;	//部门主任审批意见
	private String planBasis;		//编报制度依据
	private Date planStartTime;		//计划实施时间
	private String contractPeriod;	//合同执行周期
	private String submitMonth;		//提报月份
	private String planNumber;		//项目编号
	private String bmfzrId;			//部门负责人id
	private String bmfzrName;		//部门负责人姓名
	private String bmfzrMan;		//部门负责人审核人
	private Date bmfzrTime;		//部门负责人审批时间
	private String bmfzrApproval;	//部门负责人审批意见
	private String threeCost;		//三级费用

	public String getThreeCost() {
		return threeCost;
	}

	public void setThreeCost(String threeCost) {
		this.threeCost = threeCost;
	}

	public String getBmfzrId() {
		return bmfzrId;
	}

	public void setBmfzrId(String bmfzrId) {
		this.bmfzrId = bmfzrId;
	}

	public String getBmfzrName() {
		return bmfzrName;
	}

	public void setBmfzrName(String bmfzrName) {
		this.bmfzrName = bmfzrName;
	}

	public String getBmfzrMan() {
		return bmfzrMan;
	}

	public void setBmfzrMan(String bmfzrMan) {
		this.bmfzrMan = bmfzrMan;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getBmfzrTime() {
		return bmfzrTime;
	}

	public void setBmfzrTime(Date bmfzrTime) {
		this.bmfzrTime = bmfzrTime;
	}

	public String getBmfzrApproval() {
		return bmfzrApproval;
	}

	public void setBmfzrApproval(String bmfzrApproval) {
		this.bmfzrApproval = bmfzrApproval;
	}

	public String getPlanNumber() {
		return planNumber;
	}

	public void setPlanNumber(String planNumber) {
		this.planNumber = planNumber;
	}

	public String getPlanBasis() {
		return planBasis;
	}

	public void setPlanBasis(String planBasis) {
		this.planBasis = planBasis;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPlanStartTime() {
		return planStartTime;
	}

	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
	}

	public String getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	public String getSubmitMonth() {
		return submitMonth;
	}

	public void setSubmitMonth(String submitMonth) {
		this.submitMonth = submitMonth;
	}

	public String getBmzrName() {
		return bmzrName;
	}

	public void setBmzrName(String bmzrName) {
		this.bmzrName = bmzrName;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getBmzrTime() {
		return bmzrTime;
	}

	public void setBmzrTime(Date bmzrTime) {
		this.bmzrTime = bmzrTime;
	}

	public String getBmzrId() {
		return bmzrId;
	}

	public void setBmzrId(String bmzrId) {
		this.bmzrId = bmzrId;
	}

	public String getBmzrMan() {
		return bmzrMan;
	}

	public void setBmzrMan(String bmzrMan) {
		this.bmzrMan = bmzrMan;
	}


	public String getBmzrApproval() {
		return bmzrApproval;
	}

	public void setBmzrApproval(String bmzrApproval) {
		this.bmzrApproval = bmzrApproval;
	}

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public String getIssc() {
		return issc;
	}

	public void setIssc(String issc) {
		this.issc = issc;
	}

	public String getScryName() {
		return scryName;
	}

	public void setScryName(String scryName) {
		this.scryName = scryName;
	}

	public String getScryId() {
		return scryId;
	}

	public void setScryId(String scryId) {
		this.scryId = scryId;
	}

	public String getScryMan() {
		return scryMan;
	}

	public void setScryMan(String scryMan) {
		this.scryMan = scryMan;
	}


	@JSONField(format = "yyyy-MM-dd")
	public Date getScryTime() {
		return scryTime;
	}

	public void setScryTime(Date scryTime) {
		this.scryTime = scryTime;
	}

	public String getScryApproval() {
		return scryApproval;
	}

	public void setScryApproval(String scryApproval) {
		this.scryApproval = scryApproval;
	}

	public String getOtherTaxrate() {
		return otherTaxrate;
	}

	public void setOtherTaxrate(String otherTaxrate) {
		this.otherTaxrate = otherTaxrate;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getRlwzMan() {
		return rlwzMan;
	}

	public void setRlwzMan(String rlwzMan) {
		this.rlwzMan = rlwzMan;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getRlwzTime() {
		return rlwzTime;
	}

	public void setRlwzTime(Date rlwzTime) {
		this.rlwzTime = rlwzTime;
	}

	public String getRlwzApproval() {
		return rlwzApproval;
	}

	public void setRlwzApproval(String rlwzApproval) {
		this.rlwzApproval = rlwzApproval;
	}

	public String getSystemBasis() {
		return systemBasis;
	}

	public void setSystemBasis(String systemBasis) {
		this.systemBasis = systemBasis;
	}

	public String getPriceFormula() {
		return priceFormula;
	}

	public void setPriceFormula(String priceFormula) {
		this.priceFormula = priceFormula;
	}

	public String getEmergencyOrder() {
		return emergencyOrder;
	}

	public void setEmergencyOrder(String emergencyOrder) {
		this.emergencyOrder = emergencyOrder;
	}

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}

	private String taxrate;			//税率
	private String stopReason;		//终止原因

	public String getTaxrate() {
		return taxrate;
	}

	public void setTaxrate(String taxrate) {
		this.taxrate = taxrate;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getIsgenerate() {
		return isgenerate;
	}

	public void setIsgenerate(String isgenerate) {
		this.isgenerate = isgenerate;
	}

	public String getCgzcMan() {
		return cgzcMan;
	}

	public void setCgzcMan(String cgzcMan) {
		this.cgzcMan = cgzcMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getCgzcTime() {
		return cgzcTime;
	}

	public void setCgzcTime(Date cgzcTime) {
		this.cgzcTime = cgzcTime;
	}

	public String getCgzcApproval() {
		return cgzcApproval;
	}

	public void setCgzcApproval(String cgzcApproval) {
		this.cgzcApproval = cgzcApproval;
	}

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public String getBackApproval() {
		return backApproval;
	}

	public void setBackApproval(String backApproval) {
		this.backApproval = backApproval;
	}

	public String getZygkMan() {
		return zygkMan;
	}

	public void setZygkMan(String zygkMan) {
		this.zygkMan = zygkMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getZygkTime() {
		return zygkTime;
	}

	public void setZygkTime(Date zygkTime) {
		this.zygkTime = zygkTime;
	}

	public String getZygkApproval() {
		return zygkApproval;
	}

	public void setZygkApproval(String zygkApproval) {
		this.zygkApproval = zygkApproval;
	}

	public String getXqdwMan() {
		return xqdwMan;
	}

	public void setXqdwMan(String xqdwMan) {
		this.xqdwMan = xqdwMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getXqdwTime() {
		return xqdwTime;
	}

	public void setXqdwTime(Date xqdwTime) {
		this.xqdwTime = xqdwTime;
	}

	public String getXqdwApproval() {
		return xqdwApproval;
	}

	public void setXqdwApproval(String xqdwApproval) {
		this.xqdwApproval = xqdwApproval;
	}

	public String getCgdlMan() {
		return cgdlMan;
	}

	public void setCgdlMan(String cgdlMan) {
		this.cgdlMan = cgdlMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getCgdlTime() {
		return cgdlTime;
	}

	public void setCgdlTime(Date cgdlTime) {
		this.cgdlTime = cgdlTime;
	}

	public String getCgdlApproval() {
		return cgdlApproval;
	}

	public void setCgdlApproval(String cgdlApproval) {
		this.cgdlApproval = cgdlApproval;
	}

	public String getJscgMan() {
		return jscgMan;
	}

	public void setJscgMan(String jscgMan) {
		this.jscgMan = jscgMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getJscgTime() {
		return jscgTime;
	}

	public void setJscgTime(Date jscgTime) {
		this.jscgTime = jscgTime;
	}

	public String getJscgApproval() {
		return jscgApproval;
	}

	public void setJscgApproval(String jscgApproval) {
		this.jscgApproval = jscgApproval;
	}

	public String getApprovalDept() {
		return approvalDept;
	}

	public void setApprovalDept(String approvalDept) {
		this.approvalDept = approvalDept;
	}

	public String getApprovalDeptName() {
		return approvalDeptName;
	}

	public void setApprovalDeptName(String approvalDeptName) {
		this.approvalDeptName = approvalDeptName;
	}

	public String getDetailedMoney() {
		return detailedMoney;
	}

	public void setDetailedMoney(String detailedMoney) {
		this.detailedMoney = detailedMoney;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getWhetherMetting() {
		return whetherMetting;
	}

	public void setWhetherMetting(String whetherMetting) {
		this.whetherMetting = whetherMetting;
	}

	public String getMettingFile() {
		return mettingFile;
	}

	public void setMettingFile(String mettingFile) {
		this.mettingFile = mettingFile;
	}

	public String getOtherCost() {
		return otherCost;
	}

	public void setOtherCost(String otherCost) {
		this.otherCost = otherCost;
	}

	public String getScoring() {
		return scoring;
	}

	public void setScoring(String scoring) {
		this.scoring = scoring;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public WzPlan() {
		super();
	}

	public WzPlan(String id){
		super(id);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getExamineDescribe() {
		return examineDescribe;
	}

	public void setExamineDescribe(String examineDescribe) {
		this.examineDescribe = examineDescribe;
	}
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSonCompany() {
		return sonCompany;
	}

	public void setSonCompany(String sonCompany) {
		this.sonCompany = sonCompany;
	}
	public String getProjectDescribe() {
		return projectDescribe;
	}

	public void setProjectDescribe(String projectDescribe) {
		this.projectDescribe = projectDescribe;
	}
	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
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
	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getProcurementMethod() {
		return procurementMethod;
	}

	public void setProcurementMethod(String procurementMethod) {
		this.procurementMethod = procurementMethod;
	}
	public String getProcurementBasis() {
		return procurementBasis;
	}

	public void setProcurementBasis(String procurementBasis) {
		this.procurementBasis = procurementBasis;
	}
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getMoneyResource() {
		return moneyResource;
	}

	public void setMoneyResource(String moneyResource) {
		this.moneyResource = moneyResource;
	}
	public String getJobContent() {
		return jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}
	public String getWorkload() {
		return workload;
	}

	public void setWorkload(String workload) {
		this.workload = workload;
	}
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getPeopleSituation() {
		return peopleSituation;
	}

	public void setPeopleSituation(String peopleSituation) {
		this.peopleSituation = peopleSituation;
	}
	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public String getReviewMethod() {
		return reviewMethod;
	}

	public void setReviewMethod(String reviewMethod) {
		this.reviewMethod = reviewMethod;
	}
	public String getDetailedList() {
		return detailedList;
	}

	public void setDetailedList(String detailedList) {
		this.detailedList = detailedList;
	}
	public String getSpecificationsFile() {
		return specificationsFile;
	}

	public void setSpecificationsFile(String specificationsFile) {
		this.specificationsFile = specificationsFile;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getInitiator() {
		return initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
