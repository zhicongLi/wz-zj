/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzTimelinessRateService;

import com.ims.wz.cg.entity.WzTimelinessRate;
import com.ims.wz.cg.dao.WzTimelinessRateDao;


/**
 * 采购申请及时率基础表Service
 * @author lizhicong
 * @version 2022-07-19
 */
@Service
@Transactional(readOnly = true)
public class WzTimelinessRateServiceImpl extends CrudServiceImpl<WzTimelinessRateDao, WzTimelinessRate> implements IWzTimelinessRateService{

 	public WzTimelinessRate get(WzTimelinessRate wzTimelinessRate) {
		return super.get(wzTimelinessRate);
	}

    public List<WzTimelinessRate> findList(WzTimelinessRate wzTimelinessRate) {
        return super.findList(wzTimelinessRate);
    }

	public List<WzTimelinessRate> findAllListM(WzTimelinessRate wzTimelinessRate,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzTimelinessRate,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzTimelinessRate> findPageM(Page<WzTimelinessRate> page, WzTimelinessRate wzTimelinessRate,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzTimelinessRate,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzTimelinessRate initInsert(WzTimelinessRate wzTimelinessRate)  {
		return super.initInsert(wzTimelinessRate);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzTimelinessRate wzTimelinessRate) {
		super.checkSave(wzTimelinessRate);
	}

	@Transactional(readOnly = false)
	public WzTimelinessRate save(WzTimelinessRate wzTimelinessRate, boolean isNewRecord){
		return super.save(wzTimelinessRate,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzTimelinessRate> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzTimelinessRate wzTimelinessRate,String baseFilter){
		super.checkRemove(wzTimelinessRate,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzTimelinessRate wzTimelinessRate,String baseFilter) {
		super.delete(wzTimelinessRate,baseFilter);
	}
}