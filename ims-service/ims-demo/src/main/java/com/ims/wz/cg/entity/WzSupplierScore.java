/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 供应商评议打分表Entity
 * @author lizhicong
 * @version 2022-07-21
 */
public class WzSupplierScore extends DataEntity<WzSupplierScore> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String companyName;		// 评议单位
	private String supplierName;		// 供应商名称
	private String dataSituation;		// 提交合同（协议）所需资料情况（0-10分
	private String responseSituation;		// 签约响应情况（0-10分）
	private String acceptanceSituation;		// 验收情况（0-15分）
	private String problemSituation;		// 质保期内质量问题（0-15分）
	private String accuracySituation;		// 工作量准确率（0-10分
	private String timeSituation;		// 工期按时率（0-10分）
	private String participation;		// 参与采购活动情况（0-10分）
	private String cooperation;		// 签约配合情况（0-10分）
	private String serviceSituation;		// 售后服务情况（0-10分）
	private String situationSum;		// 评议总分
	private String approval;		// 评议综合意见
	private String dimensionTime;	//时间

	public String getDimensionTime() {
		return dimensionTime;
	}

	public void setDimensionTime(String dimensionTime) {
		this.dimensionTime = dimensionTime;
	}

	public WzSupplierScore() {
		super();
	}

	public WzSupplierScore(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getDataSituation() {
		return dataSituation;
	}

	public void setDataSituation(String dataSituation) {
		this.dataSituation = dataSituation;
	}
	public String getResponseSituation() {
		return responseSituation;
	}

	public void setResponseSituation(String responseSituation) {
		this.responseSituation = responseSituation;
	}
	public String getAcceptanceSituation() {
		return acceptanceSituation;
	}

	public void setAcceptanceSituation(String acceptanceSituation) {
		this.acceptanceSituation = acceptanceSituation;
	}
	public String getProblemSituation() {
		return problemSituation;
	}

	public void setProblemSituation(String problemSituation) {
		this.problemSituation = problemSituation;
	}
	public String getAccuracySituation() {
		return accuracySituation;
	}

	public void setAccuracySituation(String accuracySituation) {
		this.accuracySituation = accuracySituation;
	}
	public String getTimeSituation() {
		return timeSituation;
	}

	public void setTimeSituation(String timeSituation) {
		this.timeSituation = timeSituation;
	}
	public String getParticipation() {
		return participation;
	}

	public void setParticipation(String participation) {
		this.participation = participation;
	}
	public String getCooperation() {
		return cooperation;
	}

	public void setCooperation(String cooperation) {
		this.cooperation = cooperation;
	}
	public String getServiceSituation() {
		return serviceSituation;
	}

	public void setServiceSituation(String serviceSituation) {
		this.serviceSituation = serviceSituation;
	}
	public String getSituationSum() {
		return situationSum;
	}

	public void setSituationSum(String situationSum) {
		this.situationSum = situationSum;
	}
	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

}
