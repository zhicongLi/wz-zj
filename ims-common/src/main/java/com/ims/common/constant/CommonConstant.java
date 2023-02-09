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

/**
 * 通用常量
 *
 * @author Chill
 */
public interface CommonConstant {

	/**
	 * sword 系统名
	 */
	String SWORD_NAME = "sword";

	/**
	 * saber 系统名
	 */
	String SABER_NAME = "saber";

	/**
	 * 顶级父节点id
	 */
	Integer TOP_PARENT_ID = 0;

	/**
	 * 顶级父节点名称
	 */
	String TOP_PARENT_NAME = "顶级";


	/**
	 * 默认密码
	 */
	String DEFAULT_PASSWORD = "123456";
	/**
	 * 目标管理微服务名称
	 */
	String APPLICATION_GOAL_NAME="ims-goal";
	/**
	 * 会议管理微服务名称
	 */
	String APPLICATION_MEET_NAME="ims-meet";
	/**
	 * 安全组织机构微服务名称
	 */
	String APPLICATION_ORG_NAME="ims-org";
	/**
	 * 安全检查与隐患治理微服务名称
	 */
	String APPLICATION_CHECK_NAME="wz-cg";

	/**
	 * 职业健康微服务名称 Healthy
	 */
	String APPLICATION_HEALTHY_NAME="sm-healthy";

	String APPPLICATION_WZCG_NAME="wz-cg";
}
