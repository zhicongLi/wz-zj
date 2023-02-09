/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package com.ims.common.launch;

import com.ims.common.constant.LauncherConstant;
import org.springblade.core.auto.service.AutoService;
import org.springblade.core.launch.constant.AppConstant;
import org.springblade.core.launch.service.LauncherService;
import org.springblade.core.launch.utils.PropsUtil;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

/**
 * 启动参数拓展
 *
 * @author smallchil
 */
@AutoService(LauncherService.class)
public class LauncherServiceImpl implements LauncherService {


	@Override
	public void launcher(SpringApplicationBuilder builder, String appName, String profile, boolean isLocalDev) {
		Properties props = System.getProperties();
		// 通用注册
		PropsUtil.setProperty(props, "spring.cloud.nacos.discovery.server-addr", LauncherConstant.nacosAddr(profile));
		PropsUtil.setProperty(props, "spring.cloud.nacos.config.server-addr", LauncherConstant.nacosAddr(profile));
		PropsUtil.setProperty(props, "spring.cloud.sentinel.transport.dashboard", LauncherConstant.sentinelAddr(profile));

		// dubbo注册
		PropsUtil.setProperty(props, "dubbo.application.name", appName);
		PropsUtil.setProperty(props, "dubbo.application.qos.enable", "false");
		PropsUtil.setProperty(props, "dubbo.protocol.name", "dubbo");
		PropsUtil.setProperty(props, "dubbo.registry.address", "nacos://" + LauncherConstant.nacosAddr(profile));
		PropsUtil.setProperty(props, "dubbo.version", AppConstant.APPLICATION_VERSION);
		PropsUtil.setProperty(props, "dubbo.scan.base-packages", AppConstant.BASE_PACKAGES);

		// seata注册地址
		PropsUtil.setProperty(props, "seata.service.grouplist.default", LauncherConstant.seataAddr(profile));
		// seata注册group格式
		PropsUtil.setProperty(props, "seata.tx-service-group", LauncherConstant.seataServiceGroup(appName));
		// seata配置服务group
		PropsUtil.setProperty(props, "seata.service.vgroup-mapping.".concat(LauncherConstant.seataServiceGroup(appName)), LauncherConstant.DEFAULT_MODE);
		// seata注册模式配置
		// PropsUtil.setProperty(props, "seata.registry.type", LauncherConstant.NACOS_MODE);
		// PropsUtil.setProperty(props, "seata.registry.nacos.server-addr", LauncherConstant.nacosAddr(profile));
		// PropsUtil.setProperty(props, "seata.config.type", LauncherConstant.NACOS_MODE);
		// PropsUtil.setProperty(props, "seata.config.nacos.server-addr", LauncherConstant.nacosAddr(profile));

	}

}
