/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 非招标一挂基础表Entity
 * @author lizhicong
 * @version 2022-07-14
 */
public class WzHangUpBasics extends DataEntity<WzHangUpBasics> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String serialNumber;		// 序号
	private String bbNumber;		// 标包编号
	private String cgNumber;		// 采购编号
	private String projectName;		// 项目名称
	private String projectDept;		// 项目单位
	private String sonCompany;		// 子分公司
	private String purchaseCompany;		// 项目发生采购机构
	private String assessmentPurchaseCompany;		// 考核采购机构
	private String purchaseMan;		// 采购员
	private String gwTime;		// 挂网时间
	private String endTime;		// 报价截止时间
	private String reviewTime;		// 撤回时间
	private String status;		// 当前状态
	private String isSuccess;		// 一挂是否成功
	private String dimensionTime;		//时间

	public String getDimensionTime() {
		return dimensionTime;
	}

	public void setDimensionTime(String dimensionTime) {
		this.dimensionTime = dimensionTime;
	}

	public WzHangUpBasics() {
		super();
	}

	public WzHangUpBasics(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getBbNumber() {
		return bbNumber;
	}

	public void setBbNumber(String bbNumber) {
		this.bbNumber = bbNumber;
	}
	public String getCgNumber() {
		return cgNumber;
	}

	public void setCgNumber(String cgNumber) {
		this.cgNumber = cgNumber;
	}
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDept() {
		return projectDept;
	}

	public void setProjectDept(String projectDept) {
		this.projectDept = projectDept;
	}
	public String getSonCompany() {
		return sonCompany;
	}

	public void setSonCompany(String sonCompany) {
		this.sonCompany = sonCompany;
	}
	public String getPurchaseCompany() {
		return purchaseCompany;
	}

	public void setPurchaseCompany(String purchaseCompany) {
		this.purchaseCompany = purchaseCompany;
	}
	public String getAssessmentPurchaseCompany() {
		return assessmentPurchaseCompany;
	}

	public void setAssessmentPurchaseCompany(String assessmentPurchaseCompany) {
		this.assessmentPurchaseCompany = assessmentPurchaseCompany;
	}
	public String getPurchaseMan() {
		return purchaseMan;
	}

	public void setPurchaseMan(String purchaseMan) {
		this.purchaseMan = purchaseMan;
	}
	public String getGwTime() {
		return gwTime;
	}

	public void setGwTime(String gwTime) {
		this.gwTime = gwTime;
	}
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}

}
