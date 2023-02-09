/**
 *
 */
package com.ims.wz.cg.dao;

import com.ims.core.dao.CrudDao;
import com.ims.wz.cg.entity.WzFormApproval;

/**
 * wz_form_approvalDAO接口
 * @author yx
 * @version 2021-10-20
 */
public interface WzFormApprovalDao extends CrudDao<WzFormApproval> {

	String getMaxFormNumber();


}
