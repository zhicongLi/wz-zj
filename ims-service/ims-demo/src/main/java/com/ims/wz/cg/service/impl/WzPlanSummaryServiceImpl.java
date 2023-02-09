/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ims.idms.modules.sys.vo.SysUserVO;
import com.ims.idms.modules.utils.UserUtils;
import com.ims.wz.cg.dao.WzPlanDao;
import com.ims.wz.cg.dao.WzTopicsDao;
import com.ims.wz.cg.entity.WzPlan;
import com.ims.wz.cg.entity.WzTopics;
import com.ims.wz.cg.service.IWzTopicsService;
import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzPlanSummaryService;

import com.ims.wz.cg.entity.WzPlanSummary;
import com.ims.wz.cg.dao.WzPlanSummaryDao;


/**
 * wz_plan_summaryService
 * @author lizhicong
 * @version 2021-09-18
 */
@Service
@Transactional(readOnly = true)
public class WzPlanSummaryServiceImpl extends CrudServiceImpl<WzPlanSummaryDao, WzPlanSummary> implements IWzPlanSummaryService{

	@Autowired
	private WzPlanSummaryDao wzPlanSummaryDao;
	@Autowired
	private WzPlanDao wzPlanDao;
	@Autowired
	private WzTopicsServiceImpl wzTopicsService;

 	public WzPlanSummary get(WzPlanSummary wzPlanSummary) {
		return super.get(wzPlanSummary);
	}

    public List<WzPlanSummary> findList(WzPlanSummary wzPlanSummary) {
        return super.findList(wzPlanSummary);
    }

	public List<WzPlanSummary> findAllListM(WzPlanSummary wzPlanSummary,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzPlanSummary,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzPlanSummary> findPageM(Page<WzPlanSummary> page, WzPlanSummary wzPlanSummary,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzPlanSummary,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzPlanSummary initInsert(WzPlanSummary wzPlanSummary)  {
		return super.initInsert(wzPlanSummary);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzPlanSummary wzPlanSummary) {
		super.checkSave(wzPlanSummary);
	}

	@Transactional(readOnly = false)
	public WzPlanSummary save(WzPlanSummary wzPlanSummary, boolean isNewRecord){
		return super.save(wzPlanSummary,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzPlanSummary> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzPlanSummary wzPlanSummary,String baseFilter){
		super.checkRemove(wzPlanSummary,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzPlanSummary wzPlanSummary,String baseFilter) {
		super.delete(wzPlanSummary,baseFilter);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveSummary(WzPlanSummary wzPlanSummary) {
 		wzPlanSummary.setSummanyTime(new Date());
		wzPlanSummary.setIsNewRecord(true);
		this.save(wzPlanSummary);
	}

	@Transactional(readOnly = false)
	public void saveTopics(String objId){
		List<WzPlan> wzPlanList = wzPlanDao.queryList(objId);
		for(WzPlan wzPlan : wzPlanList){
			WzTopics wzTopics = new WzTopics();
			if("0".equals(wzPlan.getProcurementMethod()) || "1".equals(wzPlan.getProcurementMethod())){
				//议题编号
				wzTopics.setCode(createCode(wzPlan.getCreateDept()));
				//议题名称
				wzTopics.setBiddingName(wzPlan.getProjectName());
				//议题类型
				wzTopics.setTopicsType("4");
				//分（子）公司名称
				wzTopics.setSonCompany(wzPlan.getSonCompany());
				//项目公司名称
				wzTopics.setCompanyName1(wzPlan.getDept());
				//招标项目名称
				wzTopics.setProjectName(wzPlan.getProjectName());
				//项目阶段
				wzTopics.setStage(wzPlan.getStage());
				//标的名称
				wzTopics.setCategory(wzPlan.getCategory());
				//概算金额
				wzTopics.setBudget(wzPlan.getBudget());
				//招标管理机构
				wzTopics.setMechanism(wzPlan.getSonCompany());
				//费用来源
				wzTopics.setMoneyResource(wzPlan.getMoneyResource());
				//议题填报人
				wzTopics.setWriteName(wzPlan.getInitiator());
				//议题填报单位
				wzTopics.setWriteDept(wzPlan.getDept());
				//议题状态
				wzTopics.setStatus("0");
				//议题填报时间
				//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				wzTopics.setWriteDate(new Date());
				wzTopics.setIsNewRecord(true);
				//议题状态 默认为提交状态
				wzTopics.setTopicsStatus("1");
				wzTopicsService.save(wzTopics);
			}else{
				//id
				wzTopics.setId(wzPlan.getId());
				//议题编号
				wzTopics.setCode(createCode(wzPlan.getCreateDept()));
				//议题名称
				wzTopics.setBiddingName(wzPlan.getProjectName());
				//议题类型
				wzTopics.setTopicsType("5");
				//招标项目名称
				wzTopics.setProjectName(wzPlan.getProjectName());
				//分（子）公司名称
				wzTopics.setSonCompany1(wzPlan.getSonCompany());
				//项目公司名称
				wzTopics.setCompanyName2(wzPlan.getDept());
				//采购方式
				wzTopics.setProcurementMethod(wzPlan.getProcurementMethod());
				//费用来源
				wzTopics.setMoneyResource1(wzPlan.getMoneyResource());
				//拟推荐供应商
				wzTopics.setSupplier(wzPlan.getSupplier());
				//主要工作内容
				wzTopics.setJobContent(wzPlan.getJobContent());
				//工作量
				wzTopics.setWorkload(wzPlan.getWorkload());
				//工期
				wzTopics.setDuration1(wzPlan.getDuration());
				//人员情况
				wzTopics.setPeopleSituation(wzPlan.getPeopleSituation());
				//资质业绩
				wzTopics.setAchievement(wzPlan.getAchievement());
				//物资技术规格清单
				wzTopics.setDetailedList(wzPlan.getDetailedList());
				//议题填报人
				wzTopics.setWriteName(wzPlan.getInitiator());
				//议题填报单位
				wzTopics.setWriteDept(wzPlan.getDept());
				//议题状态
				wzTopics.setStatus("0");
				//议题填报时间
				//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				wzTopics.setWriteDate(new Date());
				wzTopics.setIsNewRecord(true);
				//议题状态 默认为提交状态
				wzTopics.setTopicsStatus("1");
				wzTopicsService.save(wzTopics);
			}

		}
	}

	public String createCode(String deptId){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		String createDate = simpleDateFormat.format(new Date());
		String year = createDate.substring(2,4);
		String month = createDate.substring(5,7);
		String maxcode = wzTopicsService.getMaxCode(createDate);
		String str = "";
		if("".equals(maxcode) || maxcode == null){
			str = "0";
		}else{
			str = String.valueOf(maxcode).substring(String.valueOf(maxcode).length()-3,String.valueOf(maxcode).length());
		}

		int max = 1000 + Integer.parseInt(str) + 1;
		String code = "YT" + deptId + year + month + String.valueOf(max).substring(1);
		return code;
	}
}
