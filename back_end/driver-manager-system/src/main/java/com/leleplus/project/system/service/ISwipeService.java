package com.leleplus.project.system.service;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @interfaceName ISwipeService
 * @date 2020-04-17 21:49
 * @description 刷卡接口Service
 */
public interface ISwipeService {

	// 管理员注册卡
	String REGISTER = "register";

	// 普通刷卡
	String NORMAL = "normal";


	/**
	 * 注册卡
	 * @param machineId
	 * @param number
	 */
	void registerSwipe(String machineId, String number);


	/**
	 * 普通刷卡记录
	 * @param machineId
	 * @param number
	 */
	void swipe(String machineId, String number);
}
