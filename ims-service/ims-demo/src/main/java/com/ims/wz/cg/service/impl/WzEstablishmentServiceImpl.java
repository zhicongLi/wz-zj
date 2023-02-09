/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzEstablishmentService;

import com.ims.wz.cg.entity.WzEstablishment;
import com.ims.wz.cg.dao.WzEstablishmentDao;


/**
 * wz_establishmentService
 * @author lizhicong
 * @version 2021-10-11
 */
@Service
@Transactional(readOnly = true)
public class WzEstablishmentServiceImpl extends CrudServiceImpl<WzEstablishmentDao, WzEstablishment> implements IWzEstablishmentService{

 	public WzEstablishment get(WzEstablishment wzEstablishment) {
		return super.get(wzEstablishment);
	}

    public List<WzEstablishment> findList(WzEstablishment wzEstablishment) {
        return super.findList(wzEstablishment);
    }

	public List<WzEstablishment> findAllListM(WzEstablishment wzEstablishment,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzEstablishment,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzEstablishment> findPageM(Page<WzEstablishment> page, WzEstablishment wzEstablishment,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzEstablishment,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzEstablishment initInsert(WzEstablishment wzEstablishment)  {
		return super.initInsert(wzEstablishment);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzEstablishment wzEstablishment) {
		super.checkSave(wzEstablishment);
	}

	@Transactional(readOnly = false)
	public WzEstablishment save(WzEstablishment wzEstablishment, boolean isNewRecord){
		return super.save(wzEstablishment,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzEstablishment> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzEstablishment wzEstablishment,String baseFilter){
		super.checkRemove(wzEstablishment,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzEstablishment wzEstablishment,String baseFilter) {
		super.delete(wzEstablishment,baseFilter);
	}
}