/**
 *
 */
package com.ims.wz.cg.service;



import com.ims.core.service.ICrudService;

import com.ims.wz.cg.entity.WzPlan;
import com.ims.wz.cg.dao.WzPlanDao;

import java.util.List;

/**
 * 物资采购计划Service
 * @author lizhicong
 * @version 2021-09-09
 */

public interface IWzPlanService extends ICrudService<WzPlan> {

    String getMaxCode(String createDate);

    String createCode(String createDept);

    List<WzPlan> getSelectPlan(String planNumber);
}
