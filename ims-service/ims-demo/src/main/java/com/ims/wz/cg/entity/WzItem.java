/**
 *
 */
package com.ims.wz.cg.entity;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;

import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * wz_itemEntity
 * @author lizhicong
 * @version 2022-05-06
 */
public class WzItem extends DataEntity<WzItem> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String deptName;		// 需求部门名称
	private Date writeDate;		// 填报时间
	private String code;		// 采购申请号
	private String projectName;		// 项目名称
	private String applicant;		// 申请人
	private String applicantPhone;		// 申请人电话
	private String category;		// 标的物类别
	private String yearPlanCode;		// 年度计划号
	private String duration;		// 工期/货期要求
	private String contractType;		// 合同类型
	private String procurementMethod;		// 采购方式
	private String reviewMethod;		// 评标/审办法
	private String budget;		// 预算(万元)
	private String moneyResource;		// 费用来源
	private String detailedMoney;		// 详细费用
	private String otherCost;		// 其他费用
	private String taxrate;		// 税率
	private String paymentMethod;		// 支付方式
	private String overBudget;		// 是否超出年度下达预算
	private String supplier;		// 潜在承包/供应商
	private String projectRange;		// 采购项目范围描述
	private String projectNecessity;		// 采购项目必要性
	private String status;		// 审批节点
	private String xqbmMan;		// 需求部门负责人
	private Date xqbmTime;		// 需求部门负责人审批时间
	private String xqbmApproval;		// 需求部门负责人审批意见
	private String zygkjbMan;		// 专业归口部门经办人
	private Date zygkjbTime;		// 专业归口部门经办人审批时间
	private String zygkjbApproval;		// 专业归口部门经办人审批意见
	private String cggljbMan;		// 采购管理部门经办人
	private Date cggljbTime;		// 采购管理部门经办人审批时间
	private String cggljbApproval;		// 采购管理部门经办人审批意见
	private String cwbMan;		// 财务部负责人
	private Date cwbTime;		// 财务部负责人审批时间
	private String cwbApproval;		// 财务部负责人审批意见
	private String fgldMan;		// 分管业务领导负责人
	private Date fgldTime;		// 分管业务领导审批时间
	private String fgldApproval;		// 分管业务领导审批意见
	private String fgcgMan;		// 分管采购领导
	private Date fgcgTime;		// 分管采购领导审批时间
	private String fgcgApproval;		// 分管采购领导审批意见
	private String zygkfzMan;		// 专业归口部门负责人
	private Date zygkfzTime;		// 专业归口部门负责人审批时间
	private String zygkfzApproval;		// 专业归口部门负责人审批意见
	private String cgglfzMan;		// 采购管理部门负责人
	private Date cgglfzTime;		// 采购管理部门负责人审批时间
	private String cgglfzApproval;		// 采购管理部门负责人审批意见
	private String fzrMan;		// 公司主要负责人
	private Date fzrTime;		// 公司主要负责人审批时间
	private String fzrApproval;		// 公司主要负责人审批意见
	private String applicantCode;		// 采购申请编号
	private String rlwzMan;		// 燃料物资部计划预审接收人
	private Date receiveTime;		// 燃料物资部计划预审接收时间
	private String rlwzManId;		// 燃料物资部计划预审接受人id
	private String otherTaxrate;		// 税率其他
	private String scoring;		// 评分权重
	private Date endTime;		// 接收日期
	private String planStatus;	//单据状态
	private String applicantCompany;	//申请公司
	private String remark;		//备注
	private String stopReason;	//终止原因
	private String xqspId;		//需求部门审批人id
	private String xqspName;	//需求部门审批人姓名;
	private String zyjbId;		//专业归口部门经办人id
	private String zyjbName;	//专业归口部门经办人姓名
	private String zyfzId;		//专业归口部门负责人id
	private String zyfzName;	//专业归口部门负责人姓名；
	private String cgId;		//分管采购领导id;
	private String cgName;		//分管采购领导姓名
	private String ywId;		//分管业务领导id
	private String ywName;		//分管业务领导姓名
	private String isgenerate;	//是否关联计划
	private String glbmjbId;	//管理部门经办人id
	private String glbmjbName;	//管理部门经办人姓名
	private String glbmfzId;	//管理部门负责人id
	private String glbmfzName;	//管理部门负责人姓名
	private String cwbId;		//财务部审批人id
	private String cwbName;		//财务部审批人姓名
	private String fzrId;		//公司主要负责人id
	private String fzrName;		//公司主要负责人姓名
	private String classification;	//项目分类
	private String stage;		//项目阶段
	private String whetherMetting;	//是否上会
	private String moreReason;	//超出原因
	private String mettingName;	//会议名称
	private String planBasis;		//编报制度依据
	private Date planStartTime;		//计划实施时间
	private String contractPeriod;	//合同执行周期
	private String planNumber;		//项目编号
	private String threeCost;		//三级费用

	public String getThreeCost() {
		return threeCost;
	}

	public void setThreeCost(String threeCost) {
		this.threeCost = threeCost;
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

	public String getPlanNumber() {
		return planNumber;
	}

	public void setPlanNumber(String planNumber) {
		this.planNumber = planNumber;
	}

	public String getMettingName() {
		return mettingName;
	}

	public void setMettingName(String mettingName) {
		this.mettingName = mettingName;
	}

	public String getMoreReason() {
		return moreReason;
	}

	public void setMoreReason(String moreReason) {
		this.moreReason = moreReason;
	}

	public String getWhetherMetting() {
		return whetherMetting;
	}

	public void setWhetherMetting(String whetherMetting) {
		this.whetherMetting = whetherMetting;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getGlbmjbId() {
		return glbmjbId;
	}

	public void setGlbmjbId(String glbmjbId) {
		this.glbmjbId = glbmjbId;
	}

	public String getGlbmjbName() {
		return glbmjbName;
	}

	public void setGlbmjbName(String glbmjbName) {
		this.glbmjbName = glbmjbName;
	}

	public String getGlbmfzId() {
		return glbmfzId;
	}

	public void setGlbmfzId(String glbmfzId) {
		this.glbmfzId = glbmfzId;
	}

	public String getGlbmfzName() {
		return glbmfzName;
	}

	public void setGlbmfzName(String glbmfzName) {
		this.glbmfzName = glbmfzName;
	}

	public String getCwbId() {
		return cwbId;
	}

	public void setCwbId(String cwbId) {
		this.cwbId = cwbId;
	}

	public String getCwbName() {
		return cwbName;
	}

	public void setCwbName(String cwbName) {
		this.cwbName = cwbName;
	}

	public String getFzrId() {
		return fzrId;
	}

	public void setFzrId(String fzrId) {
		this.fzrId = fzrId;
	}

	public String getFzrName() {
		return fzrName;
	}

	public void setFzrName(String fzrName) {
		this.fzrName = fzrName;
	}

	public String getIsgenerate() {
		return isgenerate;
	}

	public void setIsgenerate(String isgenerate) {
		this.isgenerate = isgenerate;
	}

	public String getXqspId() {
		return xqspId;
	}

	public void setXqspId(String xqspId) {
		this.xqspId = xqspId;
	}

	public String getXqspName() {
		return xqspName;
	}

	public void setXqspName(String xqspName) {
		this.xqspName = xqspName;
	}


	public String getZyjbId() {
		return zyjbId;
	}

	public void setZyjbId(String zyjbId) {
		this.zyjbId = zyjbId;
	}

	public String getZyjbName() {
		return zyjbName;
	}

	public void setZyjbName(String zyjbName) {
		this.zyjbName = zyjbName;
	}

	public String getZyfzId() {
		return zyfzId;
	}

	public void setZyfzId(String zyfzId) {
		this.zyfzId = zyfzId;
	}

	public String getZyfzName() {
		return zyfzName;
	}

	public void setZyfzName(String zyfzName) {
		this.zyfzName = zyfzName;
	}

	public String getCgId() {
		return cgId;
	}

	public void setCgId(String cgId) {
		this.cgId = cgId;
	}

	public String getCgName() {
		return cgName;
	}

	public void setCgName(String cgName) {
		this.cgName = cgName;
	}

	public String getYwId() {
		return ywId;
	}

	public void setYwId(String ywId) {
		this.ywId = ywId;
	}

	public String getYwName() {
		return ywName;
	}

	public void setYwName(String ywName) {
		this.ywName = ywName;
	}

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApplicantCompany() {
		return applicantCompany;
	}

	public void setApplicantCompany(String applicantCompany) {
		this.applicantCompany = applicantCompany;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public WzItem() {
		super();
	}

	public WzItem(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getApplicantPhone() {
		return applicantPhone;
	}

	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public String getYearPlanCode() {
		return yearPlanCode;
	}

	public void setYearPlanCode(String yearPlanCode) {
		this.yearPlanCode = yearPlanCode;
	}
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getProcurementMethod() {
		return procurementMethod;
	}

	public void setProcurementMethod(String procurementMethod) {
		this.procurementMethod = procurementMethod;
	}
	public String getReviewMethod() {
		return reviewMethod;
	}

	public void setReviewMethod(String reviewMethod) {
		this.reviewMethod = reviewMethod;
	}
	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getMoneyResource() {
		return moneyResource;
	}

	public void setMoneyResource(String moneyResource) {
		this.moneyResource = moneyResource;
	}
	public String getDetailedMoney() {
		return detailedMoney;
	}

	public void setDetailedMoney(String detailedMoney) {
		this.detailedMoney = detailedMoney;
	}
	public String getOtherCost() {
		return otherCost;
	}

	public void setOtherCost(String otherCost) {
		this.otherCost = otherCost;
	}
	public String getTaxrate() {
		return taxrate;
	}

	public void setTaxrate(String taxrate) {
		this.taxrate = taxrate;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getOverBudget() {
		return overBudget;
	}

	public void setOverBudget(String overBudget) {
		this.overBudget = overBudget;
	}
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getProjectRange() {
		return projectRange;
	}

	public void setProjectRange(String projectRange) {
		this.projectRange = projectRange;
	}
	public String getProjectNecessity() {
		return projectNecessity;
	}

	public void setProjectNecessity(String projectNecessity) {
		this.projectNecessity = projectNecessity;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getXqbmMan() {
		return xqbmMan;
	}

	public void setXqbmMan(String xqbmMan) {
		this.xqbmMan = xqbmMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getXqbmTime() {
		return xqbmTime;
	}

	public void setXqbmTime(Date xqbmTime) {
		this.xqbmTime = xqbmTime;
	}
	public String getXqbmApproval() {
		return xqbmApproval;
	}

	public void setXqbmApproval(String xqbmApproval) {
		this.xqbmApproval = xqbmApproval;
	}
	public String getZygkjbMan() {
		return zygkjbMan;
	}

	public void setZygkjbMan(String zygkjbMan) {
		this.zygkjbMan = zygkjbMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getZygkjbTime() {
		return zygkjbTime;
	}

	public void setZygkjbTime(Date zygkjbTime) {
		this.zygkjbTime = zygkjbTime;
	}
	public String getZygkjbApproval() {
		return zygkjbApproval;
	}

	public void setZygkjbApproval(String zygkjbApproval) {
		this.zygkjbApproval = zygkjbApproval;
	}
	public String getCggljbMan() {
		return cggljbMan;
	}

	public void setCggljbMan(String cggljbMan) {
		this.cggljbMan = cggljbMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getCggljbTime() {
		return cggljbTime;
	}

	public void setCggljbTime(Date cggljbTime) {
		this.cggljbTime = cggljbTime;
	}
	public String getCggljbApproval() {
		return cggljbApproval;
	}

	public void setCggljbApproval(String cggljbApproval) {
		this.cggljbApproval = cggljbApproval;
	}
	public String getCwbMan() {
		return cwbMan;
	}

	public void setCwbMan(String cwbMan) {
		this.cwbMan = cwbMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getCwbTime() {
		return cwbTime;
	}

	public void setCwbTime(Date cwbTime) {
		this.cwbTime = cwbTime;
	}
	public String getCwbApproval() {
		return cwbApproval;
	}

	public void setCwbApproval(String cwbApproval) {
		this.cwbApproval = cwbApproval;
	}
	public String getFgldMan() {
		return fgldMan;
	}

	public void setFgldMan(String fgldMan) {
		this.fgldMan = fgldMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getFgldTime() {
		return fgldTime;
	}

	public void setFgldTime(Date fgldTime) {
		this.fgldTime = fgldTime;
	}
	public String getFgldApproval() {
		return fgldApproval;
	}

	public void setFgldApproval(String fgldApproval) {
		this.fgldApproval = fgldApproval;
	}
	public String getFgcgMan() {
		return fgcgMan;
	}

	public void setFgcgMan(String fgcgMan) {
		this.fgcgMan = fgcgMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getFgcgTime() {
		return fgcgTime;
	}

	public void setFgcgTime(Date fgcgTime) {
		this.fgcgTime = fgcgTime;
	}
	public String getFgcgApproval() {
		return fgcgApproval;
	}

	public void setFgcgApproval(String fgcgApproval) {
		this.fgcgApproval = fgcgApproval;
	}
	public String getZygkfzMan() {
		return zygkfzMan;
	}

	public void setZygkfzMan(String zygkfzMan) {
		this.zygkfzMan = zygkfzMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getZygkfzTime() {
		return zygkfzTime;
	}

	public void setZygkfzTime(Date zygkfzTime) {
		this.zygkfzTime = zygkfzTime;
	}
	public String getZygkfzApproval() {
		return zygkfzApproval;
	}

	public void setZygkfzApproval(String zygkfzApproval) {
		this.zygkfzApproval = zygkfzApproval;
	}
	public String getCgglfzMan() {
		return cgglfzMan;
	}

	public void setCgglfzMan(String cgglfzMan) {
		this.cgglfzMan = cgglfzMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getCgglfzTime() {
		return cgglfzTime;
	}

	public void setCgglfzTime(Date cgglfzTime) {
		this.cgglfzTime = cgglfzTime;
	}
	public String getCgglfzApproval() {
		return cgglfzApproval;
	}

	public void setCgglfzApproval(String cgglfzApproval) {
		this.cgglfzApproval = cgglfzApproval;
	}
	public String getFzrMan() {
		return fzrMan;
	}

	public void setFzrMan(String fzrMan) {
		this.fzrMan = fzrMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getFzrTime() {
		return fzrTime;
	}

	public void setFzrTime(Date fzrTime) {
		this.fzrTime = fzrTime;
	}
	public String getFzrApproval() {
		return fzrApproval;
	}

	public void setFzrApproval(String fzrApproval) {
		this.fzrApproval = fzrApproval;
	}
	public String getApplicantCode() {
		return applicantCode;
	}

	public void setApplicantCode(String applicantCode) {
		this.applicantCode = applicantCode;
	}
	public String getRlwzMan() {
		return rlwzMan;
	}

	public void setRlwzMan(String rlwzMan) {
		this.rlwzMan = rlwzMan;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getRlwzManId() {
		return rlwzManId;
	}

	public void setRlwzManId(String rlwzManId) {
		this.rlwzManId = rlwzManId;
	}
	public String getOtherTaxrate() {
		return otherTaxrate;
	}

	public void setOtherTaxrate(String otherTaxrate) {
		this.otherTaxrate = otherTaxrate;
	}
	public String getScoring() {
		return scoring;
	}

	public void setScoring(String scoring) {
		this.scoring = scoring;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
