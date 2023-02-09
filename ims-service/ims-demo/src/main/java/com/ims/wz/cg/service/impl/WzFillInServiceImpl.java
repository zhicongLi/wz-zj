/**
 *
 */
package com.ims.wz.cg.service.impl;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;
import com.ims.wz.cg.dao.WzFillInDao;
import com.ims.wz.cg.entity.WzFillIn;
import com.ims.wz.cg.service.IWzFillInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 电厂填报表Service
 * @author lizhicong
 * @version 2022-08-18
 */
@Service
@Transactional(readOnly = true)
public class WzFillInServiceImpl extends CrudServiceImpl<WzFillInDao, WzFillIn> implements IWzFillInService{

	@Autowired
	private WzFillInDao wzFillInDao;

 	public WzFillIn get(WzFillIn wzFillIn) {
		return super.get(wzFillIn);
	}

    public List<WzFillIn> findList(WzFillIn wzFillIn) {
        return super.findList(wzFillIn);
    }

	public List<WzFillIn> findAllListM(WzFillIn wzFillIn,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzFillIn,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzFillIn> findPageM(Page<WzFillIn> page, WzFillIn wzFillIn,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzFillIn,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzFillIn initInsert(WzFillIn wzFillIn)  {
		return super.initInsert(wzFillIn);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzFillIn wzFillIn) {
		super.checkSave(wzFillIn);
	}

	@Transactional(readOnly = false)
	public WzFillIn save(WzFillIn wzFillIn, boolean isNewRecord){
		return super.save(wzFillIn,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzFillIn> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzFillIn wzFillIn,String baseFilter){
		super.checkRemove(wzFillIn,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzFillIn wzFillIn,String baseFilter) {
		super.delete(wzFillIn,baseFilter);
	}

	@Override
	public Float getSelectIndexValue(String indexCode,String orgId, String time) {
		if(wzFillInDao.getSelectIndexValue(indexCode,orgId,time) == null){
			return (float) 0;
		}
		return wzFillInDao.getSelectIndexValue(indexCode,orgId,time);
	}
}
