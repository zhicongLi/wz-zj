/**
 *
 */
package com.ims.wz.cg.entity;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;

import com.ims.core.entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * wz_topicsEntity
 * @author lizhicong
 * @version 2021-09-23
 */
public class WzTopics extends DataEntity<WzTopics> {

	private static final long serialVersionUID = 1L;
	private String code;		// 议题编号
	private String biddingName;		// 议题名称
	private String topicsType;		// 议题类型
	private String projectName;		// 招标项目名称
	private String bidder;		// 投标人
	private String tenderPrice;		// 开标价格
	private String evaluatePrice;		// 评价价格
	private String priceNumber;		// 价格得分
	private String technologyNumber;		// 技术评分
	private String businessNumber;		// 商务评分
	private String comprehensiveNumber;		// 综合评分
	private String comprehensiveSort;		// 综合排序
	private String indexProposal;		// 授标建议
	private String writeBy;		// 填报人id
	private String writeName;		// 填报人
	private String writeDept;		// 填报单位
	private String status;		// 议题状态
	private Date writeDate;		// 填报时间
	private String estimate;		// 标的概算
	private String range;		// 招标范围
	private String qualifications;		// 主要资格条件
	private String qualityRequirement;		// 主要质量要求
	private String duration;		// 工期/交货期
	private String proportion;		// 付款比例
	private String avoid;		// 评委会是否试行回避
	private String secrecy;		// 招标工作人员是否执行保密纪律
	private String objection;		// 异议、投诉情况
	private String population;		// 总体情况
	private String companyName;		// 单位名称
	private String registerDate;		// 注册时间
	private String registerPlace;		// 注册地点
	private String companyAchievement;		// 公司业绩
	private String otherAchievement;		// 其他业绩
	private String problemAnalysis;		// 首选中标候选人可能存在问题分析
	private String scoreJudge;		// 评标分判断
	private String tenderee;		// 招标人
	private String diector;		// 评标主任（组长）
	private String bidSupervisor;		// 监标人
	private String types;		// 标的类别
	private String procurementEstimate;		// 采购概算
	private String supplierName;		// 供应商名称
	private String supplierPrice;		// 价格
	private String substituteName;		// 备选供应商名称
	private String substitutePrice;		// 价格
	private String remark;		// 备注
	private String sketch;		// 失信行为简介
	private String disposalSuggestions;		// 适用条款及处置建议
	private String behaviorType;		// 失信行为分类
	private String basis;		// 制度依据
	private String projectCgcode;		// 采购项目（标包）编号
	private String projectCgname;		// 采购项目（标包）名称
	private String presentSituation;		// 采购项目（标包）现状
	private String purchaseType;		// 采购方式
	private String endDate;		// 项目评审/评标/报价截止日期
	private String sendDate;		// 成交（中标）通知书发出日期
	private String signDate;		// 合同签订日期
	private String relieveDescr;		// 解除失信行为简述
	private String clause;		// 适用条款及处置建议
	private String requestType;		// 申请类型
	private String mettingNumber;	//会议编号
	private String supplierName1;	//失信供应商名称
	private String supplierName2;	//解除失信供应商名称
	private String parentId;		//父类id
	private String topicsStatus;	//议题状态
	private String supplierFile1;	//供应商附件
	private String supplierFile2; 	//供应商附件
	private String sonCompany;		//所属子公司
	private String companyName1;	//项目公司名称
	private String stage;			//项目阶段
	private String category;		//标的名称
	private String budget;			//概算金额
	private String mechanism;		//招标管理机构
	private String moneyResource;	//费用来源
	private String procurementMethod;	//采购方式
	private String supplier;		//供应商
	private String jobContent;		//主要工作内容
	private String workload;		//工作量
	private String duration1;		//工期
	private String peopleSituation;		//人员情况
	private String achievement;		//资质业绩
	private String detailedList;	//物资技术规格清单
	private String sonCompany1;		//非招标采购所属子公司
	private String companyName2;	//非招标采购项目公司名称
	private String moneyResource1;	//非招标采购项目资金来源
	private String ispass;			//是否通过
	private String conclusion;		//议题结论
	private Date passTime;			//议题通过时间
	private String firstAchievement;	//首选单位业绩情况
	private String isestimate;		//是否偏离概算
	private String estimateDetailed;	//偏离概算说明
	private String isoffer;			//是否否决报价
	private String offerDetailed;	//否决报价说明
	private String topicsValue;		//议题内容
	private String topicsFile;		//议题附件
	private String mettingName;		//会议名字
	private Date mettingTime;		//会议时间
	private String mettingSummary;	//会议纪要
	private String zbplanId;		//招标计划关联id
	private String zbplanName;		//招标计划名称
	private String fzbplanId;		//非招标计划关联id
	private String fzbplanName;		//非招标计划关联name
	private String zbplanSid;		//招标关联结果id
	private String fzbplanSid;		//非招标关联结果id

