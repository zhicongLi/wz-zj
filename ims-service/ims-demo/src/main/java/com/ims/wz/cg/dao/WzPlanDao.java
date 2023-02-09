/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzPlan;
import com.ims.wz.cg.entity.WzTopics;

import java.util.List;

/**
 * 物资采购计划DAO接口
 * @author lizhicong
 * @version 2021-09-09
 */
public interface WzPlanDao extends CrudDao<WzPlan> {

	String getMaxCode(String createDate);
	//根据汇总id查询相关采购计划
	List<WzPlan> queryList(String objId);
	//根据表单id查询计划
    List<WzPlan> getSelectPlan(String planNumber);
	//关联计划结果删除 修改result_id
    void updateWzPlanResultId(String id);
}
