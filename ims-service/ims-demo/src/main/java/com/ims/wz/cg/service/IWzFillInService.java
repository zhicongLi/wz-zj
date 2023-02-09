/**
 *
 */
package com.ims.wz.cg.service;



import com.ims.core.service.ICrudService;

import com.ims.wz.cg.entity.WzFillIn;

import java.util.Map;

/**
 * 电厂填报表Service
 * @author lizhicong
 * @version 2022-08-18
 */

public interface IWzFillInService extends ICrudService<WzFillIn> {

    Float getSelectIndexValue(String indexCode, String orgId, String time);
}
