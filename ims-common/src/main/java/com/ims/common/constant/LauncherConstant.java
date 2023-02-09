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
package com.ims.common.constant;

import org.springblade.core.launch.constant.AppConstant;
import org.springframework.util.StringUtils;

import static org.springblade.core.launch.constant.AppConstant.APPLICATION_NAME_PREFIX;

/**
 * 通用常量
 *
 * @author Chill
 */
public interface LauncherConstant {

	/**
	 * nacos namespace id
	 */
	String NACOS_NAMESPACE = "f447a694-519a-4255-95f9-bcbb5a5d6369";

	/**
	 * nacos dev 地址
	 */
	String NACOS_DEV_ADDR = "192.168.0.171:8848";

	/**
	 * nacos prod 地址
	 */
	String NACOS_PROD_ADDR = "10.204.111.236:8848";

	/**
	 * nacos test 地址
	 */
	String NACOS_TEST_ADDR = "172.30.0.48:8848";

	/**
	 * sentinel dev 地址
	 */
	String SENTINEL_DEV_ADDR = "127.0.0.1:8858";

	/**
	 * sentinel prod 地址
	 */
	String SENTINEL_PROD_ADDR = "172.30.0.58:8858";

	/**
	 * sentinel test 地址
	 */
	String SENTINEL_TEST_ADDR = "172.30.0.58:8858";

	/**
	 * seata dev 地址
	 */
	String SEATA_DEV_ADDR = "127.0.0.1:8091";

	/**
	 * seata prod 地址
	 */
	String SEATA_PROD_ADDR = "172.30.0.68:8091";

	/**
	 * seata test 地址
	 */
	String SEATA_TEST_ADDR = "172.30.0.68:8091";

	/**
	 * dbuuo提供者
	 */
	String APPLICATION_DUBBO_PROVIDER_NAME = APPLICATION_NAME_PREFIX + "dubbo-provider";

	/**
	 * dbuuo消费者
	 */
	String APPLICATION_DUBBO_CONSUMER_NAME = APPLICATION_NAME_PREFIX + "dubbo-consumer";

	/**
	 * seata订单
	 */
	String APPLICATION_SEATA_ORDER_NAME = APPLICATION_NAME_PREFIX + "seata-order";

	/**
	 * seata库存
	 */
	String APPLICATION_SEATA_STORAGE_NAME = APPLICATION_NAME_PREFIX + "seata-storage";

	/**
	 * easypoi
	 */
	String APPLICATION_EASYPOI_NAME = APPLICATION_NAME_PREFIX + "easypoi";

	/**
	 * kafka
	 */
	String APPLICATION_KAFKA_NAME = APPLICATION_NAME_PREFIX + "kafka";

	/**
	 * rabbit
	 */
	String APPLICATION_RABBIT_NAME = APPLICATION_NAME_PREFIX + "rabbit";

	/**
	 * stream消费者
	 */
	String APPLICATION_STREAM_CONSUMER_NAME = APPLICATION_NAME_PREFIX + "stream-consumer";

	/**
	 * stream生产者
	 */
	String APPLICATION_STREAM_PROVIDER_NAME = APPLICATION_NAME_PREFIX + "stream-provider";

	/**
	 * seata file模式
	 */
	String FILE_MODE = "file";

	/**
	 * seata nacos模式
	 */
	String NACOS_MODE = "nacos";

	/**
	 * seata default模式
	 */
	String DEFAULT_MODE = "default";

	/**
	 * seata group后缀
	 */
	String GROUP_NAME = "-group";

	/**
	 * seata 服务组格式
	 *
	 * @param appName 服务名
	 * @return group
	 */
	static String seataServiceGroup(String appName) {
		return appName.concat(GROUP_NAME);
	}

	/**
	 * 动态获取nacos地址
	 *
	 * @param profile 环境变量
	 * @return addr
	 */
	static String nacosAddr(String profile) {
		final String nacos_addr = System.getenv("NACOS_ADDR");

		System.out.println(nacos_addr);

		if(!StringUtils.isEmpty(nacos_addr)) {
			return nacos_addr;
		}
		switch (profile) {
			case (AppConstant.PROD_CODE):
				return NACOS_PROD_ADDR;
			case (AppConstant.TEST_CODE):
				return NACOS_TEST_ADDR;
			default:
				return NACOS_DEV_ADDR;
		}
	}

	/**
	 * 动态获取sentinel地址
	 *
	 * @param profile 环境变量
	 * @return addr
	 */
	static String sentinelAddr(String profile) {
		final String sentinel_addr = System.getenv("SENTINEL_ADDR");

		if(!StringUtils.isEmpty(sentinel_addr)) {
			return sentinel_addr;
		}
		switch (profile) {
			case (AppConstant.PROD_CODE):
				return SENTINEL_PROD_ADDR;
			case (AppConstant.TEST_CODE):
				return SENTINEL_TEST_ADDR;
			default:
				return SENTINEL_DEV_ADDR;
		}
	}

	/**
	 * 动态获取seata地址
	 *
	 * @param profile 环境变量
	 * @return addr
	 */
	static String seataAddr(String profile) {
		final String seata_addr = System.getenv("SEATA_ADDR");

		if(!StringUtils.isEmpty(seata_addr)) {
			return seata_addr;
		}
		switch (profile) {
			case (AppConstant.PROD_CODE):
				return SEATA_PROD_ADDR;
			case (AppConstant.TEST_CODE):
				return SEATA_TEST_ADDR;
			default:
				return SEATA_DEV_ADDR;
		}
	}

}
