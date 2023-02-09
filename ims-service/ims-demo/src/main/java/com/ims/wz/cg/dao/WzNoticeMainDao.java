/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzNoticeMain;

/**
 * wz_notice_mainDAO接口
 * @author lizhicong
 * @version 2021-12-27
 */
public interface WzNoticeMainDao extends CrudDao<WzNoticeMain> {

    String getMaxCode(String createDate);
}
