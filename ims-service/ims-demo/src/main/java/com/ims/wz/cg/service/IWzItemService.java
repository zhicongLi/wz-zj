/**
 *
 */
package com.ims.wz.cg.service;



import com.ims.core.service.ICrudService;

import com.ims.wz.cg.entity.WzItem;
import com.ims.wz.cg.dao.WzItemDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * wz_itemService
 * @author lizhicong
 * @version 2022-05-06
 */

public interface IWzItemService extends ICrudService<WzItem> {

    String exportWord(HttpServletRequest request, HttpServletResponse response, String id);
}
