/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import com.ims.wz.cg.dao.WzPlanDao;
import com.ims.wz.cg.entity.WzItem;
import com.ims.wz.cg.entity.WzTopicsResult;
import com.ims.wz.cg.utils.ExportWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzPlanResultService;

import com.ims.wz.cg.entity.WzPlanResult;
import com.ims.wz.cg.dao.WzPlanResultDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 非招标采购结果议题审批Service
 * @author lizhicong
 * @version 2022-11-15
 */
@Service
@Transactional(readOnly = true)
public class WzPlanResultServiceImpl extends CrudServiceImpl<WzPlanResultDao, WzPlanResult> implements IWzPlanResultService{

	@Autowired
	private WzPlanResultDao wzPlanResultDao;

	@Autowired
	private WzPlanDao wzPlanDao;

 	public WzPlanResult get(WzPlanResult wzPlanResult) {
		return super.get(wzPlanResult);
	}

    public List<WzPlanResult> findList(WzPlanResult wzPlanResult) {
        return super.findList(wzPlanResult);
    }

	public List<WzPlanResult> findAllListM(WzPlanResult wzPlanResult,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzPlanResult,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzPlanResult> findPageM(Page<WzPlanResult> page, WzPlanResult wzPlanResult,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzPlanResult,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzPlanResult initInsert(WzPlanResult wzPlanResult)  {
		return super.initInsert(wzPlanResult);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzPlanResult wzPlanResult) {
		super.checkSave(wzPlanResult);
	}

	@Transactional(readOnly = false)
	public WzPlanResult save(WzPlanResult wzPlanResult, boolean isNewRecord){
		if(isNewRecord){
			wzPlanResult.setCode(createCode());
		}
		return super.save(wzPlanResult,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzPlanResult> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzPlanResult wzPlanResult,String baseFilter){
		super.checkRemove(wzPlanResult,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzPlanResult wzPlanResult,String baseFilter) {
		wzPlanDao.updateWzPlanResultId(wzPlanResult.getId());
 		super.delete(wzPlanResult,baseFilter);
	}

	public String createCode(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		String createDate = simpleDateFormat.format(new Date());
		String year = createDate.substring(0,4);
		String month = createDate.substring(5,7);
		String maxcode = getMaxCode(createDate);
		String str = "";
		if("".equals(maxcode) || maxcode == null){
			str = "0";
		}else{
			str = maxcode.substring(maxcode.length()-3,maxcode.length());
		}

		int max = 1000 + Integer.parseInt(str) + 1;
		String code = year + month + "-" + String.valueOf(max).substring(1);
		return code;
	}

	public String getMaxCode(String createDate){
		return wzPlanResultDao.getMaxCode(createDate);
	}

	@Transactional(readOnly = false)
	public void saveSponsor(String id,String name){
		WzPlanResult wzPlanResult = this.get(id);
		if(wzPlanResult != null){
			wzPlanResult.setApplyName(name);
			this.saveOrUpdate(wzPlanResult);
		}
	}

	@Transactional(readOnly = false)
	public void saveOpinion(String id,String name,String opinion){
		WzPlanResult wzPlanResult = this.get(id);
		if(wzPlanResult != null){
			if("2".equals(wzPlanResult.getStatus())){
				wzPlanResult.setXqbmName(name);
				wzPlanResult.setXqbmDate(new Date());
				wzPlanResult.setXqbmApproval("同意");
			}
			if("3".equals(wzPlanResult.getStatus())){
				wzPlanResult.setCgbmName(name);
				wzPlanResult.setCgbmDate(new Date());
				wzPlanResult.setCgbmApproval(opinion);
			}
			if("4".equals(wzPlanResult.getStatus())){
				wzPlanResult.setFgldName(name);
				wzPlanResult.setFgldDate(new Date());
				wzPlanResult.setFgldApproval("同意");
			}
			if("5".equals(wzPlanResult.getStatus())){
				wzPlanResult.setZjlName(name);
				wzPlanResult.setZjlDate(new Date());
				wzPlanResult.setZjlApproval(opinion);
			}
			if("8".equals(wzPlanResult.getStatus())){
				wzPlanResult.setCgfgldName(name);
				wzPlanResult.setCgfgldDate(new Date());
				wzPlanResult.setCgfgldApproval(opinion);
			}
			this.saveOrUpdate(wzPlanResult);
		}
	}

	@Override
	public String exportWord(HttpServletRequest request, HttpServletResponse response, String id) {
		WzPlanResult wzPlanResult = this.get(id);
		String wordPath = "template/非招标采购结果审议表.docx";
		String fileName = wzPlanResult.getCode() + "非招标采购结果审议表";
		Map<String, Object> dataMap=new HashMap<>();

		dataMap.put("createCompanyName",wzPlanResult.getCreateCompanyName());
		dataMap.put("applyDate",returnDate(wzPlanResult.getApplyDate()));
		dataMap.put("code",wzPlanResult.getCode());
		dataMap.put("createName",wzPlanResult.getCreateName());
		dataMap.put("applyName",wzPlanResult.getApplyName());
		dataMap.put("xqbmName",wzPlanResult.getXqbmName());
		dataMap.put("xqbmApproval",wzPlanResult.getXqbmApproval());
		dataMap.put("xqbmDate",returnDate(wzPlanResult.getXqbmDate()));
		dataMap.put("cgbmName",wzPlanResult.getCgbmName());
		dataMap.put("cgbmApproval",wzPlanResult.getCgbmApproval());
		dataMap.put("cgbmDate",returnDate(wzPlanResult.getCgbmDate()));
		dataMap.put("fgldName",wzPlanResult.getFgldName());
		dataMap.put("fgldApproval",wzPlanResult.getFgldApproval());
		dataMap.put("fgldDate",returnDate(wzPlanResult.getFgldDate()));
		dataMap.put("zjlName",wzPlanResult.getZjlName());
		dataMap.put("zjlApproval",wzPlanResult.getZjlApproval());
		dataMap.put("zjlDate",returnDate(wzPlanResult.getZjlDate()));
		dataMap.put("approvedName",wzPlanResult.getApprovedName());
		dataMap.put("explicate",wzPlanResult.getExplicate());
		dataMap.put("cgfgldName",wzPlanResult.getCgfgldName());
		dataMap.put("cgfgldDate", returnDate(wzPlanResult.getCgfgldDate()));
		dataMap.put("cgfgldApproval",wzPlanResult.getCgfgldApproval());
		ExportWord.exportWord(wordPath,"/file",fileName,dataMap,request,response);

		return fileName;
	}

	public String returnDate(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}
}
