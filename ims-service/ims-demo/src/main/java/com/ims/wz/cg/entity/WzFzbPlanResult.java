/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 非招标采购结果议题审批Entity
 * @author lizhicong
 * @version 2022-12-15
 */
public class WzFzbPlanResult extends DataEntity<WzFzbPlanResult> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String projectName;		// 项目名称
	private String category;		// 标的类别
	private String budget;		// 采购概算
	private String supplierName;		// 首选供应商
	private String supplierPrice;		// 首选报价（万元）
	private String substituteName;		// 备选供应商
	private String substitutePrice;		// 备选报价（万元）
	private String parentId;		// 父类id


	public WzFzbPlanResult() {
		super();
	}

	public WzFzbPlanResult(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierPrice() {
		return supplierPrice;
	}

	public void setSupplierPrice(String supplierPrice) {
		this.supplierPrice = supplierPrice;
	}
	public String getSubstituteName() {
		return substituteName;
	}

	public void setSubstituteName(String substituteName) {
		this.substituteName = substituteName;
	}
	public String getSubstitutePrice() {
		return substitutePrice;
	}

	public void setSubstitutePrice(String substitutePrice) {
		this.substitutePrice = substitutePrice;
	}
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}