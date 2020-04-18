
package com.leleplus.project.system.service.impl;


import com.leleplus.common.exception.driver.DriverException;
import com.leleplus.common.utils.SecurityUtils;
import com.leleplus.common.utils.StringUtils;
import com.leleplus.core.web.domain.BaseEntity;
import com.leleplus.project.monitor.domain.SwipeRecord;
import com.leleplus.project.system.mapper.SwipeRFIDRecordSwipeMapper;
import com.leleplus.project.system.service.ISwipeRecordService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className SwipeRFIDRecordServiceImpl
 * @date 2020-04-18 10:53
 * @description 刷卡记录Service实现类
 */


@Service
public class SwipeRFIDRecordServiceImpl implements ISwipeRecordService {

	// logger日志全局初始化
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Resource
	private SwipeRFIDRecordSwipeMapper mapper;


	/**
	 * 查询所有
	 *
	 * @return 对象集合
	 */

	@Override
	public List<SwipeRecord> selectAll() {
		return mapper.select();
	}

	/**
	 * 分页查询所有的数据
	 *
	 * @param record
	 * @return
	 */
	@Override
	public List<SwipeRecord> selectAllByPage(SwipeRecord record) {
		return mapper.selectByPage(record);
	}

	/**
	 * 根据id查询单个对象
	 *
	 * @param id
	 * @return 对象
	 */

	@Override
	public SwipeRecord selectById(Long id) {
		if (id != null) {
			logger.error("select swipeRFIDRecord ,id is NULL !");
			throw new DriverException("swipeRFIDRecord.id.null");
		}
		return mapper.selectByPrimaryKey(id);
	}


	/**
	 * 通过其他任意类型参数查询
	 *
	 * @param t
	 * @return 对象
	 */

	@Override
	public <K> SwipeRecord selectByArg(K t) {
		return null;
	}

	/**
	 * 单个插入
	 *
	 * @param obj
	 * @return 主键id
	 */

	@Override
	public Long addByObject(SwipeRecord obj) {

		if (obj == null) {
			logger.error("insert into swipeRFIDRecord ,the object is null !");
			throw new DriverException("swipeRFIDRecord.object.null");
		}

		if (obj.getId() != null) {
			logger.error("insert into swipeRFIDRecord ,id not NULL !");
			throw new DriverException("swipeRFIDRecord.id.not.null");
		}

		if (obj.getRfidId() == null) {
			logger.error("insert into swipeRFIDRecord,the RFID is NULL !");
			throw new DriverException("swipeRFIDRecord.rfidId.not.null");
		}

		mapper.insert(obj);

		return obj.getId();
	}


	/**
	 * 批量插入
	 *
	 * @param objs
	 * @return 添加条数
	 */

	@Override
	public Long BatchAdd(List<SwipeRecord> objs) {
		return null;
	}


	/**
	 * 删除单个数据
	 *
	 * @param id
	 * @return 删除条数
	 */

	@Override
	public Long deleteByPrimaryKey(Long id) {
		return null;
	}


	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return 删除条数
	 */

	@Override
	public Long BatchDelete(String ids) {

		if (StringUtils.isEmpty(ids)) {
			logger.error("批量删除的id为空");
			throw new DriverException("swipeRFIDRecord.delete.id");
		}

		return mapper.deleteBatch(new BaseEntity()
				.setIds((Long[]) ConvertUtils.convert(ids.split("[,]"), Long.class))
				.setUpdateBy(SecurityUtils.getUsername()));
	}


	/**
	 * 单个更新
	 *
	 * @param swipeRFIDRecord 对象
	 * @return 更新条数
	 */

	@Override
	public Long updateByArg(SwipeRecord swipeRFIDRecord) {
		return null;
	}

	/**
	 * 批量更新
	 *
	 * @param objs 对象集合
	 * @return 更新条数
	 */

	@Override
	public Long BatchUpdate(List<SwipeRecord> objs) {
		return null;
	}

}

