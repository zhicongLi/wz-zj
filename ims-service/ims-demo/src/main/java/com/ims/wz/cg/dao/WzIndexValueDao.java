/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzIndexValue;

import java.util.List;

/**
 * 指标数据表DAO接口
 * @author lizhicong
 * @version 2022-06-20
 */
public interface WzIndexValueDao extends CrudDao<WzIndexValue> {

	List<WzIndexValue> selectIndexValue(String indexCode, String orgId, String time, String timeDimensionality);

	List<WzIndexValue> getSelectIndexValue(List date, String orgId, String time,String timeDimensionality);

	List<WzIndexValue> getSelectIndexValueForYear(String indexCode);
}
