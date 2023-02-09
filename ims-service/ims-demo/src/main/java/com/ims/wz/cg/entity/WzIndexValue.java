/**
 *
 */
package com.ims.wz.cg.entity;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;

import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 指标数据表Entity
 * @author lizhicong
 * @version 2022-06-20
 */
public class WzIndexValue extends DataEntity<WzIndexValue> {

	private static final long serialVersionUID = 1L;
	private String indexCode;		// index_code
	private String orgId;		// org_id
	private String time;		// time
	private String dValue;		// d_value
	private String value1;		// value1
	private String value2;		// value2
	private Long indexFrom;		// index_from
	private Long ismodify;		// ismodify
	private String planValue;		// plan_value
	private String actualValue;		// actual_value
	private String extendValue;		// extend_value
	private Date createTime;		// create_time
	private Date updateTime;		// update_time
	private String dataIndexCode;		// data_index_code
	private String orgName;		// org_name
	private String timeDimensionality;		// time_dimensionality


	public WzIndexValue() {
		super();
	}

	public WzIndexValue(String id){
		super(id);
	}

	public String getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public String getDValue() {
		return dValue;
	}

	public void setDValue(String dValue) {
		this.dValue = dValue;
	}
	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}
	public Long getIndexFrom() {
		return indexFrom;
	}

	public void setIndexFrom(Long indexFrom) {
		this.indexFrom = indexFrom;
	}
	public Long getIsmodify() {
		return ismodify;
	}

	public void setIsmodify(Long ismodify) {
		this.ismodify = ismodify;
	}
	public String getPlanValue() {
		return planValue;
	}

	public void setPlanValue(String planValue) {
		this.planValue = planValue;
	}
	public String getActualValue() {
		return actualValue;
	}

	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}
	public String getExtendValue() {
		return extendValue;
	}

	public void setExtendValue(String extendValue) {
		this.extendValue = extendValue;
	}
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getDataIndexCode() {
		return dataIndexCode;
	}

	public void setDataIndexCode(String dataIndexCode) {
		this.dataIndexCode = dataIndexCode;
	}
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getTimeDimensionality() {
		return timeDimensionality;
	}

	public void setTimeDimensionality(String timeDimensionality) {
		this.timeDimensionality = timeDimensionality;
	}

}