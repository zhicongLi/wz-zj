/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ims.core.utils.StringUtils;
import com.ims.wz.cg.entity.WzPlan;
import com.ims.wz.cg.service.IWzPlanService;
import com.ims.wz.cg.utils.ExportWord;
import com.ims.wz.cg.utils.ExportWordUtil;
import com.ims.wz.cg.utils.XwpfTUtil;
import com.qiniu.util.IOUtils;
import io.swagger.models.auth.In;
//import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzFormApprovalService;

import com.ims.wz.cg.entity.WzFormApproval;
import com.ims.wz.cg.dao.WzFormApprovalDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.AppConfigurationEntry;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;


/**
 * wz_form_approvalService
 * @author yx
 * @version 2021-10-20
 */
@Service
@Transactional(readOnly = true)
public class WzFormApprovalServiceImpl extends CrudServiceImpl<WzFormApprovalDao, WzFormApproval> implements IWzFormApprovalService{

	@Autowired
	WzFormApprovalDao wzFormApprovalDao;
	@Lazy
	@Autowired
	IWzPlanService wzPlanService;

 	public WzFormApproval get(WzFormApproval wzFormApproval) {
		return super.get(wzFormApproval);
	}

    public List<WzFormApproval> findList(WzFormApproval wzFormApproval) {
        return super.findList(wzFormApproval);
    }

