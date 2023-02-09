/**
 *
 */
package com.ims.wz.cg.entity;


import com.alibaba.fastjson.annotation.JSONField;
import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * wz_establishmentEntity
 * @author lizhicong
 * @version 2021-10-11
 */
public class WzEstablishment extends DataEntity<WzEstablishment> {

	private static final long serialVersionUID = 1L;
	private String dept;		// 业务部门
	private String projectName;		// 项目完成名称
	private Date endDate;		// 要求完成时间
	private String budget;		// 预算
	private String costSource;		// 费用来源
	private String applicants;		// 申请人
	private String phoneNumber;		// 联系电话
	private String projectRange;		// 范围
	private String necessity;		// 采购项目必要性
	private String submitDate;		// 需求部门提交表单时间
	private String status;		// 表单状态
	private String bmHandlerOpinion;		// 部门经办人意见
	private String bmHandlerPeople;		// 部门经办人
	private String bmHandlerDate;		// 部门经办人审批时间
	private String bmResponsibleOpinion;		// 部门负责人意见
	private String bmResponsiblePeople;		// 部门负责人
	private String bmResponsibleDate;		// 部门负责人审批时间
	private String cgHandlerOpinion;		// 采购部门经办人意见
	private String cgHandlerPeople;		// 采购部门经办人
	private String cgHandlerDate;		// 采购部门经办人审批时间
	private String cgResponsibleOpinion;		// 采购部门负责人意见
	private String cgResponsiblePeople;		// 采购部门负责人
	private String cgResponsibleDate;		// 采购部门负责人审批时间
	private String fgLeaderOpinion;		// 分管领导审批意见
	private String fgLeaderPeople;		// 分管领导
	private String fgLeaderDate;		// 分管领导审批时间
	private String gsResponsibleOpinion;		// 公司负责人意见
	private String gsResponsiblePeople;		// 公司负责人
	private String gsResponsibleDate;		// 公司负责人审批时间
	private String copy;		// 抄送
	private String tenantId;		// 租户id


	public WzEstablishment() {
		super();
	}

	public WzEstablishment(String id){
		super(id);
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getCostSource() {
		return costSource;
	}

	public void setCostSource(String costSource) {
		this.costSource = costSource;
	}
	public String getApplicants() {
		return applicants;
	}

	public void setApplicants(String applicants) {
		this.applicants = applicants;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getProjectRange() {
		return projectRange;
	}

	public void setProjectRange(String projectRange) {
		this.projectRange = projectRange;
	}
	public String getNecessity() {
		return necessity;
	}

	public void setNecessity(String necessity) {
		this.necessity = necessity;
	}
	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getBmHandlerOpinion() {
		return bmHandlerOpinion;
	}

	public void setBmHandlerOpinion(String bmHandlerOpinion) {
		this.bmHandlerOpinion = bmHandlerOpinion;
	}
	public String getBmHandlerPeople() {
		return bmHandlerPeople;
	}

	public void setBmHandlerPeople(String bmHandlerPeople) {
		this.bmHandlerPeople = bmHandlerPeople;
	}
	public String getBmHandlerDate() {
		return bmHandlerDate;
	}

	public void setBmHandlerDate(String bmHandlerDate) {
		this.bmHandlerDate = bmHandlerDate;
	}
	public String getBmResponsibleOpinion() {
		return bmResponsibleOpinion;
	}

	public void setBmResponsibleOpinion(String bmResponsibleOpinion) {
		this.bmResponsibleOpinion = bmResponsibleOpinion;
	}
	public String getBmResponsiblePeople() {
		return bmResponsiblePeople;
	}

	public void setBmResponsiblePeople(String bmResponsiblePeople) {
		this.bmResponsiblePeople = bmResponsiblePeople;
	}
	public String getBmResponsibleDate() {
		return bmResponsibleDate;
	}

	public void setBmResponsibleDate(String bmResponsibleDate) {
		this.bmResponsibleDate = bmResponsibleDate;
	}
	public String getCgHandlerOpinion() {
		return cgHandlerOpinion;
	}

	public void setCgHandlerOpinion(String cgHandlerOpinion) {
		this.cgHandlerOpinion = cgHandlerOpinion;
	}
	public String getCgHandlerPeople() {
		return cgHandlerPeople;
	}

	public void setCgHandlerPeople(String cgHandlerPeople) {
		this.cgHandlerPeople = cgHandlerPeople;
	}
	public String getCgHandlerDate() {
		return cgHandlerDate;
	}

	public void setCgHandlerDate(String cgHandlerDate) {
		this.cgHandlerDate = cgHandlerDate;
	}
	public String getCgResponsibleOpinion() {
		return cgResponsibleOpinion;
	}

	public void setCgResponsibleOpinion(String cgResponsibleOpinion) {
		this.cgResponsibleOpinion = cgResponsibleOpinion;
	}
	public String getCgResponsiblePeople() {
		return cgResponsiblePeople;
	}

	public void setCgResponsiblePeople(String cgResponsiblePeople) {
		this.cgResponsiblePeople = cgResponsiblePeople;
	}
	public String getCgResponsibleDate() {
		return cgResponsibleDate;
	}

	public void setCgResponsibleDate(String cgResponsibleDate) {
		this.cgResponsibleDate = cgResponsibleDate;
	}
	public String getFgLeaderOpinion() {
		return fgLeaderOpinion;
	}

	public void setFgLeaderOpinion(String fgLeaderOpinion) {
		this.fgLeaderOpinion = fgLeaderOpinion;
	}
	public String getFgLeaderPeople() {
		return fgLeaderPeople;
	}

	public void setFgLeaderPeople(String fgLeaderPeople) {
		this.fgLeaderPeople = fgLeaderPeople;
	}
	public String getFgLeaderDate() {
		return fgLeaderDate;
	}

	public void setFgLeaderDate(String fgLeaderDate) {
		this.fgLeaderDate = fgLeaderDate;
	}
	public String getGsResponsibleOpinion() {
		return gsResponsibleOpinion;
	}

	public void setGsResponsibleOpinion(String gsResponsibleOpinion) {
		this.gsResponsibleOpinion = gsResponsibleOpinion;
	}
	public String getGsResponsiblePeople() {
		return gsResponsiblePeople;
	}

	public void setGsResponsiblePeople(String gsResponsiblePeople) {
		this.gsResponsiblePeople = gsResponsiblePeople;
	}
	public String getGsResponsibleDate() {
		return gsResponsibleDate;
	}

	public void setGsResponsibleDate(String gsResponsibleDate) {
		this.gsResponsibleDate = gsResponsibleDate;
	}
	public String getCopy() {
		return copy;
	}

	public void setCopy(String copy) {
		this.copy = copy;
	}
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
