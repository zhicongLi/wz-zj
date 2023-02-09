/**
 *
 */
package com.ims.wz.cg.service;



import com.ims.core.service.ICrudService;

import com.ims.wz.cg.entity.WzPlanResult;
import com.ims.wz.cg.dao.WzPlanResultDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 非招标采购结果议题审批Service
 * @author lizhicong
 * @version 2022-11-15
 */

public interface IWzPlanResultService extends ICrudService<WzPlanResult> {

	String exportWord(HttpServletRequest request, HttpServletResponse response, String id);
}
