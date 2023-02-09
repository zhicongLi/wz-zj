/**
 *
 */
package com.ims.wz.cg.entity;


import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 采购申请及时率基础表Entity
 * @author lizhicong
 * @version 2022-07-19
 */
public class WzTimelinessRate extends DataEntity<WzTimelinessRate> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户id
	private String systemName;		// 系统
	private String modelName;		// 模块
	private String deptName;		// 单位
	private String year;		// 年份
	private String month;		//月份
	private String indexName;	//指标名称
	private String indexCode;	//指标编号
	private String indexValue;	//指标值
	private String indexWeight;		//指标权重
	private String indexDept;	//指标单位
	private String indexPurpose;	//指标用途
	private String createTime;	//创建日期
	private String indexDenominator;	//指标分母
	private String denominator;		// 分母值
	private String indicatorMolecule;		// 指标分子
	private String molecule;		// 分子值
	private String frequency;		// 推送频率
	private String evaluationDimension;		// 评价维度
	private String remark;		// 备注
	private String dimensionTime;		//时间

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
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

	public String getIndexValue() {
		return indexValue;
	}

	public void setIndexValue(String indexValue) {
		this.indexValue = indexValue;
	}

	public String getIndexWeight() {
		return indexWeight;
	}

	public void setIndexWeight(String indexWeight) {
		this.indexWeight = indexWeight;
	}

	public String getIndexDept() {
		return indexDept;
	}

	public void setIndexDept(String indexDept) {
		this.indexDept = indexDept;
	}

	public String getIndexPurpose() {
		return indexPurpose;
	}

	public void setIndexPurpose(String indexPurpose) {
		this.indexPurpose = indexPurpose;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getIndexDenominator() {
		return indexDenominator;
	}

	public void setIndexDenominator(String indexDenominator) {
		this.indexDenominator = indexDenominator;
	}

	public String getDimensionTime() {
		return dimensionTime;
	}

	public void setDimensionTime(String dimensionTime) {
		this.dimensionTime = dimensionTime;
	}

	public WzTimelinessRate() {
		super();
	}

	public WzTimelinessRate(String id){
		super(id);
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	public String getDenominator() {
		return denominator;
	}

	public void setDenominator(String denominator) {
		this.denominator = denominator;
	}
	public String getIndicatorMolecule() {
		return indicatorMolecule;
	}

	public void setIndicatorMolecule(String indicatorMolecule) {
		this.indicatorMolecule = indicatorMolecule;
	}
	public String getMolecule() {
		return molecule;
	}

	public void setMolecule(String molecule) {
		this.molecule = molecule;
	}
	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getEvaluationDimension() {
		return evaluationDimension;
	}

	public void setEvaluationDimension(String evaluationDimension) {
		this.evaluationDimension = evaluationDimension;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
