/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzSupplierManagementService;

import com.ims.wz.cg.entity.WzSupplierManagement;
import com.ims.wz.cg.dao.WzSupplierManagementDao;


/**
 * 失信供应商处置Service
 * @author lizhicong
 * @version 2022-07-22
 */
@Service
@Transactional(readOnly = true)
public class WzSupplierManagementServiceImpl extends CrudServiceImpl<WzSupplierManagementDao, WzSupplierManagement> implements IWzSupplierManagementService{

 	public WzSupplierManagement get(WzSupplierManagement wzSupplierManagement) {
		return super.get(wzSupplierManagement);
	}

    public List<WzSupplierManagement> findList(WzSupplierManagement wzSupplierManagement) {
        return super.findList(wzSupplierManagement);
    }

	public List<WzSupplierManagement> findAllListM(WzSupplierManagement wzSupplierManagement,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzSupplierManagement,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzSupplierManagement> findPageM(Page<WzSupplierManagement> page, WzSupplierManagement wzSupplierManagement,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzSupplierManagement,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzSupplierManagement initInsert(WzSupplierManagement wzSupplierManagement)  {
		return super.initInsert(wzSupplierManagement);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzSupplierManagement wzSupplierManagement) {
		super.checkSave(wzSupplierManagement);
	}

	@Transactional(readOnly = false)
	public WzSupplierManagement save(WzSupplierManagement wzSupplierManagement, boolean isNewRecord){
		return super.save(wzSupplierManagement,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzSupplierManagement> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzSupplierManagement wzSupplierManagement,String baseFilter){
		super.checkRemove(wzSupplierManagement,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzSupplierManagement wzSupplierManagement,String baseFilter) {
		super.delete(wzSupplierManagement,baseFilter);
	}
}