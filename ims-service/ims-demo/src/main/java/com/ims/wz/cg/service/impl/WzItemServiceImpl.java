/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import com.ims.idms.modules.sys.vo.SysUserVO;
import com.ims.idms.modules.utils.UserUtils;
import com.ims.wz.cg.utils.ExportWord;
import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzItemService;

import com.ims.wz.cg.entity.WzItem;
import com.ims.wz.cg.dao.WzItemDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * wz_itemService
 * @author lizhicong
 * @version 2022-05-06
 */
@Service
@Transactional(readOnly = true)
public class WzItemServiceImpl extends CrudServiceImpl<WzItemDao, WzItem> implements IWzItemService{

	@Autowired
	private WzItemDao wzItemDao;

 	public WzItem get(WzItem wzItem) {
		return super.get(wzItem);
	}

    public List<WzItem> findList(WzItem wzItem) {
        return super.findList(wzItem);
    }

	public List<WzItem> findAllListM(WzItem wzItem,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzItem,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzItem> findPageM(Page<WzItem> page, WzItem wzItem,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzItem,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzItem initInsert(WzItem wzItem)  {
		return super.initInsert(wzItem);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzItem wzItem) {
		super.checkSave(wzItem);
	}

	@Transactional(readOnly = false)
	public WzItem save(WzItem wzItem, boolean isNewRecord){
		if(isNewRecord){
			wzItem.setCode(createCode());
		}
 		return super.save(wzItem,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzItem> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzItem wzItem,String baseFilter){
		super.checkRemove(wzItem,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzItem wzItem,String baseFilter) {
		super.delete(wzItem,baseFilter);
	}

	public String createCode(){
		R<SysUserVO> sysUserVOR = UserUtils.currentUser();
		String deptId = sysUserVOR.getData().getUnitId();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		String createDate = simpleDateFormat.format(new Date());
		String year = createDate.substring(2,4);
		String month = createDate.substring(5,7);
		String maxcode = getMaxCode(createDate);
		String str = "";
		if("".equals(maxcode) || maxcode == null){
			str = "0";
		}else{
			str = maxcode.substring(maxcode.length()-3,maxcode.length());
		}

		int max = 1000 + Integer.parseInt(str) + 1;
		String code = deptId + year + month + String.valueOf(max).substring(1);
		return code;
	}

	public String getMaxCode(String createDate){
		return wzItemDao.getMaxCode(createDate);
	}

	public void saveOption(String id,String name,String opinion){
		WzItem wzItem = this.get(id);
		//需求部门
		if("1".equals(wzItem.getStatus())){
			wzItem.setXqbmMan(name);
			wzItem.setXqbmTime(new Date());
			//if("".equals(wzItem.getXqbmApproval())){
			wzItem.setXqbmApproval(opinion);
			//}
		}
		//专业归口部门经办人
		if("2".equals(wzItem.getStatus())){
			wzItem.setZygkjbMan(name);
			wzItem.setZygkjbTime(new Date());
			//if("".equals(wzItem.getZygkjbApproval())){
			wzItem.setZygkjbApproval(opinion);
			//}
		}
		//专业归口部门负责人
		if("3".equals(wzItem.getStatus())){
			wzItem.setZygkfzMan(name);
			wzItem.setZygkfzTime(new Date());
			//if("".equals(wzItem.getZygkfzApproval())){
			wzItem.setZygkfzApproval(opinion);
			//}
		}
		//采购管理部门经办人
		if("4".equals(wzItem.getStatus())){
			wzItem.setCggljbMan(name);
			wzItem.setCggljbTime(new Date());
			//if("".equals(wzItem.getCggljbApproval())){
			wzItem.setCggljbApproval(opinion);
			//}
		}
		//采购管理部门负责人
		if("5".equals(wzItem.getStatus())){
			wzItem.setCgglfzMan(name);
			wzItem.setCgglfzTime(new Date());
			//if("".equals(wzItem.getCgglfzApproval())){
			wzItem.setCgglfzApproval(opinion);
			//}
		}
		//财务部负责人
		if("6".equals(wzItem.getStatus())){
			wzItem.setCwbMan(name);
			wzItem.setCwbTime(new Date());
			//if("".equals(wzItem.getCwbApproval())){
			wzItem.setCwbApproval(opinion);
			//}
		}
		//分管业务领导
		if("7".equals(wzItem.getStatus())){
			wzItem.setFgldMan(name);
			wzItem.setFgldTime(new Date());
			//if("".equals(wzItem.getFgldApproval())){
			wzItem.setFgldApproval(opinion);
			//}
		}
		//分管采购领导
		if("8".equals(wzItem.getStatus())){
			wzItem.setFgcgMan(name);
			wzItem.setFgcgTime(new Date());
			//if("".equals(wzItem.getFgcgApproval())){
			wzItem.setFgcgApproval(opinion);
			//}
		}
		//公司主要负责人
		if("9".equals(wzItem.getStatus())){
			wzItem.setFzrMan(name);
			wzItem.setFzrTime(new Date());
			//if("".equals(wzItem.getFzrApproval())){
			wzItem.setFzrApproval(opinion);
			//}
		}
		//燃料物资部接收
		if("11".equals(wzItem.getStatus())){
			wzItem.setRlwzMan(name);
			//}
		}
		this.saveOrUpdate(wzItem);
	}

	@Override
	public String exportWord(HttpServletRequest request, HttpServletResponse response, String id) {
		WzItem wzItem = this.get(id);
		String wordPath = "template/采购立项审批表.docx";
		String fileName = wzItem.getCode() + "采购立项审批表";
		Map<String, Object> dataMap=new HashMap<>();

		dataMap.put("deptName",wzItem.getDeptName());
		dataMap.put("writeDate",returnDate(wzItem.getWriteDate()));
		dataMap.put("projectName",wzItem.getProjectName());
		dataMap.put("applicant",wzItem.getApplicant());
		dataMap.put("applicantPhone",wzItem.getApplicantPhone());
		String category = "";
		switch (wzItem.getCategory()){
			case "0":
				category = "服务";
				break;
			case "1":
				category = "工程";
				break;
			case "2":
				category = "物资";
				break;
		}
		dataMap.put("category",category);
		dataMap.put("yearPlanCode",wzItem.getYearPlanCode());
		String procurementMethod = "";
		switch(wzItem.getProcurementMethod()){
			case "0":
				procurementMethod = "邀请招标";
				break;
			case "1":
				procurementMethod = "公开招标";
				break;
			case "2":
				procurementMethod = "单一来源";
				break;
			case "3":
				procurementMethod = "询比价";
				break;
			case "4":
				procurementMethod = "竞争性谈判";
				break;
			case "5":
				procurementMethod = "竞价";
				break;
			case "6":
				procurementMethod = "直接采购";
				break;
			case "7":
				procurementMethod = "电商采购";
				break;
		}
		dataMap.put("procurementMethod",procurementMethod);
		String reviewMethod = "";
		switch(wzItem.getReviewMethod()){
			case "0":
				reviewMethod = "综合评估法（价格优先）";
				break;
			case "1":
				reviewMethod = "综合评估法（价格K值）";
				break;
			case "2":
				reviewMethod = "最低评审价格法（技术商务定性）";
				break;
			case "3":
				reviewMethod = "最低评审价格法（询价通知单）";
				break;
			case "4":
				reviewMethod = "单一来源";
				break;
			case "5":
				reviewMethod = "竞争性谈判";
				break;
			case "6":
				reviewMethod = "电商采购";
				break;
			case "7":
				reviewMethod = "直接采购";
				break;
		}
		dataMap.put("reviewMethod",reviewMethod);
		dataMap.put("budget",wzItem.getBudget());
		String moneyResource =  this.getSource(wzItem.getMoneyResource(),wzItem.getDetailedMoney(),wzItem.getOtherCost(),wzItem.getThreeCost());
		dataMap.put("moneyResource",moneyResource);
		String taxrate = "";
		switch(wzItem.getTaxrate()){
			case "0":
				taxrate = "0%";
				break;
			case "1":
				taxrate = "3%";
				break;
			case "2":
				taxrate = "6%";
				break;
			case "3":
				taxrate = "9%";
				break;
			case "4":
				taxrate = "13%";
				break;
			case "5":
				taxrate = "其他";
				break;
		}
		dataMap.put("taxrate",taxrate);
		dataMap.put("paymentMethod",wzItem.getPaymentMethod());
		String overBudget = "";
		switch(wzItem.getOverBudget()){
			case "0":
				overBudget = "是";
				break;
			case "1":
				overBudget = "否";
				break;
		}
		dataMap.put("overBudget",overBudget);
		dataMap.put("supplier",wzItem.getSupplier());
		dataMap.put("projectRange",wzItem.getProjectRange());
		dataMap.put("projectNecessity",wzItem.getProjectNecessity());
		dataMap.put("xqbmApproval",wzItem.getXqbmApproval());
		dataMap.put("xqbmMan",wzItem.getXqbmMan());
		dataMap.put("xqbmTime",returnDate(wzItem.getXqbmTime()));
		dataMap.put("zygkjbApproval",wzItem.getZygkjbApproval());
		dataMap.put("zygkjbMan",wzItem.getZygkjbMan());
		dataMap.put("zygkjbTime",returnDate(wzItem.getZygkjbTime()));
		dataMap.put("zygkfzApproval",wzItem.getZygkfzApproval());
		dataMap.put("zygkfzMan",wzItem.getZygkfzMan());
		dataMap.put("zygkfzTime",returnDate(wzItem.getZygkfzTime()));
		dataMap.put("cggljbApproval",wzItem.getCggljbApproval());
		dataMap.put("cggljbMan",wzItem.getCggljbMan());
		dataMap.put("cggljbTime",returnDate(wzItem.getCggljbTime()));
		dataMap.put("cgglfzApproval",wzItem.getCgglfzApproval());
		dataMap.put("cgglfzMan",wzItem.getCgglfzMan());
		dataMap.put("cgglfzTime",returnDate(wzItem.getCgglfzTime()));
		dataMap.put("cwbApproval",wzItem.getCwbApproval());
		dataMap.put("cwbMan",wzItem.getCwbMan());
		dataMap.put("cwbTime",returnDate(wzItem.getCwbTime()));
		dataMap.put("fgldApproval",wzItem.getFgldApproval());
		dataMap.put("fgldMan",wzItem.getFgldMan());
		dataMap.put("fgldTime",returnDate(wzItem.getFgldTime()));
		dataMap.put("fgcgApproval",wzItem.getFgcgApproval());
		dataMap.put("fgcgMan",wzItem.getFgcgMan());
		dataMap.put("fgcgTime",returnDate(wzItem.getFgcgTime()));
		dataMap.put("fzrApproval",wzItem.getFzrApproval());
		dataMap.put("fzrMan",wzItem.getFzrMan());
		dataMap.put("fzrTime",returnDate(wzItem.getFzrTime()));
		if(!StringUtils.isEmpty(wzItem.getApplicantCode())){
			dataMap.put("applicantCode",wzItem.getApplicantCode());
		}
		if(!StringUtils.isEmpty(wzItem.getRlwzMan())){
			dataMap.put("rlwzMan",wzItem.getRlwzMan());
		}
		if(wzItem.getEndTime() != null){
			dataMap.put("endTime",returnDate(wzItem.getEndTime()));
		}

		ExportWord.exportWord(wordPath,"/file",fileName,dataMap,request,response);

		return fileName;
	}

	public String getSource(String source1,String source2,String source3,String source4){
		String source = "";
		if("0".equals(source1)){
			if ("0".equals(source2)){
				source = "燃料费-燃煤";
			}
			if ("1".equals(source2)){
				source = "燃料费-燃油";
			}
			if ("2".equals(source2)){
				source = "燃料费-燃气";
			}
			if ("3".equals(source2)){
				source = "燃料费-秸秆";
			}
			if ("4".equals(source2)){
				source = "燃料费-垃圾";
			}
			if ("5".equals(source2)){
				source = "燃料费-分摊转出";
			}
			if ("6".equals(source2)){
				source = "燃料费-分摊转入";
			}
		}
		if("1".equals(source1)){
			if ("0".equals(source2)){
				source = "购入电（热）费-电费";
			}
			if ("1".equals(source2)){
				source = "购入电（热）费-热费";
			}
			if ("2".equals(source2)){
				source = "购入电（热）费-分摊转出";
			}
			if ("3".equals(source2)){
				source = "购入电（热）费-分摊转入";
			}
		}

		if("2".equals(source1)){
			if ("0".equals(source2)){
				source = "水费-外购税费";
			}
			if ("1".equals(source2)){
				source = "水费-水资源费";
			}
			if ("2".equals(source2)){
				source = "水费-库区维护基金";
			}
			if ("3".equals(source2)){
				source = "水费-分摊转出";
			}
			if ("4".equals(source2)){
				source = "水费-分摊转入";
			}
		}

		if("3".equals(source1)){
			if ("0".equals(source2)){
				source = "材料费-主要材料";
			}
			if ("1".equals(source2)){
				source = "材料费-辅助材料";
			}
			if ("2".equals(source2)){
				source = "材料费-分摊转出";
			}
			if ("3".equals(source2)){
				source = "材料费-分摊转入";
			}
		}

		if("4".equals(source1)){
			if ("0".equals(source2)){
				source = "修理费-A级检修";
				if("0".equals(source4)){
					source = "修理费-A级检修-标准项目";
				}
				if("1".equals(source4)){
					source = "修理费-A级检修-特殊项目";
				}
				if("2".equals(source4)){
					source = "修理费-A级检修-检修人工费";
				}
			}
			if ("1".equals(source2)){
				source = "修理费-B级检修";
				if("0".equals(source4)){
					source = "修理费-B级检修-标准项目";
				}
				if("1".equals(source4)){
					source = "修理费-B级检修-特殊项目";
				}
				if("2".equals(source4)){
					source = "修理费-B级检修-检修人工费";
				}
			}
			if ("2".equals(source2)){
				source = "修理费-C级检修";
				if("0".equals(source4)){
					source = "修理费-C级检修-标准项目";
				}
				if("1".equals(source4)){
					source = "修理费-C级检修-特殊项目";
				}
				if("2".equals(source4)){
					source = "修理费-C级检修-检修人工费";
				}
			}
			if ("3".equals(source2)){
				source = "修理费-重大非标";
			}
			if ("4".equals(source2)){
				source = "修理费-公用系统检修";
			}
			if ("5".equals(source2)){
				source = "修理费-道路修缮";
			}
			if ("6".equals(source2)){
				source = "修理费-房屋修缮";
			}
			if ("7".equals(source2)){
				source = "修理费-建筑物维护";
			}
			if ("8".equals(source2)){
				source = "修理费-其他修理";
			}
			if ("9".equals(source2)){
				source = "修理费-分摊转出";
			}
			if ("10".equals(source2)){
				source = "修理费-分摊转入";
			}
			if ("11".equals(source2)){
				source = "修理费-专项检修";
				if("0".equals(source4)){
					source = "修理费-专项检修-制粉系统专项";
				}
				if("1".equals(source4)){
					source = "修理费-专项检修-其他专项";
				}
			}
			if ("12".equals(source2)){
				source = "修理费-日常维护材料";
			}
		}
		if("5".equals(source1)){
			if ("0".equals(source2)){
				source = "生产运行费-技术服务费";
			}
			if ("1".equals(source2)){
				source = "生产运行费-试验校验费";
			}
			if ("2".equals(source2)){
				source = "生产运行费-发电权交易费";
			}
			if ("3".equals(source2)){
				source = "生产运行费-分摊转出";
			}
			if ("4".equals(source2)){
				source = "生产运行费-分摊转入";
			}
		}

		if("6".equals(source1)){
			if ("0".equals(source2)){
				source = "人工成本-职工工资";
			}
			if ("1".equals(source2)){
				source = "人工成本-职工福利费";
			}
			if ("2".equals(source2)){
				source = "人工成本-社会保险费";
			}
			if ("3".equals(source2)){
				source = "人工成本-住房公积金";
			}
			if ("4".equals(source2)){
				source = "人工成本-工会经费";
			}
			if ("5".equals(source2)){
				source = "人工成本-职工教育经费";
			}
			if ("6".equals(source2)){
				source = "人工成本-费货币性福利";
			}
			if ("7".equals(source2)){
				source = "人工成本-辞退福利";
			}
			if ("8".equals(source2)){
				source = "人工成本-股份支付";
			}
			if ("9".equals(source2)){
				source = "人工成本-劳务派遣费";
			}

		}
		if("7".equals(source1)){
			if ("0".equals(source2)){
				source = "政策性税费-土地适用费";
			}
			if ("1".equals(source2)){
				source = "政策性税费-土地损失补偿费";
			}
			if ("2".equals(source2)){
				source = "政策性税费-电力监督费";
			}
			if ("3".equals(source2)){
				source = "政策性税费-海域使用权";
			}
			if ("4".equals(source2)){
				source = "政策性税费-水利建设基金";
			}
			if ("5".equals(source2)){
				source = "政策性税费-防洪保安基金";
			}
			if ("6".equals(source2)){
				source = "政策性税费-残疾人保障金";
			}
			if ("7".equals(source2)){
				source = "政策性税费-堤围保护费";
			}
			if ("8".equals(source2)){
				source = "政策性税费-价格调节基金";
			}
			if ("9".equals(source2)){
				source = "政策性税费-河道治理费";
			}
			if ("10".equals(source2)){
				source = "政策性税费-地方综合税费";
			}
			if ("11".equals(source2)){
				source = "政策性税费-工业企业机构调整专项资金";
			}
			if ("12".equals(source2)){
				source = "政策性税费-环保支出";
			}

		}
		if("8".equals(source1)){
			if ("0".equals(source2)){
				source = "财产保险费-财产基本险";
			}
			if ("1".equals(source2)){
				source = "财产保险费-机器损坏险";
			}
			if ("2".equals(source2)){
				source = "财产保险费-公共责任险";
			}
			if ("3".equals(source2)){
				source = "财产保险费-营业中断险";
			}
			if ("4".equals(source2)){
				source = "财产保险费-环境污染责任险";
			}
			if ("5".equals(source2)){
				source = "财产保险费-其他财产保险";
			}
		}

		if("9".equals(source1)){
			if ("0".equals(source2)){
				source = "其他费用-业务招待费";
			}
			if ("1".equals(source2)){
				source = "其他费用-公务车辆费用";
			}
			if ("2".equals(source2)){
				source = "其他费用-出国（境）经费";
			}
			if ("3".equals(source2)){
				source = "其他费用-办公费";
			}
			if ("4".equals(source2)){
				source = "其他费用-差旅费";
			}
			if ("5".equals(source2)){
				source = "其他费用-会议费";
			}
			if ("6".equals(source2)){
				source = "其他费用-宣传费";
			}
			if ("7".equals(source2)){
				source = "其他费用-办公用交通费";
			}
			if ("8".equals(source2)){
				source = "其他费用-党组织工作经费";
			}
			if ("9".equals(source2)){
				source = "其他费用-董事会费";
			}
			if ("10".equals(source2)){
				source = "其他费用-诉讼费";
			}
			if ("11".equals(source2)){
				source = "其他费用-会员费";
			}
			if ("12".equals(source2)){
				source = "其他费用-水费";
			}
			if ("13".equals(source2)){
				source = "其他费用-电费";
			}
			if ("14".equals(source2)){
				source = "其他费用-取暖费";
			}
			if ("15".equals(source2)){
				source = "其他费用-燃气费";
			}
			if ("16".equals(source2)){
				source = "其他费用-物业服务费";
			}
			if ("17".equals(source2)){
				source = "其他费用-消防费";
			}
			if ("18".equals(source2)){
				source = "其他费用-绿化费";
			}
			if ("19".equals(source2)){
				source = "其他费用-中介费";
			}
			if ("20".equals(source2)){
				source = "其他费用-租赁费";
			}
			if ("21".equals(source2)){
				source = "其他费用-信息技术服务费";
			}
			if ("22".equals(source2)){
				source = "其他费用-存货盘盈盘亏及正常报废损失";
			}
			if ("23".equals(source2)){
				source = "其他费用-低值易耗品摊销";
			}
			if ("24".equals(source2)){
				source = "其他费用-劳务费";
			}
			if ("25".equals(source2)){
				source = "其他费用-仓储保管费";
			}
			if ("26".equals(source2)){
				source = "其他费用-安全防护费";
			}
			if ("27".equals(source2)){
				source = "其他费用-环保支出";
			}
			if ("28".equals(source2)){
				source = "其他费用-劳动保护费用";
			}
			if ("29".equals(source2)){
				source = "其他费用-河道维护费";
			}
			if ("30".equals(source2)){
				source = "其他费用-水文气象费";
			}
			if ("31".equals(source2)){
				source = "其他费用-技术转让费";
			}
			if ("32".equals(source2)){
				source = "其他费用-生产车辆费用";
			}
			if ("33".equals(source2)){
				source = "其他费用-青苗补偿费";
			}
			if ("34".equals(source2)){
				source = "其他费用-其他-"+ source3;
			}
			if ("35".equals(source2)){
				source = "其他费用-分摊转出";
			}
			if ("36".equals(source2)){
				source = "其他费用-分摊转入";
			}
			if("37".equals(source2)){
				source = "其他费用-警卫费";
			}

		}
		if("10".equals(source1)){
			source = "委托运营费  " + source3;
		}
		if("11".equals(source1)){
			source = "无形资产摊销  " + source3;
		}
		if("12".equals(source1)){
			source = "长期待摊销费用摊销  " + source3;
		}
		if("13".equals(source1)){
			source = "研究开发费  " + source3;
		}
		if("14".equals(source1)){
			source = "折旧费  " + source3;
		}
		if("15".equals(source1)){
			source = "技改费  " + source3;
		}
		if("16".equals(source1)){
			source = "基建费  " + source3;
		}
		if("17".equals(source1)){
			source = "科技费  " + source3;
		}
		if("18".equals(source1)){
			source = "信息化费用  " + source3;
		}


		return source;
	}

	public String returnDate(Date date){
 		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		return simpleDateFormat.format(date);
	}
}
