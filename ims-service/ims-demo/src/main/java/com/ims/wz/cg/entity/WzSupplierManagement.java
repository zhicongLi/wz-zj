/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 失信供应商处置Entity
 * @author lizhicong
 * @version 2022-07-22
 */
public class WzSupplierManagement extends DataEntity<WzSupplierManagement> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String sxxwczNumber;		// 失信行为处置申请编号
	private String sxxwczTitle;		// 失信行为处置申请标题
	private String projectNumber;		// 采购项目（标包）编号
	private String projectName;		// 采购项目名称
	private String projectDept;		// 采购项目单位
	private String supplierCode;		// 供应商编码
	private String supplierName;		// 供应商名称
	private String supplierCreditCode;		// 供应商统一社会信用代码
	private String discreditType;		// 失信行为分类
	private String xgdwProposal;		// 相关单位处置建议
	private String endResult;		// 集团终审处置结果
	private String endProposal;		// 集团终审处置意见
	private String startDate;		// 集团终审处置开始日期
	private String endDate;		// 集团终审处置结束日期
	private String bczReason;		// 集团终审不处置理由
	private String status;		// 审批状态
	private String dimensionTime;	//时间

	public String getDimensionTime() {
		return dimensionTime;
	}

	public void setDimensionTime(String dimensionTime) {
		this.dimensionTime = dimensionTime;
	}

	public WzSupplierManagement() {
		super();
	}

	public WzSupplierManagement(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getSxxwczNumber() {
		return sxxwczNumber;
	}

	public void setSxxwczNumber(String sxxwczNumber) {
		this.sxxwczNumber = sxxwczNumber;
	}
	public String getSxxwczTitle() {
		return sxxwczTitle;
	}

	public void setSxxwczTitle(String sxxwczTitle) {
		this.sxxwczTitle = sxxwczTitle;
	}
	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
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
	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierCreditCode() {
		return supplierCreditCode;
	}

	public void setSupplierCreditCode(String supplierCreditCode) {
		this.supplierCreditCode = supplierCreditCode;
	}
	public String getDiscreditType() {
		return discreditType;
	}

	public void setDiscreditType(String discreditType) {
		this.discreditType = discreditType;
	}
	public String getXgdwProposal() {
		return xgdwProposal;
	}

	public void setXgdwProposal(String xgdwProposal) {
		this.xgdwProposal = xgdwProposal;
	}
	public String getEndResult() {
		return endResult;
	}

	public void setEndResult(String endResult) {
		this.endResult = endResult;
	}
	public String getEndProposal() {
		return endProposal;
	}

	public void setEndProposal(String endProposal) {
		this.endProposal = endProposal;
	}
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBczReason() {
		return bczReason;
	}

	public void setBczReason(String bczReason) {
		this.bczReason = bczReason;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
