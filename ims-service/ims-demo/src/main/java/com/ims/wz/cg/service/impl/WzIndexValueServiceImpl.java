/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzIndexValueService;

import com.ims.wz.cg.entity.WzIndexValue;
import com.ims.wz.cg.dao.WzIndexValueDao;


/**
 * 指标数据表Service
 * @author lizhicong
 * @version 2022-06-20
 */
@Service
@Transactional(readOnly = true)
public class WzIndexValueServiceImpl extends CrudServiceImpl<WzIndexValueDao, WzIndexValue> implements IWzIndexValueService{

	@Autowired
	private WzIndexValueDao wzIndexValueDao;

 	public WzIndexValue get(WzIndexValue wzIndexValue) {
		return super.get(wzIndexValue);
	}

    public List<WzIndexValue> findList(WzIndexValue wzIndexValue) {
        return super.findList(wzIndexValue);
    }

	public List<WzIndexValue> findAllListM(WzIndexValue wzIndexValue,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzIndexValue,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzIndexValue> findPageM(Page<WzIndexValue> page, WzIndexValue wzIndexValue,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzIndexValue,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzIndexValue initInsert(WzIndexValue wzIndexValue)  {
		return super.initInsert(wzIndexValue);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzIndexValue wzIndexValue) {
		super.checkSave(wzIndexValue);
	}

	@Transactional(readOnly = false)
	public WzIndexValue save(WzIndexValue wzIndexValue, boolean isNewRecord){
		return super.save(wzIndexValue,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzIndexValue> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzIndexValue wzIndexValue,String baseFilter){
		super.checkRemove(wzIndexValue,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzIndexValue wzIndexValue,String baseFilter) {
		super.delete(wzIndexValue,baseFilter);
	}

	@Override
	public List<WzIndexValue> selectIndexValue(String indexCode, String orgId, String time, String timeDimensionality) {
		return wzIndexValueDao.selectIndexValue(indexCode,orgId,time,timeDimensionality);
	}

	@Override
	public List<WzIndexValue> getSelectIndexValue(String indexCode, String orgId, String time,String timeDimensionality) {
 		List<String> date = JSONArray.parseArray(indexCode,String.class);
		return wzIndexValueDao.getSelectIndexValue(date,orgId,time,timeDimensionality);
	}

	@Override
	public List<WzIndexValue> getSelectIndexValueForYear(String indexCode) {
		return wzIndexValueDao.getSelectIndexValueForYear(indexCode);
	}
}
