/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 合同签订及时率基础表Entity
 * @author lizhicong
 * @version 2022-07-20
 */
public class WzContractTimeliness extends DataEntity<WzContractTimeliness> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String companyName;		// 三级单位
	private String contractNumber;		// 合同编号
	private String contractName;		// 合同名称
	private String dealDate;		// 成交日期
	private String passDate;		// 合同审批通过日期
	private String authorizeDate;		// 采购结果审定时间
	private String standardDuration;		// 合同签订标准时长
	private String actualDuration;		// 合同签订实际时长
	private String bidMoney;		// 投标金额
	private String contractMoney;		// 合同金额
	private String dimensionTime;		//时间

	public String getDimensionTime() {
		return dimensionTime;
	}

	public void setDimensionTime(String dimensionTime) {
		this.dimensionTime = dimensionTime;
	}

	public WzContractTimeliness() {
		super();
	}

	public WzContractTimeliness(String id){
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
	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
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
	public String getAuthorizeDate() {
		return authorizeDate;
	}

	public void setAuthorizeDate(String authorizeDate) {
		this.authorizeDate = authorizeDate;
	}
	public String getStandardDuration() {
		return standardDuration;
	}

	public void setStandardDuration(String standardDuration) {
		this.standardDuration = standardDuration;
	}
	public String getActualDuration() {
		return actualDuration;
	}

	public void setActualDuration(String actualDuration) {
		this.actualDuration = actualDuration;
	}
	public String getBidMoney() {
		return bidMoney;
	}

	public void setBidMoney(String bidMoney) {
		this.bidMoney = bidMoney;
	}
	public String getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(String contractMoney) {
		this.contractMoney = contractMoney;
	}

}
