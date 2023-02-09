/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ims.idms.modules.sys.vo.SysUserVO;
import com.ims.idms.modules.utils.UserUtils;
import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzTopicsResultService;

import com.ims.wz.cg.entity.WzTopicsResult;
import com.ims.wz.cg.dao.WzTopicsResultDao;


/**
 * 非招标采购结果议题审批Service
 * @author lizhicong
 * @version 2022-10-09
 */
@Service
@Transactional(readOnly = true)
public class WzTopicsResultServiceImpl extends CrudServiceImpl<WzTopicsResultDao, WzTopicsResult> implements IWzTopicsResultService{

	@Autowired
	private WzTopicsResultDao wzTopicsResultDao;

 	public WzTopicsResult get(WzTopicsResult wzTopicsResult) {
		return super.get(wzTopicsResult);
	}

    public List<WzTopicsResult> findList(WzTopicsResult wzTopicsResult) {
        return super.findList(wzTopicsResult);
    }

	public List<WzTopicsResult> findAllListM(WzTopicsResult wzTopicsResult,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzTopicsResult,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzTopicsResult> findPageM(Page<WzTopicsResult> page, WzTopicsResult wzTopicsResult,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzTopicsResult,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzTopicsResult initInsert(WzTopicsResult wzTopicsResult)  {
		return super.initInsert(wzTopicsResult);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzTopicsResult wzTopicsResult) {
		super.checkSave(wzTopicsResult);
	}

	@Transactional(readOnly = false)
	public WzTopicsResult save(WzTopicsResult wzTopicsResult, boolean isNewRecord){
 		if(isNewRecord){
 			wzTopicsResult.setCode(createCode());
		}
		return super.save(wzTopicsResult,isNewRecord);
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
 		return wzTopicsResultDao.getMaxCode(createDate);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzTopicsResult> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzTopicsResult wzTopicsResult,String baseFilter){
		super.checkRemove(wzTopicsResult,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzTopicsResult wzTopicsResult,String baseFilter) {
		super.delete(wzTopicsResult,baseFilter);
	}

	@Transactional(readOnly = false)
	public void saveSponsor(String id,String name){
 		WzTopicsResult wzTopicsResult = this.get(id);
 		if(wzTopicsResult != null){
 			wzTopicsResult.setApplyName(name);
 			this.saveOrUpdate(wzTopicsResult);
		}
	}


	@Transactional(readOnly = false)
	public void saveOpinion(String id,String name,String opinion){
		WzTopicsResult wzTopicsResult = this.get(id);
		if(wzTopicsResult != null){
			if("2".equals(wzTopicsResult.getStatus())){
				wzTopicsResult.setXqbmName(name);
				wzTopicsResult.setXqbmDate(new Date());
				wzTopicsResult.setXqbmApproval(opinion);
			}
			if("3".equals(wzTopicsResult.getStatus())){
				wzTopicsResult.setCgbmName(name);
				wzTopicsResult.setCgbmDate(new Date());
				wzTopicsResult.setCgbmApproval(opinion);
			}
			if("4".equals(wzTopicsResult.getStatus())){
				wzTopicsResult.setFgldName(name);
				wzTopicsResult.setFgldDate(new Date());
				wzTopicsResult.setFgldApproval(opinion);
			}
			if("5".equals(wzTopicsResult.getStatus())){
				wzTopicsResult.setZjlName(name);
				wzTopicsResult.setZjlDate(new Date());
				wzTopicsResult.setZjlApproval(opinion);
			}
			this.saveOrUpdate(wzTopicsResult);
		}
	}
}
