/**
 *
 */
package com.ims.wz.cg.service;



import com.ims.core.service.ICrudService;

import com.ims.wz.cg.entity.WzPurchaseRate;
import com.ims.wz.cg.dao.WzPurchaseRateDao;

import java.util.List;

/**
 * 集中 公开 上网采购率Service
 * @author lizhicong
 * @version 2022-08-18
 */

public interface IWzPurchaseRateService extends ICrudService<WzPurchaseRate> {

    List<WzPurchaseRate> getSelectIndexValue(String time);
}
