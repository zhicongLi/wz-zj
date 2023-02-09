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
import org.springframework.format.annotation.DateTimeFormat;

/**
 * wz_topics_mettingEntity
 * @author lizhicong
 * @version 2021-09-28
 */
public class WzTopicsMetting extends DataEntity<WzTopicsMetting> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String mettingCode;		// 会议编号
	private String mettingName;		// 会议名称
	private Date mettingTime;		// 会议时间
	private String mettingPlace;		// 会议地点
	private String mettingPeople;		// 参会人员
	private String mettingBoth;		// 会议结论
	private String mettingStatus;		// 会议状态
	private String mettingFile;		// 会议结论文件
	private String status;			//流程状态


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public WzTopicsMetting() {
		super();
	}

	public WzTopicsMetting(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getMettingCode() {
		return mettingCode;
	}

	public void setMettingCode(String mettingCode) {
		this.mettingCode = mettingCode;
	}
	public String getMettingName() {
		return mettingName;
	}

	public void setMettingName(String mettingName) {
		this.mettingName = mettingName;
	}
	@JSONField(format = "yyyy-MM-dd")
	public Date getMettingTime() {
		return mettingTime;
	}

	public void setMettingTime(Date mettingTime) {
		this.mettingTime = mettingTime;
	}

	public String getMettingPlace() {
		return mettingPlace;
	}

	public void setMettingPlace(String mettingPlace) {
		this.mettingPlace = mettingPlace;
	}
	public String getMettingPeople() {
		return mettingPeople;
	}

	public void setMettingPeople(String mettingPeople) {
		this.mettingPeople = mettingPeople;
	}
	public String getMettingBoth() {
		return mettingBoth;
	}

	public void setMettingBoth(String mettingBoth) {
		this.mettingBoth = mettingBoth;
	}
	public String getMettingStatus() {
		return mettingStatus;
	}

	public void setMettingStatus(String mettingStatus) {
		this.mettingStatus = mettingStatus;
	}
	public String getMettingFile() {
		return mettingFile;
	}

	public void setMettingFile(String mettingFile) {
		this.mettingFile = mettingFile;
	}

}
