/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 电厂填报表Entity
 * @author lizhicong
 * @version 2022-08-18
 */
public class WzFillIn extends DataEntity<WzFillIn> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String agreementMoney;		// 框架协议采购金额
	private String declareNumber;		// 物资编码申报已赋码数
	private String declareNoNumber;		// 物资编码申报未通过数
	private String reviewNumber;		// 物资编码审核及时数
	private String reviewNoNumber;		// 物资编码审核不及时数
	private String useNumber;		// 物资编码使用数
	private String useNoNumber;		// 物资编码未使用数
	private String biddingNumber;		// 招标一挂数量
	private String biddingSuccessNumber;		// 招标一挂成功数量
	private String stockMoney;		// 库存金额


	public WzFillIn() {
		super();
	}

	public WzFillIn(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getAgreementMoney() {
		return agreementMoney;
	}

	public void setAgreementMoney(String agreementMoney) {
		this.agreementMoney = agreementMoney;
	}
	public String getDeclareNumber() {
		return declareNumber;
	}

	public void setDeclareNumber(String declareNumber) {
		this.declareNumber = declareNumber;
	}
	public String getDeclareNoNumber() {
		return declareNoNumber;
	}

	public void setDeclareNoNumber(String declareNoNumber) {
		this.declareNoNumber = declareNoNumber;
	}
	public String getReviewNumber() {
		return reviewNumber;
	}

	public void setReviewNumber(String reviewNumber) {
		this.reviewNumber = reviewNumber;
	}
	public String getReviewNoNumber() {
		return reviewNoNumber;
	}

	public void setReviewNoNumber(String reviewNoNumber) {
		this.reviewNoNumber = reviewNoNumber;
	}
	public String getUseNumber() {
		return useNumber;
	}

	public void setUseNumber(String useNumber) {
		this.useNumber = useNumber;
	}
	public String getUseNoNumber() {
		return useNoNumber;
	}

	public void setUseNoNumber(String useNoNumber) {
		this.useNoNumber = useNoNumber;
	}
	public String getBiddingNumber() {
		return biddingNumber;
	}

	public void setBiddingNumber(String biddingNumber) {
		this.biddingNumber = biddingNumber;
	}
	public String getBiddingSuccessNumber() {
		return biddingSuccessNumber;
	}

	public void setBiddingSuccessNumber(String biddingSuccessNumber) {
		this.biddingSuccessNumber = biddingSuccessNumber;
	}
	public String getStockMoney() {
		return stockMoney;
	}

	public void setStockMoney(String stockMoney) {
		this.stockMoney = stockMoney;
	}

}