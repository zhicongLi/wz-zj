/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzTopics;
import java.util.List;

/**
 * wz_topicsDAO接口
 * @author lizhicong
 * @version 2021-09-23
 */
public interface WzTopicsDao extends CrudDao<WzTopics> {

    String getMaxCode(String createDate);

	List<WzTopics> queryWzTopicsList(String id);

    List<WzTopics> getWzTopics(String id);

	List<WzTopics> getWzTopics1(String id);

	List<WzTopics> findListOfMeet(WzTopics wzTopics);
}
