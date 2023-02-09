/**
 *
 */
package com.ims.wz.cg.entity;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import com.google.common.collect.Lists;

import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 非招标采购结果议题审批Entity
 * @author lizhicong
 * @version 2022-11-15
 */
public class WzPlanResult extends DataEntity<WzPlanResult> {

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
	private String status;		// 节点
	private String topicsStatus;		// 状态
	private String noticeId;		// 关联物资通知单id
	private String noticeCode;		// 关联物资通知单编号
	private String xqbmMan;			//需求部门审批人
	private String xqbmId;			//需求部门审批人id
	private String cgbmMan;			//采购部门审核人
	private String cgbmId;			//采购部门审核人id
	private String fgldMan;			//分管领导审核人
	private String fgldId;			//分管领导审核人id
	private String zjlMan;			//总经理审核人
	private String zjlId;			//总经理审核人id
	private String category;		//标的类别
	private String approvedName;	//审议名称
	private String explicate;			//说明
	private String cgfgldMan;		//采购部门分管领导审核人
	private String cgfgldId;		//采购部门分管领导审核人id
	private String cgfgldName;		//采购部门分管领导审核人姓名
	private Date cgfgldDate;		//采购部门分管领导审核时间
	private String cgfgldApproval;	//采购部门分管领导审核意见

	public String getCgfgldName() {
		return cgfgldName;
	}

	public void setCgfgldName(String cgfgldName) {
		this.cgfgldName = cgfgldName;
	}

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	public Date getCgfgldDate() {
		return cgfgldDate;
	}

	public void setCgfgldDate(Date cgfgldDate) {
		this.cgfgldDate = cgfgldDate;
	}

	public String getCgfgldApproval() {
		return cgfgldApproval;
	}

	public void setCgfgldApproval(String cgfgldApproval) {
		this.cgfgldApproval = cgfgldApproval;
	}

	public String getCgfgldMan() {
		return cgfgldMan;
	}

	public void setCgfgldMan(String cgfgldMan) {
		this.cgfgldMan = cgfgldMan;
	}

	public String getCgfgldId() {
		return cgfgldId;
	}

	public void setCgfgldId(String cgfgldId) {
		this.cgfgldId = cgfgldId;
	}

	public String getApprovedName() {
		return approvedName;
	}

	public void setApprovedName(String approvedName) {
		this.approvedName = approvedName;
	}

	public String getExplicate() {
		return explicate;
	}

	public void setExplicate(String explicate) {
		this.explicate = explicate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getXqbmMan() {
		return xqbmMan;
	}

	public void setXqbmMan(String xqbmMan) {
		this.xqbmMan = xqbmMan;
	}

	public String getXqbmId() {
		return xqbmId;
	}

	public void setXqbmId(String xqbmId) {
		this.xqbmId = xqbmId;
	}

	public String getCgbmMan() {
		return cgbmMan;
	}

	public void setCgbmMan(String cgbmMan) {
		this.cgbmMan = cgbmMan;
	}

	public String getCgbmId() {
		return cgbmId;
	}

	public void setCgbmId(String cgbmId) {
		this.cgbmId = cgbmId;
	}

	public String getFgldMan() {
		return fgldMan;
	}

	public void setFgldMan(String fgldMan) {
		this.fgldMan = fgldMan;
	}

	public String getFgldId() {
		return fgldId;
	}

	public void setFgldId(String fgldId) {
		this.fgldId = fgldId;
	}

	public String getZjlMan() {
		return zjlMan;
	}

	public void setZjlMan(String zjlMan) {
		this.zjlMan = zjlMan;
	}

	public String getZjlId() {
		return zjlId;
	}

	public void setZjlId(String zjlId) {
		this.zjlId = zjlId;
	}

	public WzPlanResult() {
		super();
	}

	public WzPlanResult(String id){
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
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	public Date getApplyEndDate() {
		return applyEndDate;
	}

	public void setApplyEndDate(Date applyEndDate) {
		this.applyEndDate = applyEndDate;
	}
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
	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeCode() {
		return noticeCode;
	}

	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}

}
