/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzSupplierScoreService;

import com.ims.wz.cg.entity.WzSupplierScore;
import com.ims.wz.cg.dao.WzSupplierScoreDao;


/**
 * 供应商评议打分表Service
 * @author lizhicong
 * @version 2022-07-21
 */
@Service
@Transactional(readOnly = true)
public class WzSupplierScoreServiceImpl extends CrudServiceImpl<WzSupplierScoreDao, WzSupplierScore> implements IWzSupplierScoreService{

 	public WzSupplierScore get(WzSupplierScore wzSupplierScore) {
		return super.get(wzSupplierScore);
	}

    public List<WzSupplierScore> findList(WzSupplierScore wzSupplierScore) {
        return super.findList(wzSupplierScore);
    }

	public List<WzSupplierScore> findAllListM(WzSupplierScore wzSupplierScore,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzSupplierScore,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzSupplierScore> findPageM(Page<WzSupplierScore> page, WzSupplierScore wzSupplierScore,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzSupplierScore,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzSupplierScore initInsert(WzSupplierScore wzSupplierScore)  {
		return super.initInsert(wzSupplierScore);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzSupplierScore wzSupplierScore) {
		super.checkSave(wzSupplierScore);
	}

	@Transactional(readOnly = false)
	public WzSupplierScore save(WzSupplierScore wzSupplierScore, boolean isNewRecord){
		return super.save(wzSupplierScore,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzSupplierScore> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzSupplierScore wzSupplierScore,String baseFilter){
		super.checkRemove(wzSupplierScore,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzSupplierScore wzSupplierScore,String baseFilter) {
		super.delete(wzSupplierScore,baseFilter);
	}
}