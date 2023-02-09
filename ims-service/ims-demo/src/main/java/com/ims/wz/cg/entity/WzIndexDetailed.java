/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.SimpleDateFormat;

/**
 * 指标详细表Entity
 * @author lizhicong
 * @version 2022-08-24
 */
public class WzIndexDetailed extends DataEntity<WzIndexDetailed> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String indexName;		// 指标名称
	private String indexCode;		// 统一指标编码
	private String indexType;		// 指标分类
	private String indexTypeCode;		// 指标分类编码
	private String company;		// 计量单位
	private String timeDimension;		// 时间维度
	private String calculationDimension;		// 计算维度
	private String organizationDimension;		// 组织维度
	private String formula;		// 计算公式
	private String remark;		// 备注
	private String sourceSurface;		// 来源表
	private String sourceField;		// 来源字段


	public WzIndexDetailed() {
		super();
	}

	public WzIndexDetailed(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
	public String getIndexType() {
		return indexType;
	}

	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}
	public String getIndexTypeCode() {
		return indexTypeCode;
	}

	public void setIndexTypeCode(String indexTypeCode) {
		this.indexTypeCode = indexTypeCode;
	}
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public String getTimeDimension() {
		return timeDimension;
	}

	public void setTimeDimension(String timeDimension) {
		this.timeDimension = timeDimension;
	}
	public String getCalculationDimension() {
		return calculationDimension;
	}

	public void setCalculationDimension(String calculationDimension) {
		this.calculationDimension = calculationDimension;
	}
	public String getOrganizationDimension() {
		return organizationDimension;
	}

	public void setOrganizationDimension(String organizationDimension) {
		this.organizationDimension = organizationDimension;
	}
	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSourceSurface() {
		return sourceSurface;
	}

	public void setSourceSurface(String sourceSurface) {
		this.sourceSurface = sourceSurface;
	}
	public String getSourceField() {
		return sourceField;
	}

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}

}
