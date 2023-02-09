/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzNoticeSonService;

import com.ims.wz.cg.entity.WzNoticeSon;
import com.ims.wz.cg.dao.WzNoticeSonDao;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * wz_notice_mainService
 * @author lizhicong
 * @version 2021-12-27
 */
@Service
@Transactional(readOnly = true)
public class WzNoticeSonServiceImpl extends CrudServiceImpl<WzNoticeSonDao, WzNoticeSon> implements IWzNoticeSonService{

 	public WzNoticeSon get(WzNoticeSon wzNoticeSon) {
		return super.get(wzNoticeSon);
	}

    public List<WzNoticeSon> findList(WzNoticeSon wzNoticeSon) {
        return super.findList(wzNoticeSon);
    }

	public List<WzNoticeSon> findAllListM(WzNoticeSon wzNoticeSon,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzNoticeSon,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzNoticeSon> findPageM(Page<WzNoticeSon> page, WzNoticeSon wzNoticeSon,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzNoticeSon,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzNoticeSon initInsert(WzNoticeSon wzNoticeSon)  {
		return super.initInsert(wzNoticeSon);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzNoticeSon wzNoticeSon) {
		super.checkSave(wzNoticeSon);
	}

	@Transactional(readOnly = false)
	public WzNoticeSon save(WzNoticeSon wzNoticeSon, boolean isNewRecord){
		return super.save(wzNoticeSon,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzNoticeSon> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzNoticeSon wzNoticeSon,String baseFilter){
		super.checkRemove(wzNoticeSon,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzNoticeSon wzNoticeSon,String baseFilter) {
		super.delete(wzNoticeSon,baseFilter);
	}

	@Override
	public String downLoad(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletOutputStream out = null;
		FileInputStream ips = null;
		try{
			String url = this.getClass().getClassLoader().getResource("template/物资通知单.xls").getPath();
			File file = new File(url);
			if (!file.exists()){
				return null;
			}
			ips = new FileInputStream(file);
			response.setContentType("application/force-download");
			response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode("物资通知单.xls","UTF-8"));
			response.setContentLength((int)file.length());
			out = response.getOutputStream();
			int len = 0;
			byte[] buffer = new byte[1024*10];
			while((len = ips.read(buffer))!=-1){
				out.write(buffer,0,len);
			}
			out.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out != null){
				out.close();
			}
			if(ips != null){
				ips.close();
			}
		}
		return null;
	}
}
