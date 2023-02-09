/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzItem;

/**
 * wz_itemDAO接口
 * @author lizhicong
 * @version 2022-05-06
 */
public interface WzItemDao extends CrudDao<WzItem> {

	String getMaxCode(String createDate);
}
