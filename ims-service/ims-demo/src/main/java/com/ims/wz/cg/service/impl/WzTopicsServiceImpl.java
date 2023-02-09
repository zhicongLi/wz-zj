/**
 *
 */
package com.ims.wz.cg.service.impl;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONArray;
import com.ims.core.utils.StringUtils;
import com.ims.idms.modules.sys.vo.SysUserVO;
import com.ims.idms.modules.utils.UserUtils;
import com.ims.wz.cg.entity.WzPlan;
import com.ims.wz.cg.entity.WzTopicsMetting;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.core.persistence.Page;
import com.ims.core.service.impl.CrudServiceImpl;

import com.ims.wz.cg.service.IWzTopicsService;

import com.ims.wz.cg.entity.WzTopics;
import com.ims.wz.cg.dao.WzTopicsDao;

import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

/**
 * wz_topicsService
 * @author lizhicong
 * @version 2021-09-23
 */
@Service
@Transactional(readOnly = true)
public class WzTopicsServiceImpl extends CrudServiceImpl<WzTopicsDao, WzTopics> implements IWzTopicsService{

	@Autowired
	private WzTopicsDao wzTopicsDao;

	@Lazy
	@Autowired
	private WzPlanServiceImpl wzPlanService;

	@Lazy
	@Autowired
	private WzTopicsMettingServiceImpl wzTopicsMettingService;

 	public WzTopics get(WzTopics wzTopics) {
		return super.get(wzTopics);
	}

    public List<WzTopics> findList(WzTopics wzTopics) {
        return super.findList(wzTopics);
    }

