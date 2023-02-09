package com.ims.wz.cg.controller;

import com.alibaba.fastjson.JSONArray;
import com.ims.wz.cg.utils.ZipUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/wz/downFile")
public class DownFile {

	@RequestMapping(value = "download")
	@ResponseBody
	public String generateFile(String data,String projectName,HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("文件下载路径地址data=============" + data);
		String path = "/file/topics/" + projectName;
		//String zipPath = path + projectName + ".zip";
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
		//ZipUtil.ZipFile(file,zipPath);
		return null;
	}

	@RequestMapping(value = "zipFile")
	@ResponseBody
	public void zipFile(HttpServletRequest request,HttpServletResponse response) {
		try{
			File file = new File("/file/topics");

			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			String filePath = "/file/" + uuid + ".zip";
			ZipUtil.ZipFile(file,filePath);
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
			deleteDir(file);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void deleteDir(File files) {
		//获取File对象中的所有文件，并将其放在数组中
		File[] listFiles = files.listFiles();
		//循环遍历数组
		for (File file: listFiles) {
			//如果是目录文件，则递归调用删除方法
			if (file.isDirectory()) {
				deleteDir(file);
			}
			//如果是文件，则删除
			file.delete();
		}
		//删除文件夹内所有文件后，再删除文件夹
		files.delete();
	}

}
