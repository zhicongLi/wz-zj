/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 非招标采购结果议题审批Entity
 * @author lizhicong
 * @version 2022-12-27
 */
public class WzNoticeResult extends DataEntity<WzNoticeResult> {

	private static final long serialVersionUID = 1L;
	private String subcontractNumber;		// 分包编号
	private String materialNumber;		// 物料编号
	private String planCategoryName;		// 计划类别名称
	private String materialDescribe;		// 物料描述
	private String demandQuantity;		// 需求数量
	private String unit;		// 计量单位
	private String supplierName;		// 首选供应商
	private String supplierPrice;		// 首选报价（万元）
	private String substituteName;		// 备选供应商
	private String substitutePrice;		// 备选报价（万元）
	private String parentId;		// 父类id
	private String tenantId;		// 租户id


	public WzNoticeResult() {
		super();
	}

	public WzNoticeResult(String id){
		super(id);
	}

	public String getSubcontractNumber() {
		return subcontractNumber;
	}

	public void setSubcontractNumber(String subcontractNumber) {
		this.subcontractNumber = subcontractNumber;
	}
	public String getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}
	public String getPlanCategoryName() {
		return planCategoryName;
	}

	public void setPlanCategoryName(String planCategoryName) {
		this.planCategoryName = planCategoryName;
	}
	public String getMaterialDescribe() {
		return materialDescribe;
	}

	public void setMaterialDescribe(String materialDescribe) {
		this.materialDescribe = materialDescribe;
	}
	public String getDemandQuantity() {
		return demandQuantity;
	}

	public void setDemandQuantity(String demandQuantity) {
		this.demandQuantity = demandQuantity;
	}
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}