	private String informationSources;      //信息来源
	private String contactInformation;      //联系方式
	private String mailbox;      //联系人邮箱
	private String month;      //所属月度
	private String applicationType;      //申请类型
	private String projectCategory;      //项目类别
	private String projectUnit;      //采购项目单位
	private String plate;      //所属板块
	private String budgetAmount;      //预算金额（CNY）
	private String documentNumber;      //采购领导机构纪要文号
	private Date dateMeeting;      //采购领导机构上会日期
	private String supplierNumber;      //供应商编号
	private String socialCreditCode;      //供应商统一社会信用代码
	private Date informSupplierofdate;      //告知供应商日期
	private String appeal;      //供应商是否申诉
	private String appealHandling;      //申诉处理结果
	private Date disposalStartDate;      //处置开始日期
	private Date disposalEndDate;      //整改截止日期
	private String remarks;      //备注
	private String budgetFzb;      //备注
	private String quotedAmount;      //报价金额（CNY）

	//新增字段
	private String projectDescribe; //非招标采购范围
	private String stageFzb; //非招标项目阶段
	private String jName; //招标工程项目名称
	private String remarkZb; //招标备注
	private String priceCeiling;	//最高限价
	private String offerNumber;		//报价家数
	private String behaviorDescription; //串标或其他供应商失信行为情况说明
	private String achievementzb;	//招标资质业绩
	private String projectDescribezb;	//招标采购范围
	private String stopReason;		//终止原因
	private String procurementBasisZb;	//采购制度依据招标
	private String procurementBasisFzb;	//采购制度依据非招标
	private String parentId1;		//父类id
	private String resultStatus;	//结果议题状态
	private Date mettingYear;		//采委会年份
	private String period;			//采委会期数
	private String notPassReason;	//未通过原因

	public String getjName() {
		return jName;
	}

	public void setjName(String jName) {
		this.jName = jName;
	}

	public String getNotPassReason() {
		return notPassReason;
	}

	public void setNotPassReason(String notPassReason) {
		this.notPassReason = notPassReason;
	}

	@JSONField(format = "yyyy")
	public Date getMettingYear() {
		return mettingYear;
	}

	public void setMettingYear(Date mettingYear) {
		this.mettingYear = mettingYear;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getParentId1() {
		return parentId1;
	}

	public void setParentId1(String parentId1) {
		this.parentId1 = parentId1;
	}

	public String getProcurementBasisZb() {
		return procurementBasisZb;
	}

	public void setProcurementBasisZb(String procurementBasisZb) {
		this.procurementBasisZb = procurementBasisZb;
	}

	public String getProcurementBasisFzb() {
		return procurementBasisFzb;
	}

	public void setProcurementBasisFzb(String procurementBasisFzb) {
		this.procurementBasisFzb = procurementBasisFzb;
	}

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}

	public String getAchievementzb() {
		return achievementzb;
	}

	public void setAchievementzb(String achievementzb) {
		this.achievementzb = achievementzb;
	}

	public String getProjectDescribezb() {
		return projectDescribezb;
	}

	public void setProjectDescribezb(String projectDescribezb) {
		this.projectDescribezb = projectDescribezb;
	}

	public String getZbplanSid() {
		return zbplanSid;
	}

	public String getPriceCeiling() {
		return priceCeiling;
	}

	public void setPriceCeiling(String priceCeiling) {
		this.priceCeiling = priceCeiling;
	}

	public String getOfferNumber() {
		return offerNumber;
	}

	public void setOfferNumber(String offerNumber) {
		this.offerNumber = offerNumber;
	}

	public String getBehaviorDescription() {
		return behaviorDescription;
	}

	public void setBehaviorDescription(String behaviorDescription) {
		this.behaviorDescription = behaviorDescription;
	}

	public void setZbplanSid(String zbplanSid) {
		this.zbplanSid = zbplanSid;
	}

	public String getFzbplanSid() {
		return fzbplanSid;
	}

	public void setFzbplanSid(String fzbplanSid) {
		this.fzbplanSid = fzbplanSid;
	}

