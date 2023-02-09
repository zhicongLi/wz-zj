/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzContractTimelinessService;

import com.ims.wz.cg.entity.WzContractTimeliness;
import com.ims.wz.cg.dao.WzContractTimelinessDao;


/**
 * 合同签订及时率基础表Service
 * @author lizhicong
 * @version 2022-07-20
 */
@Service
@Transactional(readOnly = true)
public class WzContractTimelinessServiceImpl extends CrudServiceImpl<WzContractTimelinessDao, WzContractTimeliness> implements IWzContractTimelinessService{

 	public WzContractTimeliness get(WzContractTimeliness wzContractTimeliness) {
		return super.get(wzContractTimeliness);
	}

    public List<WzContractTimeliness> findList(WzContractTimeliness wzContractTimeliness) {
        return super.findList(wzContractTimeliness);
    }

	public List<WzContractTimeliness> findAllListM(WzContractTimeliness wzContractTimeliness,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzContractTimeliness,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzContractTimeliness> findPageM(Page<WzContractTimeliness> page, WzContractTimeliness wzContractTimeliness,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzContractTimeliness,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzContractTimeliness initInsert(WzContractTimeliness wzContractTimeliness)  {
		return super.initInsert(wzContractTimeliness);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzContractTimeliness wzContractTimeliness) {
		super.checkSave(wzContractTimeliness);
	}

	@Transactional(readOnly = false)
	public WzContractTimeliness save(WzContractTimeliness wzContractTimeliness, boolean isNewRecord){
		return super.save(wzContractTimeliness,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzContractTimeliness> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzContractTimeliness wzContractTimeliness,String baseFilter){
		super.checkRemove(wzContractTimeliness,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzContractTimeliness wzContractTimeliness,String baseFilter) {
		super.delete(wzContractTimeliness,baseFilter);
	}
}