/**
 *
 */
package com.ims.wz.cg.entity;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;

import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 江苏公司填报Entity
 * @author lizhicong
 * @version 2022-08-19
 */
public class WzJsFillIn extends DataEntity<WzJsFillIn> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private Date dimensionTime;		// 填报时间
	private String krb;		// 库容比
	private String company;		// 公司
	private String cgcs;		// 年度计划外采购次数
	private String cgzb;		// 年度计划内采购占比


	public WzJsFillIn() {
		super();
	}

	public WzJsFillIn(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	@JSONField(format = "yyyy-MM")
	public Date getDimensionTime() {
		return dimensionTime;
	}

	public void setDimensionTime(Date dimensionTime) {
		this.dimensionTime = dimensionTime;
	}
	public String getKrb() {
		return krb;
	}

	public void setKrb(String krb) {
		this.krb = krb;
	}
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public String getCgcs() {
		return cgcs;
	}

	public void setCgcs(String cgcs) {
		this.cgcs = cgcs;
	}
	public String getCgzb() {
		return cgzb;
	}

	public void setCgzb(String cgzb) {
		this.cgzb = cgzb;
	}

}
