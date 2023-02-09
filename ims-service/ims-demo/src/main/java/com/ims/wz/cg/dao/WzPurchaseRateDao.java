/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzPurchaseRate;

import java.util.List;

/**
 * 集中 公开 上网采购率DAO接口
 * @author lizhicong
 * @version 2022-08-18
 */
public interface WzPurchaseRateDao extends CrudDao<WzPurchaseRate> {

    List<WzPurchaseRate> getSelectIndexValue(String time);
}
