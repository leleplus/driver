package com.leleplus.project.system.mapper;

import com.leleplus.core.web.domain.BaseEntity;
import com.leleplus.project.monitor.domain.SwipeRecord;

import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @interfaceName SwipeRFIDRecordSwipeMapper
 * @date 2020-04-18 10:56
 * @description 刷卡记录数据库接口
 */
public interface SwipeRFIDRecordSwipeMapper {

	/**
	 * 新增刷卡记录
	 *
	 * @param obj
	 * @return
	 */
	Long insert(SwipeRecord obj);

	/**
	 * 查询所有的刷卡记录
	 *
	 * @return
	 */
	List<SwipeRecord> select();

	/**
	 * 通过主键插叙
	 * @param id
	 * @return
	 */
	SwipeRecord selectByPrimaryKey(Long id);

	/**
	 * 批量删除
	 * @param setUpdateBy
	 * @return
	 */
	Long deleteBatch(BaseEntity setUpdateBy);

	/**
	 * 分页查询
	 * @param record
	 * @return
	 */
	List<SwipeRecord> selectByPage(SwipeRecord record);
}
