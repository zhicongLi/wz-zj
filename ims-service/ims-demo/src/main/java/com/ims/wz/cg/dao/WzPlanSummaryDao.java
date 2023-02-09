/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzPlanSummary;

/**
 * wz_plan_summaryDAO接口
 * @author lizhicong
 * @version 2021-09-18
 */
public interface WzPlanSummaryDao extends CrudDao<WzPlanSummary> {

	void saveSummary(WzPlanSummary wzPlanSummary);
}
