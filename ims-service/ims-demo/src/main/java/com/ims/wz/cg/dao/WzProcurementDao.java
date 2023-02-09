/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzProcurement;

import java.util.List;

/**
 * wz_procurementDAO接口
 * @author lizhicong
 * @version 2022-06-28
 */
public interface WzProcurementDao extends CrudDao<WzProcurement> {

    List<WzProcurement> getSelectIndexValue(String time);

    List<WzProcurement> getSelectDate();
}
