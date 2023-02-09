/**
 *
 */
package com.ims.wz.cg.service;



import com.ims.core.service.ICrudService;

import com.ims.wz.cg.entity.WzTopics;
import com.ims.wz.cg.dao.WzTopicsDao;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * wz_topicsService
 * @author lizhicong
 * @version 2021-09-23
 */

public interface IWzTopicsService extends ICrudService<WzTopics> {

    List<WzTopics> queryList(String id);

	List<WzTopics> findListOfMeet(WzTopics wzTopics);

	Boolean ZbToWord(String wzTopicsList, HttpServletResponse response);

	Boolean FzbToWord(String wzTopicsList, HttpServletResponse response);
}
