/**
 *
 */
package com.ims.wz.cg.service;



import com.ims.core.service.ICrudService;

import com.ims.wz.cg.entity.WzNoticeSon;
import com.ims.wz.cg.dao.WzNoticeSonDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * wz_notice_mainService
 * @author lizhicong
 * @version 2021-12-27
 */

public interface IWzNoticeSonService extends ICrudService<WzNoticeSon> {
	//导入模板下载
	String downLoad(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
