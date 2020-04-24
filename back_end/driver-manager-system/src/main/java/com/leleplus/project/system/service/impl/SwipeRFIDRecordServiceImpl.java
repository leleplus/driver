
package com.leleplus.project.system.service.impl;


import com.leleplus.common.exception.driver.DriverException;
import com.leleplus.common.utils.SecurityUtils;
import com.leleplus.common.utils.StringUtils;
import com.leleplus.core.config.DriverSystemConfiguration;
import com.leleplus.core.redis.RedisCache;
import com.leleplus.core.web.domain.BaseEntity;
import com.leleplus.project.monitor.domain.SwipeRecord;
import com.leleplus.project.monitor.enums.SwipeType;
import com.leleplus.project.system.domain.RFIDCard;
import com.leleplus.project.system.mapper.SwipeRFIDRecordSwipeMapper;
import com.leleplus.project.system.service.IRFIDService;
import com.leleplus.project.system.service.ISwipeRecordService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

	@Autowired
	private RedisCache redisCache;

	@Autowired
	private IRFIDService rfidService;

	@Autowired
	private DriverSystemConfiguration configuration;


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
		List<SwipeRecord> swipeRecords = mapper.selectByPage(record);


		if (! CollectionUtils.isEmpty(swipeRecords)) {
			swipeRecords.forEach(item -> {
				if (item != null) {
					RFIDCard rfidCard = rfidService.selectById(item.getRfidId());
					if (rfidCard != null) {
						item.setPhynumber(rfidCard.getPhyNumber());
					}
				}
			});
		}
		return swipeRecords;
	}

	/**
	 * 注册卡
	 *
	 * @param machineId
	 * @param number
	 */
	@Override
	public void registerSwipe(String machineId, String number) {
		// 1. 查到RFID对象
		RFIDCard rfidCard = rfidService.selectByPhyNumber(number);

		// 卡存在，直接返回，不存在，新增再返回
		if (rfidCard == null) {
			rfidCard = new RFIDCard()
					.setPhyNumber(number)
					.setStatus("管理员授权")
					.setDeleted(false)
					.setIsNew(true);
			rfidCard.setRemark("自动创建");
			rfidService.addByObject(rfidCard);
		}


		// 2.获取存放在redis中的key值
		String swipeKey = configuration.getSwipeKey();
		Integer swipeTime = configuration.getSwipeTime();

		// 3.确保原来的key没有对应的值，删除之前key
		redisCache.deleteObject(swipeKey);

		// 4.将刷卡得到的对象缓存在redis中
		/**
		 * redis中存放时间为S，时间动态获取
		 */
		redisCache.setCacheObject(swipeKey, rfidCard, swipeTime, TimeUnit.SECONDS);

		logger.info("Save {} in redis cache,time -> {} ", rfidCard, swipeTime);
	}

	/**
	 * 普通刷卡记录
	 *
	 * @param machineId
	 * @param number
	 */
	@Override
	public void swipe(String machineId, String number) {

		// 查到卡片信息
		RFIDCard rfidCard = rfidService.selectByPhyNumber(number);

		if (rfidCard == null) {
			logger.error("查询不到对应的已登记卡片数据");
			throw new DriverException("查询不到对应的已登记卡片数据");
		}

		// 查询卡片持有者
//		UserRFID userRFID = rfidService.selectUserRFID(rfidCard.getId())
//				.stream()
//				.filter(item -> !item.getDeleted())
//				.collect(Collectors.toList())
//				.get(0);
//
//		if (userRFID == null) {
//			logger.error("该卡片没有持有者");
//			throw new DriverException("RFID.swipe.user.null");
//		}

		SwipeType[] status = new SwipeType[] {
				SwipeType.DOOR, SwipeType.CAR_DOOR, SwipeType.ACCELERATOR, SwipeType.GEAR
		};
		// 保存刷卡记录
		SwipeRecord swipe = SwipeRecord
				.swipe(1L, rfidCard.getId(), status[new Random().nextInt(4)], "正常", "普通刷卡", "");

		// 刷卡记录保存到数据库
		logger.info("新增刷卡记录 --> {}", addByObject(swipe));
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

