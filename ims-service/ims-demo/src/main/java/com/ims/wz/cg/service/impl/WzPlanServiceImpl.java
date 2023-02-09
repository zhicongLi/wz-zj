/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.ims.core.utils.StringUtils;
import com.ims.idms.modules.sys.vo.SysUserVO;
import com.ims.idms.modules.utils.UserUtils;
import com.ims.wz.cg.entity.WzItem;
import com.ims.wz.cg.service.IWzItemService;
import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzPlanService;

import com.ims.wz.cg.entity.WzPlan;
import com.ims.wz.cg.dao.WzPlanDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 物资采购计划Service
 * @author lizhicong
 * @version 2021-09-09
 */
@Service
@Transactional(readOnly = true)
public class WzPlanServiceImpl extends CrudServiceImpl<WzPlanDao, WzPlan> implements IWzPlanService{

	@Autowired
	private WzPlanDao wzPlanDao;
	@Autowired
	private IWzItemService wzItemService;
	@Autowired
	private WzTopicsServiceImpl wzTopicsService;
	@Autowired
	private WzFormApprovalServiceImpl wzFormApprovalService;


 	public WzPlan get(WzPlan wzPlan) {
		return super.get(wzPlan);
	}

    public List<WzPlan> findList(WzPlan wzPlan) {
        return super.findList(wzPlan);
    }

	public List<WzPlan> findAllListM(WzPlan wzPlan,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzPlan,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzPlan> findPageM(Page<WzPlan> page, WzPlan wzPlan,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzPlan,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzPlan initInsert(WzPlan wzPlan)  {
		return super.initInsert(wzPlan);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzPlan wzPlan) {
		super.checkSave(wzPlan);
	}

	@Transactional(readOnly = false)
	public WzPlan save(WzPlan wzPlan, boolean isNewRecord){
		if(isNewRecord){
			wzPlan.setCode(createCode());
		}
 		return super.save(wzPlan,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzPlan> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzPlan wzPlan,String baseFilter){
		super.checkRemove(wzPlan,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzPlan wzPlan,String baseFilter) {
 		WzPlan wz = this.get(wzPlan.getId());
		if(StringUtil.isNotBlank(wz.getItemId())){
			WzItem wzItem = wzItemService.get(wz.getItemId());
			wzItem.setIsgenerate("0");
			wzItemService.saveOrUpdate(wzItem);
		}
 		super.delete(wzPlan,baseFilter);
	}

	@Override
	public String getMaxCode(String createDate) {
		return wzPlanDao.getMaxCode(createDate);
	}

	public String createCode(){
		R<SysUserVO> sysUserVOR = UserUtils.currentUser();
		String deptId = sysUserVOR.getData().getUnitId();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		String createDate = simpleDateFormat.format(new Date());
		String year = createDate.substring(2,4);
		String month = createDate.substring(5,7);
		String maxcode = getMaxCode(createDate);
		String str = "";
		if("".equals(maxcode) || maxcode == null){
			str = "0";
		}else{
			str = maxcode.substring(maxcode.length()-3,maxcode.length());
		}

		int max = 1000 + Integer.parseInt(str) + 1;
		String code = deptId + year + month + String.valueOf(max).substring(1);
		return code;
	}

	//招标计划流程结束回写方法
	@Transactional(readOnly = false)
	public void saveZbPlan(String objId){
 		WzPlan wzPlan = this.get(objId);
		if(!("3".equals(wzPlan.getReviewMethod()))){
			wzFormApprovalService.saveFromPlan(wzPlan);
		}

	/*	String content = "智慧企业物资采购系统提醒：采购计划-" + wzPlan.getCode() + "-" + wzPlan.getProjectName() + "已审批完成，请您及时处理。(系统自动发送，请勿回复)";
		MessageUtil.sendBpmMessage(wzPlan.getCreateBy(),content);*/
	}

	//非招标计划流程回写方法
	@Transactional(readOnly = false)
	public void saveFzbPlan(String objId){
		System.out.println("进入流程回写方法" + objId);
 		WzPlan wzPlan = this.get(objId);
		if(!("3".equals(wzPlan.getReviewMethod())) && !("6".equals(wzPlan.getProcurementMethod())) && !("7".equals(wzPlan.getProcurementMethod()))) {
			wzFormApprovalService.saveFromPlan(wzPlan);
		}
		/*String content = "智慧企业物资采购系统提醒：采购计划-" + wzPlan.getCode() + "-" + wzPlan.getProjectName() + "已审批完成，请您及时处理。(系统自动发送，请勿回复)";
		MessageUtil.sendBpmMessage(wzPlan.getCreateBy(),content);*/
	}
	@Override
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

	@Transactional(readOnly = false)
	@Override
	public List<WzPlan> getSelectPlan(String planNumber) {
		return wzPlanDao.getSelectPlan(planNumber);
	}

	@Transactional(readOnly = false)
	public void savePlanTime(String objId){
		WzPlan wzPlan = this.get(objId);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		wzPlan.setPlanTime(date);
		this.saveOrUpdate(wzPlan);
	}

	@Transactional(readOnly = false)
	public void updatePlanStatus(String objId){
		WzPlan wzPlan = this.get(objId);
		if (StringUtils.equals(wzPlan.getProcurementMethod(), "6") || StringUtils.equals(wzPlan.getProcurementMethod(), "7")||("2".equals(wzPlan.getCategory()) && "3".equals(wzPlan.getReviewMethod()))) {
			wzPlan.setPlanStatus("8");
			wzPlan.setStatus("8");
			this.saveOrUpdate(wzPlan);
		}
	}

	@Transactional(readOnly = false)
	public void updatePlanMonth(String objId){
		WzPlan wzPlan = this.get(objId);
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		if (day < 20) {
			calendar.add(Calendar.MONTH, 1);
		} else {
			calendar.add(Calendar.MONTH, 2);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		wzPlan.setSubmitMonth(simpleDateFormat.format(calendar.getTime()));
		if("0".equals(wzPlan.getProcurementMethod()) || "1".equals(wzPlan.getProcurementMethod())){
			wzPlan.setIsgenerate("1");
		}else{
			if(("0".equals(wzPlan.getCategory()) && Double.parseDouble(wzPlan.getBudget()) >= 50) || ("1".equals(wzPlan.getCategory()) && Double.parseDouble(wzPlan.getBudget()) >= 200) || ("2".equals(wzPlan.getCategory()) && Double.parseDouble(wzPlan.getBudget()) >= 100)){
				wzPlan.setIsgenerate("1");
			}else{
				wzPlan.setIsgenerate("2");
			}
		}
		this.saveOrUpdate(wzPlan);
	}
}
