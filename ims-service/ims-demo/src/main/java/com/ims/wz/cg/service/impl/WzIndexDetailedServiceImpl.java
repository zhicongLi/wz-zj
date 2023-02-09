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

import com.ims.wz.cg.service.IWzIndexDetailedService;

import com.ims.wz.cg.entity.WzIndexDetailed;
import com.ims.wz.cg.dao.WzIndexDetailedDao;


/**
 * 指标详细表Service
 * @author lizhicong
 * @version 2022-08-24
 */
@Service
@Transactional(readOnly = true)
public class WzIndexDetailedServiceImpl extends CrudServiceImpl<WzIndexDetailedDao, WzIndexDetailed> implements IWzIndexDetailedService{


 	public WzIndexDetailed get(WzIndexDetailed wzIndexDetailed) {
		return super.get(wzIndexDetailed);
	}

    public List<WzIndexDetailed> findList(WzIndexDetailed wzIndexDetailed) {
        return super.findList(wzIndexDetailed);
    }

	public List<WzIndexDetailed> findAllListM(WzIndexDetailed wzIndexDetailed,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzIndexDetailed,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzIndexDetailed> findPageM(Page<WzIndexDetailed> page, WzIndexDetailed wzIndexDetailed,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzIndexDetailed,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzIndexDetailed initInsert(WzIndexDetailed wzIndexDetailed)  {
		return super.initInsert(wzIndexDetailed);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzIndexDetailed wzIndexDetailed) {
		super.checkSave(wzIndexDetailed);
	}

	@Transactional(readOnly = false)
	public WzIndexDetailed save(WzIndexDetailed wzIndexDetailed, boolean isNewRecord){
		return super.save(wzIndexDetailed,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzIndexDetailed> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzIndexDetailed wzIndexDetailed,String baseFilter){
		super.checkRemove(wzIndexDetailed,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzIndexDetailed wzIndexDetailed,String baseFilter) {
		super.delete(wzIndexDetailed,baseFilter);
	}

}
