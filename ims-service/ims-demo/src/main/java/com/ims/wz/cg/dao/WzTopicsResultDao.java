/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzTopicsResult;

/**
 * 非招标采购结果议题审批DAO接口
 * @author lizhicong
 * @version 2022-10-09
 */
public interface WzTopicsResultDao extends CrudDao<WzTopicsResult> {

    String getMaxCode(String createDate);
}
