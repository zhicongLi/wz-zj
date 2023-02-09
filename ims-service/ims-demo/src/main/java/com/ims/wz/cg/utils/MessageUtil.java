package com.ims.wz.cg.utils;

import com.ims.idms.modules.sys.feign.ISysUserClient;
import com.ims.idms.modules.sys.vo.SysUserVO;
import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class MessageUtil {

	@Autowired
	private static ISysUserClient sysUserClient;

	@Value("${ims.message}")
	private static String msgUrl;

	public static Object sendBpmMessage(String userId,String content){
		R<SysUserVO> sysUserVOR = sysUserClient.currentUser(userId);
		MultiValueMap map = new LinkedMultiValueMap();
		map.add("code", "wzcg");
		map.add("mobileList", sysUserVOR.getData().getPhone());
		map.add("content", content);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity responseEntity = restTemplate.postForEntity(msgUrl, map, String.class);
		Object body = responseEntity.getBody();
		return body;
	}
}
