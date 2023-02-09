/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzFzbPlanResultService;

import com.ims.wz.cg.entity.WzFzbPlanResult;
import com.ims.wz.cg.dao.WzFzbPlanResultDao;


/**
 * 非招标采购结果议题审批Service
 * @author lizhicong
 * @version 2022-12-15
 */
@Service
@Transactional(readOnly = true)
public class WzFzbPlanResultServiceImpl extends CrudServiceImpl<WzFzbPlanResultDao, WzFzbPlanResult> implements IWzFzbPlanResultService{

 	public WzFzbPlanResult get(WzFzbPlanResult wzFzbPlanResult) {
		return super.get(wzFzbPlanResult);
	}

    public List<WzFzbPlanResult> findList(WzFzbPlanResult wzFzbPlanResult) {
        return super.findList(wzFzbPlanResult);
    }

	public List<WzFzbPlanResult> findAllListM(WzFzbPlanResult wzFzbPlanResult,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzFzbPlanResult,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzFzbPlanResult> findPageM(Page<WzFzbPlanResult> page, WzFzbPlanResult wzFzbPlanResult,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzFzbPlanResult,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzFzbPlanResult initInsert(WzFzbPlanResult wzFzbPlanResult)  {
		return super.initInsert(wzFzbPlanResult);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzFzbPlanResult wzFzbPlanResult) {
		super.checkSave(wzFzbPlanResult);
	}

	@Transactional(readOnly = false)
	public WzFzbPlanResult save(WzFzbPlanResult wzFzbPlanResult, boolean isNewRecord){
		return super.save(wzFzbPlanResult,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzFzbPlanResult> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzFzbPlanResult wzFzbPlanResult,String baseFilter){
		super.checkRemove(wzFzbPlanResult,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzFzbPlanResult wzFzbPlanResult,String baseFilter) {
		super.delete(wzFzbPlanResult,baseFilter);
	}
}