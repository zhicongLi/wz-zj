/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzTopicsMettingService;

import com.ims.wz.cg.entity.WzTopicsMetting;
import com.ims.wz.cg.dao.WzTopicsMettingDao;


/**
 * wz_topics_mettingService
 * @author lizhicong
 * @version 2021-09-28
 */
@Service
@Transactional(readOnly = true)
public class WzTopicsMettingServiceImpl extends CrudServiceImpl<WzTopicsMettingDao, WzTopicsMetting> implements IWzTopicsMettingService{

 	public WzTopicsMetting get(WzTopicsMetting wzTopicsMetting) {
		return super.get(wzTopicsMetting);
	}

    public List<WzTopicsMetting> findList(WzTopicsMetting wzTopicsMetting) {
        return super.findList(wzTopicsMetting);
    }

	public List<WzTopicsMetting> findAllListM(WzTopicsMetting wzTopicsMetting,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzTopicsMetting,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzTopicsMetting> findPageM(Page<WzTopicsMetting> page, WzTopicsMetting wzTopicsMetting,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzTopicsMetting,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzTopicsMetting initInsert(WzTopicsMetting wzTopicsMetting)  {
		return super.initInsert(wzTopicsMetting);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzTopicsMetting wzTopicsMetting) {
		super.checkSave(wzTopicsMetting);
	}

	@Transactional(readOnly = false)
	public WzTopicsMetting save(WzTopicsMetting wzTopicsMetting, boolean isNewRecord){
		return super.save(wzTopicsMetting,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzTopicsMetting> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzTopicsMetting wzTopicsMetting,String baseFilter){
		super.checkRemove(wzTopicsMetting,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzTopicsMetting wzTopicsMetting,String baseFilter) {
		super.delete(wzTopicsMetting,baseFilter);
	}
}