	public List<WzFormApproval> findAllListM(WzFormApproval wzFormApproval,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzFormApproval,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzFormApproval> findPageM(Page<WzFormApproval> page, WzFormApproval wzFormApproval,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzFormApproval,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzFormApproval initInsert(WzFormApproval wzFormApproval)  {
		return super.initInsert(wzFormApproval);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzFormApproval wzFormApproval) {
		super.checkSave(wzFormApproval);
	}

	@Transactional(readOnly = false)
	public WzFormApproval save(WzFormApproval wzFormApproval, boolean isNewRecord){

		if (isNewRecord){
			String newCode = getCode();
			wzFormApproval.setFormNumber(newCode);
			wzFormApproval.setFormStatus("0");
		}


		return super.save(wzFormApproval,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzFormApproval> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzFormApproval wzFormApproval,String baseFilter){
		super.checkRemove(wzFormApproval,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzFormApproval wzFormApproval,String baseFilter) {
		super.delete(wzFormApproval,baseFilter);
	}

	public String getSource(String source1,String source2,String source3,String source4){
		 String source = "";
		if("0".equals(source1)){
			if ("0".equals(source2)){
				source = "燃料费-燃煤";
			}
			if ("1".equals(source2)){
				source = "燃料费-燃油";
			}
			if ("2".equals(source2)){
				source = "燃料费-燃气";
			}
			if ("3".equals(source2)){
				source = "燃料费-秸秆";
			}
			if ("4".equals(source2)){
				source = "燃料费-垃圾";
			}
			if ("5".equals(source2)){
				source = "燃料费-分摊转出";
			}
			if ("6".equals(source2)){
				source = "燃料费-分摊转入";
			}
		}
		if("1".equals(source1)){
			if ("0".equals(source2)){
				source = "购入电（热）费-电费";
			}
			if ("1".equals(source2)){
				source = "购入电（热）费-热费";
			}
			if ("2".equals(source2)){
				source = "购入电（热）费-分摊转出";
			}
			if ("3".equals(source2)){
				source = "购入电（热）费-分摊转入";
			}
		}

		if("2".equals(source1)){
			if ("0".equals(source2)){
				source = "水费-外购税费";
			}
			if ("1".equals(source2)){
				source = "水费-水资源费";
			}
			if ("2".equals(source2)){
				source = "水费-库区维护基金";
			}
			if ("3".equals(source2)){
				source = "水费-分摊转出";
			}
			if ("4".equals(source2)){
				source = "水费-分摊转入";
			}
		}

		if("3".equals(source1)){
			if ("0".equals(source2)){
				source = "材料费-主要材料";
			}
			if ("1".equals(source2)){
				source = "材料费-辅助材料";
			}
			if ("2".equals(source2)){
				source = "材料费-分摊转出";
			}
			if ("3".equals(source2)){
				source = "材料费-分摊转入";
			}
		}

		if("4".equals(source1)){
			if ("0".equals(source2)){
				source = "修理费-A级检修";
				if("0".equals(source4)){
					source = "修理费-A级检修-标准项目";
				}
				if("1".equals(source4)){
					source = "修理费-A级检修-特殊项目";
				}
				if("2".equals(source4)){
					source = "修理费-A级检修-检修人工费";
				}
			}
			if ("1".equals(source2)){
				source = "修理费-B级检修";
				if("0".equals(source4)){
					source = "修理费-B级检修-标准项目";
				}
				if("1".equals(source4)){
					source = "修理费-B级检修-特殊项目";
				}
				if("2".equals(source4)){
					source = "修理费-B级检修-检修人工费";
				}
			}
			if ("2".equals(source2)){
				source = "修理费-C级检修";
				if("0".equals(source4)){
					source = "修理费-C级检修-标准项目";
				}
				if("1".equals(source4)){
					source = "修理费-C级检修-特殊项目";
				}
				if("2".equals(source4)){
					source = "修理费-C级检修-检修人工费";
				}
			}
			if ("3".equals(source2)){
				source = "修理费-重大非标";
			}
			if ("4".equals(source2)){
				source = "修理费-公用系统检修";
			}
			if ("5".equals(source2)){
				source = "修理费-道路修缮";
			}
			if ("6".equals(source2)){
				source = "修理费-房屋修缮";
			}
			if ("7".equals(source2)){
				source = "修理费-建筑物维护";
			}
			if ("8".equals(source2)){
				source = "修理费-其他修理";
			}
			if ("9".equals(source2)){
				source = "修理费-分摊转出";
			}
			if ("10".equals(source2)){
				source = "修理费-分摊转入";
			}
			if ("11".equals(source2)){
				source = "修理费-专项检修";
				if("0".equals(source4)){
					source = "修理费-专项检修-制粉系统专项";
				}
				if("1".equals(source4)){
					source = "修理费-专项检修-其他专项";
				}
			}
			if ("12".equals(source2)){
				source = "修理费-日常维护材料";
			}
		}
		if("5".equals(source1)){
			if ("0".equals(source2)){
				source = "生产运行费-技术服务费";
			}
			if ("1".equals(source2)){
				source = "生产运行费-试验校验费";
			}
			if ("2".equals(source2)){
				source = "生产运行费-发电权交易费";
			}
			if ("3".equals(source2)){
				source = "生产运行费-分摊转出";
			}
			if ("4".equals(source2)){
				source = "生产运行费-分摊转入";
			}
		}

		if("6".equals(source1)){
			if ("0".equals(source2)){
				source = "人工成本-职工工资";
			}
			if ("1".equals(source2)){
				source = "人工成本-职工福利费";
			}
			if ("2".equals(source2)){
				source = "人工成本-社会保险费";
			}
			if ("3".equals(source2)){
				source = "人工成本-住房公积金";
			}
			if ("4".equals(source2)){
				source = "人工成本-工会经费";
			}
			if ("5".equals(source2)){
				source = "人工成本-职工教育经费";
			}
			if ("6".equals(source2)){
				source = "人工成本-费货币性福利";
			}
			if ("7".equals(source2)){
				source = "人工成本-辞退福利";
			}
			if ("8".equals(source2)){
				source = "人工成本-股份支付";
			}
			if ("9".equals(source2)){
				source = "人工成本-劳务派遣费";
			}

		}
		if("7".equals(source1)){
			if ("0".equals(source2)){
				source = "政策性税费-土地适用费";
			}
			if ("1".equals(source2)){
				source = "政策性税费-土地损失补偿费";
			}
			if ("2".equals(source2)){
				source = "政策性税费-电力监督费";
			}
			if ("3".equals(source2)){
				source = "政策性税费-海域使用权";
			}
			if ("4".equals(source2)){
				source = "政策性税费-水利建设基金";
			}
			if ("5".equals(source2)){
				source = "政策性税费-防洪保安基金";
			}
			if ("6".equals(source2)){
				source = "政策性税费-残疾人保障金";
			}
			if ("7".equals(source2)){
				source = "政策性税费-堤围保护费";
			}
			if ("8".equals(source2)){
				source = "政策性税费-价格调节基金";
			}
			if ("9".equals(source2)){
				source = "政策性税费-河道治理费";
			}
			if ("10".equals(source2)){
				source = "政策性税费-地方综合税费";
			}
			if ("11".equals(source2)){
				source = "政策性税费-工业企业机构调整专项资金";
			}
			if ("12".equals(source2)){
				source = "政策性税费-环保支出";
			}

		}
		if("8".equals(source1)){
			if ("0".equals(source2)){
				source = "财产保险费-财产基本险";
			}
			if ("1".equals(source2)){
				source = "财产保险费-机器损坏险";
			}
			if ("2".equals(source2)){
				source = "财产保险费-公共责任险";
			}
			if ("3".equals(source2)){
				source = "财产保险费-营业中断险";
			}
			if ("4".equals(source2)){
				source = "财产保险费-环境污染责任险";
			}
			if ("5".equals(source2)){
				source = "财产保险费-其他财产保险";
			}
		}

		if("9".equals(source1)){
			if ("0".equals(source2)){
				source = "其他费用-业务招待费";
			}
			if ("1".equals(source2)){
				source = "其他费用-公务车辆费用";
			}
			if ("2".equals(source2)){
				source = "其他费用-出国（境）经费";
			}
			if ("3".equals(source2)){
				source = "其他费用-办公费";
			}
			if ("4".equals(source2)){
				source = "其他费用-差旅费";
			}
			if ("5".equals(source2)){
				source = "其他费用-会议费";
			}
			if ("6".equals(source2)){
				source = "其他费用-宣传费";
			}
			if ("7".equals(source2)){
				source = "其他费用-办公用交通费";
			}
			if ("8".equals(source2)){
				source = "其他费用-党组织工作经费";
			}
			if ("9".equals(source2)){
				source = "其他费用-董事会费";
			}
			if ("10".equals(source2)){
				source = "其他费用-诉讼费";
			}
			if ("11".equals(source2)){
				source = "其他费用-会员费";
			}
			if ("12".equals(source2)){
				source = "其他费用-水费";
			}
			if ("13".equals(source2)){
				source = "其他费用-电费";
			}
			if ("14".equals(source2)){
				source = "其他费用-取暖费";
			}
			if ("15".equals(source2)){
				source = "其他费用-燃气费";
			}
			if ("16".equals(source2)){
				source = "其他费用-物业服务费";
			}
			if ("17".equals(source2)){
				source = "其他费用-消防费";
			}
			if ("18".equals(source2)){
				source = "其他费用-绿化费";
			}
			if ("19".equals(source2)){
				source = "其他费用-中介费";
			}
			if ("20".equals(source2)){
				source = "其他费用-租赁费";
			}
			if ("21".equals(source2)){
				source = "其他费用-信息技术服务费";
			}
			if ("22".equals(source2)){
				source = "其他费用-存货盘盈盘亏及正常报废损失";
			}
			if ("23".equals(source2)){
				source = "其他费用-低值易耗品摊销";
			}
			if ("24".equals(source2)){
				source = "其他费用-劳务费";
			}
			if ("25".equals(source2)){
				source = "其他费用-仓储保管费";
			}
			if ("26".equals(source2)){
				source = "其他费用-安全防护费";
			}
			if ("27".equals(source2)){
				source = "其他费用-环保支出";
			}
			if ("28".equals(source2)){
				source = "其他费用-劳动保护费用";
			}
			if ("29".equals(source2)){
				source = "其他费用-河道维护费";
			}
			if ("30".equals(source2)){
				source = "其他费用-水文气象费";
			}
			if ("31".equals(source2)){
				source = "其他费用-技术转让费";
			}
			if ("32".equals(source2)){
				source = "其他费用-生产车辆费用";
			}
			if ("33".equals(source2)){
				source = "其他费用-青苗补偿费";
			}
			if ("34".equals(source2)){
				source = "其他费用-其他-"+ source3;
			}
			if ("35".equals(source2)){
				source = "其他费用-分摊转出";
			}
			if ("36".equals(source2)){
				source = "其他费用-分摊转入";
			}
			if("37".equals(source2)){
				source = "其他费用-警卫费";
			}

		}
		if("10".equals(source1)){
			source = "委托运营费  " + source3;
		}
		if("11".equals(source1)){
			source = "无形资产摊销  " + source3;
		}
		if("12".equals(source1)){
			source = "长期待摊销费用摊销  " + source3;
		}
		if("13".equals(source1)){
			source = "研究开发费  " + source3;
		}
		if("14".equals(source1)){
			source = "折旧费  " + source3;
		}
		if("15".equals(source1)){
			source = "技改费  " + source3;
		}
		if("16".equals(source1)){
			source = "基建费  " + source3;
		}
		if("17".equals(source1)){
			source = "科技费  " + source3;
		}
		if("18".equals(source1)){
			source = "信息化费用  " + source3;
		}


		return source;
	}

	public String getGradingMethods(String method){
		 String method1 = "";
		 if ("0".equals(method)){
			 method1 = "综合评估法（低价优先）";
		 }
		if ("1".equals(method)){
			method1 = "综合评估法（价格K值）";
		}
		if ("2".equals(method)){
			method1 = "最低评审价格法（技术商务定性）";
		}
		if("3".equals(method)){
			method1 = "最低评审价格法（询价通知单）";
		}
		if("4".equals(method)){
			method1 = "单一来源";
		}
		if("5".equals(method)){
			method1 = "竞争性谈判";
		}
		if("6".equals(method)){
			method1 = "电商采购";
		}
		if("7".equals(method)){
			method1 = "直接采购";
		}
		 return method1;
	}

	/**
	 *生成表单编号 formNumber
	 * @return
	 */
	public String getCode(){

		String maxCode = wzFormApprovalDao.getMaxFormNumber();
		String newCode = "";

		Calendar rightTime = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		String date = simpleDateFormat.format(new Date());
		if ("" == maxCode || maxCode == null){
			newCode = date + "001";
		}else {
			String yAndM = maxCode.substring(0,6);
			Integer lastCode = Integer.parseInt(maxCode.substring(6));
			String nowYAndM = date;
			Integer newLastCode = 0;

			if (yAndM.equals(nowYAndM)){
				newLastCode = lastCode + 1;
				if (newLastCode < 10){
					newCode = nowYAndM + "00"+ newLastCode;
				}
				if (newLastCode >= 10 && newLastCode <= 99){
					newCode = nowYAndM + "0"+ newLastCode;
				}
				if (newLastCode >= 100){
					newCode = nowYAndM + newLastCode;
				}

			}else{
				newCode = nowYAndM + "001";
			}
		}

		 return newCode;
	}

	/**
	 * 生成表单
	 * @param wzPlan
	 */
	public WzFormApproval saveFromPlan(WzPlan wzPlan){

		WzFormApproval wzFormApproval = new WzFormApproval();
		wzFormApproval.setCreateBy(wzPlan.getCreateBy());
		wzFormApproval.setCreateByName(wzPlan.getCreateByName());
		wzFormApproval.setCreateCompany(wzPlan.getCreateCompany());
		wzFormApproval.setCreateCompanyName(wzPlan.getCreateCompanyName());
		wzFormApproval.setCreateDate(wzPlan.getCreateDate());
		wzFormApproval.setCreateDept(wzPlan.getCreateDept());
		wzFormApproval.setCreateDeptName(wzPlan.getCreateDeptName());
		wzFormApproval.setFormNumber(getCode());	//表单编号
		wzFormApproval.setPlanNumber(wzPlan.getCode());	//计划编号
		wzFormApproval.setFormType(wzPlan.getProcurementMethod());	//表单类型
		wzFormApproval.setProjectName0(wzPlan.getProjectName());
		wzFormApproval.setClassification(wzPlan.getClassification());	//项目分类
		wzFormApproval.setCategory(wzPlan.getCategory());	//标的类别
		wzFormApproval.setPlate(wzPlan.getPlate());	//专业模块
		wzFormApproval.setPlanWriter(wzPlan.getCreateByName());	//计划填报人
		wzFormApproval.setPlanUnit(wzPlan.getDept());	//计划填报单位
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		wzFormApproval.setPlanApproveTime(date);	//计划审批时间
		wzFormApproval.setFlag("0");
		wzFormApproval.setFormStatus("0");
		wzFormApproval.setProjectBudget(wzPlan.getBudget());	//标的概算\项目预算
		wzFormApproval.setCreateCompany(wzPlan.getCreateCompany());//创建人公司
		wzFormApproval.setReviewPlace2("国家能源集团江苏电力有限公司");;
		wzFormApproval.setZygkId(wzPlan.getApprovalDept()); //专业归口审批人id
		if ("3".equals(wzPlan.getProcurementMethod()) || "6".equals(wzPlan.getProcurementMethod()) || "7".equals(wzPlan.getProcurementMethod()) || "5".equals(wzPlan.getProcurementMethod())){
			wzFormApproval.setProjectName(wzPlan.getProjectName());	//标的名称\采购项目名称
			wzFormApproval.setPlanWriter(wzPlan.getCreateByName());	//计划填报人
			wzFormApproval.setPlanUnit(wzPlan.getDept());	//计划填报单位
			wzFormApproval.setPlanApproveTime(date);	//计划审批时间
			wzFormApproval.setPurchaser(wzPlan.getDept());	//采购人
			//wzFormApproval.setProjectBudget(wzPlan.getBudget());	//标的概算\项目预算
			//wzPlan.getMoneyResource()
			wzFormApproval.setCostSource(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//资金来源
			wzFormApproval.setAffiliatedUnit("国家能源集团江苏电力有限公司");	//所属单位
			wzFormApproval.setProcurementRange(wzPlan.getProjectDescribe());	//采购范围
			wzFormApproval.setPerformance(wzPlan.getAchievement());	//资质业绩条件
			wzFormApproval.setPotentialInvestors(wzPlan.getSupplier());	//潜在投资人
			//reviewMethod wzPlan.getReviewMethod()

			String mothods = getGradingMethods(wzPlan.getReviewMethod());
			if("0".equals(wzPlan.getReviewMethod()) || "1".equals(wzPlan.getReviewMethod())){
				mothods = mothods + " " + wzPlan.getScoring();
			}
			wzFormApproval.setGradingMethods(mothods);	//评分方法
			//wzFormApproval.setReviewTime(new Date());	//审查时间
			wzFormApproval.setQualifications(wzPlan.getAchievement());	// 资质要求
			wzFormApproval.setPurchaseReason(wzPlan.getProcurementBasis());	//单一来源采购理由
			wzFormApproval.setSupplier(wzPlan.getSupplier());	//供应商名称及联系方式
			wzFormApproval.setSelectReason(wzPlan.getReason());	//选择原因

		}
		if ("0".equals(wzPlan.getProcurementMethod()) || "1".equals(wzPlan.getProcurementMethod())){
		/*	//wzFormApproval.setReviewnTime2(new Date());	//审查时间
			wzFormApproval.setProjectName2(wzPlan.getProjectName());
			wzFormApproval.setProjectBudget2(wzPlan.getBudget());//标的概算\项目预算
			wzFormApproval.setPurchaser2(wzPlan.getDept());	//采购人
			wzFormApproval.setAffiliatedUnit2("国家能源集团江苏电力有限公司");	//所属单位
			wzFormApproval.setProcurementRange2(wzPlan.getProjectDescribe());	//采购范围
			wzFormApproval.setQualifications2(wzPlan.getAchievement());	// 资质要求
			wzFormApproval.setPotentialInvestors2(wzPlan.getSupplier());	//潜在投资人
			wzFormApproval.setGradingMethods2(getGradingMethods(wzPlan.getReviewMethod()));	//评分方法
			//wzFormApproval.setParticipants2();*/
			wzFormApproval.setId(wzPlan.getId()); //id
			wzFormApproval.setProjectName8(wzPlan.getCreateCompanyName());//项目填报单位
			wzFormApproval.setProjectBname8(wzPlan.getProjectName());	//项目名称
			wzFormApproval.setProjectDeptName8(wzPlan.getCreateDeptName());	//项目单位
			wzFormApproval.setSonCompany8("国家能源江苏电力有限公司");	//子分公司
			wzFormApproval.setPlate8(wzPlan.getPlate());	//专业板块
			wzFormApproval.setPlanNumber8(wzPlan.getCode());		//计划编号
			wzFormApproval.setStage8(wzPlan.getStage());		//项目阶段
			wzFormApproval.setProjectBcategory8(wzPlan.getCategory());	//标的物类别
			wzFormApproval.setProjectBudget8(wzPlan.getBudget());	//概算、预算
			wzFormApproval.setProcumentMethod8(wzPlan.getProcurementMethod());	//采购方式
			wzFormApproval.setJurisdiction8(wzPlan.getJurisdiction());	//采购管理权限
			wzFormApproval.setMoneyResource8(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//采购依据，资金来源
			wzFormApproval.setProjectDescribe8(wzPlan.getProjectDescribe());	//项目简介
			wzFormApproval.setWorkload8(wzPlan.getWorkload());		//工作量
			wzFormApproval.setDuration8(wzPlan.getDuration());		//工期
			wzFormApproval.setPeopleSituation8(wzPlan.getPeopleSituation());	//人员情况
			wzFormApproval.setIszbsp("0");		//是否为表单审批
		}
		if ("2".equals(wzPlan.getProcurementMethod())){
			double budget = Double.parseDouble(wzPlan.getBudget());
			wzFormApproval.setProjectBudget5(wzPlan.getBudget());
			if (budget < 20){
				wzFormApproval.setProjectName(wzPlan.getProjectName());	//标的名称\采购项目名称
				wzFormApproval.setPlanWriter(wzPlan.getCreateByName());	//计划填报人
				wzFormApproval.setPlanUnit(wzPlan.getDept());	//计划填报单位
				wzFormApproval.setPlanApproveTime(date);	//计划审批时间
				wzFormApproval.setPurchaser(wzPlan.getDept());	//采购人
				wzFormApproval.setProjectBudget(wzPlan.getBudget());	//标的概算\项目预算
				wzFormApproval.setCostSource(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//资金来源
				wzFormApproval.setAffiliatedUnit("国家能源集团江苏电力有限公司");	//所属单位
				wzFormApproval.setProcurementRange(wzPlan.getProjectDescribe());	//采购范围
				wzFormApproval.setPerformance(wzPlan.getAchievement());	//资质业绩条件
				wzFormApproval.setPotentialInvestors(wzPlan.getSupplier());	//潜在投资人
				String mothods = getGradingMethods(wzPlan.getReviewMethod());
				if("0".equals(wzPlan.getReviewMethod()) || "1".equals(wzPlan.getReviewMethod())){
					mothods = mothods + " " + wzPlan.getScoring();
				}
				wzFormApproval.setGradingMethods(mothods);	//评分方法
				//wzFormApproval.setReviewTime(new Date());	//审查时间
				wzFormApproval.setQualifications(wzPlan.getAchievement());	// 资质要求
				wzFormApproval.setPurchaseReason(wzPlan.getProcurementBasis());	//单一来源采购理由
				wzFormApproval.setSupplier(wzPlan.getSupplier());	//供应商名称及联系方式
				wzFormApproval.setSelectReason(wzPlan.getReason());	//选择原因



				wzFormApproval.setPurchaser3(wzPlan.getDept());	//采购人
				wzFormApproval.setProjectName3(wzPlan.getProjectName());
				wzFormApproval.setProjectBudget3(wzPlan.getBudget());//标的概算\项目预算
				wzFormApproval.setCostSource3(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//资金来源
				wzFormApproval.setProcurementRange3(wzPlan.getProjectDescribe());	//采购范围
				wzFormApproval.setQualifications3(wzPlan.getAchievement());	// 资质要求
				wzFormApproval.setPerformance3(wzPlan.getAchievement());	//资质业绩条件
				//wzFormApproval.setCreditStanding3();//资信要求
				wzFormApproval.setPurchaseReason3(wzPlan.getProcurementBasis());	//单一来源采购理由
				wzFormApproval.setSupplier3(wzPlan.getSupplier());	//供应商名称及联系方式
				wzFormApproval.setSelectReason3(wzPlan.getReason());	//选择原因
			}else{
				wzFormApproval.setPurchaser5(wzPlan.getDept());	//采购人
				wzFormApproval.setProjectName5(wzPlan.getProjectName());
				//wzFormApproval.setReviewnTime5(new Date());	//计划审批时间
				//wzFormApproval.setProjectBudget5(wzPlan.getBudget());//标的概算\项目预算
				wzFormApproval.setCostSource5(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//资金来源
				wzFormApproval.setProcurementRange5(wzPlan.getProjectDescribe());	//采购范围
				wzFormApproval.setQualifications5(wzPlan.getAchievement());	// 资质要求
				wzFormApproval.setPerformance5(wzPlan.getAchievement());	//资质业绩条件
				String mothods = getGradingMethods(wzPlan.getReviewMethod());
				if("0".equals(wzPlan.getReviewMethod()) || "1".equals(wzPlan.getReviewMethod())){
					mothods = mothods + " " + wzPlan.getScoring();
				}
				wzFormApproval.setGradingMethods5(mothods);	//评分方法
				wzFormApproval.setPurchaseReason5(wzPlan.getProcurementBasis());	//单一来源采购理由
				wzFormApproval.setSupplier5(wzPlan.getSupplier());	//供应商名称及联系方式
				wzFormApproval.setSelectReason5(wzPlan.getReason());	//选择原因
			}


		}
		if ("4".equals(wzPlan.getProcurementMethod())){
			double budget1 = Double.parseDouble(wzPlan.getBudget());
			wzFormApproval.setProjectBudget6(wzPlan.getBudget());//标的概算\项目预算
			if (budget1 < 20){
				wzFormApproval.setProjectName(wzPlan.getProjectName());	//标的名称\采购项目名称
				wzFormApproval.setPlanWriter(wzPlan.getCreateByName());	//计划填报人
				wzFormApproval.setPlanUnit(wzPlan.getDept());	//计划填报单位
				wzFormApproval.setPlanApproveTime(date);	//计划审批时间
				wzFormApproval.setPurchaser(wzPlan.getDept());	//采购人
				wzFormApproval.setProjectBudget(wzPlan.getBudget());	//标的概算\项目预算
				wzFormApproval.setCostSource(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//资金来源
				wzFormApproval.setAffiliatedUnit("国家能源集团江苏电力有限公司");	//所属单位
				wzFormApproval.setProcurementRange(wzPlan.getProjectDescribe());	//采购范围
				wzFormApproval.setPerformance(wzPlan.getAchievement());	//资质业绩条件
				wzFormApproval.setPotentialInvestors(wzPlan.getSupplier());	//潜在投资人
				String mothods = getGradingMethods(wzPlan.getReviewMethod());
				if("0".equals(wzPlan.getReviewMethod()) || "1".equals(wzPlan.getReviewMethod())){
					mothods = mothods + " " + wzPlan.getScoring();
				}
				wzFormApproval.setGradingMethods(mothods);	//评分方法
				//wzFormApproval.setReviewTime(new Date());	//审查时间
				wzFormApproval.setQualifications(wzPlan.getAchievement());	// 资质要求
				wzFormApproval.setPurchaseReason(wzPlan.getProcurementBasis());	//单一来源采购理由
				wzFormApproval.setSupplier(wzPlan.getSupplier());	//供应商名称及联系方式
				wzFormApproval.setSelectReason(wzPlan.getReason());	//选择原因


				wzFormApproval.setPurchaser4(wzPlan.getDept());	//采购人
				wzFormApproval.setProjectName4(wzPlan.getProjectName());
				wzFormApproval.setProjectBudget4(wzPlan.getBudget());//标的概算\项目预算
				wzFormApproval.setCostSource4(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//资金来源
				wzFormApproval.setProcurementRange4(wzPlan.getProjectDescribe());	//采购范围
				wzFormApproval.setQualifications4(wzPlan.getAchievement());	// 资质要求
				wzFormApproval.setPerformance4(wzPlan.getAchievement());	//资质业绩条件
				//wzFormApproval.setCreditStanding3();//资信要求
				wzFormApproval.setPurchaseReason4(wzPlan.getProcurementBasis());	//单一来源采购理由
				wzFormApproval.setSupplier4(wzPlan.getSupplier());	//供应商名称及联系方式
				wzFormApproval.setSelectReason4(wzPlan.getReason());	//选择原因
			}else{
				wzFormApproval.setPurchaser6(wzPlan.getDept());	//采购人
				wzFormApproval.setProjectName6(wzPlan.getProjectName());
				//wzFormApproval.setReviewnTime6(new Date());	//计划审批时间
				//wzFormApproval.setProjectBudget6(wzPlan.getBudget());//标的概算\项目预算
				wzFormApproval.setCostSource6(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//资金来源
				wzFormApproval.setProcurementRange6(wzPlan.getProjectDescribe());	//采购范围
				wzFormApproval.setQualifications6(wzPlan.getAchievement());	// 资质要求
				wzFormApproval.setPerformance6(wzPlan.getAchievement());	//资质业绩条件
				String mothods = getGradingMethods(wzPlan.getReviewMethod());
				if("0".equals(wzPlan.getReviewMethod()) || "1".equals(wzPlan.getReviewMethod())){
					mothods = mothods + " " + wzPlan.getScoring();
				}
				wzFormApproval.setGradingMethods6(mothods);	//评分方法
				wzFormApproval.setPurchaseReason6(wzPlan.getProcurementBasis());	//单一来源采购理由
				wzFormApproval.setSupplier6(wzPlan.getSupplier());	//供应商名称及联系方式
				wzFormApproval.setSelectReason6(wzPlan.getReason());	//选择原因
			}
		}


		Boolean isNewRecord = true;

		return super.save(wzFormApproval,isNewRecord);
	}

	public void savezbsp(String id){
		WzFormApproval wzFormApproval = this.get(id);
		if("0".equals(wzFormApproval.getFormType()) || "1".equals(wzFormApproval.getFormType())){
			if("0".equals(wzFormApproval.getIszbsp())){
				WzFormApproval wz = new WzFormApproval();

				wz.setCreateBy(wzFormApproval.getCreateBy());
				wz.setCreateByName(wzFormApproval.getCreateByName());
				wz.setCreateCompany(wzFormApproval.getCreateCompany());
				wz.setCreateCompanyName(wzFormApproval.getCreateCompanyName());
				wz.setCreateDate(wzFormApproval.getCreateDate());
				wz.setCreateDept(wzFormApproval.getCreateDept());
				wz.setCreateDeptName(wzFormApproval.getCreateDeptName());
				wz.setFormNumber(getCode());	//表单编号
				wz.setPlanNumber(wzFormApproval.getPlanNumber());	//计划编号
				wz.setFormType(wzFormApproval.getFormType());	//表单类型
				wz.setProjectName0(wzFormApproval.getProjectName0());
				wz.setClassification(wzFormApproval.getClassification());	//项目分类
				wz.setCategory(wzFormApproval.getCategory());	//标的类别
				wz.setPlate(wzFormApproval.getPlate());	//专业模块
				wz.setPlanWriter(wzFormApproval.getPlanWriter());	//计划填报人
				wz.setPlanUnit(wzFormApproval.getPlanUnit());	//计划填报单位
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = simpleDateFormat.format(new Date());
				wz.setPlanApproveTime(date);	//计划审批时间
				wz.setFlag("0");
				wz.setFormStatus("0");
				wz.setProjectBudget(wzFormApproval.getProjectBudget());	//标的概算\项目预算
				wz.setCreateCompany(wzFormApproval.getCreateCompany());//创建人公司
				wz.setReviewPlace2("国家能源集团江苏电力有限公司");;
				wz.setZygkId(wzFormApproval.getZygkId()); //专业归口审批人id
				wz.setIszbsp("1");

				WzPlan wzPlan = wzPlanService.get(id);
				wz.setReviewnTime2(new Date());	//审查时间
				wz.setProjectName2(wzPlan.getProjectName());
				wz.setProjectBudget2(wzPlan.getBudget());//标的概算\项目预算
				wz.setPurchaser2(wzPlan.getDept());	//采购人
				wz.setAffiliatedUnit2("国家能源集团江苏电力有限公司");	//所属单位
				wz.setProcurementRange2(wzPlan.getProjectDescribe());	//采购范围
				wz.setQualifications2(wzPlan.getAchievement());	// 资质要求
				wz.setPotentialInvestors2(wzPlan.getSupplier());	//潜在投资人
				wz.setGradingMethods2(getGradingMethods(wzPlan.getReviewMethod()));	//评分方法

				this.saveOrUpdate(wz);
			}
		}
	}

	//招标计划审批结束后生成招标表单
	public void saveFromZb(String id){
		WzPlan wzPlan = wzPlanService.getById(id);
		WzFormApproval wzFormApproval = new WzFormApproval();
		wzFormApproval.setFormNumber(getCode());	//表单编号
		wzFormApproval.setPlanNumber(wzPlan.getCode());	//计划编号
		wzFormApproval.setFormType(wzPlan.getProcurementMethod());	//表单类型
		wzFormApproval.setProjectName0(wzPlan.getProjectName());
		wzFormApproval.setClassification(wzPlan.getClassification());	//项目分类
		wzFormApproval.setCategory(wzPlan.getCategory());	//标的类别
		wzFormApproval.setPlate(wzPlan.getPlate());	//专业模块
		wzFormApproval.setPlanWriter(wzPlan.getCreateByName());	//计划填报人
		wzFormApproval.setPlanUnit(wzPlan.getDept());	//计划填报单位
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		wzFormApproval.setPlanApproveTime(date);	//计划审批时间
		wzFormApproval.setFlag("0");
		wzFormApproval.setFormStatus("0");
		wzFormApproval.setProjectBudget(wzPlan.getBudget());	//标的概算\项目预算
		wzFormApproval.setCreateCompany(wzPlan.getCreateCompany());//创建人公司
		wzFormApproval.setReviewPlace2("国家能源集团江苏电力有限公司");;
		wzFormApproval.setZygkId(wzPlan.getApprovalDept()); //专业归口审批人id

		wzFormApproval.setReviewnTime2(new Date());	//审查时间
		wzFormApproval.setProjectName2(wzPlan.getProjectName());
		wzFormApproval.setProjectBudget2(wzPlan.getBudget());//标的概算\项目预算
		wzFormApproval.setPurchaser2(wzPlan.getDept());	//采购人
		wzFormApproval.setAffiliatedUnit2("国家能源集团江苏电力有限公司");	//所属单位
		wzFormApproval.setProcurementRange2(wzPlan.getProjectDescribe());	//采购范围
		wzFormApproval.setQualifications2(wzPlan.getAchievement());	// 资质要求
		wzFormApproval.setPotentialInvestors2(wzPlan.getSupplier());	//潜在投资人
		wzFormApproval.setGradingMethods2(getGradingMethods(wzPlan.getReviewMethod()));	//评分方法
		//wzFormApproval.setParticipants2();
		wzFormApproval.setIszbsp("1");
		this.saveOrUpdate(wzFormApproval);
	}

	public void savePlanTime(String objId){
		WzFormApproval wzFormApproval = this.get(objId);
		wzFormApproval.setReviewTime(new Date());
		wzFormApproval.setReviewnTime2(new Date());
		wzFormApproval.setReviewnTime5(new Date());
		wzFormApproval.setReviewnTime6(new Date());
		this.saveOrUpdate(wzFormApproval);

	}



//
//	@Transactional(readOnly = false)
//	public void exportForm(HttpServletRequest request,HttpServletResponse response){
//		Map<String,Object> dataMap = new HashMap<>();
//		dataMap.put("purchaser","123");
//		try {
//			String fileName = "导出1";
//			ExportWordUtil exportWordUtil  = new ExportWordUtil();
//			exportWordUtil.exportProfessionalExperiment(response);
//
//			//ExportWord.exportWord("template/caigou.docx","template/tempFile",fileName,dataMap,request,response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


//		public void testExport(HttpServletResponse response) throws Exception {
//			Map<String, Object> params = new HashMap<>();
//			params.put("${purchaser}", "202101170001");
//
//			InputStream is = getClass().getClassLoader().getResourceAsStream("caigou.docx");
//			XWPFDocument doc = new XWPFDocument(is);
//			XwpfTUtil.replaceInPara(doc, params);
//			//XwpfTUtil.replaceInTable(doc, params);
//
//			String fileName = "caigou01.docx";
//			//response.setContentType("application/vnd.ms-excel");
//			//response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
//			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
//			response.setContentType("application/vnd.ms-excel;charset=utf-8");
//			OutputStream os = response.getOutputStream();
//			doc.write(os);
//
//			XwpfTUtil.close(os);
//			XwpfTUtil.close(is);
//		}


//	public static void doc2pdf(Document doc, String targetFile) {
//
//		try {
//			long old = System.currentTimeMillis();
//			//新建一个空白pdf文档
//			File file = new File(targetFile);
//			FileOutputStream os = new FileOutputStream(file);
//			//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
//			doc.save(os, SaveFormat.PDF);
//			os.close();
//			long now = System.currentTimeMillis();
//			//转化用时
//			System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public String returnDate(Date toS){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time1 = "";
		if (toS == null){

		}else{
			time1 = sdf.format(toS);
		}
		return time1;
	}


	public String downOrPreviewPDF(HttpServletRequest request, HttpServletResponse response, String id) {
		String fileNames = "";
		WzFormApproval wzFormApproval = this.get(id);

		String type = wzFormApproval.getFormType();

		Map<String, Object> dataMap=new HashMap<>();
		Map<String, Object> dataMap1 = new HashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String wordPath = "";
		String fileName = wzFormApproval.getFormNumber();
		if ("3".equals(type) || "6".equals(type) || "7".equals(type) || "5".equals(type)){
			dataMap.put("purchaser",wzFormApproval.getPurchaser());
			dataMap.put("projectName",wzFormApproval.getProjectName());
			String time1 = "";
			/*if (wzFormApproval.getReviewTime() == null){
				dataMap.put("reviewTime",wzFormApproval.getReviewTime());
			}else{
				time1 = sdf.format(wzFormApproval.getReviewTime());
				dataMap.put("reviewTime",time1);
			}*/

			dataMap.put("reviewTime",returnDate(wzFormApproval.getReviewTime()));
			dataMap.put("projectBudget",wzFormApproval.getProjectBudget());
			dataMap.put("costSource",wzFormApproval.getCostSource());
			dataMap.put("procurementRange",wzFormApproval.getProcurementRange());
			dataMap.put("performance",wzFormApproval.getPerformance());
			dataMap.put("gradingMethods",wzFormApproval.getGradingMethods());
			dataMap.put("contentImproved",wzFormApproval.getContentImproved());
			dataMap.put("participants",wzFormApproval.getParticipants());
			dataMap.put("purchaserDemandOp",wzFormApproval.getPurchaserDemandOp());
		/*	if (wzFormApproval.getPurchaserDemandOpTime() == null){
				dataMap.put("purchaserDemandOpTime",wzFormApproval.getPurchaserDemandOpTime());
			}else{
				time1 = sdf.format(wzFormApproval.getPurchaserDemandOpTime());
				dataMap.put("purchaserDemandOpTime",time1);
			}*/
			dataMap.put("purchaserDemandOpTime",returnDate(wzFormApproval.getPurchaserDemandOpTime()));
			if(wzFormApproval.getPurchaserMajorOp() == null || "".equals(wzFormApproval.getPurchaserMajorOp())){
				dataMap.put("purchaserMajorOp","/");
			}else{
				dataMap.put("purchaserMajorOp",wzFormApproval.getPurchaserMajorOp());
				dataMap.put("purchaserMajorOpTime","日期：" + returnDate(wzFormApproval.getPurchaserMajorOpTime()));
			}
			/*if (wzFormApproval.getPurchaserMajorOpTime() == null){
				dataMap.put("purchaserMajorOpTime",wzFormApproval.getPurchaserMajorOpTime());
			}else{
				time1 = sdf.format(wzFormApproval.getPurchaserMajorOpTime());
				dataMap.put("purchaserMajorOpTime",time1);
			}*/

			dataMap.put("purchaserPurchaseOp",wzFormApproval.getPurchaserPurchaseOp());
			/*if (wzFormApproval.getPurchaserPurchaseOpTime() == null){
				dataMap.put("purchaserPurchaseOpTime",wzFormApproval.getPurchaserPurchaseOpTime());
			}else{
				time1 = sdf.format(wzFormApproval.getPurchaserPurchaseOpTime());
				dataMap.put("purchaserPurchaseOpTime",time1);
			}*/
			dataMap.put("purchaserPurchaseOpTime",returnDate(wzFormApproval.getPurchaserPurchaseOpTime()));

			dataMap.put("purchaserLeaderOp",wzFormApproval.getPurchaserLeaderOp());
			/*if (wzFormApproval.getPurchaserLeaderOpTime() == null){
				dataMap.put("purchaserLeaderOpTime",wzFormApproval.getPurchaserLeaderOpTime());
			}else{
				time1 = sdf.format(wzFormApproval.getPurchaserLeaderOpTime());
				dataMap.put("purchaserLeaderOpTime",time1);
			}*/
			dataMap.put("purchaserLeaderOpTime",returnDate(wzFormApproval.getPurchaserLeaderOpTime()));

			dataMap.put("jsMajorOp",wzFormApproval.getJsMajorOp());
			/*if (wzFormApproval.getJsMajorOpTime() == null){
				dataMap.put("jsMajorOpTime",wzFormApproval.getJsMajorOpTime());
			}else{
				time1 = sdf.format(wzFormApproval.getJsMajorOpTime());
				dataMap.put("jsMajorOpTime",time1);
			}*/
			dataMap.put("jsMajorOpTime",returnDate(wzFormApproval.getJsMajorOpTime()));

			dataMap.put("jsMajorLeaderOp",wzFormApproval.getJsMajorLeaderOp());
		/*	if (wzFormApproval.getJsMajorLeaderOpTime() == null){
				dataMap.put("jsMajorLeaderOpTime",wzFormApproval.getJsMajorLeaderOpTime());
			}else{
				time1 = sdf.format(wzFormApproval.getJsMajorLeaderOpTime());
				dataMap.put("jsMajorLeaderOpTime",time1);
			}*/
			dataMap.put("jsMajorLeaderOpTime",returnDate(wzFormApproval.getJsMajorLeaderOpTime()));

			dataMap.put("jsPurchaseOp",wzFormApproval.getJsPurchaseOp());
			/*if (wzFormApproval.getJsPurchaseOpTime() == null){
				dataMap.put("jsPurchaseOpTime",wzFormApproval.getJsPurchaseOpTime());
			}else{
				time1 = sdf.format(wzFormApproval.getJsPurchaseOpTime());
				dataMap.put("jsPurchaseOpTime",time1);
			}*/
			dataMap.put("jsPurchaseOpTime",returnDate(wzFormApproval.getJsPurchaseOpTime()));

			dataMap.put("jsPurchaseLeaderOp",wzFormApproval.getJsPurchaseLeaderOp());
			/*if (wzFormApproval.getPurchaserLeaderOpTime() == null){
				dataMap.put("jsPurchaseLeaderOpTime",wzFormApproval.getPurchaserLeaderOpTime());
			}else{
				time1 = sdf.format(wzFormApproval.getJsPurchaseLeaderOpTime());
				dataMap.put("jsPurchaseLeaderOpTime",time1);
			}*/
			dataMap.put("jsPurchaseLeaderOpTime",returnDate(wzFormApproval.getJsPurchaseLeaderOpTime()));

			wordPath = "template/采购文件审查记录.docx";
			fileName = fileName + "采购文件审查记录";
			fileNames = fileName + "_1";
			ExportWord.exportWord(wordPath,"/file",fileName,dataMap,request,response);
		}
		if ("0".equals(type) || "1".equals(type)){
			//2
			if("1".equals(wzFormApproval.getIszbsp())){
				String time1 = "";
				if (wzFormApproval.getReviewnTime2() == null){
					dataMap.put("reviewTime",wzFormApproval.getReviewnTime2());
				}else{
					time1 = sdf.format(wzFormApproval.getReviewnTime2());
					dataMap.put("reviewTime",time1);
				}

				dataMap.put("reviewPlace",wzFormApproval.getReviewPlace2());
				dataMap.put("projectName",wzFormApproval.getProjectName2());
				dataMap.put("purchaser",wzFormApproval.getPurchaser2());
				dataMap.put("projectBudget",wzFormApproval.getProjectBudget2());
				dataMap.put("affiliatedUnit",wzFormApproval.getAffiliatedUnit2());
				dataMap.put("procurementRange",wzFormApproval.getProcurementRange2());
				dataMap.put("qualification",wzFormApproval.getQualifications2());
				dataMap.put("performance",wzFormApproval.getQualifications2());
				dataMap.put("potentialInvestors",wzFormApproval.getPotentialInvestors2());
				dataMap.put("gradingMethods",wzFormApproval.getGradingMethods2());
				dataMap.put("contentImproved",wzFormApproval.getContentImproved2());
				dataMap.put("participants",wzFormApproval.getParticipants2());
				dataMap.put("purchaserDemandOp",wzFormApproval.getPurchaserDemandOp2());


				dataMap.put("purchaserDemandOpTime",returnDate(wzFormApproval.getPurchaserdEmandOpTime2()));

				dataMap.put("purchaserPurchaseOp",wzFormApproval.getPurchaseOp2());

				dataMap.put("purchaserPurchaseOpTime",returnDate(wzFormApproval.getPurchaseOpTime2()));
				dataMap.put("purchaserLeaderOp",wzFormApproval.getPurchaserMajorOp2());

				dataMap.put("purchaserLeaderOpTime",returnDate(wzFormApproval.getPurchaserMajorOpTime2()));
				dataMap.put("finalDemandOp",wzFormApproval.getFinalDemandOp2());

				dataMap.put("finalDemandOpTime",returnDate(wzFormApproval.getFinalDemandOpTime2()));
				dataMap.put("finalPurchaseOp",wzFormApproval.getFinalPurchaseOp2());

				dataMap.put("finalPurchaseOpTime",returnDate(wzFormApproval.getFinalPurchaseOpTime2()));
				dataMap.put("finalDemandLeaderOp",wzFormApproval.getFinalDemandLeaderOp2());

				dataMap.put("finalDemandLeaderOpTime",returnDate(wzFormApproval.getFinalDemandLeaderOpTime2()));
				dataMap.put("finalPurchaseLeaderOp",wzFormApproval.getFinalPurchaseLeaderOp2());

				dataMap.put("finalPurchaseLeaderOpTime",returnDate(wzFormApproval.getFinalPurchaseLeaderOpTime2()));
				wordPath = "template/招标文件审查记录.docx";
				fileName = fileName + "招标文件审查记录";
				fileNames = fileName + "_1";
				ExportWord.exportWord(wordPath,"/file",fileName,dataMap,request,response);
				//ExportWord exportWord = new ExportWord();
				//exportfile(response);
			}else{
				dataMap.put("projectName8",wzFormApproval.getProjectName8());
				dataMap.put("projectBname8",wzFormApproval.getProjectBname8());
				dataMap.put("planTime8",returnDate(wzFormApproval.getPlanTime8()));
				dataMap.put("projectDeptName8",wzFormApproval.getProjectDeptName8());
				dataMap.put("sonCompany8",wzFormApproval.getSonCompany8());
				String plate8 = "";
				if("0".equals(wzFormApproval.getPlate8())){
					plate8 = "火电";
				}else if("1".equals(wzFormApproval.getPlate8())){
					plate8 = "煤炭";
				}else if("2".equals(wzFormApproval.getPlate8())){
					plate8 = "新能源";
				}else if("3".equals(wzFormApproval.getPlate8())){
					plate8 = "水电";
				}else if("4".equals(wzFormApproval.getPlate8())){
					plate8 = "铁路";
				}else if("5".equals(wzFormApproval.getPlate8())){
					plate8 = "港口航运";
				}else if("6".equals(wzFormApproval.getPlate8())){
					plate8 = "化工";
				}else if("7".equals(wzFormApproval.getPlate8())){
					plate8 = "环保";
				}else if("8".equals(wzFormApproval.getPlate8())){
					plate8 = "金融";
				}else if("9".equals(wzFormApproval.getPlate8())){
					plate8 = "科技研发";
				}else if("10".equals(wzFormApproval.getPlate8())){
					plate8 = "信息化";
				}else if("11".equals(wzFormApproval.getPlate8())){
					plate8 = "综合办公及其他";
				}
				dataMap.put("plate8",plate8);
				dataMap.put("planNumber8",wzFormApproval.getPlanNumber8());
				String stage8 = "";
				switch (wzFormApproval.getStage8()){
					case "0":
						stage8 = "生产检修技改和运维";
						break;
					case "1":
						stage8 = "工程前期与基建";
						break;
					case "2":
						stage8 = "信息化";
						break;
					case "3":
						stage8 = "综合办公";
						break;
					case "4":
						stage8 = "科技项目";
						break;
				}
				dataMap.put("stage8",stage8);
				String twoCategory8 = "";
				switch(wzFormApproval.getTwoCategory8()){
					case "0":
						twoCategory8 = "技改";
						break;
					case "1":
						twoCategory8 = "大修中修";
						break;
					case "2":
						twoCategory8 = "检修小修";
						break;
					case "3":
						twoCategory8 = "运维";
						break;
					case "4":
						twoCategory8 = "后勤";
						break;
					case "5":
						twoCategory8 = "承揽";
						break;
					case "6":
						twoCategory8 = "其他";
						break;
				}
				dataMap.put("twoCategory8",twoCategory8);
				String projectBcategory8 = "";
				switch (wzFormApproval.getProjectBcategory8()){
					case "0":
						projectBcategory8 = "服务";
						break;
					case "1":
						projectBcategory8 = "工程";
						break;
					case "2":
						projectBcategory8 = "物资";
						break;
				}
				dataMap.put("projectBcategory8",projectBcategory8);
				dataMap.put("projectBudget8",wzFormApproval.getProjectBudget8());
				String procumentMethod8 = "";
				switch(wzFormApproval.getProcumentMethod8()){
					case "0":
						procumentMethod8 = "邀请招标";
						break;
					case "1":
						procumentMethod8 = "公开招标";
						break;
					case "2":
						procumentMethod8 = "单一来源";
						break;
					case "3":
						procumentMethod8 = "询比价";
						break;
					case "4":
						procumentMethod8 = "竞争性谈判";
						break;
					case "5":
						procumentMethod8 = "竞价";
						break;
					case "6":
						procumentMethod8 = "直接采购";
						break;
					case "7":
						procumentMethod8 = "电商采购";
						break;
				}
				dataMap.put("procumentMethod8",procumentMethod8);
				String jurisdiction8 = "";
				switch(wzFormApproval.getJurisdiction8()){
					case "0":
						jurisdiction8 = "江苏公司";
						break;
					case "1":
						jurisdiction8 = "集团公司";
						break;
				}
				dataMap.put("jurisdiction8",jurisdiction8);
				dataMap.put("moneyResource8",wzFormApproval.getMoneyResource8());
				dataMap.put("projectDescribe8",wzFormApproval.getProjectDescribe8());
				dataMap.put("workload8",wzFormApproval.getWorkload8());
				dataMap.put("duration8",wzFormApproval.getDuration8());
				dataMap.put("peopleSituation8",wzFormApproval.getPeopleSituation8());
				dataMap.put("purchaserDemandOp8",wzFormApproval.getPurchaserDemandOp8());
				dataMap.put("purchaserdEmandOpTime8",returnDate(wzFormApproval.getPurchaserdEmandOpTime8()));
				dataMap.put("purchaseOp8",wzFormApproval.getPurchaseOp8());
				dataMap.put("purchaseOpTime8",returnDate(wzFormApproval.getPurchaseOpTime8()));
				dataMap.put("purchaserMajorOp8",wzFormApproval.getPurchaserMajorOp8());
				dataMap.put("purchaserMajorOpTime8",returnDate(wzFormApproval.getPurchaserMajorOpTime8()));
				dataMap.put("finalDemandLeaderOp8",wzFormApproval.getFinalDemandLeaderOp8());
				dataMap.put("finalDemandLeaderOpTime8",returnDate(wzFormApproval.getFinalDemandLeaderOpTime8()));
				dataMap.put("finalPurchaseLeaderOp8",wzFormApproval.getFinalPurchaseLeaderOp8());
				dataMap.put("finalPurchaseLeaderOpTime8",returnDate(wzFormApproval.getFinalPurchaseLeaderOpTime8()));
				dataMap.put("jsPurchaserLeaderOp8",wzFormApproval.getJsPurchaserLeaderOp8());
				dataMap.put("jsPurchaserLeaderOpTime8",returnDate(wzFormApproval.getJsPurchaserLeaderOpTime8()));

				wordPath = "template/招标计划审批表.docx";
				fileName = fileName + "招标计划审批表";
				fileNames = fileName + "_1";
				ExportWord.exportWord(wordPath,"/file",fileName,dataMap,request,response);
				}
			}
		if ("2".equals(type)){
			double budget1 = Double.parseDouble(wzFormApproval.getProjectBudget5());
			if (budget1 < 20){
				dataMap.put("purchaser",wzFormApproval.getPurchaser());
				dataMap.put("projectName",wzFormApproval.getProjectName());

				dataMap.put("reviewTime",returnDate(wzFormApproval.getReviewTime()));
				dataMap.put("projectBudget",wzFormApproval.getProjectBudget());
				dataMap.put("costSource",wzFormApproval.getCostSource());
				dataMap.put("procurementRange",wzFormApproval.getProcurementRange());
				dataMap.put("performance",wzFormApproval.getPerformance());
				dataMap.put("gradingMethods",wzFormApproval.getGradingMethods());
				dataMap.put("contentImproved",wzFormApproval.getContentImproved());
				dataMap.put("participants",wzFormApproval.getParticipants());
				dataMap.put("purchaserDemandOp",wzFormApproval.getPurchaserDemandOp());
				dataMap.put("purchaserDemandOpTime",returnDate(wzFormApproval.getPurchaserDemandOpTime()));
				if(wzFormApproval.getPurchaserMajorOp() == null || "".equals(wzFormApproval.getPurchaserMajorOp())){
					dataMap.put("purchaserMajorOp","/");
				}else{
					dataMap.put("purchaserMajorOp",wzFormApproval.getPurchaserMajorOp());
					dataMap.put("purchaserMajorOpTime","日期：" + returnDate(wzFormApproval.getPurchaserMajorOpTime()));
				}
				dataMap.put("purchaserPurchaseOp",wzFormApproval.getPurchaserPurchaseOp());

				dataMap.put("purchaserPurchaseOpTime",returnDate(wzFormApproval.getPurchaserPurchaseOpTime()));
				dataMap.put("purchaserLeaderOp",wzFormApproval.getPurchaserLeaderOp());

				dataMap.put("purchaserLeaderOpTime",returnDate(wzFormApproval.getPurchaserLeaderOpTime()));
				dataMap.put("jsMajorOp",wzFormApproval.getJsMajorOp());

				dataMap.put("jsMajorOpTime",returnDate(wzFormApproval.getJsMajorOpTime()));
				dataMap.put("jsMajorLeaderOp",wzFormApproval.getJsMajorLeaderOp());

				dataMap.put("jsMajorLeaderOpTime",returnDate(wzFormApproval.getJsMajorLeaderOpTime()));
				dataMap.put("jsPurchaseOp",wzFormApproval.getJsPurchaseOp());

				dataMap.put("jsPurchaseOpTime",returnDate(wzFormApproval.getJsPurchaseOpTime()));
				dataMap.put("jsPurchaseLeaderOp",wzFormApproval.getJsPurchaseLeaderOp());

				dataMap.put("jsPurchaseLeaderOpTime",returnDate(wzFormApproval.getJsPurchaseLeaderOpTime()));
				wordPath = "template/采购文件审查记录.docx";
				String fileName1 = fileName + "采购文件审查记录";
				ExportWord.exportWord(wordPath,"/file",fileName1,dataMap,request,response);

				dataMap1.put("purchaser",wzFormApproval.getPurchaser3());
				dataMap1.put("projectName",wzFormApproval.getProjectName3());
				dataMap1.put("projectBudget",wzFormApproval.getProjectBudget3());
				dataMap1.put("costSource",wzFormApproval.getCostSource3());
				dataMap1.put("procurementRange",wzFormApproval.getProcurementRange3());
				dataMap1.put("qualifications",wzFormApproval.getQualifications3());
				dataMap1.put("performance",wzFormApproval.getPerformance3());
				dataMap1.put("creditStanding",wzFormApproval.getCreditStanding3());
				dataMap1.put("purchaseReason",wzFormApproval.getPurchaseReason3());
				dataMap1.put("supplier",wzFormApproval.getSupplier3());
				dataMap1.put("selectReason",wzFormApproval.getSelectReason3());
				dataMap1.put("purchaserDemandOp",wzFormApproval.getPurchaserDemandOp3());

				dataMap1.put("purchaserDemandOpTime",returnDate(wzFormApproval.getPurchaserDemandOpTime3()));
				if(wzFormApproval.getPurchaserMajorOp3() == null || "".equals(wzFormApproval.getPurchaserMajorOp3())){
					dataMap1.put("purchaserMajorOp","/");
				}else{
					dataMap1.put("purchaserMajorOp",wzFormApproval.getPurchaserMajorOp3());
					dataMap1.put("purchaserMajorOpTime","日期：" + returnDate(wzFormApproval.getPurchaserMajorOpTime3()));
				}
				dataMap1.put("purchaserPurchaseOp",wzFormApproval.getPurchaserPurchaseOp3());

				dataMap1.put("purchaserPurchaseOpTime",returnDate(wzFormApproval.getPurchaserPurchaseOpTime3()));
				dataMap1.put("purchaserLeaderOp",wzFormApproval.getPurchaserLeaderOp3());

				dataMap1.put("purchaserLeaderOpTime",returnDate(wzFormApproval.getPurchaserLeaderOpTime3()));
				dataMap1.put("purchaserMainOp",wzFormApproval.getPurchaserMainOp3());

				dataMap1.put("purchaserMainOpTime",returnDate(wzFormApproval.getPurchaserMainOpTime3()));
				dataMap1.put("jsMajorOp",wzFormApproval.getJsMajorOp3());

				dataMap1.put("jsMajorOpTime",returnDate(wzFormApproval.getJsMajorOpTime3()));
				dataMap1.put("jsMajorLeaderOp",wzFormApproval.getJsMajorLeaderOp3());

				dataMap1.put("jsMajorLeaderOpTime",returnDate(wzFormApproval.getJsMajorLeaderOpTime3()));
				dataMap1.put("jsPurchaseOp",wzFormApproval.getJsPurchaseOp3());

				dataMap1.put("jsPurchaseOpTime",returnDate(wzFormApproval.getJsPurchaseOpTime3()));
				dataMap1.put("jsPurchaseLeaderOp",wzFormApproval.getJsPurchaseLeaderOp3());

				dataMap1.put("jsPurchaseLeaderOpTime",returnDate(wzFormApproval.getJsPurchaseLeaderOpTime3()));
				wordPath = "template/单一来源采购审批单.docx";
				String fileName2 = fileName + "单一来源采购审批单";
				fileNames = fileName1 + "_" + fileName2;
				ExportWord.exportWord(wordPath,"/file",fileName2,dataMap1,request,response);

			}else{
				/*dataMap.put("purchaser",wzFormApproval.getPurchaser5());
				dataMap.put("projectName",wzFormApproval.getProjectName5());

				dataMap.put("reviewTime",returnDate(wzFormApproval.getReviewnTime5()));
				dataMap.put("projectBudget",wzFormApproval.getProjectBudget5());
				dataMap.put("costSource",wzFormApproval.getCostSource5());
				dataMap.put("procurementRange",wzFormApproval.getProcurementRange5());
				dataMap.put("performance",wzFormApproval.getPerformance5());
				dataMap.put("qualifications",wzFormApproval.getQualifications5());
				dataMap.put("perReq",wzFormApproval.getPerReq5());
				dataMap1.put("creditStanding",wzFormApproval.getCreditStanding5());
				dataMap.put("gradingMethods",wzFormApproval.getGradingMethods5());
				dataMap.put("purchaseReason",wzFormApproval.getPurchaseReason5());
				dataMap.put("supplier",wzFormApproval.getSupplier5());
				dataMap.put("selectReason",wzFormApproval.getSelectReason5());
				dataMap.put("contentImproved",wzFormApproval.getContentImproved5());
				dataMap.put("participants",wzFormApproval.getParticipants5());
				dataMap.put("purchaserDemandOp",wzFormApproval.getPurchaserDemandOp5());

				dataMap.put("purchaserDemandOpTime",returnDate(wzFormApproval.getPurchaserDemandOpTime5()));
				dataMap.put("purchaserMajorOp",wzFormApproval.getPurchaserMajorOp5());

				dataMap.put("purchaserMajorOpTime",returnDate(wzFormApproval.getPurchaserMajorOpTime5()));
				dataMap.put("purchaserPurchaseOp",wzFormApproval.getPurchaserPurchaseOp5());

				dataMap.put("purchaserPurchaseOpTime",returnDate(wzFormApproval.getPurchaserPurchaseOpTime5()));
				dataMap.put("purchaserLeaderOp",wzFormApproval.getPurchaserLeaderOp5());

				dataMap.put("purchaserLeaderOpTime",returnDate(wzFormApproval.getPurchaserLeaderOpTime5()));
				dataMap.put("purchaserMainOp",wzFormApproval.getPurchaserMainOp5());

				dataMap.put("purchaserMainOpTime",returnDate(wzFormApproval.getPurchaserMainOpTime5()));
				dataMap.put("jsMajorOp",wzFormApproval.getJsMajorOp5());

				dataMap.put("jsMajorOpTime",returnDate(wzFormApproval.getJsMajorOpTime5()));
				dataMap.put("jsMajorLeaderOp",wzFormApproval.getJsMajorLeaderOp5());

				dataMap.put("jsMajorLeaderOpTime",returnDate(wzFormApproval.getJsMajorLeaderOpTime5()));
				dataMap.put("jsPurchaseOp",wzFormApproval.getJsPurchaseOp5());

				dataMap.put("jsPurchaseOpTime",returnDate(wzFormApproval.getJsPurchaseOpTime5()));
				dataMap.put("jsPurchaseLeaderOp",wzFormApproval.getJsPurchaseLeaderOp5());

				dataMap.put("jsPurchaseLeaderOpTime",returnDate(wzFormApproval.getPurchaserLeaderOpTime5()));
				wordPath = "template/单一来源合并表.docx";
				fileName = fileName + "单一来源合并表";
				fileNames = fileName + "_1";
				ExportWord.exportWord(wordPath,"/file",fileName,dataMap,request,response);*/

				dataMap.put("purchaser",wzFormApproval.getPurchaser5());
				dataMap.put("projectName",wzFormApproval.getProjectName5());

				dataMap.put("reviewTime",returnDate(wzFormApproval.getReviewnTime5()));
				dataMap.put("projectBudget",wzFormApproval.getProjectBudget5());
				dataMap.put("costSource",wzFormApproval.getCostSource5());
				dataMap.put("procurementRange",wzFormApproval.getProcurementRange5());
				dataMap.put("performance",wzFormApproval.getPerformance5());
				dataMap.put("gradingMethods",wzFormApproval.getGradingMethods5());
				dataMap.put("contentImproved",wzFormApproval.getContentImproved5());
				dataMap.put("participants",wzFormApproval.getParticipants5());
				dataMap.put("purchaserDemandOp",wzFormApproval.getPurchaserDemandOp5());
				dataMap.put("purchaserDemandOpTime",returnDate(wzFormApproval.getPurchaserDemandOpTime5()));
				if(wzFormApproval.getPurchaserMajorOp5() == null || "".equals(wzFormApproval.getPurchaserMajorOp5())){
					dataMap.put("purchaserMajorOp","/");
				}else{
					dataMap.put("purchaserMajorOp",wzFormApproval.getPurchaserMajorOp5());
					dataMap.put("purchaserMajorOpTime","日期：" + returnDate(wzFormApproval.getPurchaserMajorOpTime5()));
				}

				dataMap.put("purchaserPurchaseOp",wzFormApproval.getPurchaserPurchaseOp5());

				dataMap.put("purchaserPurchaseOpTime",returnDate(wzFormApproval.getPurchaserPurchaseOpTime5()));
				dataMap.put("purchaserLeaderOp",wzFormApproval.getPurchaserLeaderOp5());

				dataMap.put("purchaserLeaderOpTime",returnDate(wzFormApproval.getPurchaserLeaderOpTime5()));
				dataMap.put("jsMajorOp",wzFormApproval.getJsMajorOp5());

				dataMap.put("jsMajorOpTime",returnDate(wzFormApproval.getJsMajorOpTime5()));
				dataMap.put("jsMajorLeaderOp",wzFormApproval.getJsMajorLeaderOp5());

				dataMap.put("jsMajorLeaderOpTime",returnDate(wzFormApproval.getJsMajorLeaderOpTime5()));
				dataMap.put("jsPurchaseOp",wzFormApproval.getJsPurchaseOp5());

				dataMap.put("jsPurchaseOpTime",returnDate(wzFormApproval.getJsPurchaseOpTime5()));
				dataMap.put("jsPurchaseLeaderOp",wzFormApproval.getJsPurchaseLeaderOp5());

				dataMap.put("jsPurchaseLeaderOpTime",returnDate(wzFormApproval.getJsPurchaseLeaderOpTime5()));
				wordPath = "template/采购文件审查记录.docx";
				String fileName1 = fileName + "采购文件审查记录";
				ExportWord.exportWord(wordPath,"/file",fileName1,dataMap,request,response);

				dataMap1.put("purchaser",wzFormApproval.getPurchaser5());
				dataMap1.put("projectName",wzFormApproval.getProjectName5());
				dataMap1.put("projectBudget",wzFormApproval.getProjectBudget5());
				dataMap1.put("costSource",wzFormApproval.getCostSource5());
				dataMap1.put("procurementRange",wzFormApproval.getProcurementRange5());
				dataMap1.put("qualifications",wzFormApproval.getQualifications5());
				dataMap1.put("performance",wzFormApproval.getPerformance5());
				dataMap1.put("creditStanding",wzFormApproval.getCreditStanding5());
				dataMap1.put("purchaseReason",wzFormApproval.getPurchaseReason5());
				dataMap1.put("supplier",wzFormApproval.getSupplier5());
				dataMap1.put("selectReason",wzFormApproval.getSelectReason5());
				dataMap1.put("purchaserDemandOp",wzFormApproval.getPurchaserDemandOp5());

				dataMap1.put("purchaserDemandOpTime",returnDate(wzFormApproval.getPurchaserDemandOpTime5()));
				if(wzFormApproval.getPurchaserMajorOp5() == null || "".equals(wzFormApproval.getPurchaserMajorOp5())){
					dataMap1.put("purchaserMajorOp","/");
				}else{
					dataMap1.put("purchaserMajorOp",wzFormApproval.getPurchaserMajorOp5());
					dataMap1.put("purchaserMajorOpTime","日期：" + returnDate(wzFormApproval.getPurchaserMajorOpTime5()));
				}

				dataMap1.put("purchaserPurchaseOp",wzFormApproval.getPurchaserPurchaseOp5());

				dataMap1.put("purchaserPurchaseOpTime",returnDate(wzFormApproval.getPurchaserPurchaseOpTime5()));
				dataMap1.put("purchaserLeaderOp",wzFormApproval.getPurchaserLeaderOp5());

				dataMap1.put("purchaserLeaderOpTime",returnDate(wzFormApproval.getPurchaserLeaderOpTime5()));
				dataMap1.put("purchaserMainOp",wzFormApproval.getPurchaserMainOp5());

				dataMap1.put("purchaserMainOpTime",returnDate(wzFormApproval.getPurchaserMainOpTime5()));
				dataMap1.put("jsMajorOp",wzFormApproval.getJsMajorOp5());

				dataMap1.put("jsMajorOpTime",returnDate(wzFormApproval.getJsMajorOpTime5()));
				dataMap1.put("jsMajorLeaderOp",wzFormApproval.getJsMajorLeaderOp5());

				dataMap1.put("jsMajorLeaderOpTime",returnDate(wzFormApproval.getJsMajorLeaderOpTime5()));
				dataMap1.put("jsPurchaseOp",wzFormApproval.getJsPurchaseOp5());

				dataMap1.put("jsPurchaseOpTime",returnDate(wzFormApproval.getJsPurchaseOpTime5()));
				dataMap1.put("jsPurchaseLeaderOp",wzFormApproval.getJsPurchaseLeaderOp5());

				dataMap1.put("jsPurchaseLeaderOpTime",returnDate(wzFormApproval.getJsPurchaseLeaderOpTime5()));
				wordPath = "template/单一来源采购审批单.docx";
				String fileName2 = fileName + "单一来源采购审批单";
				fileNames = fileName1 + "_" + fileName2;
				ExportWord.exportWord(wordPath,"/file",fileName2,dataMap1,request,response);

			}
		}
		if ("4".equals(type)) {
			double budget2 = Double.parseDouble(wzFormApproval.getProjectBudget6());
			if (budget2 < 20) {
				dataMap.put("purchaser",wzFormApproval.getPurchaser());
				dataMap.put("projectName",wzFormApproval.getProjectName());

				dataMap.put("reviewTime",returnDate(wzFormApproval.getReviewTime()));
				dataMap.put("projectBudget",wzFormApproval.getProjectBudget());
				dataMap.put("costSource",wzFormApproval.getCostSource());
				dataMap.put("procurementRange",wzFormApproval.getProcurementRange());
				dataMap.put("performance",wzFormApproval.getPerformance());
				dataMap.put("gradingMethods",wzFormApproval.getGradingMethods());
				dataMap.put("contentImproved",wzFormApproval.getContentImproved());
				dataMap.put("participants",wzFormApproval.getParticipants());
				dataMap.put("purchaserDemandOp",wzFormApproval.getPurchaserDemandOp());
				dataMap.put("purchaserDemandOpTime",returnDate(wzFormApproval.getPurchaserDemandOpTime()));
				if(wzFormApproval.getPurchaserMajorOp() == null || "".equals(wzFormApproval.getPurchaserMajorOp())){
					dataMap.put("purchaserMajorOp","/");
				}else{
					dataMap.put("purchaserMajorOp",wzFormApproval.getPurchaserMajorOp());
					dataMap.put("purchaserMajorOpTime","日期：" + returnDate(wzFormApproval.getPurchaserMajorOpTime()));
				}
				dataMap.put("purchaserPurchaseOp",wzFormApproval.getPurchaserPurchaseOp());

				dataMap.put("purchaserPurchaseOpTime",returnDate(wzFormApproval.getPurchaserPurchaseOpTime()));
				dataMap.put("purchaserLeaderOp",wzFormApproval.getPurchaserLeaderOp());

				dataMap.put("purchaserLeaderOpTime",returnDate(wzFormApproval.getPurchaserLeaderOpTime()));
				dataMap.put("jsMajorOp",wzFormApproval.getJsMajorOp());

				dataMap.put("jsMajorOpTime",returnDate(wzFormApproval.getJsMajorOpTime()));
				dataMap.put("jsMajorLeaderOp",wzFormApproval.getJsMajorLeaderOp());

				dataMap.put("jsMajorLeaderOpTime",returnDate(wzFormApproval.getJsMajorLeaderOpTime()));
				dataMap.put("jsPurchaseOp",wzFormApproval.getJsPurchaseOp());

				dataMap.put("jsPurchaseOpTime",returnDate(wzFormApproval.getJsPurchaseOpTime()));
				dataMap.put("jsPurchaseLeaderOp",wzFormApproval.getJsPurchaseLeaderOp());

				dataMap.put("jsPurchaseLeaderOpTime",returnDate(wzFormApproval.getJsPurchaseLeaderOpTime()));
				wordPath = "template/采购文件审查记录.docx";
				String fileName1 = fileName + "采购文件审查记录";
				ExportWord.exportWord(wordPath, "/file", fileName1, dataMap, request, response);

				dataMap1.put("purchaser", wzFormApproval.getPurchaser4());
				dataMap1.put("projectName", wzFormApproval.getProjectName4());
				dataMap1.put("projectBudget", wzFormApproval.getProjectBudget4());
				dataMap1.put("costSource", wzFormApproval.getCostSource4());
				dataMap1.put("procurementRange", wzFormApproval.getProcurementRange4());
				dataMap1.put("qualifications", wzFormApproval.getQualifications4());
				dataMap1.put("performance", wzFormApproval.getPerformance4());
				dataMap1.put("creditStanding", wzFormApproval.getCreditStanding4());
				dataMap1.put("purchaseReason", wzFormApproval.getPurchaseReason4());
				dataMap1.put("supplier", wzFormApproval.getSupplier4());
				dataMap1.put("selectReason", wzFormApproval.getSelectReason4());
				dataMap1.put("purchaserDemandOp",wzFormApproval.getPurchaserDemandOp4());

				dataMap1.put("purchaserDemandOpTime", returnDate(wzFormApproval.getPurchaserDemandOpTime4()));
				if(wzFormApproval.getPurchaserMajorOp4() == null || "".equals(wzFormApproval.getPurchaserMajorOp4())){
					dataMap1.put("purchaserMajorOp","/");
				}else{
					dataMap1.put("purchaserMajorOp",wzFormApproval.getPurchaserMajorOp4());
					dataMap1.put("purchaserMajorOpTime", "日期：" + returnDate(wzFormApproval.getPurchaserMajorOpTime4()));
				}

				dataMap1.put("purchaserPurchaseOp", wzFormApproval.getPurchaserPurchaseOp4());

				dataMap1.put("purchaserPurchaseOpTime", returnDate(wzFormApproval.getPurchaserPurchaseOpTime4()));
				dataMap1.put("purchaserLeaderOp", wzFormApproval.getPurchaserLeaderOp4());

				dataMap1.put("purchaserLeaderOpTime", returnDate(wzFormApproval.getPurchaserLeaderOpTime4()));
				dataMap1.put("purchaserMainOp", wzFormApproval.getPurchaserMainOp4());

				dataMap1.put("purchaserMainOpTime", returnDate(wzFormApproval.getPurchaserMainOpTime4()));
				dataMap1.put("jsMajorOp", wzFormApproval.getJsMajorOp4());

				dataMap1.put("jsMajorOpTime", returnDate(wzFormApproval.getJsMajorOpTime4()));
				dataMap1.put("jsMajorLeaderOp", wzFormApproval.getJsMajorLeaderOp4());

				dataMap1.put("jsMajorLeaderOpTime", returnDate(wzFormApproval.getJsMajorLeaderOpTime4()));
				dataMap1.put("jsPurchaseOp", wzFormApproval.getJsPurchaseOp4());

				dataMap1.put("jsPurchaseOpTime", returnDate(wzFormApproval.getJsPurchaseOpTime4()));
				dataMap1.put("jsPurchaseLeaderOp", wzFormApproval.getJsPurchaseLeaderOp4());

				dataMap1.put("jsPurchaseLeaderOpTime", returnDate(wzFormApproval.getJsPurchaseLeaderOpTime4()));
				wordPath = "template/竞争性谈判采购审批单.docx";
				String fileName2 = fileName + "竞争性谈判采购审批单";
				fileNames = fileName1 + "_" + fileName2;
				ExportWord.exportWord(wordPath, "/file", fileName2, dataMap1, request, response);

			} else {
		/*		dataMap.put("purchaser", wzFormApproval.getPurchaser6());
				dataMap.put("projectName", wzFormApproval.getProjectName6());

				dataMap.put("reviewTime", returnDate(wzFormApproval.getReviewnTime6()));
				dataMap.put("projectBudget", wzFormApproval.getProjectBudget6());
				dataMap.put("costSource", wzFormApproval.getCostSource6());
				dataMap.put("procurementRange", wzFormApproval.getProcurementRange6());
				dataMap.put("performance", wzFormApproval.getPerformance6());
				dataMap.put("qualifications", wzFormApproval.getQualifications6());
				dataMap.put("perReq", wzFormApproval.getPerReq6());
				dataMap1.put("creditStanding", wzFormApproval.getCreditStanding6());
				dataMap.put("gradingMethods", wzFormApproval.getGradingMethods6());
				dataMap.put("purchaseReason", wzFormApproval.getPurchaseReason6());
				dataMap.put("supplier", wzFormApproval.getSupplier6());
				dataMap.put("selectReason", wzFormApproval.getSelectReason6());
				dataMap.put("contentImproved", wzFormApproval.getContentImproved6());
				dataMap.put("participants", wzFormApproval.getParticipants6());
				dataMap.put("purchaserDemandOp", wzFormApproval.getPurchaserDemandOp6());

				dataMap.put("purchaserDemandOpTime", returnDate(wzFormApproval.getPurchaserDemandOpTime6()));
				dataMap.put("purchaserMajorOp", wzFormApproval.getPurchaserMajorOp6());

				dataMap.put("purchaserMajorOpTime", returnDate(wzFormApproval.getPurchaserMajorOpTime6()));
				dataMap.put("purchaserPurchaseOp", wzFormApproval.getPurchaserPurchaseOp6());

				dataMap.put("purchaserPurchaseOpTime", returnDate(wzFormApproval.getPurchaserPurchaseOpTime6()));
				dataMap.put("purchaserLeaderOp", wzFormApproval.getPurchaserLeaderOp6());

				dataMap.put("purchaserLeaderOpTime", returnDate(wzFormApproval.getPurchaserLeaderOpTime6()));
				dataMap.put("purchaserMainOp", wzFormApproval.getPurchaserMainOp6());

				dataMap.put("purchaserMainOpTime", returnDate(wzFormApproval.getPurchaserMainOpTime6()));
				dataMap.put("jsMajorOp", wzFormApproval.getJsMajorOp6());

				dataMap.put("jsMajorOpTime", returnDate(wzFormApproval.getJsMajorOpTime6()));
				dataMap.put("jsMajorLeaderOp", wzFormApproval.getJsMajorLeaderOp6());

				dataMap.put("jsMajorLeaderOpTime", returnDate(wzFormApproval.getJsMajorLeaderOpTime6()));
				dataMap.put("jsPurchaseOp", wzFormApproval.getJsPurchaseOp6());

				dataMap.put("jsPurchaseOpTime", returnDate(wzFormApproval.getJsPurchaseOpTime6()));
				dataMap.put("jsPurchaseLeaderOp", wzFormApproval.getJsPurchaseLeaderOp6());

				dataMap.put("jsPurchaseLeaderOpTime", returnDate(wzFormApproval.getPurchaserLeaderOpTime6()));
				wordPath = "template/竞争性谈判合并表.docx";
				fileName = fileName + "竞争性谈判合并表";
				fileNames = fileName + "_1";
				ExportWord.exportWord(wordPath, "/file", fileName, dataMap, request, response);*/

				dataMap.put("purchaser",wzFormApproval.getPurchaser6());
				dataMap.put("projectName",wzFormApproval.getProjectName6());

				dataMap.put("reviewTime",returnDate(wzFormApproval.getReviewnTime6()));
				dataMap.put("projectBudget",wzFormApproval.getProjectBudget6());
				dataMap.put("costSource",wzFormApproval.getCostSource6());
				dataMap.put("procurementRange",wzFormApproval.getProcurementRange6());
				dataMap.put("performance",wzFormApproval.getPerformance6());
				dataMap.put("gradingMethods",wzFormApproval.getGradingMethods6());
				dataMap.put("contentImproved",wzFormApproval.getContentImproved6());
				dataMap.put("participants",wzFormApproval.getParticipants6());
				dataMap.put("purchaserDemandOp",wzFormApproval.getPurchaserDemandOp6());
				dataMap.put("purchaserDemandOpTime",returnDate(wzFormApproval.getPurchaserDemandOpTime6()));
				if(wzFormApproval.getPurchaserMajorOp6() == null || "".equals(wzFormApproval.getPurchaserMajorOp6())){
					dataMap.put("purchaserMajorOp","/");
				}else{
					dataMap.put("purchaserMajorOp",wzFormApproval.getPurchaserMajorOp6());
					dataMap.put("purchaserMajorOpTime","日期：" + returnDate(wzFormApproval.getPurchaserMajorOpTime6()));
				}

				dataMap.put("purchaserPurchaseOp",wzFormApproval.getPurchaserPurchaseOp6());

				dataMap.put("purchaserPurchaseOpTime",returnDate(wzFormApproval.getPurchaserPurchaseOpTime6()));
				dataMap.put("purchaserLeaderOp",wzFormApproval.getPurchaserLeaderOp6());

				dataMap.put("purchaserLeaderOpTime",returnDate(wzFormApproval.getPurchaserLeaderOpTime6()));
				dataMap.put("jsMajorOp",wzFormApproval.getJsMajorOp6());

				dataMap.put("jsMajorOpTime",returnDate(wzFormApproval.getJsMajorOpTime6()));
				dataMap.put("jsMajorLeaderOp",wzFormApproval.getJsMajorLeaderOp6());

				dataMap.put("jsMajorLeaderOpTime",returnDate(wzFormApproval.getJsMajorLeaderOpTime6()));
				dataMap.put("jsPurchaseOp",wzFormApproval.getJsPurchaseOp6());

				dataMap.put("jsPurchaseOpTime",returnDate(wzFormApproval.getJsPurchaseOpTime6()));
				dataMap.put("jsPurchaseLeaderOp",wzFormApproval.getJsPurchaseLeaderOp6());

				dataMap.put("jsPurchaseLeaderOpTime",returnDate(wzFormApproval.getJsPurchaseLeaderOpTime6()));
				wordPath = "template/采购文件审查记录.docx";
				String fileName1 = fileName + "采购文件审查记录";
				ExportWord.exportWord(wordPath, "/file", fileName1, dataMap, request, response);

				dataMap1.put("purchaser", wzFormApproval.getPurchaser6());
				dataMap1.put("projectName", wzFormApproval.getProjectName6());
				dataMap1.put("projectBudget", wzFormApproval.getProjectBudget6());
				dataMap1.put("costSource", wzFormApproval.getCostSource6());
				dataMap1.put("procurementRange", wzFormApproval.getProcurementRange6());
				dataMap1.put("qualifications", wzFormApproval.getQualifications6());
				dataMap1.put("performance", wzFormApproval.getPerformance6());
				dataMap1.put("creditStanding", wzFormApproval.getCreditStanding6());
				dataMap1.put("purchaseReason", wzFormApproval.getPurchaseReason6());
				dataMap1.put("supplier", wzFormApproval.getSupplier6());
				dataMap1.put("selectReason", wzFormApproval.getSelectReason6());
				dataMap1.put("purchaserDemandOp", wzFormApproval.getPurchaserDemandOp6());

				dataMap1.put("purchaserDemandOpTime", returnDate(wzFormApproval.getPurchaserDemandOpTime6()));
				dataMap1.put("purchaserMainOp", wzFormApproval.getPurchaserMainOp6());

				dataMap1.put("purchaserMainOpTime", returnDate(wzFormApproval.getPurchaserMainOpTime6()));
				dataMap1.put("purchaserPurchaseOp", wzFormApproval.getPurchaserPurchaseOp6());

				dataMap1.put("purchaserPurchaseOpTime", returnDate(wzFormApproval.getPurchaserPurchaseOpTime6()));
				dataMap1.put("purchaserLeaderOp", wzFormApproval.getPurchaserLeaderOp6());

				dataMap1.put("purchaserLeaderOpTime", returnDate(wzFormApproval.getPurchaserLeaderOpTime6()));
				if(wzFormApproval.getPurchaserMajorOp6() == null || "".equals(wzFormApproval.getPurchaserMajorOp6())){
					dataMap1.put("purchaserMajorOp","/");
				}else{
					dataMap1.put("purchaserMajorOp",wzFormApproval.getPurchaserMajorOp6());
					dataMap1.put("purchaserMajorOpTime","日期：" +  returnDate(wzFormApproval.getPurchaserMajorOpTime6()));
				}
				dataMap1.put("jsMajorOp", wzFormApproval.getJsMajorOp6());

				dataMap1.put("jsMajorOpTime", returnDate(wzFormApproval.getJsMajorOpTime6()));
				dataMap1.put("jsMajorLeaderOp", wzFormApproval.getJsMajorLeaderOp6());

				dataMap1.put("jsMajorLeaderOpTime", returnDate(wzFormApproval.getJsMajorLeaderOpTime6()));
				dataMap1.put("jsPurchaseOp", wzFormApproval.getJsPurchaseOp6());

				dataMap1.put("jsPurchaseOpTime", returnDate(wzFormApproval.getJsPurchaseOpTime6()));
				dataMap1.put("jsPurchaseLeaderOp", wzFormApproval.getJsPurchaseLeaderOp6());

				dataMap1.put("jsPurchaseLeaderOpTime", returnDate(wzFormApproval.getJsPurchaseLeaderOpTime6()));
				wordPath = "template/竞争性谈判采购审批单.docx";
				String fileName2 = fileName + "竞争性谈判采购审批单";
				fileNames = fileName1 + "_" + fileName2;
				ExportWord.exportWord(wordPath, "/file", fileName2, dataMap1, request, response);

			}
		}
		return fileNames;

	}

	public void saveOpinion(String id,String name,String opinion){
		WzFormApproval wzFormApproval = this.get(id);
		if("3".equals(wzFormApproval.getFlag())){
			if("0".equals(wzFormApproval.getFormType()) || "1".equals(wzFormApproval.getFormType())){
				if("1".equals(wzFormApproval.getIszbsp())){
					wzFormApproval.setPurchaserDemandOp2(opinion + "  " + name);
					wzFormApproval.setPurchaserdEmandOpTime2(new Date());
				}else{
					wzFormApproval.setPurchaserDemandOp8(opinion + "  " + name);
					wzFormApproval.setPurchaserdEmandOpTime8(new Date());
				}
			}else if("3".equals(wzFormApproval.getFormType()) || "5".equals(wzFormApproval.getFormType()) || "6".equals(wzFormApproval.getFormType()) || "7".equals(wzFormApproval.getFormType())){
				wzFormApproval.setPurchaserDemandOp(opinion + "  " + name);
				wzFormApproval.setPurchaserDemandOpTime(new Date());

				wzFormApproval.setPurchaserMajorOp("");
				wzFormApproval.setPurchaserMajorOpTime(null);
			}else if("2".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget5()) >= 20){
					wzFormApproval.setPurchaserDemandOp5(opinion + "  " + name);
					wzFormApproval.setPurchaserDemandOpTime5(new Date());
					wzFormApproval.setPurchaserMajorOp5("");
					wzFormApproval.setPurchaserMajorOpTime5(null);
				}else{
					wzFormApproval.setPurchaserDemandOp(opinion + "  " + name);
					wzFormApproval.setPurchaserDemandOp3(opinion + "  " + name);
					wzFormApproval.setPurchaserDemandOpTime(new Date());
					wzFormApproval.setPurchaserDemandOpTime3(new Date());
					wzFormApproval.setPurchaserMajorOp("");
					wzFormApproval.setPurchaserMajorOp3("");
					wzFormApproval.setPurchaserMajorOpTime(null);
					wzFormApproval.setPurchaserMajorOpTime3(null);
				}
			}else if("4".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget6()) >= 20){
					wzFormApproval.setPurchaserDemandOp6(opinion + "  " + name);
					wzFormApproval.setPurchaserDemandOpTime6(new Date());
					wzFormApproval.setPurchaserMajorOp6("");
					wzFormApproval.setPurchaserMajorOpTime6(null);
				}else{
					wzFormApproval.setPurchaserDemandOp(opinion + "  " + name);
					wzFormApproval.setPurchaserDemandOp4(opinion + "  " + name);
					wzFormApproval.setPurchaserDemandOpTime(new Date());
					wzFormApproval.setPurchaserDemandOpTime4(new Date());
					wzFormApproval.setPurchaserMajorOp("");
					wzFormApproval.setPurchaserMajorOp4("");
					wzFormApproval.setPurchaserMajorOpTime(null);
					wzFormApproval.setPurchaserMajorOpTime4(null);
				}
			}
		}
		if("4".equals(wzFormApproval.getFlag())){
			if("3".equals(wzFormApproval.getFormType()) || "5".equals(wzFormApproval.getFormType()) || "6".equals(wzFormApproval.getFormType()) || "7".equals(wzFormApproval.getFormType())){
				wzFormApproval.setPurchaserMajorOp(opinion + "  " + name);
				wzFormApproval.setPurchaserMajorOpTime(new Date());
			}else if("2".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget5()) >= 20){
					wzFormApproval.setPurchaserMajorOp5(opinion + "  " + name);
					wzFormApproval.setPurchaserMajorOpTime5(new Date());
				}else{
					wzFormApproval.setPurchaserMajorOp(opinion + "  " + name);
					wzFormApproval.setPurchaserMajorOp3(opinion + "  " + name);
					wzFormApproval.setPurchaserMajorOpTime(new Date());
					wzFormApproval.setPurchaserMajorOpTime3(new Date());
				}
			}else if("4".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget6()) >= 20){
					wzFormApproval.setPurchaserMajorOp6(opinion + "  " + name);
					wzFormApproval.setPurchaserMajorOpTime6(new Date());
				}else{
					wzFormApproval.setPurchaserMajorOp(opinion + "  " + name);
					wzFormApproval.setPurchaserMajorOp4(opinion + "  " + name);
					wzFormApproval.setPurchaserMajorOpTime(new Date());
					wzFormApproval.setPurchaserMajorOpTime4(new Date());
				}
			}
		}
		if("5".equals(wzFormApproval.getFlag())){
			if("0".equals(wzFormApproval.getFormType()) || "1".equals(wzFormApproval.getFormType())){
				if("1".equals(wzFormApproval.getIszbsp())){
					wzFormApproval.setPurchaseOp2(opinion + "  " + name);
					wzFormApproval.setPurchaseOpTime2(new Date());
				}else{
					wzFormApproval.setPurchaseOp8(opinion + "  " + name);
					wzFormApproval.setPurchaseOpTime8(new Date());
				}
			}else if("3".equals(wzFormApproval.getFormType()) || "5".equals(wzFormApproval.getFormType()) || "6".equals(wzFormApproval.getFormType()) || "7".equals(wzFormApproval.getFormType())){
				wzFormApproval.setPurchaserPurchaseOp(opinion + "  " + name);
				wzFormApproval.setPurchaserPurchaseOpTime(new Date());
			}else if("2".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget5()) >= 20){
					wzFormApproval.setPurchaserPurchaseOp5(opinion + "  " + name);
					wzFormApproval.setPurchaserPurchaseOpTime5(new Date());
				}else{
					wzFormApproval.setPurchaserPurchaseOp(opinion + "  " + name);
					wzFormApproval.setPurchaserPurchaseOp3(opinion + "  " + name);
					wzFormApproval.setPurchaserPurchaseOpTime(new Date());
					wzFormApproval.setPurchaserPurchaseOpTime3(new Date());
				}
			}else if("4".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget6()) >= 20){
					wzFormApproval.setPurchaserPurchaseOp6(opinion + "  " + name);
					wzFormApproval.setPurchaserPurchaseOpTime6(new Date());
				}else{
					wzFormApproval.setPurchaserPurchaseOp(opinion + "  " + name);
					wzFormApproval.setPurchaserPurchaseOp4(opinion + "  " + name);
					wzFormApproval.setPurchaserPurchaseOpTime(new Date());
					wzFormApproval.setPurchaserPurchaseOpTime4(new Date());
				}
			}
		}
		//需求部门分管领导
		if("6".equals(wzFormApproval.getFlag())){
			if("0".equals(wzFormApproval.getFormType()) || "1".equals(wzFormApproval.getFormType())){
				if("1".equals(wzFormApproval.getIszbsp())){
					wzFormApproval.setPurchaserMajorOp2(opinion + "  " + name);
					wzFormApproval.setPurchaserMajorOpTime2(new Date());
				}else{
					if(Double.parseDouble(wzFormApproval.getProjectBudget8()) < 1000){
						wzFormApproval.setPurchaserMajorOp8(opinion + "  " + name);
						wzFormApproval.setPurchaserMajorOpTime8(new Date());
					}
				}
			}else if("3".equals(wzFormApproval.getFormType()) || "5".equals(wzFormApproval.getFormType()) || "6".equals(wzFormApproval.getFormType()) || "7".equals(wzFormApproval.getFormType())){
				wzFormApproval.setPurchaserLeaderOp(opinion + "  " + name);
				wzFormApproval.setPurchaserLeaderOpTime(new Date());
			}else if("2".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget5()) >= 20){
					wzFormApproval.setPurchaserLeaderOp5(opinion + "  " + name);
					wzFormApproval.setPurchaserLeaderOpTime5(new Date());
				}else{
					wzFormApproval.setPurchaserLeaderOp(opinion + "  " + name);
					wzFormApproval.setPurchaserLeaderOp3(opinion + "  " + name);
					wzFormApproval.setPurchaserLeaderOpTime(new Date());
					wzFormApproval.setPurchaserLeaderOpTime3(new Date());
				}
			}else if("4".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget6()) >= 20){
					wzFormApproval.setPurchaserLeaderOp6(opinion + "  " + name);
					wzFormApproval.setPurchaserLeaderOpTime6(new Date());
				}else{
					wzFormApproval.setPurchaserLeaderOp(opinion + "  " + name);
					wzFormApproval.setPurchaserLeaderOp4(opinion + "  " + name);
					wzFormApproval.setPurchaserLeaderOpTime(new Date());
					wzFormApproval.setPurchaserLeaderOpTime4(new Date());
				}
			}
		}
		//主要领导意见
		if("7".equals(wzFormApproval.getFlag())) {
			if ("2".equals(wzFormApproval.getFormType())) {
				if (Double.parseDouble(wzFormApproval.getProjectBudget5()) >= 20) {
					wzFormApproval.setPurchaserMainOp5(opinion + "  " + name);
					wzFormApproval.setPurchaserMainOpTime5(new Date());
				} else {
					wzFormApproval.setPurchaserMainOp3(opinion + "  " + name);
					wzFormApproval.setPurchaserMainOpTime3(new Date());
				}
			} else if ("4".equals(wzFormApproval.getFormType())) {
				if (Double.parseDouble(wzFormApproval.getProjectBudget6()) >= 20) {
					wzFormApproval.setPurchaserMainOp6(opinion + "  " + name);
					wzFormApproval.setPurchaserMainOpTime6(new Date());
				} else {
					wzFormApproval.setPurchaserMainOp4(opinion + "  " + name);
					wzFormApproval.setPurchaserMainOpTime4(new Date());
				}
			} else if ("0".equals(wzFormApproval.getFormType()) || "1".equals(wzFormApproval.getFormType())) {
				if (Double.parseDouble(wzFormApproval.getProjectBudget8()) >= 1000) {
					wzFormApproval.setPurchaserMajorOp8(opinion + "  " + name);
					wzFormApproval.setPurchaserMajorOpTime8(new Date());
				}

			}
		}
		//江苏公司专业归口部门意见
		if("8".equals(wzFormApproval.getFlag())){
			if("0".equals(wzFormApproval.getFormType()) || "1".equals(wzFormApproval.getFormType())){
				wzFormApproval.setFinalDemandOp2(opinion + "  " + name);
				wzFormApproval.setFinalDemandOpTime2(new Date());
				if("0".equals(wzFormApproval.getClassification())){
					if("1".equals(wzFormApproval.getIszbsp())){
						wzFormApproval.setFinalDemandLeaderOp2(opinion + "  " +  wzFormApproval.getZygkCharge());
						wzFormApproval.setFinalDemandLeaderOpTime2(new Date());
					}/*else{
						wzFormApproval.setFinalDemandLeaderOp8(opinion + "  " +  wzFormApproval.getZygkCharge());
						if("".equals(wzFormApproval.getFinalDemandLeaderOpTime8()) || wzFormApproval.getFinalDemandLeaderOpTime8() == null){
							wzFormApproval.setFinalDemandLeaderOpTime8(new Date());
						}
					}*/
				}
			}else if("3".equals(wzFormApproval.getFormType()) || "5".equals(wzFormApproval.getFormType()) || "6".equals(wzFormApproval.getFormType()) || "7".equals(wzFormApproval.getFormType())){
				wzFormApproval.setJsMajorOp(opinion + "  " + name);
				wzFormApproval.setJsMajorOpTime(new Date());
				if("0".equals(wzFormApproval.getClassification())){
					wzFormApproval.setJsMajorLeaderOp(opinion + "  " +  wzFormApproval.getZygkCharge());
					wzFormApproval.setJsMajorLeaderOpTime(new Date());
				}
			}else if("2".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget5()) >= 20){
					wzFormApproval.setJsMajorOp5(opinion + "  " + name);
					wzFormApproval.setJsMajorOpTime5(new Date());
					if("0".equals(wzFormApproval.getClassification())){
						wzFormApproval.setJsMajorLeaderOp5(opinion + "  " +  wzFormApproval.getZygkCharge());
						wzFormApproval.setJsMajorLeaderOpTime5(new Date());
					}
				}else{
					//wzFormApproval.setJsMajorOp(opinion + "  " + name);
					wzFormApproval.setJsMajorOp3(opinion + "  " + name);
					/*if("".equals(wzFormApproval.getJsMajorOpTime()) || wzFormApproval.getJsMajorOpTime() == null){
						wzFormApproval.setJsMajorOpTime(new Date());
					}*/
					wzFormApproval.setJsMajorOpTime3(new Date());
					if("0".equals(wzFormApproval.getClassification())){
						//wzFormApproval.setJsMajorLeaderOp("同意  " +  wzFormApproval.getZygkCharge());
						wzFormApproval.setJsMajorLeaderOp3(opinion + "  " +  wzFormApproval.getZygkCharge());
					/*	if("".equals(wzFormApproval.getJsMajorLeaderOpTime()) || wzFormApproval.getJsMajorLeaderOpTime() == null){
							wzFormApproval.setJsMajorLeaderOpTime(new Date());
						}*/
						wzFormApproval.setJsMajorLeaderOpTime3(new Date());
					}
				}
			}else if("4".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget6()) >= 20){
					wzFormApproval.setJsMajorOp6(opinion + " " + name);
					wzFormApproval.setJsMajorOpTime6(new Date());
					if("0".equals(wzFormApproval.getClassification())){
						wzFormApproval.setJsMajorLeaderOp6(opinion + "  " +  wzFormApproval.getZygkCharge());
						wzFormApproval.setJsMajorLeaderOpTime6(new Date());
					}
				}else{
					//wzFormApproval.setJsMajorOp(opinion + "  " + name);
					wzFormApproval.setJsMajorOp4(opinion + "  " + name);
					/*if("".equals(wzFormApproval.getJsMajorOpTime()) || wzFormApproval.getJsMajorOpTime() == null){
						wzFormApproval.setJsMajorOpTime(new Date());
					}*/
					wzFormApproval.setJsMajorOpTime4(new Date());
					if("0".equals(wzFormApproval.getClassification())){
						wzFormApproval.setJsMajorLeaderOp4(opinion + "  " +  wzFormApproval.getZygkCharge());
						wzFormApproval.setJsMajorLeaderOpTime4(new Date());
					}
				}
			}
		}
		//江苏公司专业归口部门负责人意见
		if("9".equals(wzFormApproval.getFlag())){
			if("0".equals(wzFormApproval.getFormType()) || "1".equals(wzFormApproval.getFormType())){
				if("1".equals(wzFormApproval.getIszbsp())){
					wzFormApproval.setFinalDemandLeaderOp2(opinion + "  " + name);
					wzFormApproval.setFinalDemandLeaderOpTime2(new Date());
				}else{
					wzFormApproval.setFinalDemandLeaderOp8(opinion + "  " + name);
					wzFormApproval.setFinalDemandLeaderOpTime8(new Date());
				}
			}else if("3".equals(wzFormApproval.getFormType()) || "5".equals(wzFormApproval.getFormType()) || "6".equals(wzFormApproval.getFormType()) || "7".equals(wzFormApproval.getFormType())){
				wzFormApproval.setJsMajorLeaderOp(opinion + "  " + name);
				wzFormApproval.setJsMajorLeaderOpTime(new Date());
			}else if("2".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget5()) >= 20){
					wzFormApproval.setJsMajorLeaderOp5(opinion + "  " + name);
					wzFormApproval.setJsMajorLeaderOpTime5(new Date());
				}else{
					//wzFormApproval.setJsMajorLeaderOp(opinion + "  " + name);
					wzFormApproval.setJsMajorLeaderOp3(opinion + "  " + name);
					/*if("".equals(wzFormApproval.getJsMajorLeaderOpTime()) || wzFormApproval.getJsMajorLeaderOpTime() == null){
						wzFormApproval.setJsMajorLeaderOpTime(new Date());
					}*/
					wzFormApproval.setJsMajorLeaderOpTime3(new Date());
				}
			}else if("4".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget6()) >= 20){
					wzFormApproval.setJsMajorLeaderOp6(opinion + "  " + name);
					wzFormApproval.setJsMajorLeaderOpTime6(new Date());
				}else{
					//wzFormApproval.setJsMajorLeaderOp(opinion + "  " + name);
					wzFormApproval.setJsMajorLeaderOp4(opinion + "  " + name);/*
					if("".equals(wzFormApproval.getJsMajorLeaderOpTime()) || wzFormApproval.getJsMajorLeaderOpTime() == null){
						wzFormApproval.setJsMajorLeaderOpTime(new Date());
					}*/
					wzFormApproval.setJsMajorLeaderOpTime4(new Date());
				}
			}
		}
		//江苏公司采购部门意见
		if("10".equals(wzFormApproval.getFlag())){
			wzFormApproval.setApprovalEndTime(new Date());
			if("0".equals(wzFormApproval.getFormType()) || "1".equals(wzFormApproval.getFormType())){
				wzFormApproval.setFinalPurchaseOp2(opinion + "  " + name);
				wzFormApproval.setFinalPurchaseOpTime2(new Date());
				if("0".equals(wzFormApproval.getClassification())){
					if("1".equals(wzFormApproval.getIszbsp())){
						wzFormApproval.setFinalPurchaseLeaderOp2(opinion + "  " + wzFormApproval.getCgglCharge());
						wzFormApproval.setFinalPurchaseLeaderOpTime2(new Date());
					}/*else{
						wzFormApproval.setFinalPurchaseLeaderOp8(opinion + "  " + wzFormApproval.getCgglCharge());
						if("".equals(wzFormApproval.getFinalPurchaseLeaderOpTime8()) || wzFormApproval.getFinalPurchaseLeaderOpTime8() == null){
							wzFormApproval.setFinalPurchaseLeaderOpTime8(new Date());
						}
					}*/
				}
			}else if("3".equals(wzFormApproval.getFormType()) || "5".equals(wzFormApproval.getFormType()) || "6".equals(wzFormApproval.getFormType()) || "7".equals(wzFormApproval.getFormType())){
				wzFormApproval.setJsPurchaseOp(opinion + "  " + name);
				wzFormApproval.setJsPurchaseOpTime(new Date());
				if("0".equals(wzFormApproval.getClassification())){
					wzFormApproval.setJsPurchaseLeaderOp(opinion + "  " + wzFormApproval.getCgglCharge());
					wzFormApproval.setJsPurchaseLeaderOpTime(new Date());
				}
			}else if("2".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget5()) >= 20){
					wzFormApproval.setJsPurchaseOp5(opinion + "  " + name);
					wzFormApproval.setJsPurchaseOpTime5(new Date());
					if("0".equals(wzFormApproval.getClassification())){
						wzFormApproval.setJsPurchaseLeaderOp5(opinion + "  " + wzFormApproval.getCgglCharge());
						wzFormApproval.setJsPurchaseLeaderOpTime5(new Date());
					}
				}else{
					//wzFormApproval.setJsPurchaseOp(opinion + "  " + name);
					wzFormApproval.setJsPurchaseOp3(opinion + "  " + name);
					/*if("".equals(wzFormApproval.getJsPurchaseOpTime()) || wzFormApproval.getJsPurchaseOpTime() == null){
						wzFormApproval.setJsPurchaseOpTime(new Date());
					}*/
					wzFormApproval.setJsPurchaseOpTime3(new Date());
					if("0".equals(wzFormApproval.getClassification())){
						//wzFormApproval.setJsPurchaseLeaderOp("同意  " + wzFormApproval.getCgglCharge());
						wzFormApproval.setJsPurchaseLeaderOp3(opinion + "  " + wzFormApproval.getCgglCharge());
						/*if("".equals(wzFormApproval.getJsPurchaseLeaderOpTime()) || wzFormApproval.getJsPurchaseLeaderOpTime() == null){
							wzFormApproval.setJsPurchaseLeaderOpTime(new Date());
						}*/
						wzFormApproval.setJsPurchaseLeaderOpTime3(new Date());
					}
				}
			}else if("4".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget6()) >= 20){
					wzFormApproval.setJsPurchaseOp6(opinion + "  " + name);
					wzFormApproval.setJsPurchaseOpTime6(new Date());
					if("0".equals(wzFormApproval.getClassification())){
						wzFormApproval.setJsPurchaseLeaderOp6(opinion + "  " + wzFormApproval.getCgglCharge());
						wzFormApproval.setJsPurchaseLeaderOpTime6(new Date());
					}
				}else{
					//wzFormApproval.setJsPurchaseOp(opinion + "  " + name);
					wzFormApproval.setJsPurchaseOp4(opinion + "  " + name);
					/*if("".equals(wzFormApproval.getJsPurchaseOpTime()) || wzFormApproval.getJsPurchaseOpTime() == null){
						wzFormApproval.setJsPurchaseOpTime(new Date());
					}*/
					wzFormApproval.setJsPurchaseOpTime4(new Date());
					if("0".equals(wzFormApproval.getClassification())){
						//wzFormApproval.setJsPurchaseLeaderOp("同意  " + wzFormApproval.getCgglCharge());
						wzFormApproval.setJsPurchaseLeaderOp4(opinion + "  " + wzFormApproval.getCgglCharge());
						/*if("".equals(wzFormApproval.getJsPurchaseLeaderOpTime()) || wzFormApproval.getJsPurchaseLeaderOpTime() == null){
							wzFormApproval.setJsPurchaseLeaderOpTime(new Date());
						}*/
						wzFormApproval.setJsPurchaseLeaderOpTime4(new Date());
					}
				}
			}
		}
		//江苏公司采购部门负责人意见
		if("11".equals(wzFormApproval.getFlag())){
			if("0".equals(wzFormApproval.getFormType()) || "1".equals(wzFormApproval.getFormType())){
				if("1".equals(wzFormApproval.getIszbsp())){
					wzFormApproval.setFinalPurchaseLeaderOp2(opinion + "  " + name);
					wzFormApproval.setFinalPurchaseLeaderOpTime2(new Date());
				}else{
					wzFormApproval.setFinalPurchaseLeaderOp8(opinion + "  " + name);
					wzFormApproval.setFinalPurchaseLeaderOpTime8(new Date());
				}
			}else if("3".equals(wzFormApproval.getFormType()) || "5".equals(wzFormApproval.getFormType()) || "6".equals(wzFormApproval.getFormType()) || "7".equals(wzFormApproval.getFormType())){
				wzFormApproval.setJsPurchaseLeaderOp(opinion + "  " + name);
				wzFormApproval.setJsPurchaseLeaderOpTime(new Date());
			}else if("2".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget5()) >= 20){
					wzFormApproval.setJsPurchaseLeaderOp5(opinion + "  " + name);
					wzFormApproval.setJsPurchaseLeaderOpTime5(new Date());
				}else{
					//wzFormApproval.setJsPurchaseLeaderOp(opinion + "  " + name);
					wzFormApproval.setJsPurchaseLeaderOp3(opinion + "  " + name);/*
					if("".equals(wzFormApproval.getJsPurchaseLeaderOpTime()) || wzFormApproval.getJsPurchaseLeaderOpTime() == null){
						wzFormApproval.setJsPurchaseLeaderOpTime(new Date());
					}*/
					wzFormApproval.setJsPurchaseLeaderOpTime3(new Date());
				}
			}else if("4".equals(wzFormApproval.getFormType())){
				if(Double.parseDouble(wzFormApproval.getProjectBudget6()) >= 20){
					wzFormApproval.setJsPurchaseLeaderOp6(opinion + "  " + name);
					wzFormApproval.setJsPurchaseLeaderOpTime6(new Date());
				}else{
					//wzFormApproval.setJsPurchaseLeaderOp(opinion + "  " + name);
					wzFormApproval.setJsPurchaseLeaderOp4(opinion + "  " + name);
					/*if("".equals(wzFormApproval.getJsPurchaseLeaderOpTime()) || wzFormApproval.getJsPurchaseLeaderOpTime() == null){
						wzFormApproval.setJsPurchaseLeaderOpTime(new Date());
					}*/
					wzFormApproval.setJsPurchaseLeaderOpTime4(new Date());
				}
			}
		}
		//分管领导
		if("13".equals(wzFormApproval.getFlag())){
			if("0".equals(wzFormApproval.getFormType()) || "1".equals(wzFormApproval.getFormType())){
				wzFormApproval.setJsPurchaserLeaderOp8(opinion + "  " + name);
				wzFormApproval.setJsPurchaserLeaderOpTime8(new Date());
			}
		}
		this.saveOrUpdate(wzFormApproval);
	}
}




