/**
 *
 */
package com.ims.wz.cg.service;



import com.ims.core.service.ICrudService;

import com.ims.wz.cg.entity.WzIndexValue;
import com.ims.wz.cg.dao.WzIndexValueDao;

import java.util.List;

/**
 * 指标数据表Service
 * @author lizhicong
 * @version 2022-06-20
 */

public interface IWzIndexValueService extends ICrudService<WzIndexValue> {

	List<WzIndexValue> selectIndexValue(String indexCode, String orgId, String time, String timeDimensionality);

	List<WzIndexValue> getSelectIndexValue(String indexCode, String orgId, String time,String timeDimensionality);

    List<WzIndexValue> getSelectIndexValueForYear(String indexCode);
}
