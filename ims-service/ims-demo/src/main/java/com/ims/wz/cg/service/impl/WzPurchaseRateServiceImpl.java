/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzPurchaseRateService;

import com.ims.wz.cg.entity.WzPurchaseRate;
import com.ims.wz.cg.dao.WzPurchaseRateDao;


/**
 * 集中 公开 上网采购率Service
 * @author lizhicong
 * @version 2022-08-18
 */
@Service
@Transactional(readOnly = true)
public class WzPurchaseRateServiceImpl extends CrudServiceImpl<WzPurchaseRateDao, WzPurchaseRate> implements IWzPurchaseRateService{

	@Autowired
	private WzPurchaseRateDao wzPurchaseRateDao;

 	public WzPurchaseRate get(WzPurchaseRate wzPurchaseRate) {
		return super.get(wzPurchaseRate);
	}

    public List<WzPurchaseRate> findList(WzPurchaseRate wzPurchaseRate) {
        return super.findList(wzPurchaseRate);
    }

	public List<WzPurchaseRate> findAllListM(WzPurchaseRate wzPurchaseRate,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzPurchaseRate,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzPurchaseRate> findPageM(Page<WzPurchaseRate> page, WzPurchaseRate wzPurchaseRate,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzPurchaseRate,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzPurchaseRate initInsert(WzPurchaseRate wzPurchaseRate)  {
		return super.initInsert(wzPurchaseRate);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzPurchaseRate wzPurchaseRate) {
		super.checkSave(wzPurchaseRate);
	}

	@Transactional(readOnly = false)
	public WzPurchaseRate save(WzPurchaseRate wzPurchaseRate, boolean isNewRecord){
		return super.save(wzPurchaseRate,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzPurchaseRate> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzPurchaseRate wzPurchaseRate,String baseFilter){
		super.checkRemove(wzPurchaseRate,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzPurchaseRate wzPurchaseRate,String baseFilter) {
		super.delete(wzPurchaseRate,baseFilter);
	}

	@Override
	public List<WzPurchaseRate> getSelectIndexValue(String time) {
		return wzPurchaseRateDao.getSelectIndexValue(time);
	}
}