	public String getFzbplanId() {
		return fzbplanId;
	}

	public void setFzbplanId(String fzbplanId) {
		this.fzbplanId = fzbplanId;
	}

	public String getFzbplanName() {
		return fzbplanName;
	}

	public void setFzbplanName(String fzbplanName) {
		this.fzbplanName = fzbplanName;
	}

	public String getZbplanName() {
		return zbplanName;
	}

	public void setZbplanName(String zbplanName) {
		this.zbplanName = zbplanName;
	}

	public String getZbplanId() {
		return zbplanId;
	}

	public void setZbplanId(String zbplanId) {
		this.zbplanId = zbplanId;
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

	public String getMettingSummary() {
		return mettingSummary;
	}

	public void setMettingSummary(String mettingSummary) {
		this.mettingSummary = mettingSummary;
	}

	public String getTopicsValue() {
		return topicsValue;
	}

	public void setTopicsValue(String topicsValue) {
		this.topicsValue = topicsValue;
	}

	public String getTopicsFile() {
		return topicsFile;
	}

	public void setTopicsFile(String topicsFile) {
		this.topicsFile = topicsFile;
	}

	public String getIsestimate() {
		return isestimate;
	}

	public void setIsestimate(String isestimate) {
		this.isestimate = isestimate;
	}

	public String getEstimateDetailed() {
		return estimateDetailed;
	}

	public void setEstimateDetailed(String estimateDetailed) {
		this.estimateDetailed = estimateDetailed;
	}

	public String getIsoffer() {
		return isoffer;
	}

	public void setIsoffer(String isoffer) {
		this.isoffer = isoffer;
	}

	public String getOfferDetailed() {
		return offerDetailed;
	}

	public void setOfferDetailed(String offerDetailed) {
		this.offerDetailed = offerDetailed;
	}

	public String getFirstAchievement() {
		return firstAchievement;
	}

	public void setFirstAchievement(String firstAchievement) {
		this.firstAchievement = firstAchievement;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getPassTime() {
		return passTime;
	}

	public void setPassTime(Date passTime) {
		this.passTime = passTime;
	}

	public String getIspass() {
		return ispass;
	}

	public void setIspass(String ispass) {
		this.ispass = ispass;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getSonCompany1() {
		return sonCompany1;
	}

	public void setSonCompany1(String sonCompany1) {
		this.sonCompany1 = sonCompany1;
	}

	public String getCompanyName2() {
		return companyName2;
	}

	public void setCompanyName2(String companyName2) {
		this.companyName2 = companyName2;
	}

	public String getMoneyResource1() {
		return moneyResource1;
	}

	public void setMoneyResource1(String moneyResource1) {
		this.moneyResource1 = moneyResource1;
	}

	public String getProcurementMethod() {
		return procurementMethod;
	}

	public void setProcurementMethod(String procurementMethod) {
		this.procurementMethod = procurementMethod;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getJobContent() {
		return jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}

	public String getWorkload() {
		return workload;
	}

	public void setWorkload(String workload) {
		this.workload = workload;
	}

	public String getDuration1() {
		return duration1;
	}

	public void setDuration1(String duration1) {
		this.duration1 = duration1;
	}

	public String getPeopleSituation() {
		return peopleSituation;
	}

	public void setPeopleSituation(String peopleSituation) {
		this.peopleSituation = peopleSituation;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getDetailedList() {
		return detailedList;
	}

	public void setDetailedList(String detailedList) {
		this.detailedList = detailedList;
	}

	public String getSonCompany() {
		return sonCompany;
	}

	public void setSonCompany(String sonCompany) {
		this.sonCompany = sonCompany;
	}

	public String getCompanyName1() {
		return companyName1;
	}

	public void setCompanyName1(String companyName1) {
		this.companyName1 = companyName1;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
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

	public String getMechanism() {
		return mechanism;
	}

	public void setMechanism(String mechanism) {
		this.mechanism = mechanism;
	}

	public String getMoneyResource() {
		return moneyResource;
	}

	public void setMoneyResource(String moneyResource) {
		this.moneyResource = moneyResource;
	}

	public String getSupplierFile1() {
		return supplierFile1;
	}

	public void setSupplierFile1(String supplierFile1) {
		this.supplierFile1 = supplierFile1;
	}

	public String getSupplierFile2() {
		return supplierFile2;
	}

	public void setSupplierFile2(String supplierFile2) {
		this.supplierFile2 = supplierFile2;
	}

	public String getTopicsStatus() {
		return topicsStatus;
	}

	public void setTopicsStatus(String topicsStatus) {
		this.topicsStatus = topicsStatus;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getSupplierName2() {
		return supplierName2;
	}

	public void setSupplierName2(String supplierName2) {
		this.supplierName2 = supplierName2;
	}

	public String getSupplierName1() {
		return supplierName1;
	}

	public void setSupplierName1(String supplierName1) {
		this.supplierName1 = supplierName1;
	}

	public String getMettingNumber() {
		return mettingNumber;
	}

	public void setMettingNumber(String mettingNumber) {
		this.mettingNumber = mettingNumber;
	}

	public WzTopics() {
		super();
	}

	public WzTopics(String id){
		super(id);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getBiddingName() {
		return biddingName;
	}

	public void setBiddingName(String biddingName) {
		this.biddingName = biddingName;
	}
	public String getTopicsType() {
		return topicsType;
	}

	public void setTopicsType(String topicsType) {
		this.topicsType = topicsType;
	}
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getBidder() {
		return bidder;
	}

	public void setBidder(String bidder) {
		this.bidder = bidder;
	}
	public String getTenderPrice() {
		return tenderPrice;
	}

	public void setTenderPrice(String tenderPrice) {
		this.tenderPrice = tenderPrice;
	}
	public String getEvaluatePrice() {
		return evaluatePrice;
	}

	public void setEvaluatePrice(String evaluatePrice) {
		this.evaluatePrice = evaluatePrice;
	}
	public String getPriceNumber() {
		return priceNumber;
	}

	public void setPriceNumber(String priceNumber) {
		this.priceNumber = priceNumber;
	}
	public String getTechnologyNumber() {
		return technologyNumber;
	}

	public void setTechnologyNumber(String technologyNumber) {
		this.technologyNumber = technologyNumber;
	}
	public String getBusinessNumber() {
		return businessNumber;
	}

	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	public String getComprehensiveNumber() {
		return comprehensiveNumber;
	}

	public void setComprehensiveNumber(String comprehensiveNumber) {
		this.comprehensiveNumber = comprehensiveNumber;
	}
	public String getComprehensiveSort() {
		return comprehensiveSort;
	}

	public void setComprehensiveSort(String comprehensiveSort) {
		this.comprehensiveSort = comprehensiveSort;
	}
	public String getIndexProposal() {
		return indexProposal;
	}

	public void setIndexProposal(String indexProposal) {
		this.indexProposal = indexProposal;
	}

	public String getWriteBy() {
		return writeBy;
	}

	public void setWriteBy(String writeBy) {
		this.writeBy = writeBy;
	}

	public String getWriteName() {
		return writeName;
	}

	public void setWriteName(String writeName) {
		this.writeName = writeName;
	}

	public String getWriteDept() {
		return writeDept;
	}

	public void setWriteDept(String writeDept) {
		this.writeDept = writeDept;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getEstimate() {
		return estimate;
	}

	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}
	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}
	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public String getQualityRequirement() {
		return qualityRequirement;
	}

	public void setQualityRequirement(String qualityRequirement) {
		this.qualityRequirement = qualityRequirement;
	}
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
	public String getAvoid() {
		return avoid;
	}

	public void setAvoid(String avoid) {
		this.avoid = avoid;
	}
	public String getSecrecy() {
		return secrecy;
	}

	public void setSecrecy(String secrecy) {
		this.secrecy = secrecy;
	}
	public String getObjection() {
		return objection;
	}

	public void setObjection(String objection) {
		this.objection = objection;
	}
	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getRegisterPlace() {
		return registerPlace;
	}

	public void setRegisterPlace(String registerPlace) {
		this.registerPlace = registerPlace;
	}
	public String getCompanyAchievement() {
		return companyAchievement;
	}

	public void setCompanyAchievement(String companyAchievement) {
		this.companyAchievement = companyAchievement;
	}
	public String getOtherAchievement() {
		return otherAchievement;
	}

	public void setOtherAchievement(String otherAchievement) {
		this.otherAchievement = otherAchievement;
	}
	public String getProblemAnalysis() {
		return problemAnalysis;
	}

	public void setProblemAnalysis(String problemAnalysis) {
		this.problemAnalysis = problemAnalysis;
	}
	public String getScoreJudge() {
		return scoreJudge;
	}

	public void setScoreJudge(String scoreJudge) {
		this.scoreJudge = scoreJudge;
	}
	public String getTenderee() {
		return tenderee;
	}

	public void setTenderee(String tenderee) {
		this.tenderee = tenderee;
	}
	public String getDiector() {
		return diector;
	}

	public void setDiector(String diector) {
		this.diector = diector;
	}
	public String getBidSupervisor() {
		return bidSupervisor;
	}

	public void setBidSupervisor(String bidSupervisor) {
		this.bidSupervisor = bidSupervisor;
	}
	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}
	public String getProcurementEstimate() {
		return procurementEstimate;
	}

	public void setProcurementEstimate(String procurementEstimate) {
		this.procurementEstimate = procurementEstimate;
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
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSketch() {
		return sketch;
	}

	public void setSketch(String sketch) {
		this.sketch = sketch;
	}
	public String getDisposalSuggestions() {
		return disposalSuggestions;
	}

	public void setDisposalSuggestions(String disposalSuggestions) {
		this.disposalSuggestions = disposalSuggestions;
	}
	public String getBehaviorType() {
		return behaviorType;
	}

	public void setBehaviorType(String behaviorType) {
		this.behaviorType = behaviorType;
	}
	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}
	public String getProjectCgcode() {
		return projectCgcode;
	}

	public void setProjectCgcode(String projectCgcode) {
		this.projectCgcode = projectCgcode;
	}
	public String getProjectCgname() {
		return projectCgname;
	}

	public void setProjectCgname(String projectCgname) {
		this.projectCgname = projectCgname;
	}
	public String getPresentSituation() {
		return presentSituation;
	}

	public void setPresentSituation(String presentSituation) {
		this.presentSituation = presentSituation;
	}
	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) { this.signDate = signDate; }
	public String getRelieveDescr() {
		return relieveDescr;
	}

	public void setRelieveDescr(String relieveDescr) {
		this.relieveDescr = relieveDescr;
	}
	public String getClause() {
		return clause;
	}

	public void setClause(String clause) {
		this.clause = clause;
	}
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getInformationSources() {
		return informationSources;
	}

	public void setInformationSources(String informationSources) {
		this.informationSources = informationSources;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}

	public String getProjectUnit() {
		return projectUnit;
	}

	public void setProjectUnit(String projectUnit) {
		this.projectUnit = projectUnit;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(String budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getDateMeeting() {
		return dateMeeting;
	}

	public void setDateMeeting(Date dateMeeting) {
		this.dateMeeting = dateMeeting;
	}

	public String getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public String getSocialCreditCode() {
		return socialCreditCode;
	}

	public void setSocialCreditCode(String socialCreditCode) {
		this.socialCreditCode = socialCreditCode;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getInformSupplierofdate() {
		return informSupplierofdate;
	}

	public void setInformSupplierofdate(Date informSupplierofdate) {
		this.informSupplierofdate = informSupplierofdate;
	}

	public String getAppeal() {
		return appeal;
	}

	public void setAppeal(String appeal) {
		this.appeal = appeal;
	}

	public String getAppealHandling() {
		return appealHandling;
	}

	public void setAppealHandling(String appealHandling) {
		this.appealHandling = appealHandling;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getDisposalStartDate() {
		return disposalStartDate;
	}

	public void setDisposalStartDate(Date disposalStartDate) {
		this.disposalStartDate = disposalStartDate;
	}

	@JSONField(format = "yyyy-MM-dd")
	public Date getDisposalEndDate() {
		return disposalEndDate;
	}

	public void setDisposalEndDate(Date disposalEndDate) {
		this.disposalEndDate = disposalEndDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getBudgetFzb() {
		return budgetFzb;
	}

	public void setBudgetFzb(String budgetFzb) { this.budgetFzb = budgetFzb; }

	public String getQuotedAmount() {
		return quotedAmount;
	}

	public void setQuotedAmount(String quotedAmount) {
		this.quotedAmount = quotedAmount;
	}

	public String getProjectDescribe() {
		return projectDescribe;
	}

	public void setProjectDescribe(String projectDescribe) { this.projectDescribe = projectDescribe; }

	public String getStageFzb() {
		return stageFzb;
	}

	public void setStageFzb(String stageFzb) { this.stageFzb = stageFzb; }

	public String getJName() { return jName; }

	public void setJName(String jName) { this.jName = jName; }

	public String getRemarkZb() { return remarkZb; }

	public void setRemarkZb(String remarkZb) { this.remarkZb = remarkZb; }
}
