package com.leleplus.project.system.service.impl;

import com.leleplus.common.exception.driver.DriverException;
import com.leleplus.core.config.DriverSystemConfiguration;
import com.leleplus.core.redis.RedisCache;
import com.leleplus.project.monitor.domain.SwipeRecord;
import com.leleplus.project.monitor.enums.SwipeType;
import com.leleplus.project.system.domain.RFIDCard;
import com.leleplus.project.system.domain.UserRFID;
import com.leleplus.project.system.service.IRFIDCardService;
import com.leleplus.project.system.service.ISwipeRecordService;
import com.leleplus.project.system.service.ISwipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className SwipeServiceImpl
 * @date 2020-04-17 21:53
 * @description 刷卡Service实现类
 */
@Service
public class SwipeServiceImpl implements ISwipeService {


	// logger日志全局初始化
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IRFIDCardService rfidCardService;

	@Autowired
	private ISwipeRecordService swipeRecordService;

	@Autowired
	private RedisCache redisCache;


	/**
	 * 注册卡
	 *
	 * @param machineId
	 * @param number
	 */
	@Override
	public void registerSwipe(String machineId, String number) {
		// 1. 查到RFID对象
		RFIDCard rfidCard = rfidCardService.selectByPhyNumber(number);

		// 卡存在，直接返回，不存在，新增再返回
		if(rfidCard == null){
			rfidCard = new RFIDCard()
			.setPhyNumber(number)
					.setStatus("管理员授权")
					.setDeleted(false)
					.setIsNew(true);
			rfidCard.setRemark("自动创建");
			rfidCardService.addByObject(rfidCard);
		}


		// 2.获取存放在redis中的key值
		String swipeKey = DriverSystemConfiguration.getSwipeKey();
		Integer swipeTime = DriverSystemConfiguration.getSwipeTime();

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
		RFIDCard rfidCard = rfidCardService.selectByPhyNumber(number);


		// 查询卡片持有者
		UserRFID userRFID = rfidCardService.selectUserRFID(rfidCard.getId())
				.stream()
				.filter(item -> ! item.getDeleted())
				.collect(Collectors.toList())
				.get(0);

		if (userRFID == null) {
			logger.error("该卡片没有持有者");
			throw new DriverException("RFID.swipe.user.null");
		}
		// 保存刷卡记录
		SwipeRecord swipe = SwipeRecord
				.swipe(userRFID.getUserInfoId(), rfidCard.getId(), SwipeType.DOOR, "正常", "普通刷卡", "");

		// 刷卡记录保存到数据库
		logger.info("新增刷卡记录 --> {}", swipeRecordService.addByObject(swipe));
	}
}
