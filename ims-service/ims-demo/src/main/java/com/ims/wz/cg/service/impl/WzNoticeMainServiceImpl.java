/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ims.idms.modules.sys.vo.SysUserVO;
import com.ims.idms.modules.utils.UserUtils;
import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzNoticeMainService;

import com.ims.wz.cg.entity.WzNoticeMain;
import com.ims.wz.cg.dao.WzNoticeMainDao;


/**
 * wz_notice_mainService
 * @author lizhicong
 * @version 2021-12-27
 */
@Service
@Transactional(readOnly = true)
public class WzNoticeMainServiceImpl extends CrudServiceImpl<WzNoticeMainDao, WzNoticeMain> implements IWzNoticeMainService{

	@Autowired
	private WzNoticeMainDao wzNoticeMainDao;

 	public WzNoticeMain get(WzNoticeMain wzNoticeMain) {
		return super.get(wzNoticeMain);
	}

    public List<WzNoticeMain> findList(WzNoticeMain wzNoticeMain) {
        return super.findList(wzNoticeMain);
    }

	public List<WzNoticeMain> findAllListM(WzNoticeMain wzNoticeMain,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzNoticeMain,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzNoticeMain> findPageM(Page<WzNoticeMain> page, WzNoticeMain wzNoticeMain,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzNoticeMain,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzNoticeMain initInsert(WzNoticeMain wzNoticeMain)  {
		return super.initInsert(wzNoticeMain);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzNoticeMain wzNoticeMain) {
		super.checkSave(wzNoticeMain);
	}

	@Transactional(readOnly = false)
	public WzNoticeMain save(WzNoticeMain wzNoticeMain, boolean isNewRecord){
		if(isNewRecord){
			wzNoticeMain.setNumber(createNumber());
		}
		return super.save(wzNoticeMain,isNewRecord);
	}

	private String createNumber() {
		R<SysUserVO> sysUserVOR = UserUtils.currentUser();
		String deptId = sysUserVOR.getData().getDeptId();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		String createDate = simpleDateFormat.format(new Date());
		String year = createDate.substring(2,4);
		String month = createDate.substring(5,7);
		String maxcode = getMaxCode(createDate);
		String str = "";
		if("".equals(maxcode) || maxcode == null){
			str = "0";
		}else{
			str = String.valueOf(maxcode).substring(String.valueOf(maxcode).length()-3,String.valueOf(maxcode).length());
		}

		int max = 1000 + Integer.parseInt(str) + 1;
		String code = deptId + year + month + String.valueOf(max).substring(1);
		return code;
	}

	public String getMaxCode(String createDate){
 		return wzNoticeMainDao.getMaxCode(createDate);
	}

	@Transactional(readOnly = false)
    @Override
    public void insertList(List<WzNoticeMain> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzNoticeMain wzNoticeMain,String baseFilter){
		super.checkRemove(wzNoticeMain,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzNoticeMain wzNoticeMain,String baseFilter) {
		super.delete(wzNoticeMain,baseFilter);
	}
}
