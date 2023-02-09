/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * wz_procurementEntity
 * @author lizhicong
 * @version 2022-06-28
 */
public class WzProcurement extends DataEntity<WzProcurement> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String companyName;		// 公司代码
	private String projectType;		// 项目类型
	private String procurementMethod;		// 采购方式
	private String packageCode;		// 采购标包号
	private String contractName;		// 合同名称
	private String supplier;		// 供应商名称
	private String dealDate;		// 成交日期
	private String passDate;		// 合同通过日期
	private String quantity;		// 采购数量
	private String unitPrice;		// 计划采购单价（元）
	private String planMoney;		// 计划采购金额
	private String biddingMoney;		// 中标金额
	private String planCountNumber;		// 合同采购总数量
	private String contractUnitPrice;		// 合同单价
	private String contractCountPrice;		// 合同采购总金额（元）
	private String receivingNumber;		// 收货数量
	private String receivingPrice;		// 收货金额
	private String invoiceNumber;		// 发票校验数量
	private String invoiceMoney;		// 发票校验金额（元）
	private String planProjectNumber;		// 计划行项目数
	private String saleContractMoney;		// 销售合同金额
	private String saleContractNumber;		// 销售合同数量
	private String saleContractUnitPrice;		// 销售合同单价
	private String twoContractCountPrice;		// 二级单位采购合同金额
	private String twoSaleContractUnitPrice;		// 销售合同单价
	private String deliveryNumber;		// 已交货数量
	private String noDeliveryNumber;		// 仍要交货数量
	private String invoicingNumber;		// 开票数量
	private String companyCode;			//公司编号
	private String supplierCode;		//供应商编号
	private String supplierName;		//供应商名称
	private String dimensionTime;		//时间
	private String rowNumber;	//序号

	public String getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getDimensionTime() {
		return dimensionTime;
	}

	public void setDimensionTime(String dimensionTime) {
		this.dimensionTime = dimensionTime;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public WzProcurement() {
		super();
	}

	public WzProcurement(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getProcurementMethod() {
		return procurementMethod;
	}

	public void setProcurementMethod(String procurementMethod) {
		this.procurementMethod = procurementMethod;
	}
	public String getPackageCode() {
		return packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}
	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getDealDate() {
		return dealDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getPassDate() {
		return passDate;
	}

	public void setPassDate(String passDate) {
		this.passDate = passDate;
	}
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getPlanMoney() {
		return planMoney;
	}

	public void setPlanMoney(String planMoney) {
		this.planMoney = planMoney;
	}
	public String getBiddingMoney() {
		return biddingMoney;
	}

	public void setBiddingMoney(String biddingMoney) {
		this.biddingMoney = biddingMoney;
	}
	public String getPlanCountNumber() {
		return planCountNumber;
	}

	public void setPlanCountNumber(String planCountNumber) {
		this.planCountNumber = planCountNumber;
	}
	public String getContractUnitPrice() {
		return contractUnitPrice;
	}

	public void setContractUnitPrice(String contractUnitPrice) {
		this.contractUnitPrice = contractUnitPrice;
	}
	public String getContractCountPrice() {
		return contractCountPrice;
	}

	public void setContractCountPrice(String contractCountPrice) {
		this.contractCountPrice = contractCountPrice;
	}
	public String getReceivingNumber() {
		return receivingNumber;
	}

	public void setReceivingNumber(String receivingNumber) {
		this.receivingNumber = receivingNumber;
	}
	public String getReceivingPrice() {
		return receivingPrice;
	}

	public void setReceivingPrice(String receivingPrice) {
		this.receivingPrice = receivingPrice;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getInvoiceMoney() {
		return invoiceMoney;
	}

	public void setInvoiceMoney(String invoiceMoney) {
		this.invoiceMoney = invoiceMoney;
	}
	public String getPlanProjectNumber() {
		return planProjectNumber;
	}

	public void setPlanProjectNumber(String planProjectNumber) {
		this.planProjectNumber = planProjectNumber;
	}
	public String getSaleContractMoney() {
		return saleContractMoney;
	}

	public void setSaleContractMoney(String saleContractMoney) {
		this.saleContractMoney = saleContractMoney;
	}
	public String getSaleContractNumber() {
		return saleContractNumber;
	}

	public void setSaleContractNumber(String saleContractNumber) {
		this.saleContractNumber = saleContractNumber;
	}
	public String getSaleContractUnitPrice() {
		return saleContractUnitPrice;
	}

	public void setSaleContractUnitPrice(String saleContractUnitPrice) {
		this.saleContractUnitPrice = saleContractUnitPrice;
	}
	public String getTwoContractCountPrice() {
		return twoContractCountPrice;
	}

	public void setTwoContractCountPrice(String twoContractCountPrice) {
		this.twoContractCountPrice = twoContractCountPrice;
	}
	public String getTwoSaleContractUnitPrice() {
		return twoSaleContractUnitPrice;
	}

	public void setTwoSaleContractUnitPrice(String twoSaleContractUnitPrice) {
		this.twoSaleContractUnitPrice = twoSaleContractUnitPrice;
	}
	public String getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}
	public String getNoDeliveryNumber() {
		return noDeliveryNumber;
	}

	public void setNoDeliveryNumber(String noDeliveryNumber) {
		this.noDeliveryNumber = noDeliveryNumber;
	}
	public String getInvoicingNumber() {
		return invoicingNumber;
	}

	public void setInvoicingNumber(String invoicingNumber) {
		this.invoicingNumber = invoicingNumber;
	}

}
