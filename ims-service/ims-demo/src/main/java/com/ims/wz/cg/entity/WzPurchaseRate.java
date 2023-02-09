/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 集中 公开 上网采购率Entity
 * @author lizhicong
 * @version 2022-08-18
 */
public class WzPurchaseRate extends DataEntity<WzPurchaseRate> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String sonCompanyCode;		// 子分公司编号
	private String sonCompanyName;		// 子分公司名称
	private String jzcgl;		// 集中采购率
	private String gkcgl;		// 公开采购率
	private String swcgl;		// 上网采购率
	private String jtjzcgl;		// 集团集中采购率
	private String jtgkcgl;		// 集团公开采购率
	private String jtswcgl;		// 集团上网采购率
	private String score;		// 得分
	private String cgzje;		// 采购总金额
	private String gkcgje;		// 公开采购金额
	private String jzcgje;		// 集中采购金额
	private String dimensionTime;		// 时间


	public WzPurchaseRate() {
		super();
	}

	public WzPurchaseRate(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getSonCompanyCode() {
		return sonCompanyCode;
	}

	public void setSonCompanyCode(String sonCompanyCode) {
		this.sonCompanyCode = sonCompanyCode;
	}
	public String getSonCompanyName() {
		return sonCompanyName;
	}

	public void setSonCompanyName(String sonCompanyName) {
		this.sonCompanyName = sonCompanyName;
	}
	public String getJzcgl() {
		return jzcgl;
	}

	public void setJzcgl(String jzcgl) {
		this.jzcgl = jzcgl;
	}
	public String getGkcgl() {
		return gkcgl;
	}

	public void setGkcgl(String gkcgl) {
		this.gkcgl = gkcgl;
	}
	public String getSwcgl() {
		return swcgl;
	}

	public void setSwcgl(String swcgl) {
		this.swcgl = swcgl;
	}
	public String getJtjzcgl() {
		return jtjzcgl;
	}

	public void setJtjzcgl(String jtjzcgl) {
		this.jtjzcgl = jtjzcgl;
	}
	public String getJtgkcgl() {
		return jtgkcgl;
	}

	public void setJtgkcgl(String jtgkcgl) {
		this.jtgkcgl = jtgkcgl;
	}
	public String getJtswcgl() {
		return jtswcgl;
	}

	public void setJtswcgl(String jtswcgl) {
		this.jtswcgl = jtswcgl;
	}
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	public String getCgzje() {
		return cgzje;
	}

	public void setCgzje(String cgzje) {
		this.cgzje = cgzje;
	}
	public String getGkcgje() {
		return gkcgje;
	}

	public void setGkcgje(String gkcgje) {
		this.gkcgje = gkcgje;
	}
	public String getJzcgje() {
		return jzcgje;
	}

	public void setJzcgje(String jzcgje) {
		this.jzcgje = jzcgje;
	}
	public String getDimensionTime() {
		return dimensionTime;
	}

	public void setDimensionTime(String dimensionTime) {
		this.dimensionTime = dimensionTime;
	}

}