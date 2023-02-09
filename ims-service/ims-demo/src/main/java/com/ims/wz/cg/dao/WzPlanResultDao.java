/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzPlanResult;

/**
 * 非招标采购结果议题审批DAO接口
 * @author lizhicong
 * @version 2022-11-15
 */
public interface WzPlanResultDao extends CrudDao<WzPlanResult> {

    String getMaxCode(String createDate);
}
