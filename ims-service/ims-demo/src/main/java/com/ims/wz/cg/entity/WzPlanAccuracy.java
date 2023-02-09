/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 采购计划准确率基础表Entity
 * @author lizhicong
 * @version 2022-07-18
 */
public class WzPlanAccuracy extends DataEntity<WzPlanAccuracy> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String planTime;		// 日历年/月
	private String bbNumber;		// 采购标包编号
	private String bbNumberName;		// 采购标包号名称
	private String cgMethod;		// 采购方式
	private String tbDept;		// 提报单位
	private String entrustDate;		// 委托日期
	private String isInaccurate;		// 是否计划不准确退回
	private String reviewDate;		// 退回日期
	private String reviewType;		// 退回分类
	private String reviewReason;		// 退回原因
	private String reviewRemark;		// 退回备注
	private String dimensionTime;		//时间

	public String getDimensionTime() {
		return dimensionTime;
	}

	public void setDimensionTime(String dimensionTime) {
		this.dimensionTime = dimensionTime;
	}

	public WzPlanAccuracy() {
		super();
	}

	public WzPlanAccuracy(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}
	public String getBbNumber() {
		return bbNumber;
	}

	public void setBbNumber(String bbNumber) {
		this.bbNumber = bbNumber;
	}
	public String getBbNumberName() {
		return bbNumberName;
	}

	public void setBbNumberName(String bbNumberName) {
		this.bbNumberName = bbNumberName;
	}
	public String getCgMethod() {
		return cgMethod;
	}

	public void setCgMethod(String cgMethod) {
		this.cgMethod = cgMethod;
	}
	public String getTbDept() {
		return tbDept;
	}

	public void setTbDept(String tbDept) {
		this.tbDept = tbDept;
	}
	public String getEntrustDate() {
		return entrustDate;
	}

	public void setEntrustDate(String entrustDate) {
		this.entrustDate = entrustDate;
	}
	public String getIsInaccurate() {
		return isInaccurate;
	}

	public void setIsInaccurate(String isInaccurate) {
		this.isInaccurate = isInaccurate;
	}
	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getreviewType() {
		return reviewType;
	}

	public void setreviewType(String reviewType) {
		this.reviewType = reviewType;
	}
	public String getReviewReason() {
		return reviewReason;
	}

	public void setReviewReason(String reviewReason) {
		this.reviewReason = reviewReason;
	}
	public String getReviewRemark() {
		return reviewRemark;
	}

	public void setReviewRemark(String reviewRemark) {
		this.reviewRemark = reviewRemark;
	}

}
