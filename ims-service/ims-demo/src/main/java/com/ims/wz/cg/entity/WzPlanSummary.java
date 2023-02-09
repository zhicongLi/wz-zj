/**
 *
 */
package com.ims.wz.cg.entity;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Lists;

import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * wz_plan_summaryEntity
 * @author lizhicong
 * @version 2021-09-18
 */
public class WzPlanSummary extends DataEntity<WzPlanSummary> {

	private static final long serialVersionUID = 1L;
	private String summaryMan;		// 汇总人
	private Date summanyTime;		// 汇总时间
	private String status;		// 流程状态
	private String tenantId;		// 租户
	private String billType;		//单据类型


	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public WzPlanSummary() {
		super();
	}

	public WzPlanSummary(String id){
		super(id);
	}

	public String getSummaryMan() {
		return summaryMan;
	}

	public void setSummaryMan(String summaryMan) {
		this.summaryMan = summaryMan;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getSummanyTime() {
		return summanyTime;
	}

	public void setSummanyTime(Date summanyTime) {
		this.summanyTime = summanyTime;
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
