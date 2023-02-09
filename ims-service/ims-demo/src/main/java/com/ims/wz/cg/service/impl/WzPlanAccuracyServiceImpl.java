/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzPlanAccuracyService;

import com.ims.wz.cg.entity.WzPlanAccuracy;
import com.ims.wz.cg.dao.WzPlanAccuracyDao;


/**
 * 采购计划准确率基础表Service
 * @author lizhicong
 * @version 2022-07-18
 */
@Service
@Transactional(readOnly = true)
public class WzPlanAccuracyServiceImpl extends CrudServiceImpl<WzPlanAccuracyDao, WzPlanAccuracy> implements IWzPlanAccuracyService{

 	public WzPlanAccuracy get(WzPlanAccuracy wzPlanAccuracy) {
		return super.get(wzPlanAccuracy);
	}

    public List<WzPlanAccuracy> findList(WzPlanAccuracy wzPlanAccuracy) {
        return super.findList(wzPlanAccuracy);
    }

	public List<WzPlanAccuracy> findAllListM(WzPlanAccuracy wzPlanAccuracy,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzPlanAccuracy,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzPlanAccuracy> findPageM(Page<WzPlanAccuracy> page, WzPlanAccuracy wzPlanAccuracy,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzPlanAccuracy,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzPlanAccuracy initInsert(WzPlanAccuracy wzPlanAccuracy)  {
		return super.initInsert(wzPlanAccuracy);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzPlanAccuracy wzPlanAccuracy) {
		super.checkSave(wzPlanAccuracy);
	}

	@Transactional(readOnly = false)
	public WzPlanAccuracy save(WzPlanAccuracy wzPlanAccuracy, boolean isNewRecord){
		return super.save(wzPlanAccuracy,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzPlanAccuracy> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzPlanAccuracy wzPlanAccuracy,String baseFilter){
		super.checkRemove(wzPlanAccuracy,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzPlanAccuracy wzPlanAccuracy,String baseFilter) {
		super.delete(wzPlanAccuracy,baseFilter);
	}
}