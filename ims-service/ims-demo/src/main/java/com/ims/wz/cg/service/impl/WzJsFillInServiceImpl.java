/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzJsFillInService;

import com.ims.wz.cg.entity.WzJsFillIn;
import com.ims.wz.cg.dao.WzJsFillInDao;


/**
 * 江苏公司填报Service
 * @author lizhicong
 * @version 2022-08-19
 */
@Service
@Transactional(readOnly = true)
public class WzJsFillInServiceImpl extends CrudServiceImpl<WzJsFillInDao, WzJsFillIn> implements IWzJsFillInService{

 	public WzJsFillIn get(WzJsFillIn wzJsFillIn) {
		return super.get(wzJsFillIn);
	}

    public List<WzJsFillIn> findList(WzJsFillIn wzJsFillIn) {
        return super.findList(wzJsFillIn);
    }

	public List<WzJsFillIn> findAllListM(WzJsFillIn wzJsFillIn,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzJsFillIn,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzJsFillIn> findPageM(Page<WzJsFillIn> page, WzJsFillIn wzJsFillIn,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzJsFillIn,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzJsFillIn initInsert(WzJsFillIn wzJsFillIn)  {
		return super.initInsert(wzJsFillIn);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzJsFillIn wzJsFillIn) {
		super.checkSave(wzJsFillIn);
	}

	@Transactional(readOnly = false)
	public WzJsFillIn save(WzJsFillIn wzJsFillIn, boolean isNewRecord){
		return super.save(wzJsFillIn,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzJsFillIn> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzJsFillIn wzJsFillIn,String baseFilter){
		super.checkRemove(wzJsFillIn,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzJsFillIn wzJsFillIn,String baseFilter) {
		super.delete(wzJsFillIn,baseFilter);
	}
}