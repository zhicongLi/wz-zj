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

import com.ims.wz.cg.service.IWzProcurementService;

import com.ims.wz.cg.entity.WzProcurement;
import com.ims.wz.cg.dao.WzProcurementDao;


/**
 * wz_procurementService
 * @author lizhicong
 * @version 2022-06-28
 */
@Service
@Transactional(readOnly = true)
public class WzProcurementServiceImpl extends CrudServiceImpl<WzProcurementDao, WzProcurement> implements IWzProcurementService{

	@Autowired
	private WzProcurementDao wzProcurementDao;

 	public WzProcurement get(WzProcurement wzProcurement) {
		return super.get(wzProcurement);
	}

    public List<WzProcurement> findList(WzProcurement wzProcurement) {
        return super.findList(wzProcurement);
    }

	public List<WzProcurement> findAllListM(WzProcurement wzProcurement,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzProcurement,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzProcurement> findPageM(Page<WzProcurement> page, WzProcurement wzProcurement,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzProcurement,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzProcurement initInsert(WzProcurement wzProcurement)  {
		return super.initInsert(wzProcurement);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzProcurement wzProcurement) {
		super.checkSave(wzProcurement);
	}

	@Transactional(readOnly = false)
	public WzProcurement save(WzProcurement wzProcurement, boolean isNewRecord){
		return super.save(wzProcurement,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzProcurement> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzProcurement wzProcurement,String baseFilter){
		super.checkRemove(wzProcurement,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzProcurement wzProcurement,String baseFilter) {
		super.delete(wzProcurement,baseFilter);
	}

	@Override
	public List<WzProcurement> getSelectIndexValue(String time) {
		return wzProcurementDao.getSelectIndexValue(time);
	}

	@Override
	public List<WzProcurement> getSelectDate() {
		return wzProcurementDao.getSelectDate();
	}
}
