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
				source = "?????????-??????";
			}
			if ("1".equals(source2)){
				source = "?????????-??????";
			}
			if ("2".equals(source2)){
				source = "?????????-??????";
			}
			if ("3".equals(source2)){
				source = "?????????-??????";
			}
			if ("4".equals(source2)){
				source = "?????????-??????";
			}
			if ("5".equals(source2)){
				source = "?????????-????????????";
			}
			if ("6".equals(source2)){
				source = "?????????-????????????";
			}
		}
		if("1".equals(source1)){
			if ("0".equals(source2)){
				source = "?????????????????????-??????";
			}
			if ("1".equals(source2)){
				source = "?????????????????????-??????";
			}
			if ("2".equals(source2)){
				source = "?????????????????????-????????????";
			}
			if ("3".equals(source2)){
				source = "?????????????????????-????????????";
			}
		}

		if("2".equals(source1)){
			if ("0".equals(source2)){
				source = "??????-????????????";
			}
			if ("1".equals(source2)){
				source = "??????-????????????";
			}
			if ("2".equals(source2)){
				source = "??????-??????????????????";
			}
			if ("3".equals(source2)){
				source = "??????-????????????";
			}
			if ("4".equals(source2)){
				source = "??????-????????????";
			}
		}

		if("3".equals(source1)){
			if ("0".equals(source2)){
				source = "?????????-????????????";
			}
			if ("1".equals(source2)){
				source = "?????????-????????????";
			}
			if ("2".equals(source2)){
				source = "?????????-????????????";
			}
			if ("3".equals(source2)){
				source = "?????????-????????????";
			}
		}

		if("4".equals(source1)){
			if ("0".equals(source2)){
				source = "?????????-A?????????";
				if("0".equals(source4)){
					source = "?????????-A?????????-????????????";
				}
				if("1".equals(source4)){
					source = "?????????-A?????????-????????????";
				}
				if("2".equals(source4)){
					source = "?????????-A?????????-???????????????";
				}
			}
			if ("1".equals(source2)){
				source = "?????????-B?????????";
				if("0".equals(source4)){
					source = "?????????-B?????????-????????????";
				}
				if("1".equals(source4)){
					source = "?????????-B?????????-????????????";
				}
				if("2".equals(source4)){
					source = "?????????-B?????????-???????????????";
				}
			}
			if ("2".equals(source2)){
				source = "?????????-C?????????";
				if("0".equals(source4)){
					source = "?????????-C?????????-????????????";
				}
				if("1".equals(source4)){
					source = "?????????-C?????????-????????????";
				}
				if("2".equals(source4)){
					source = "?????????-C?????????-???????????????";
				}
			}
			if ("3".equals(source2)){
				source = "?????????-????????????";
			}
			if ("4".equals(source2)){
				source = "?????????-??????????????????";
			}
			if ("5".equals(source2)){
				source = "?????????-????????????";
			}
			if ("6".equals(source2)){
				source = "?????????-????????????";
			}
			if ("7".equals(source2)){
				source = "?????????-???????????????";
			}
			if ("8".equals(source2)){
				source = "?????????-????????????";
			}
			if ("9".equals(source2)){
				source = "?????????-????????????";
			}
			if ("10".equals(source2)){
				source = "?????????-????????????";
			}
			if ("11".equals(source2)){
				source = "?????????-????????????";
				if("0".equals(source4)){
					source = "?????????-????????????-??????????????????";
				}
				if("1".equals(source4)){
					source = "?????????-????????????-????????????";
				}
			}
			if ("12".equals(source2)){
				source = "?????????-??????????????????";
			}
		}
		if("5".equals(source1)){
			if ("0".equals(source2)){
				source = "???????????????-???????????????";
			}
			if ("1".equals(source2)){
				source = "???????????????-???????????????";
			}
			if ("2".equals(source2)){
				source = "???????????????-??????????????????";
			}
			if ("3".equals(source2)){
				source = "???????????????-????????????";
			}
			if ("4".equals(source2)){
				source = "???????????????-????????????";
			}
		}

		if("6".equals(source1)){
			if ("0".equals(source2)){
				source = "????????????-????????????";
			}
			if ("1".equals(source2)){
				source = "????????????-???????????????";
			}
			if ("2".equals(source2)){
				source = "????????????-???????????????";
			}
			if ("3".equals(source2)){
				source = "????????????-???????????????";
			}
			if ("4".equals(source2)){
				source = "????????????-????????????";
			}
			if ("5".equals(source2)){
				source = "????????????-??????????????????";
			}
			if ("6".equals(source2)){
				source = "????????????-??????????????????";
			}
			if ("7".equals(source2)){
				source = "????????????-????????????";
			}
			if ("8".equals(source2)){
				source = "????????????-????????????";
			}
			if ("9".equals(source2)){
				source = "????????????-???????????????";
			}

		}
		if("7".equals(source1)){
			if ("0".equals(source2)){
				source = "???????????????-???????????????";
			}
			if ("1".equals(source2)){
				source = "???????????????-?????????????????????";
			}
			if ("2".equals(source2)){
				source = "???????????????-???????????????";
			}
			if ("3".equals(source2)){
				source = "???????????????-???????????????";
			}
			if ("4".equals(source2)){
				source = "???????????????-??????????????????";
			}
			if ("5".equals(source2)){
				source = "???????????????-??????????????????";
			}
			if ("6".equals(source2)){
				source = "???????????????-??????????????????";
			}
			if ("7".equals(source2)){
				source = "???????????????-???????????????";
			}
			if ("8".equals(source2)){
				source = "???????????????-??????????????????";
			}
			if ("9".equals(source2)){
				source = "???????????????-???????????????";
			}
			if ("10".equals(source2)){
				source = "???????????????-??????????????????";
			}
			if ("11".equals(source2)){
				source = "???????????????-????????????????????????????????????";
			}
			if ("12".equals(source2)){
				source = "???????????????-????????????";
			}

		}
		if("8".equals(source1)){
			if ("0".equals(source2)){
				source = "???????????????-???????????????";
			}
			if ("1".equals(source2)){
				source = "???????????????-???????????????";
			}
			if ("2".equals(source2)){
				source = "???????????????-???????????????";
			}
			if ("3".equals(source2)){
				source = "???????????????-???????????????";
			}
			if ("4".equals(source2)){
				source = "???????????????-?????????????????????";
			}
			if ("5".equals(source2)){
				source = "???????????????-??????????????????";
			}
		}

		if("9".equals(source1)){
			if ("0".equals(source2)){
				source = "????????????-???????????????";
			}
			if ("1".equals(source2)){
				source = "????????????-??????????????????";
			}
			if ("2".equals(source2)){
				source = "????????????-?????????????????????";
			}
			if ("3".equals(source2)){
				source = "????????????-?????????";
			}
			if ("4".equals(source2)){
				source = "????????????-?????????";
			}
			if ("5".equals(source2)){
				source = "????????????-?????????";
			}
			if ("6".equals(source2)){
				source = "????????????-?????????";
			}
			if ("7".equals(source2)){
				source = "????????????-??????????????????";
			}
			if ("8".equals(source2)){
				source = "????????????-?????????????????????";
			}
			if ("9".equals(source2)){
				source = "????????????-????????????";
			}
			if ("10".equals(source2)){
				source = "????????????-?????????";
			}
			if ("11".equals(source2)){
				source = "????????????-?????????";
			}
			if ("12".equals(source2)){
				source = "????????????-??????";
			}
			if ("13".equals(source2)){
				source = "????????????-??????";
			}
			if ("14".equals(source2)){
				source = "????????????-?????????";
			}
			if ("15".equals(source2)){
				source = "????????????-?????????";
			}
			if ("16".equals(source2)){
				source = "????????????-???????????????";
			}
			if ("17".equals(source2)){
				source = "????????????-?????????";
			}
			if ("18".equals(source2)){
				source = "????????????-?????????";
			}
			if ("19".equals(source2)){
				source = "????????????-?????????";
			}
			if ("20".equals(source2)){
				source = "????????????-?????????";
			}
			if ("21".equals(source2)){
				source = "????????????-?????????????????????";
			}
			if ("22".equals(source2)){
				source = "????????????-???????????????????????????????????????";
			}
			if ("23".equals(source2)){
				source = "????????????-?????????????????????";
			}
			if ("24".equals(source2)){
				source = "????????????-?????????";
			}
			if ("25".equals(source2)){
				source = "????????????-???????????????";
			}
			if ("26".equals(source2)){
				source = "????????????-???????????????";
			}
			if ("27".equals(source2)){
				source = "????????????-????????????";
			}
			if ("28".equals(source2)){
				source = "????????????-??????????????????";
			}
			if ("29".equals(source2)){
				source = "????????????-???????????????";
			}
			if ("30".equals(source2)){
				source = "????????????-???????????????";
			}
			if ("31".equals(source2)){
				source = "????????????-???????????????";
			}
			if ("32".equals(source2)){
				source = "????????????-??????????????????";
			}
			if ("33".equals(source2)){
				source = "????????????-???????????????";
			}
			if ("34".equals(source2)){
				source = "????????????-??????-"+ source3;
			}
			if ("35".equals(source2)){
				source = "????????????-????????????";
			}
			if ("36".equals(source2)){
				source = "????????????-????????????";
			}
			if("37".equals(source2)){
				source = "????????????-?????????";
			}

		}
		if("10".equals(source1)){
			source = "???????????????  " + source3;
		}
		if("11".equals(source1)){
			source = "??????????????????  " + source3;
		}
		if("12".equals(source1)){
			source = "???????????????????????????  " + source3;
		}
		if("13".equals(source1)){
			source = "???????????????  " + source3;
		}
		if("14".equals(source1)){
			source = "?????????  " + source3;
		}
		if("15".equals(source1)){
			source = "?????????  " + source3;
		}
		if("16".equals(source1)){
			source = "?????????  " + source3;
		}
		if("17".equals(source1)){
			source = "?????????  " + source3;
		}
		if("18".equals(source1)){
			source = "???????????????  " + source3;
		}


		return source;
	}

	public String getGradingMethods(String method){
		 String method1 = "";
		 if ("0".equals(method)){
			 method1 = "?????????????????????????????????";
		 }
		if ("1".equals(method)){
			method1 = "????????????????????????K??????";
		}
		if ("2".equals(method)){
			method1 = "?????????????????????????????????????????????";
		}
		if("3".equals(method)){
			method1 = "??????????????????????????????????????????";
		}
		if("4".equals(method)){
			method1 = "????????????";
		}
		if("5".equals(method)){
			method1 = "???????????????";
		}
		if("6".equals(method)){
			method1 = "????????????";
		}
		if("7".equals(method)){
			method1 = "????????????";
		}
		 return method1;
	}

	/**
	 *?????????????????? formNumber
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
	 * ????????????
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
		wzFormApproval.setFormNumber(getCode());	//????????????
		wzFormApproval.setPlanNumber(wzPlan.getCode());	//????????????
		wzFormApproval.setFormType(wzPlan.getProcurementMethod());	//????????????
		wzFormApproval.setProjectName0(wzPlan.getProjectName());
		wzFormApproval.setClassification(wzPlan.getClassification());	//????????????
		wzFormApproval.setCategory(wzPlan.getCategory());	//????????????
		wzFormApproval.setPlate(wzPlan.getPlate());	//????????????
		wzFormApproval.setPlanWriter(wzPlan.getCreateByName());	//???????????????
		wzFormApproval.setPlanUnit(wzPlan.getDept());	//??????????????????
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		wzFormApproval.setPlanApproveTime(date);	//??????????????????
		wzFormApproval.setFlag("0");
		wzFormApproval.setFormStatus("0");
		wzFormApproval.setProjectBudget(wzPlan.getBudget());	//????????????\????????????
		wzFormApproval.setCreateCompany(wzPlan.getCreateCompany());//???????????????
		wzFormApproval.setReviewPlace2("??????????????????????????????????????????");;
		wzFormApproval.setZygkId(wzPlan.getApprovalDept()); //?????????????????????id
		if ("3".equals(wzPlan.getProcurementMethod()) || "6".equals(wzPlan.getProcurementMethod()) || "7".equals(wzPlan.getProcurementMethod()) || "5".equals(wzPlan.getProcurementMethod())){
			wzFormApproval.setProjectName(wzPlan.getProjectName());	//????????????\??????????????????
			wzFormApproval.setPlanWriter(wzPlan.getCreateByName());	//???????????????
			wzFormApproval.setPlanUnit(wzPlan.getDept());	//??????????????????
			wzFormApproval.setPlanApproveTime(date);	//??????????????????
			wzFormApproval.setPurchaser(wzPlan.getDept());	//?????????
			//wzFormApproval.setProjectBudget(wzPlan.getBudget());	//????????????\????????????
			//wzPlan.getMoneyResource()
			wzFormApproval.setCostSource(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//????????????
			wzFormApproval.setAffiliatedUnit("??????????????????????????????????????????");	//????????????
			wzFormApproval.setProcurementRange(wzPlan.getProjectDescribe());	//????????????
			wzFormApproval.setPerformance(wzPlan.getAchievement());	//??????????????????
			wzFormApproval.setPotentialInvestors(wzPlan.getSupplier());	//???????????????
			//reviewMethod wzPlan.getReviewMethod()

			String mothods = getGradingMethods(wzPlan.getReviewMethod());
			if("0".equals(wzPlan.getReviewMethod()) || "1".equals(wzPlan.getReviewMethod())){
				mothods = mothods + " " + wzPlan.getScoring();
			}
			wzFormApproval.setGradingMethods(mothods);	//????????????
			//wzFormApproval.setReviewTime(new Date());	//????????????
			wzFormApproval.setQualifications(wzPlan.getAchievement());	// ????????????
			wzFormApproval.setPurchaseReason(wzPlan.getProcurementBasis());	//????????????????????????
			wzFormApproval.setSupplier(wzPlan.getSupplier());	//??????????????????????????????
			wzFormApproval.setSelectReason(wzPlan.getReason());	//????????????

		}
		if ("0".equals(wzPlan.getProcurementMethod()) || "1".equals(wzPlan.getProcurementMethod())){
		/*	//wzFormApproval.setReviewnTime2(new Date());	//????????????
			wzFormApproval.setProjectName2(wzPlan.getProjectName());
			wzFormApproval.setProjectBudget2(wzPlan.getBudget());//????????????\????????????
			wzFormApproval.setPurchaser2(wzPlan.getDept());	//?????????
			wzFormApproval.setAffiliatedUnit2("??????????????????????????????????????????");	//????????????
			wzFormApproval.setProcurementRange2(wzPlan.getProjectDescribe());	//????????????
			wzFormApproval.setQualifications2(wzPlan.getAchievement());	// ????????????
			wzFormApproval.setPotentialInvestors2(wzPlan.getSupplier());	//???????????????
			wzFormApproval.setGradingMethods2(getGradingMethods(wzPlan.getReviewMethod()));	//????????????
			//wzFormApproval.setParticipants2();*/
			wzFormApproval.setId(wzPlan.getId()); //id
			wzFormApproval.setProjectName8(wzPlan.getCreateCompanyName());//??????????????????
			wzFormApproval.setProjectBname8(wzPlan.getProjectName());	//????????????
			wzFormApproval.setProjectDeptName8(wzPlan.getCreateDeptName());	//????????????
			wzFormApproval.setSonCompany8("????????????????????????????????????");	//????????????
			wzFormApproval.setPlate8(wzPlan.getPlate());	//????????????
			wzFormApproval.setPlanNumber8(wzPlan.getCode());		//????????????
			wzFormApproval.setStage8(wzPlan.getStage());		//????????????
			wzFormApproval.setProjectBcategory8(wzPlan.getCategory());	//???????????????
			wzFormApproval.setProjectBudget8(wzPlan.getBudget());	//???????????????
			wzFormApproval.setProcumentMethod8(wzPlan.getProcurementMethod());	//????????????
			wzFormApproval.setJurisdiction8(wzPlan.getJurisdiction());	//??????????????????
			wzFormApproval.setMoneyResource8(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//???????????????????????????
			wzFormApproval.setProjectDescribe8(wzPlan.getProjectDescribe());	//????????????
			wzFormApproval.setWorkload8(wzPlan.getWorkload());		//?????????
			wzFormApproval.setDuration8(wzPlan.getDuration());		//??????
			wzFormApproval.setPeopleSituation8(wzPlan.getPeopleSituation());	//????????????
			wzFormApproval.setIszbsp("0");		//?????????????????????
		}
		if ("2".equals(wzPlan.getProcurementMethod())){
			double budget = Double.parseDouble(wzPlan.getBudget());
			wzFormApproval.setProjectBudget5(wzPlan.getBudget());
			if (budget < 20){
				wzFormApproval.setProjectName(wzPlan.getProjectName());	//????????????\??????????????????
				wzFormApproval.setPlanWriter(wzPlan.getCreateByName());	//???????????????
				wzFormApproval.setPlanUnit(wzPlan.getDept());	//??????????????????
				wzFormApproval.setPlanApproveTime(date);	//??????????????????
				wzFormApproval.setPurchaser(wzPlan.getDept());	//?????????
				wzFormApproval.setProjectBudget(wzPlan.getBudget());	//????????????\????????????
				wzFormApproval.setCostSource(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//????????????
				wzFormApproval.setAffiliatedUnit("??????????????????????????????????????????");	//????????????
				wzFormApproval.setProcurementRange(wzPlan.getProjectDescribe());	//????????????
				wzFormApproval.setPerformance(wzPlan.getAchievement());	//??????????????????
				wzFormApproval.setPotentialInvestors(wzPlan.getSupplier());	//???????????????
				String mothods = getGradingMethods(wzPlan.getReviewMethod());
				if("0".equals(wzPlan.getReviewMethod()) || "1".equals(wzPlan.getReviewMethod())){
					mothods = mothods + " " + wzPlan.getScoring();
				}
				wzFormApproval.setGradingMethods(mothods);	//????????????
				//wzFormApproval.setReviewTime(new Date());	//????????????
				wzFormApproval.setQualifications(wzPlan.getAchievement());	// ????????????
				wzFormApproval.setPurchaseReason(wzPlan.getProcurementBasis());	//????????????????????????
				wzFormApproval.setSupplier(wzPlan.getSupplier());	//??????????????????????????????
				wzFormApproval.setSelectReason(wzPlan.getReason());	//????????????



				wzFormApproval.setPurchaser3(wzPlan.getDept());	//?????????
				wzFormApproval.setProjectName3(wzPlan.getProjectName());
				wzFormApproval.setProjectBudget3(wzPlan.getBudget());//????????????\????????????
				wzFormApproval.setCostSource3(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//????????????
				wzFormApproval.setProcurementRange3(wzPlan.getProjectDescribe());	//????????????
				wzFormApproval.setQualifications3(wzPlan.getAchievement());	// ????????????
				wzFormApproval.setPerformance3(wzPlan.getAchievement());	//??????????????????
				//wzFormApproval.setCreditStanding3();//????????????
				wzFormApproval.setPurchaseReason3(wzPlan.getProcurementBasis());	//????????????????????????
				wzFormApproval.setSupplier3(wzPlan.getSupplier());	//??????????????????????????????
				wzFormApproval.setSelectReason3(wzPlan.getReason());	//????????????
			}else{
				wzFormApproval.setPurchaser5(wzPlan.getDept());	//?????????
				wzFormApproval.setProjectName5(wzPlan.getProjectName());
				//wzFormApproval.setReviewnTime5(new Date());	//??????????????????
				//wzFormApproval.setProjectBudget5(wzPlan.getBudget());//????????????\????????????
				wzFormApproval.setCostSource5(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//????????????
				wzFormApproval.setProcurementRange5(wzPlan.getProjectDescribe());	//????????????
				wzFormApproval.setQualifications5(wzPlan.getAchievement());	// ????????????
				wzFormApproval.setPerformance5(wzPlan.getAchievement());	//??????????????????
				String mothods = getGradingMethods(wzPlan.getReviewMethod());
				if("0".equals(wzPlan.getReviewMethod()) || "1".equals(wzPlan.getReviewMethod())){
					mothods = mothods + " " + wzPlan.getScoring();
				}
				wzFormApproval.setGradingMethods5(mothods);	//????????????
				wzFormApproval.setPurchaseReason5(wzPlan.getProcurementBasis());	//????????????????????????
				wzFormApproval.setSupplier5(wzPlan.getSupplier());	//??????????????????????????????
				wzFormApproval.setSelectReason5(wzPlan.getReason());	//????????????
			}


		}
		if ("4".equals(wzPlan.getProcurementMethod())){
			double budget1 = Double.parseDouble(wzPlan.getBudget());
			wzFormApproval.setProjectBudget6(wzPlan.getBudget());//????????????\????????????
			if (budget1 < 20){
				wzFormApproval.setProjectName(wzPlan.getProjectName());	//????????????\??????????????????
				wzFormApproval.setPlanWriter(wzPlan.getCreateByName());	//???????????????
				wzFormApproval.setPlanUnit(wzPlan.getDept());	//??????????????????
				wzFormApproval.setPlanApproveTime(date);	//??????????????????
				wzFormApproval.setPurchaser(wzPlan.getDept());	//?????????
				wzFormApproval.setProjectBudget(wzPlan.getBudget());	//????????????\????????????
				wzFormApproval.setCostSource(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//????????????
				wzFormApproval.setAffiliatedUnit("??????????????????????????????????????????");	//????????????
				wzFormApproval.setProcurementRange(wzPlan.getProjectDescribe());	//????????????
				wzFormApproval.setPerformance(wzPlan.getAchievement());	//??????????????????
				wzFormApproval.setPotentialInvestors(wzPlan.getSupplier());	//???????????????
				String mothods = getGradingMethods(wzPlan.getReviewMethod());
				if("0".equals(wzPlan.getReviewMethod()) || "1".equals(wzPlan.getReviewMethod())){
					mothods = mothods + " " + wzPlan.getScoring();
				}
				wzFormApproval.setGradingMethods(mothods);	//????????????
				//wzFormApproval.setReviewTime(new Date());	//????????????
				wzFormApproval.setQualifications(wzPlan.getAchievement());	// ????????????
				wzFormApproval.setPurchaseReason(wzPlan.getProcurementBasis());	//????????????????????????
				wzFormApproval.setSupplier(wzPlan.getSupplier());	//??????????????????????????????
				wzFormApproval.setSelectReason(wzPlan.getReason());	//????????????


				wzFormApproval.setPurchaser4(wzPlan.getDept());	//?????????
				wzFormApproval.setProjectName4(wzPlan.getProjectName());
				wzFormApproval.setProjectBudget4(wzPlan.getBudget());//????????????\????????????
				wzFormApproval.setCostSource4(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//????????????
				wzFormApproval.setProcurementRange4(wzPlan.getProjectDescribe());	//????????????
				wzFormApproval.setQualifications4(wzPlan.getAchievement());	// ????????????
				wzFormApproval.setPerformance4(wzPlan.getAchievement());	//??????????????????
				//wzFormApproval.setCreditStanding3();//????????????
				wzFormApproval.setPurchaseReason4(wzPlan.getProcurementBasis());	//????????????????????????
				wzFormApproval.setSupplier4(wzPlan.getSupplier());	//??????????????????????????????
				wzFormApproval.setSelectReason4(wzPlan.getReason());	//????????????
			}else{
				wzFormApproval.setPurchaser6(wzPlan.getDept());	//?????????
				wzFormApproval.setProjectName6(wzPlan.getProjectName());
				//wzFormApproval.setReviewnTime6(new Date());	//??????????????????
				//wzFormApproval.setProjectBudget6(wzPlan.getBudget());//????????????\????????????
				wzFormApproval.setCostSource6(getSource(wzPlan.getMoneyResource(),wzPlan.getDetailedMoney(),wzPlan.getOtherCost(),wzPlan.getThreeCost()));	//????????????
				wzFormApproval.setProcurementRange6(wzPlan.getProjectDescribe());	//????????????
				wzFormApproval.setQualifications6(wzPlan.getAchievement());	// ????????????
				wzFormApproval.setPerformance6(wzPlan.getAchievement());	//??????????????????
				String mothods = getGradingMethods(wzPlan.getReviewMethod());
				if("0".equals(wzPlan.getReviewMethod()) || "1".equals(wzPlan.getReviewMethod())){
					mothods = mothods + " " + wzPlan.getScoring();
				}
				wzFormApproval.setGradingMethods6(mothods);	//????????????
				wzFormApproval.setPurchaseReason6(wzPlan.getProcurementBasis());	//????????????????????????
				wzFormApproval.setSupplier6(wzPlan.getSupplier());	//??????????????????????????????
				wzFormApproval.setSelectReason6(wzPlan.getReason());	//????????????
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
				wz.setFormNumber(getCode());	//????????????
				wz.setPlanNumber(wzFormApproval.getPlanNumber());	//????????????
				wz.setFormType(wzFormApproval.getFormType());	//????????????
				wz.setProjectName0(wzFormApproval.getProjectName0());
				wz.setClassification(wzFormApproval.getClassification());	//????????????
				wz.setCategory(wzFormApproval.getCategory());	//????????????
				wz.setPlate(wzFormApproval.getPlate());	//????????????
				wz.setPlanWriter(wzFormApproval.getPlanWriter());	//???????????????
				wz.setPlanUnit(wzFormApproval.getPlanUnit());	//??????????????????
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = simpleDateFormat.format(new Date());
				wz.setPlanApproveTime(date);	//??????????????????
				wz.setFlag("0");
				wz.setFormStatus("0");
				wz.setProjectBudget(wzFormApproval.getProjectBudget());	//????????????\????????????
				wz.setCreateCompany(wzFormApproval.getCreateCompany());//???????????????
				wz.setReviewPlace2("??????????????????????????????????????????");;
				wz.setZygkId(wzFormApproval.getZygkId()); //?????????????????????id
				wz.setIszbsp("1");

				WzPlan wzPlan = wzPlanService.get(id);
				wz.setReviewnTime2(new Date());	//????????????
				wz.setProjectName2(wzPlan.getProjectName());
				wz.setProjectBudget2(wzPlan.getBudget());//????????????\????????????
				wz.setPurchaser2(wzPlan.getDept());	//?????????
				wz.setAffiliatedUnit2("??????????????????????????????????????????");	//????????????
				wz.setProcurementRange2(wzPlan.getProjectDescribe());	//????????????
				wz.setQualifications2(wzPlan.getAchievement());	// ????????????
				wz.setPotentialInvestors2(wzPlan.getSupplier());	//???????????????
				wz.setGradingMethods2(getGradingMethods(wzPlan.getReviewMethod()));	//????????????

				this.saveOrUpdate(wz);
			}
		}
	}

	//?????????????????????????????????????????????
	public void saveFromZb(String id){
		WzPlan wzPlan = wzPlanService.getById(id);
		WzFormApproval wzFormApproval = new WzFormApproval();
		wzFormApproval.setFormNumber(getCode());	//????????????
		wzFormApproval.setPlanNumber(wzPlan.getCode());	//????????????
		wzFormApproval.setFormType(wzPlan.getProcurementMethod());	//????????????
		wzFormApproval.setProjectName0(wzPlan.getProjectName());
		wzFormApproval.setClassification(wzPlan.getClassification());	//????????????
		wzFormApproval.setCategory(wzPlan.getCategory());	//????????????
		wzFormApproval.setPlate(wzPlan.getPlate());	//????????????
		wzFormApproval.setPlanWriter(wzPlan.getCreateByName());	//???????????????
		wzFormApproval.setPlanUnit(wzPlan.getDept());	//??????????????????
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		wzFormApproval.setPlanApproveTime(date);	//??????????????????
		wzFormApproval.setFlag("0");
		wzFormApproval.setFormStatus("0");
		wzFormApproval.setProjectBudget(wzPlan.getBudget());	//????????????\????????????
		wzFormApproval.setCreateCompany(wzPlan.getCreateCompany());//???????????????
		wzFormApproval.setReviewPlace2("??????????????????????????????????????????");;
		wzFormApproval.setZygkId(wzPlan.getApprovalDept()); //?????????????????????id

		wzFormApproval.setReviewnTime2(new Date());	//????????????
		wzFormApproval.setProjectName2(wzPlan.getProjectName());
		wzFormApproval.setProjectBudget2(wzPlan.getBudget());//????????????\????????????
		wzFormApproval.setPurchaser2(wzPlan.getDept());	//?????????
		wzFormApproval.setAffiliatedUnit2("??????????????????????????????????????????");	//????????????
		wzFormApproval.setProcurementRange2(wzPlan.getProjectDescribe());	//????????????
		wzFormApproval.setQualifications2(wzPlan.getAchievement());	// ????????????
		wzFormApproval.setPotentialInvestors2(wzPlan.getSupplier());	//???????????????
		wzFormApproval.setGradingMethods2(getGradingMethods(wzPlan.getReviewMethod()));	//????????????
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
//			String fileName = "??????1";
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
//			//??????????????????pdf??????
//			File file = new File(targetFile);
//			FileOutputStream os = new FileOutputStream(file);
//			//????????????DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF ????????????
//			doc.save(os, SaveFormat.PDF);
//			os.close();
//			long now = System.currentTimeMillis();
//			//????????????
//			System.out.println("????????????" + ((now - old) / 1000.0) + "???");
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
				dataMap.put("purchaserMajorOpTime","?????????" + returnDate(wzFormApproval.getPurchaserMajorOpTime()));
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

			wordPath = "template/????????????????????????.docx";
			fileName = fileName + "????????????????????????";
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
				wordPath = "template/????????????????????????.docx";
				fileName = fileName + "????????????????????????";
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
					plate8 = "??????";
				}else if("1".equals(wzFormApproval.getPlate8())){
					plate8 = "??????";
				}else if("2".equals(wzFormApproval.getPlate8())){
					plate8 = "?????????";
				}else if("3".equals(wzFormApproval.getPlate8())){
					plate8 = "??????";
				}else if("4".equals(wzFormApproval.getPlate8())){
					plate8 = "??????";
				}else if("5".equals(wzFormApproval.getPlate8())){
					plate8 = "????????????";
				}else if("6".equals(wzFormApproval.getPlate8())){
					plate8 = "??????";
				}else if("7".equals(wzFormApproval.getPlate8())){
					plate8 = "??????";
				}else if("8".equals(wzFormApproval.getPlate8())){
					plate8 = "??????";
				}else if("9".equals(wzFormApproval.getPlate8())){
					plate8 = "????????????";
				}else if("10".equals(wzFormApproval.getPlate8())){
					plate8 = "?????????";
				}else if("11".equals(wzFormApproval.getPlate8())){
					plate8 = "?????????????????????";
				}
				dataMap.put("plate8",plate8);
				dataMap.put("planNumber8",wzFormApproval.getPlanNumber8());
				String stage8 = "";
				switch (wzFormApproval.getStage8()){
					case "0":
						stage8 = "???????????????????????????";
						break;
					case "1":
						stage8 = "?????????????????????";
						break;
					case "2":
						stage8 = "?????????";
						break;
					case "3":
						stage8 = "????????????";
						break;
					case "4":
						stage8 = "????????????";
						break;
				}
				dataMap.put("stage8",stage8);
				String twoCategory8 = "";
				switch(wzFormApproval.getTwoCategory8()){
					case "0":
						twoCategory8 = "??????";
						break;
					case "1":
						twoCategory8 = "????????????";
						break;
					case "2":
						twoCategory8 = "????????????";
						break;
					case "3":
						twoCategory8 = "??????";
						break;
					case "4":
						twoCategory8 = "??????";
						break;
					case "5":
						twoCategory8 = "??????";
						break;
					case "6":
						twoCategory8 = "??????";
						break;
				}
				dataMap.put("twoCategory8",twoCategory8);
				String projectBcategory8 = "";
				switch (wzFormApproval.getProjectBcategory8()){
					case "0":
						projectBcategory8 = "??????";
						break;
					case "1":
						projectBcategory8 = "??????";
						break;
					case "2":
						projectBcategory8 = "??????";
						break;
				}
				dataMap.put("projectBcategory8",projectBcategory8);
				dataMap.put("projectBudget8",wzFormApproval.getProjectBudget8());
				String procumentMethod8 = "";
				switch(wzFormApproval.getProcumentMethod8()){
					case "0":
						procumentMethod8 = "????????????";
						break;
					case "1":
						procumentMethod8 = "????????????";
						break;
					case "2":
						procumentMethod8 = "????????????";
						break;
					case "3":
						procumentMethod8 = "?????????";
						break;
					case "4":
						procumentMethod8 = "???????????????";
						break;
					case "5":
						procumentMethod8 = "??????";
						break;
					case "6":
						procumentMethod8 = "????????????";
						break;
					case "7":
						procumentMethod8 = "????????????";
						break;
				}
				dataMap.put("procumentMethod8",procumentMethod8);
				String jurisdiction8 = "";
				switch(wzFormApproval.getJurisdiction8()){
					case "0":
						jurisdiction8 = "????????????";
						break;
					case "1":
						jurisdiction8 = "????????????";
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

				wordPath = "template/?????????????????????.docx";
				fileName = fileName + "?????????????????????";
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
					dataMap.put("purchaserMajorOpTime","?????????" + returnDate(wzFormApproval.getPurchaserMajorOpTime()));
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
				wordPath = "template/????????????????????????.docx";
				String fileName1 = fileName + "????????????????????????";
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
					dataMap1.put("purchaserMajorOpTime","?????????" + returnDate(wzFormApproval.getPurchaserMajorOpTime3()));
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
				wordPath = "template/???????????????????????????.docx";
				String fileName2 = fileName + "???????????????????????????";
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
				wordPath = "template/?????????????????????.docx";
				fileName = fileName + "?????????????????????";
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
					dataMap.put("purchaserMajorOpTime","?????????" + returnDate(wzFormApproval.getPurchaserMajorOpTime5()));
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
				wordPath = "template/????????????????????????.docx";
				String fileName1 = fileName + "????????????????????????";
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
					dataMap1.put("purchaserMajorOpTime","?????????" + returnDate(wzFormApproval.getPurchaserMajorOpTime5()));
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
				wordPath = "template/???????????????????????????.docx";
				String fileName2 = fileName + "???????????????????????????";
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
					dataMap.put("purchaserMajorOpTime","?????????" + returnDate(wzFormApproval.getPurchaserMajorOpTime()));
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
				wordPath = "template/????????????????????????.docx";
				String fileName1 = fileName + "????????????????????????";
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
					dataMap1.put("purchaserMajorOpTime", "?????????" + returnDate(wzFormApproval.getPurchaserMajorOpTime4()));
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
				wordPath = "template/??????????????????????????????.docx";
				String fileName2 = fileName + "??????????????????????????????";
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
				wordPath = "template/????????????????????????.docx";
				fileName = fileName + "????????????????????????";
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
					dataMap.put("purchaserMajorOpTime","?????????" + returnDate(wzFormApproval.getPurchaserMajorOpTime6()));
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
				wordPath = "template/????????????????????????.docx";
				String fileName1 = fileName + "????????????????????????";
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
					dataMap1.put("purchaserMajorOpTime","?????????" +  returnDate(wzFormApproval.getPurchaserMajorOpTime6()));
				}
				dataMap1.put("jsMajorOp", wzFormApproval.getJsMajorOp6());

				dataMap1.put("jsMajorOpTime", returnDate(wzFormApproval.getJsMajorOpTime6()));
				dataMap1.put("jsMajorLeaderOp", wzFormApproval.getJsMajorLeaderOp6());

				dataMap1.put("jsMajorLeaderOpTime", returnDate(wzFormApproval.getJsMajorLeaderOpTime6()));
				dataMap1.put("jsPurchaseOp", wzFormApproval.getJsPurchaseOp6());

				dataMap1.put("jsPurchaseOpTime", returnDate(wzFormApproval.getJsPurchaseOpTime6()));
				dataMap1.put("jsPurchaseLeaderOp", wzFormApproval.getJsPurchaseLeaderOp6());

				dataMap1.put("jsPurchaseLeaderOpTime", returnDate(wzFormApproval.getJsPurchaseLeaderOpTime6()));
				wordPath = "template/??????????????????????????????.docx";
				String fileName2 = fileName + "??????????????????????????????";
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
		//????????????????????????
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
		//??????????????????
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
		//????????????????????????????????????
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
						//wzFormApproval.setJsMajorLeaderOp("??????  " +  wzFormApproval.getZygkCharge());
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
		//?????????????????????????????????????????????
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
		//??????????????????????????????
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
						//wzFormApproval.setJsPurchaseLeaderOp("??????  " + wzFormApproval.getCgglCharge());
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
						//wzFormApproval.setJsPurchaseLeaderOp("??????  " + wzFormApproval.getCgglCharge());
						wzFormApproval.setJsPurchaseLeaderOp4(opinion + "  " + wzFormApproval.getCgglCharge());
						/*if("".equals(wzFormApproval.getJsPurchaseLeaderOpTime()) || wzFormApproval.getJsPurchaseLeaderOpTime() == null){
							wzFormApproval.setJsPurchaseLeaderOpTime(new Date());
						}*/
						wzFormApproval.setJsPurchaseLeaderOpTime4(new Date());
					}
				}
			}
		}
		//???????????????????????????????????????
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
		//????????????
		if("13".equals(wzFormApproval.getFlag())){
			if("0".equals(wzFormApproval.getFormType()) || "1".equals(wzFormApproval.getFormType())){
				wzFormApproval.setJsPurchaserLeaderOp8(opinion + "  " + name);
				wzFormApproval.setJsPurchaserLeaderOpTime8(new Date());
			}
		}
		this.saveOrUpdate(wzFormApproval);
	}
}




