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
 * 非招标采购结果议题审批Entity
 * @author lizhicong
 * @version 2022-10-09
 */
public class WzTopicsResult extends DataEntity<WzTopicsResult> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String code;		// 审批标包号
	private String createName;		// 标包创建人
	private Date applyDate;		// 申请日期
	private String applyName;		// 审批发起人
	private String xqbmName;		// 需求部门审批人
	private Date xqbmDate;		// 需求部门审批时间
	private String xqbmApproval;		// 需求部门审批意见
	private String cgbmName;		// 采购部门审核人
	private Date cgbmDate;		// 采购部门审批时间
	private String cgbmApproval;		// 采购部门审批意见
	private String fgldName;		// 分管领导审核人
	private Date fgldDate;		// 分管领导审批时间
	private String fgldApproval;		// 分管领导审批意见
	private String zjlName;		// 总经理审核人
	private Date zjlDate;		// 总经理审核时间
	private String zjlApproval;		// 总经理审核意见
	private Date applyEndDate;		// 审批结束时间
	private String status;		//审批节点
	private String topicsStatus;  	//审批状态

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTopicsStatus() {
		return topicsStatus;
	}

	public void setTopicsStatus(String topicsStatus) {
		this.topicsStatus = topicsStatus;
	}

	public WzTopicsResult() {
		super();
	}

	public WzTopicsResult(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getXqbmName() {
		return xqbmName;
	}

	public void setXqbmName(String xqbmName) {
		this.xqbmName = xqbmName;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getXqbmDate() {
		return xqbmDate;
	}

	public void setXqbmDate(Date xqbmDate) {
		this.xqbmDate = xqbmDate;
	}
	public String getXqbmApproval() {
		return xqbmApproval;
	}

	public void setXqbmApproval(String xqbmApproval) {
		this.xqbmApproval = xqbmApproval;
	}
	public String getCgbmName() {
		return cgbmName;
	}

	public void setCgbmName(String cgbmName) {
		this.cgbmName = cgbmName;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getCgbmDate() {
		return cgbmDate;
	}

	public void setCgbmDate(Date cgbmDate) {
		this.cgbmDate = cgbmDate;
	}
	public String getCgbmApproval() {
		return cgbmApproval;
	}

	public void setCgbmApproval(String cgbmApproval) {
		this.cgbmApproval = cgbmApproval;
	}
	public String getFgldName() {
		return fgldName;
	}

	public void setFgldName(String fgldName) {
		this.fgldName = fgldName;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getFgldDate() {
		return fgldDate;
	}

	public void setFgldDate(Date fgldDate) {
		this.fgldDate = fgldDate;
	}
	public String getFgldApproval() {
		return fgldApproval;
	}

	public void setFgldApproval(String fgldApproval) {
		this.fgldApproval = fgldApproval;
	}
	public String getZjlName() {
		return zjlName;
	}

	public void setZjlName(String zjlName) {
		this.zjlName = zjlName;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getZjlDate() {
		return zjlDate;
	}

	public void setZjlDate(Date zjlDate) {
		this.zjlDate = zjlDate;
	}
	public String getZjlApproval() {
		return zjlApproval;
	}

	public void setZjlApproval(String zjlApproval) {
		this.zjlApproval = zjlApproval;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getApplyEndDate() {
		return applyEndDate;
	}

	public void setApplyEndDate(Date applyEndDate) {
		this.applyEndDate = applyEndDate;
	}

}