	public List<WzTopics> findAllListM(WzTopics wzTopics,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
	 	return super.findAllListM(wzTopics,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public Page<WzTopics> findPageM(Page<WzTopics> page, WzTopics wzTopics,String dataFilter,String baseFilter,String key,String baseQuery,String specQuery) {
		return super.findPageM(page, wzTopics,dataFilter,baseFilter,key,baseQuery,specQuery);
	}

	public WzTopics initInsert(WzTopics wzTopics)  {
		return super.initInsert(wzTopics);
	}

	@Transactional(readOnly = false)
	public void checkSave(WzTopics wzTopics) {
		super.checkSave(wzTopics);
	}

	@Transactional(readOnly = false)
	public WzTopics save(WzTopics wzTopics, boolean isNewRecord){
		if(isNewRecord){
			String uuid = UUID.randomUUID().toString();
			String id = uuid.replaceAll("-","");
			wzTopics.setCode(createCode());
			if("0".equals(wzTopics.getTopicsType())){
				wzTopics.setId(id);
				WzTopics wz = this.get(wzTopics.getZbplanId());
				wz.setZbplanSid(id);
				this.saveOrUpdate(wz);
			}
			if("1".equals(wzTopics.getTopicsType())){
				wzTopics.setId(id);
				WzTopics wz = this.get(wzTopics.getFzbplanId());
				wz.setFzbplanSid(id);
				this.saveOrUpdate(wz);
			}
		}else{
			if("0".equals(wzTopics.getTopicsType())){
				List<WzTopics> wz = wzTopicsDao.getWzTopics1(wzTopics.getId());
				WzTopics zbwz = wz.get(0);
				if(!wzTopics.getZbplanId().equals(zbwz.getId())){
					zbwz.setZbplanSid("");
					this.saveOrUpdate(zbwz);
					WzTopics wzTopics1 = this.get(wzTopics.getZbplanId());
					wzTopics1.setZbplanSid(wzTopics.getId());
					this.saveOrUpdate(wzTopics1);
				}
			}
			if("1".equals(wzTopics.getTopicsType())){
				List<WzTopics> wz = wzTopicsDao.getWzTopics(wzTopics.getId());
				WzTopics fzbwz = wz.get(0);
				if(!wzTopics.getFzbplanId().equals(fzbwz.getId())){
					fzbwz.setFzbplanSid("");
					this.saveOrUpdate(fzbwz);
					WzTopics wzTopics1 = this.get(wzTopics.getFzbplanId());
					wzTopics1.setFzbplanSid(wzTopics.getId());
					this.saveOrUpdate(wzTopics1);
				}
			}
		}
 		return super.save(wzTopics,isNewRecord);
	}

    @Transactional(readOnly = false)
    @Override
    public void insertList(List<WzTopics> list){
        super.insertList(list);
    }

	@Transactional(readOnly = false)
	public void checkRemove(WzTopics wzTopics,String baseFilter){
		super.checkRemove(wzTopics,baseFilter);
	}

	@Transactional(readOnly = false)
	public void delete(WzTopics wzTopics,String baseFilter) {
		 WzTopics w = this.get(wzTopics.getId());
		 if("0".equals(w.getTopicsType())){
			 List<WzTopics> wz = wzTopicsDao.getWzTopics1(wzTopics.getId());
			 WzTopics zbwz = wz.get(0);
			 zbwz.setZbplanSid("");
			 this.saveOrUpdate(zbwz);
		 }else if("1".equals(w.getTopicsType())){
			 List<WzTopics> wz = wzTopicsDao.getWzTopics(wzTopics.getId());
			 WzTopics fzbwz = wz.get(0);
			 fzbwz.setFzbplanSid("");
			 this.saveOrUpdate(fzbwz);
		 }
		 if(StringUtils.equals(w.getTopicsType(), "4") || StringUtils.equals(w.getTopicsType(), "5")){
			 WzPlan wzPlan = new WzPlan();
			 wzPlan.setId(w.getId());
			 wzPlan.setIsgenerate("1");
			 wzPlanService.saveOrUpdate(wzPlan);
		 }
		 super.delete(wzTopics,baseFilter);
	 }

	public String createCode(){
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
		String code = "YT" + deptId + year + month + String.valueOf(max).substring(1);
		return code;
	}

	public String getMaxCode(String createDate) {
		return wzTopicsDao.getMaxCode(createDate);
	}

	@Override
	public List<WzTopics> queryList(String id) {
		return wzTopicsDao.queryWzTopicsList(id);
	}

	@Override
	public List<WzTopics> findListOfMeet(WzTopics wzTopics) {
		return wzTopicsDao.findListOfMeet(wzTopics);
	}

	@Override
	public Boolean ZbToWord(String list, HttpServletResponse response){
		//招标结果议题集合
		List<WzTopics> wzTopicsList = JSONArray.parseArray(list,WzTopics.class);
		//会议主表数据
		if (CollectionUtils.isEmpty(wzTopicsList)) return false;
		WzTopicsMetting wzTopicsMetting = wzTopicsMettingService.get(wzTopicsList.get(0).getParentId());
		String filePath = "/zb.docx";
		File file = new File(filePath);
		if(file.exists() || file.length() > 0)file.delete();
		String[] title = new String[]{"投标人名称","开标价格（万元）","评标价格（万元）","价格得分（50%）","技术评分(40%)","商务评分(10%)","综合得分","综合排序","授标建议"};
		int[] tableWidths = {400,100,100,100,100,100,100,100,100};
		char[] cnArr = new char[]{'一','二','三','四','五','六','七','八','九','十'};
		//遍历导出word
		//创建word文档,并设置纸张的大小
		Document document = new Document(PageSize.A4);
		try {
			RtfWriter2.getInstance(document, new FileOutputStream(filePath, false));
			//打开document
			document.open();
			//标题
			Chapter chapter1 = new Chapter(1);
			//宋体
			BaseFont simsun = BaseFont.createFont("font/simsunb.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			//设置字体，字号，加粗，颜色
			Font font = new Font(simsun, 28, Font.BOLD, new Color(0, 0, 0));
			//设置新的段落，使其字体为font
			Paragraph p = new Paragraph("提请采委会审定招标项目", font);
			//设置段落居中，其中1为居中对齐，2为右对齐，3为左对齐
			p.setAlignment(1);
			p.setSpacingBefore(200f);
			//文档中加入该段落
			chapter1.add(p);
			font = new Font(simsun, 22, Font.NORMAL, new Color(0, 0, 0));
			//第一部分标题
			p = new Paragraph("（"+ wzTopicsMetting.getMettingName() + "）", font);
			p.setSpacingBefore(10f);
			p.setAlignment(1);
			chapter1.add(p);
			font = new Font(simsun, 18, Font.BOLD, new Color(0, 0, 0));
			p = new Paragraph("采购与物资管理部", font);
			p.setSpacingBefore(300f);
			p.setAlignment(1);
			chapter1.add(p);
			p = new Paragraph(new SimpleDateFormat("yyyy 年 MM 月 dd 日").format(wzTopicsMetting.getMettingTime()), font);
			p.setSpacingBefore(5f);
			p.setSpacingAfter(125f);
			p.setAlignment(1);
			chapter1.add(p);
			font = new Font(simsun, 16, Font.NORMAL, new Color(0, 0, 0));
			p = new Paragraph("需本次采委会会议审定的招标项目共" + wzTopicsList.size() + "个 :", font);
			chapter1.add(p);
			for(int i = 0;i < wzTopicsList.size();i ++){
				p = new Paragraph(i + 1 + "、" + wzTopicsList.get(i).getProjectName(), font);
				p.setFirstLineIndent(30f);
				chapter1.add(p);
			}
			p = new Paragraph("上述项目近期由中国神华国际工程有限公司组织评标，定标权属于江苏公司，现将采购结果提请会议审议。", font);
			p.setSpacingBefore(30f);
			p.setFirstLineIndent(30f);
			chapter1.add(p);
			document.add(chapter1);
			Chapter chapter2 = new Chapter(2);
			for(int i = 0;i < wzTopicsList.size();i ++){
				WzTopics wzTopics = wzTopicsList.get(i);
				font = new Font(simsun, 16, Font.BOLD, new Color(0, 0, 0));
				p = new Paragraph(cnArr[i] + "、" + wzTopics.getProjectName(), font);
				p.setFirstLineIndent(30f);
				chapter2.add(p);
				p = new Paragraph("（一）评标一览表", font);
				p.setSpacingBefore(5f);
				p.setFirstLineIndent(30f);
				p.setSpacingAfter(0);
				chapter2.add(p);
				Table table =new Table(9, 4);
				table.setAlignment(1);
				table.setWidth(100f);
				table.setWidths(tableWidths);
				for(String s:title) {
					//把表格上方的标题创建出来
					Cell cell = new Cell(s);
					//设置垂直居中
					cell.setVerticalAlignment(1);
					//设置水平居中
					cell.setHorizontalAlignment(1);
					table.addCell(cell);
				}
				Cell cell = new Cell(wzTopics.getBidder());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table.addCell(cell);
				cell = new Cell(wzTopics.getTenderPrice());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table.addCell(cell);
				cell = new Cell(wzTopics.getEvaluatePrice());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table.addCell(cell);
				cell = new Cell(wzTopics.getPriceNumber());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table.addCell(cell);
				cell = new Cell(wzTopics.getTechnologyNumber());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table.addCell(cell);
				cell = new Cell(wzTopics.getBusinessNumber());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table.addCell(cell);
				cell = new Cell(wzTopics.getComprehensiveNumber());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table.addCell(cell);
				cell = new Cell(wzTopics.getComprehensiveSort());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table.addCell(cell);
				cell = new Cell(wzTopics.getIndexProposal());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table.addCell(cell);
				cell = new Cell("最高限价");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table.addCell(cell);
				cell = new Cell("");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setColspan(8);
				table.addCell(cell);
				cell = new Cell("调价说明");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table.addCell(cell);
				cell = new Cell("无");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setColspan(8);
				table.addCell(cell);
				chapter2.add(table);
				p = new Paragraph("（二）评委会意见：", font);
				p.setFirstLineIndent(30f);
				chapter2.add(p);
				font = new Font(simsun, 16, Font.NORMAL, new Color(0, 0, 0));
				p = new Paragraph("首选中标候选人：" + wzTopics.getBidder(), font);
				p.setFirstLineIndent(30f);
				chapter2.add(p);
				p = new Paragraph("备选中标候选人：", font);
				p.setFirstLineIndent(30f);
				chapter2.add(p);
				font = new Font(simsun, 16, Font.BOLD, new Color(0, 0, 0));
				p = new Paragraph("（三）评标结果综合分析表", font);
				p.setFirstLineIndent(30f);
				chapter2.add(p);
				Table table1 =new Table(7, 16);
				table.setAlignment(1);
				table1.setWidth(100f);

				cell = new Cell("招标依据");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setColspan(2);
				table1.addCell(cell);
				cell = new Cell("");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setColspan(3);
				table1.addCell(cell);
				cell = new Cell("标的概算");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getEstimate());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell("招标范围");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setColspan(2);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getRange());
				cell.setVerticalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);

				cell = new Cell("招标文件主要要求");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setRowspan(4);
				table1.addCell(cell);
				cell = new Cell("主要资格条件");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getQualifications());
				cell.setVerticalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);
				cell = new Cell("主要技术质量要求");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getQualityRequirement());
				cell.setVerticalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);
				cell = new Cell("工期/交货期");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getDuration());
				cell.setVerticalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);
				cell = new Cell("付款比例");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getProportion());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);

				cell = new Cell("招标监督情况");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setRowspan(3);
				table1.addCell(cell);
				cell = new Cell("评委会是否试行回避");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(StringUtils.equals(wzTopics.getAvoid(), "0") ? "已执行回避" : "未执行回避");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setColspan(2);
				table1.addCell(cell);
				cell = new Cell("招标工作人员是否执行保密纪律");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(StringUtils.equals(wzTopics.getSecrecy(), "0") ? "已执行保密纪律" : "未执行保密纪律");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setColspan(2);
				table1.addCell(cell);
				cell = new Cell("异议、投诉情况");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(StringUtils.equals(wzTopics.getObjection(), "0") ? "无异议、投诉" : "有异议、投诉");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);
				cell = new Cell("总体情况");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getPopulation());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);

				cell = new Cell("首选中标投选人");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setRowspan(4);
				table1.addCell(cell);
				cell = new Cell("单位名称");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getCompanyName());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell("注册时间");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(StringUtils.isNotEmpty(wzTopics.getRegisterDate()) ? new SimpleDateFormat("yyyy年MM月dd日").format(new SimpleDateFormat("yyyy-MM-dd").parse(wzTopics.getRegisterDate())) : "");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell("注册地点");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getRegisterPlace());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell("相关资质");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell("");
				cell.setVerticalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);
				cell = new Cell("集团公司业绩");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getCompanyAchievement());
				cell.setVerticalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);
				cell = new Cell("其他业绩");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getOtherAchievement());
				cell.setVerticalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);

				cell = new Cell("综合分析");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setRowspan(2);
				table1.addCell(cell);
				cell = new Cell("首选中标候选人可能存在问题分析");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getProblemAnalysis());
				cell.setVerticalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);
				cell = new Cell("评标分析判断");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getScoreJudge());
				cell.setVerticalAlignment(1);
				cell.setColspan(5);
				table1.addCell(cell);

				cell = new Cell("招标人代表：");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				cell.setColspan(2);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getTenderee());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell("评标主任（组长）：");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getDiector());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell("监标人：");
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				cell = new Cell(wzTopics.getBidSupervisor());
				cell.setVerticalAlignment(1);
				cell.setHorizontalAlignment(1);
				table1.addCell(cell);
				chapter2.add(table1);
			}
			document.setPageSize(PageSize.A4.rotate());
			document.add(chapter2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		//关闭document
		document.close();
		return true;
	}

	@Override
	public Boolean FzbToWord(String list, HttpServletResponse response){
		//招标结果议题集合
		List<WzTopics> wzTopicsList = JSONArray.parseArray(list,WzTopics.class);
		//会议主表数据
		if (CollectionUtils.isEmpty(wzTopicsList)) return false;
		WzTopicsMetting wzTopicsMetting = wzTopicsMettingService.get(wzTopicsList.get(0).getParentId());
		String filePath = "/fzb.docx";
		File file = new File(filePath);
		if(file.exists() || file.length() > 0)file.delete();
		//遍历导出word
		//创建word文档,并设置纸张的大小
		Document document = new Document(PageSize.A4);
		try {
			RtfWriter2.getInstance(document, new FileOutputStream(filePath, false));
			//打开document
			document.open();
			document.setPageSize(PageSize.A4.rotate());
			//宋体
			BaseFont simsun = BaseFont.createFont("font/simsunb.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			//设置字体，字号，加粗，颜色
			Font font = new Font(simsun, 28, Font.BOLD, new Color(0, 0, 0));
			//设置新的段落，使其字体为font
			Paragraph p = new Paragraph("提请采委会审定非招标采购项目", font);
			//设置段落居中，其中1为居中对齐，2为右对齐，3为左对齐
			p.setAlignment(1);
			p.setSpacingBefore(130f);
			//文档中加入该段落发
			document.add(p);
			font = new Font(simsun, 22, Font.NORMAL, new Color(0, 0, 0));
			p = new Paragraph("（"+ wzTopicsMetting.getMettingName() + "）", font);
			p.setSpacingBefore(10f);
			p.setAlignment(1);
			document.add(p);
			font = new Font(simsun, 18, Font.BOLD, new Color(0, 0, 0));
			p = new Paragraph("燃料与物资采购管理部", font);
			p.setSpacingBefore(130f);
			p.setAlignment(1);
			document.add(p);
			p = new Paragraph(new SimpleDateFormat("yyyy 年 MM 月").format(wzTopicsMetting.getMettingTime()), font);
			p.setSpacingBefore(5f);
			p.setSpacingAfter(150f);
			p.setAlignment(1);
			document.add(p);
			List<WzTopics> wzlWzTopicsList = wzTopicsList.stream().filter(wzTopics -> StringUtils.equals(wzTopics.getTypes(), "2")).collect(Collectors.toList());
			List<WzTopics> gclWzTopicsList = wzTopicsList.stream().filter(wzTopics -> StringUtils.equals(wzTopics.getTypes(), "1")).collect(Collectors.toList());
			List<WzTopics> fwlWzTopicsList = wzTopicsList.stream().filter(wzTopics -> StringUtils.equals(wzTopics.getTypes(), "0")).collect(Collectors.toList());
			p = new Paragraph("物资类项目 " + wzlWzTopicsList.size() + " 个", font);
			p.setSpacingBefore(10f);
			p.setAlignment(1);
			document.add(p);
			document.add(toTable(wzlWzTopicsList));
			p = new Paragraph("工程类项目 " + gclWzTopicsList.size() + " 个", font);
			p.setSpacingBefore(10f);
			p.setAlignment(1);
			document.add(p);
			document.add(toTable(gclWzTopicsList));
			p = new Paragraph("服务类项目 " + fwlWzTopicsList.size() + " 个", font);
			p.setSpacingBefore(10f);
			p.setAlignment(1);
			document.add(p);
			document.add(toTable(fwlWzTopicsList));
			font = new Font(simsun, 14, Font.BOLD, new Color(0, 0, 0));
			p = new Paragraph("注：根据《江苏公司非招标采购实施办法（试行）》，上述项目采购评审结果，须由采购与招标管理委员会予以审议。", font);
			p.setSpacingBefore(10f);
			p.setAlignment(1);
			document.add(p);
		}catch (Exception e) {
			e.printStackTrace();
		}
		//关闭document
		document.close();
		return true;
	}

	private Table toTable(List<WzTopics> wzTopicsList) throws DocumentException {
		Table table =new Table(8, wzTopicsList.size() + 1);
		int[] tableWidths = {100,100,100,100,100,100,100,300};
		table.setAlignment(1);
		table.setWidth(100f);
		table.setWidths(tableWidths);
		Cell cell = new Cell("序 号");
		cell.setVerticalAlignment(1);
		cell.setHorizontalAlignment(1);
		cell.setRowspan(2);
		table.addCell(cell);
		cell = new Cell("项目名称");
		cell.setVerticalAlignment(1);
		cell.setHorizontalAlignment(1);
		cell.setRowspan(2);
		table.addCell(cell);
		cell = new Cell("采购预算");
		cell.setVerticalAlignment(1);
		cell.setHorizontalAlignment(1);
		table.addCell(cell);
		cell = new Cell("首  选");
		cell.setVerticalAlignment(1);
		cell.setHorizontalAlignment(1);
		cell.setColspan(2);
		table.addCell(cell);
		cell = new Cell("备  选");
		cell.setVerticalAlignment(1);
		cell.setHorizontalAlignment(1);
		cell.setColspan(2);
		table.addCell(cell);
		cell = new Cell("备  注");
		cell.setVerticalAlignment(1);
		cell.setHorizontalAlignment(1);
		cell.setRowspan(2);
		table.addCell(cell);
		cell = new Cell("（元，含税）");
		cell.setVerticalAlignment(1);
		cell.setHorizontalAlignment(1);
		table.addCell(cell);
		cell = new Cell("供应商名称");
		cell.setVerticalAlignment(1);
		cell.setHorizontalAlignment(1);
		table.addCell(cell);
		cell = new Cell("价格（元）");
		cell.setVerticalAlignment(1);
		cell.setHorizontalAlignment(1);
		table.addCell(cell);
		cell = new Cell("供应商名称");
		cell.setVerticalAlignment(1);
		cell.setHorizontalAlignment(1);
		table.addCell(cell);
		cell = new Cell("价格（元）");
		cell.setVerticalAlignment(1);
		cell.setHorizontalAlignment(1);
		table.addCell(cell);
		int i = 1;
		for (WzTopics wzTopics : wzTopicsList) {
			cell = new Cell(String.valueOf(i ++));
			cell.setVerticalAlignment(1);
			cell.setHorizontalAlignment(1);
			table.addCell(cell);
			cell = new Cell(wzTopics.getProjectName());
			cell.setVerticalAlignment(1);
			cell.setHorizontalAlignment(1);
			table.addCell(cell);
			cell = new Cell(wzTopics.getProcurementEstimate());
			cell.setVerticalAlignment(1);
			cell.setHorizontalAlignment(1);
			table.addCell(cell);
			cell = new Cell(wzTopics.getSupplierName());
			cell.setVerticalAlignment(1);
			cell.setHorizontalAlignment(1);
			table.addCell(cell);
			cell = new Cell(wzTopics.getSupplierPrice());
			cell.setVerticalAlignment(1);
			cell.setHorizontalAlignment(1);
			table.addCell(cell);
			cell = new Cell(wzTopics.getSubstituteName());
			cell.setVerticalAlignment(1);
			cell.setHorizontalAlignment(1);
			table.addCell(cell);
			cell = new Cell(wzTopics.getSubstitutePrice());
			cell.setVerticalAlignment(1);
			cell.setHorizontalAlignment(1);
			table.addCell(cell);
			String remark = "1、报价家数：" + wzTopics.getOfferNumber() + "个；2、是否否决报价：" + (StringUtils.equals(wzTopics.getIsoffer(), "1") ? "否" : "是") + "；否决报价说明：" + wzTopics.getOfferDetailed() +
				"；3、串标或其他供应商失信行为情形：" + wzTopics.getBehaviorDescription() + "；4、是否偏离概算：" + (StringUtils.equals(wzTopics.getIsestimate(), "1") ? "否" : "是") + "；偏离概算说明：" + wzTopics.getEstimateDetailed() +
				"；5、首选业绩情况：" + wzTopics.getFirstAchievement() + "；6、其他需要向采委汇报的下事项：" + wzTopics.getRemark() + "；";
			cell = new Cell(remark);
			cell.setVerticalAlignment(1);
			table.addCell(cell);
		}
		return table;
	}

	@Transactional(readOnly = false)
	public void updateTopicsStatus(String objId){
		WzTopics wzTopics = this.get(objId);
		if(wzTopics != null){
			wzTopics.setStatus("1");
			wzTopics.setIspass("0");
			wzTopics.setPassTime(new Date());
			this.saveOrUpdate(wzTopics);
		}
	}
}
