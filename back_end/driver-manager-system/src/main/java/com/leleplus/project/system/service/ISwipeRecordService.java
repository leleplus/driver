package com.leleplus.project.system.service;

import com.leleplus.common.service.ICRUDService;
import com.leleplus.project.monitor.domain.SwipeRecord;

import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @interfaceName ISwipeRecordService
 * @date 2020-04-18 0:29
 * @description 刷卡记录接口
 */
public interface ISwipeRecordService extends ICRUDService<SwipeRecord> {

	// 管理员注册卡
	String REGISTER = "register";

	// 普通刷卡
	String NORMAL = "normal";

	/**
	 * 分页查询所有的数据
	 * @param record
	 * @return
	 */
	List<SwipeRecord> selectAllByPage(SwipeRecord record);


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
