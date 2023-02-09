/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzFillIn;

import java.util.Map;

/**
 * 电厂填报表DAO接口
 * @author lizhicong
 * @version 2022-08-18
 */
public interface WzFillInDao extends CrudDao<WzFillIn> {

    Float getSelectIndexValue(String indexCode,String orgId,String time);
}
