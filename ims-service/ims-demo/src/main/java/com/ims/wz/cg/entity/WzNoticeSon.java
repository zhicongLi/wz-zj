/**
 *
 */
package com.ims.wz.cg.entity;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;

import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * wz_notice_mainEntity
 * @author lizhicong
 * @version 2021-12-27
 */
public class WzNoticeSon extends DataEntity<WzNoticeSon> {

	private static final long serialVersionUID = 1L;
	private String serialNumber;		// 序号
	private String demandDescribe;		// 需求描述
	private String demandNumber;		// 需求计划编号
	private String planCategoryName;		// 计划类别名称
	private String subcontractNumber;		// 分包编号
	private String materialNumber;		// 物料编号
	private String materialDescribe;		// 物料描述
	private String demandQuantity;		// 需求数量
	private String unit;		// 计量单位
	private String unitPrice;		// 单价
	private String totalPrice;		// 总价
	private String brand;		// 品牌/生产厂家
	private String isreplace;		// 是否可替代
	private String otherRequirement;		// 其他补充要求
	private String cnwzcgApproval;		// 场内物资采购部门初审
	private String hdcgzxApproval;		// 华东采购中心初审
	private String jsgsApproval;		// 江苏公司初审
	private String commentReply;		// 意见回复
	private String replyReview;		// 回复复核
	private String moneyType;		// 费用类型
	private String demandDate;		// 需求日期
	private String contacts;		// 联系人
	private String contactsPhone;		// 联系人电话
	private String purchaseRequisition;		// 采购申请
	private String remark;		// 备注
	private String proposalNumber;		// 建议采购数量
	private String distributionNumber;		// 利库分配数量
	private String submitDate;		// 提报日期
	private String transferApplication;		// 调拨申请
	private String transferApplicationProject;		// 调拨申请项目
	private String rejectionNumber;		// 驳回次数
	private String purchaser;		// 采购人
	private String parentId;		// 主表id
	private String tenantId;		// 租户id
	private String resultId;		//关联计划结果id

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public WzNoticeSon() {
		super();
	}

	public WzNoticeSon(String id){
		super(id);
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDemandDescribe() {
		return demandDescribe;
	}

	public void setDemandDescribe(String demandDescribe) {
		this.demandDescribe = demandDescribe;
	}
	public String getDemandNumber() {
		return demandNumber;
	}

	public void setDemandNumber(String demandNumber) {
		this.demandNumber = demandNumber;
	}
	public String getPlanCategoryName() {
		return planCategoryName;
	}

	public void setPlanCategoryName(String planCategoryName) {
		this.planCategoryName = planCategoryName;
	}
	public String getSubcontractNumber() {
		return subcontractNumber;
	}

	public void setSubcontractNumber(String subcontractNumber) {
		this.subcontractNumber = subcontractNumber;
	}
	public String getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}
	public String getMaterialDescribe() {
		return materialDescribe;
	}

	public void setMaterialDescribe(String materialDescribe) {
		this.materialDescribe = materialDescribe;
	}
	public String getDemandQuantity() {
		return demandQuantity;
	}

	public void setDemandQuantity(String demandQuantity) {
		this.demandQuantity = demandQuantity;
	}
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getIsreplace() {
		return isreplace;
	}

	public void setIsreplace(String isreplace) {
		this.isreplace = isreplace;
	}
	public String getOtherRequirement() {
		return otherRequirement;
	}

	public void setOtherRequirement(String otherRequirement) {
		this.otherRequirement = otherRequirement;
	}
	public String getCnwzcgApproval() {
		return cnwzcgApproval;
	}

	public void setCnwzcgApproval(String cnwzcgApproval) {
		this.cnwzcgApproval = cnwzcgApproval;
	}
	public String getHdcgzxApproval() {
		return hdcgzxApproval;
	}

	public void setHdcgzxApproval(String hdcgzxApproval) {
		this.hdcgzxApproval = hdcgzxApproval;
	}
	public String getJsgsApproval() {
		return jsgsApproval;
	}

	public void setJsgsApproval(String jsgsApproval) {
		this.jsgsApproval = jsgsApproval;
	}
	public String getCommentReply() {
		return commentReply;
	}

	public void setCommentReply(String commentReply) {
		this.commentReply = commentReply;
	}
	public String getReplyReview() {
		return replyReview;
	}

	public void setReplyReview(String replyReview) {
		this.replyReview = replyReview;
	}
	public String getMoneyType() {
		return moneyType;
	}

	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}

	public String getDemandDate() {
		return demandDate;
	}

	public void setDemandDate(String demandDate) {
		this.demandDate = demandDate;
	}
	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getContactsPhone() {
		return contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}
	public String getPurchaseRequisition() {
		return purchaseRequisition;
	}

	public void setPurchaseRequisition(String purchaseRequisition) {
		this.purchaseRequisition = purchaseRequisition;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getProposalNumber() {
		return proposalNumber;
	}

	public void setProposalNumber(String proposalNumber) {
		this.proposalNumber = proposalNumber;
	}
	public String getDistributionNumber() {
		return distributionNumber;
	}

	public void setDistributionNumber(String distributionNumber) {
		this.distributionNumber = distributionNumber;
	}
	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getTransferApplication() {
		return transferApplication;
	}

	public void setTransferApplication(String transferApplication) {
		this.transferApplication = transferApplication;
	}
	public String getTransferApplicationProject() {
		return transferApplicationProject;
	}

	public void setTransferApplicationProject(String transferApplicationProject) {
		this.transferApplicationProject = transferApplicationProject;
	}
	public String getRejectionNumber() {
		return rejectionNumber;
	}

	public void setRejectionNumber(String rejectionNumber) {
		this.rejectionNumber = rejectionNumber;
	}
	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
