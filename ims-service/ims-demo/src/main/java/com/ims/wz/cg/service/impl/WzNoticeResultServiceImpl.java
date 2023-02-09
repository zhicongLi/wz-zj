/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzNoticeResultService;

import com.ims.wz.cg.entity.WzNoticeResult;
import com.ims.wz.cg.dao.WzNoticeResultDao;


/**
 * 非招标采购结果议题审批Service
 * @author lizhicong
 * @version 2022-12-27
 */
@Service
@Transactional(readOnly = true)
public class WzNoticeResultServiceImpl extends CrudServiceImpl<WzNoticeResultDao, WzNoticeResult> implements IWzNoticeResultService{

 	public WzNoticeResult get(WzNoticeResult wzNoticeResult) {
		return super.get(wzNoticeResult);
	}

    public List<WzNoticeResult> findList(WzNoticeResult wzNoticeResult) {
        return super.findList(wzNoticeResult);
    }

	public List<WzNoticeResult> findAllListM(WzNoticeResult wzNoticeResult,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzNoticeResult,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzNoticeResult> findPageM(Page<WzNoticeResult> page, WzNoticeResult wzNoticeResult,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzNoticeResult,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzNoticeResult initInsert(WzNoticeResult wzNoticeResult)  {
		return super.initInsert(wzNoticeResult);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzNoticeResult wzNoticeResult) {
		super.checkSave(wzNoticeResult);
	}

	@Transactional(readOnly = false)
	public WzNoticeResult save(WzNoticeResult wzNoticeResult, boolean isNewRecord){
		return super.save(wzNoticeResult,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzNoticeResult> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzNoticeResult wzNoticeResult,String baseFilter){
		super.checkRemove(wzNoticeResult,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzNoticeResult wzNoticeResult,String baseFilter) {
		super.delete(wzNoticeResult,baseFilter);
	}
}