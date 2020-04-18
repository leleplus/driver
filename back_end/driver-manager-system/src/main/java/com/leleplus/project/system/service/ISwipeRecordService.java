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


	/**
	 * 分页查询所有的数据
	 * @param record
	 * @return
	 */
	List<SwipeRecord> selectAllByPage(SwipeRecord record);

}
