/**
 *
 */
package com.ims.wz.cg.service;



import com.ims.core.service.ICrudService;

import com.ims.wz.cg.entity.WzIndexValue;
import com.ims.wz.cg.entity.WzProcurement;
import com.ims.wz.cg.dao.WzProcurementDao;

import java.util.List;

/**
 * wz_procurementService
 * @author lizhicong
 * @version 2022-06-28
 */

public interface IWzProcurementService extends ICrudService<WzProcurement> {

    List<WzProcurement> getSelectIndexValue(String time);

    List<WzProcurement> getSelectDate();
}
