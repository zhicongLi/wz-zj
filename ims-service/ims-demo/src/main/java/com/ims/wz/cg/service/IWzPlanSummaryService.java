/**
 *
 */
package com.ims.wz.cg.service;



import com.ims.core.service.ICrudService;

import com.ims.wz.cg.entity.WzPlanSummary;

/**
 * wz_plan_summaryService
 * @author lizhicong
 * @version 2021-09-18
 */

public interface IWzPlanSummaryService extends ICrudService<WzPlanSummary> {

	void saveSummary(WzPlanSummary wzPlanSummary);
}
