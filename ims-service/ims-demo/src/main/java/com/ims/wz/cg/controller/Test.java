package com.ims.wz.cg.controller;

import com.alibaba.fastjson.JSONArray;
import com.ims.idms.modules.sys.vo.SysUserVO;
import com.ims.idms.modules.utils.UserUtils;
import com.ims.wz.cg.entity.WzPlan;
import com.ims.wz.cg.utils.ZipUtil;
import org.springblade.core.tool.api.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/wz/file")
public class Test {

	@RequestMapping(value = "download")
	@ResponseBody
	public String test(String data,HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("文件下载路径地址data=============" + data);
		String path = "/file/" + UUID.randomUUID().toString().replaceAll("-","");
		String zipPath = path + "议题文件.zip";
		//设置返回响应头
		response.reset();
		List<String> list = JSONArray.parseArray(data,String.class);
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		for(String str : list){
			File file1 = new File(path + "/" + str.substring(str.lastIndexOf("/") + 1));
			URL url = new URL(str);
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setConnectTimeout(6000);
			urlCon.setReadTimeout(6000);
			urlCon.setRequestProperty("Accept-Charset", "utf-8");
			urlCon.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
			urlCon.setRequestProperty("Charset", "utf-8");
			int code = urlCon.getResponseCode();
			if (code != HttpURLConnection.HTTP_OK) {
				throw new Exception("文件读取失败");
			}
			InputStream in = urlCon.getInputStream();
			FileOutputStream out = new FileOutputStream(file1);

			byte[] buffer = new byte[2048];
			int count = 0;
			while ((count = in.read(buffer)) > 0) {
				out.write(buffer, 0, count);
			}
			out.flush();
			try {
				if(out!=null) {
					out.close();
				}
				if(in!=null) {
					in.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ZipUtil.ZipFile(file,zipPath);
		return zipPath;
	}

	@RequestMapping(value = "zipTest")
	@ResponseBody
	public void zipTest(HttpServletRequest request,HttpServletResponse response,String filePath) {
		try{
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			// 以流的形式下载文件。
			InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
			response.reset();
			// 设置response的Header
			// 自动判断下载文件类型
			response.setContentType("multipart/form-data");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(uuid + ".zip", "UTF-8"));
			OutputStream toClient = response.getOutputStream();
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}



	@RequestMapping(value = "test")
	@ResponseBody
	public void test(HttpServletRequest request,HttpServletResponse response,String filePath) {
		R<SysUserVO> sysUserVOR = UserUtils.currentUser();
		String deptId = sysUserVOR.getData().getDeptId();
	}
}
