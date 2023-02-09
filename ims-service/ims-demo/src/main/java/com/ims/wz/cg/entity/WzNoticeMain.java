/**
 *
 */
package com.ims.wz.cg.entity;

import java.util.List;
import com.google.common.collect.Lists;

import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * wz_notice_mainEntity
 * @author lizhicong
 * @version 2021-12-27
 */
public class WzNoticeMain extends DataEntity<WzNoticeMain> {

	private static final long serialVersionUID = 1L;
	private String status;		// 单据状态
	private String approvalNode;		// 单据审批节点
	private String number;		// 单据编号
	private String sendName;		// 发起人
	private String sendCompany;		// 发起人项目单位
	private String tenantId;		// 租户id
	private String projectName;		//项目名称
	private String projectFile;		//通知单附件
	private String zygkId;		//专业归口id
	private String zygkName;		//专业归口名称
	private String emergencyOrder;	//是否为紧急单
	private String stopReason;		//终止原因

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}

	public String getEmergencyOrder() {
		return emergencyOrder;
	}

	public void setEmergencyOrder(String emergencyOrder) {
		this.emergencyOrder = emergencyOrder;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectFile() {
		return projectFile;
	}

	public void setProjectFile(String projectFile) {
		this.projectFile = projectFile;
	}

	public WzNoticeMain() {
		super();
	}

	public WzNoticeMain(String id){
		super(id);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getApprovalNode() {
		return approvalNode;
	}

	public void setApprovalNode(String approvalNode) {
		this.approvalNode = approvalNode;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getSendCompany() {
		return sendCompany;
	}

	public void setSendCompany(String sendCompany) {
		this.sendCompany = sendCompany;
	}
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getZygkId() {
		return zygkId;
	}

	public void setZygkId(String zygkId) {
		this.zygkId = zygkId;
	}
	public String getZygkName() {
		return zygkName;
	}

	public void setZygkName(String zygkName) {
		this.zygkName = zygkName;
	}

}
