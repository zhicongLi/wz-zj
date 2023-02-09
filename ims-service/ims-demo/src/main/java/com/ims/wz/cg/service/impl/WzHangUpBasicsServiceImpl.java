/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzHangUpBasicsService;

import com.ims.wz.cg.entity.WzHangUpBasics;
import com.ims.wz.cg.dao.WzHangUpBasicsDao;


/**
 * 非招标一挂基础表Service
 * @author lizhicong
 * @version 2022-07-14
 */
@Service
@Transactional(readOnly = true)
public class WzHangUpBasicsServiceImpl extends CrudServiceImpl<WzHangUpBasicsDao, WzHangUpBasics> implements IWzHangUpBasicsService{

 	public WzHangUpBasics get(WzHangUpBasics wzHangUpBasics) {
		return super.get(wzHangUpBasics);
	}

    public List<WzHangUpBasics> findList(WzHangUpBasics wzHangUpBasics) {
        return super.findList(wzHangUpBasics);
    }

	public List<WzHangUpBasics> findAllListM(WzHangUpBasics wzHangUpBasics,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzHangUpBasics,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzHangUpBasics> findPageM(Page<WzHangUpBasics> page, WzHangUpBasics wzHangUpBasics,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzHangUpBasics,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzHangUpBasics initInsert(WzHangUpBasics wzHangUpBasics)  {
		return super.initInsert(wzHangUpBasics);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzHangUpBasics wzHangUpBasics) {
		super.checkSave(wzHangUpBasics);
	}

	@Transactional(readOnly = false)
	public WzHangUpBasics save(WzHangUpBasics wzHangUpBasics, boolean isNewRecord){
		return super.save(wzHangUpBasics,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzHangUpBasics> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzHangUpBasics wzHangUpBasics,String baseFilter){
		super.checkRemove(wzHangUpBasics,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzHangUpBasics wzHangUpBasics,String baseFilter) {
		super.delete(wzHangUpBasics,baseFilter);
	}

}
