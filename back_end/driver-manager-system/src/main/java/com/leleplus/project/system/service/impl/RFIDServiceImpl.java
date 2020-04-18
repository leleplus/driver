package com.leleplus.project.system.service.impl;

import com.leleplus.common.exception.driver.DriverException;
import com.leleplus.common.exception.user.UserException;
import com.leleplus.common.utils.SecurityUtils;
import com.leleplus.common.utils.StringUtils;
import com.leleplus.core.config.DriverSystemConfiguration;
import com.leleplus.core.redis.RedisCache;
import com.leleplus.core.web.domain.BaseEntity;
import com.leleplus.project.system.domain.RFIDCard;
import com.leleplus.project.system.domain.UserRFID;
import com.leleplus.project.system.mapper.RFIDCardMapper;
import com.leleplus.project.system.service.IRFIDCardService;
import com.leleplus.project.system.service.ISwipeService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className RFIDServiceImpl
 * @date 2020-04-05 16:26
 * @description RFIDService实现类
 */

@Service
public class RFIDServiceImpl implements IRFIDCardService {
    private static final String swipeKey = DriverSystemConfiguration.getSwipeKey();

    // logger日志全局初始化
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RFIDCardMapper mapper;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISwipeService SwipeService;

    /**
     * 查询所有
     *
     * @return 对象集合
     */
    @Override
    public List<RFIDCard> selectAll() {
        return null;
    }

    /**
     * 根据id查询单个对象
     *
     * @param id
     * @return 对象
     */
    @Override
    public RFIDCard selectById(Long id) {
        if (id == null) {
            logger.error("查询RFID卡信息id为空");
            throw new UserException("RFID.select.id.notFound");
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
    public <K> RFIDCard selectByArg(K t) {
        return null;
    }

    /**
     * 单个插入
     *
     * @param obj
     * @return 主键id
     */
    @Override
    @Transactional
    public Long addByObject(RFIDCard obj) {
        if (obj == null) {
            logger.error("RFID信息对象为空");
            throw new UserException("RFID.object.notFound");
        }

        if (obj.getId() != null) {
            logger.error("新增RFID信息，id必须为空");
            throw new UserException("RFID.object.add.id");
        }

        if (StringUtils.isEmpty(obj.getPhyNumber())) {
            logger.error("RFID物理卡号为空！");
            throw new UserException("RFID.phy_number");
        }

        // 初始化值
        obj.setDeleted(false)
                .setCreateBy(SecurityUtils.getUsername());

        return mapper.insert(obj);
    }

    /**
     * 批量插入
     *
     * @param objs
     * @return 添加条数
     */
    @Override
    @Transactional
    public Long BatchAdd(List<RFIDCard> objs) {
        return null;
    }

    /**
     * 删除单个数据
     *
     * @param id
     * @return 删除条数
     */
    @Override
    @Transactional
    public Long deleteByPrimaryKey(Long id) {
        if (id == null) {
            logger.error("删除RFID信息，主键不能为空");
            throw new UserException("RFID.delete.id");
        }
        return mapper.deleteByPrimaryKey(new BaseEntity()
                .setId(id)
                .setUpdateBy(SecurityUtils.getUsername()));
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return 删除条数
     */
    @Override
    @Transactional
    public Long BatchDelete(String ids) {
        if (StringUtils.isEmpty(ids)) {
            logger.error("批量删除RFID信息，id不能为空！");
            throw new DriverException("RFID信息删除时，必须传id");
        }

        return mapper.deleteBatch(new BaseEntity()
                .setIds((Long[]) ConvertUtils.convert(ids.split("[,]"), Long.class))
                .setUpdateBy(SecurityUtils.getUsername()));
    }

    /**
     * 单个更新
     *
     * @param rfidCard 对象
     * @return 更新条数
     */
    @Override
    @Transactional
    public Long updateByArg(RFIDCard rfidCard) {
        if (rfidCard == null) {
            logger.error("RFID信息更新对象为空");
            throw new DriverException("RFID.object.notFound");
        }
        if (rfidCard.getId() == null) {
            logger.error("更新用户信息必须传id");
            throw new DriverException("RFID.update.id");
        }

        // 初始化默认值
        rfidCard.setUpdateBy(SecurityUtils.getUsername());

        return mapper.update(rfidCard);
    }

    /**
     * 批量更新
     *
     * @param objs 对象集合
     * @return 更新条数
     */
    @Override
    @Transactional
    public Long BatchUpdate(List<RFIDCard> objs) {
        return null;
    }


    /**
     * 根据条件分页查询RFID数据
     *
     * @param rfidCard
     * @return
     */
    @Override
    public List<RFIDCard> getAll(RFIDCard rfidCard) {
        return mapper.selectByPage(rfidCard);
    }

    /**
     * 通过物理卡号查询卡片信息，及刷卡操作
     *
     * @param phyId
     * @return
     */
    @Override
    public RFIDCard selectByPhyNumber(String phyId) {

        if (StringUtils.isEmpty(phyId)) {
            logger.error("物理卡号id为空");
            throw new DriverException("RFID.rw.phyNumber");
        }

//        if (StringUtils.isNull(card)) {
//            logger.info("查询到的卡片信息为空");
//            throw new DriverException("RFID.rw.object.notFound");
//        }
//        if (!card.getDeleted()) {
//            logger.info("此卡已经被注销！");
//            throw new DriverException("RFID.rw.deleted");
//        }
//        if (StringUtils.isNotEmpty(card.getStatus())) {
//            logger.info("卡片状态提示！");
//            throw new DriverException(card.getStatus());
//        }
        return mapper.selectByPhyNumber(phyId);
    }


    /**********************************          用户和RFID相关接口            *****************************/


    /**
     * 查询用户的RFID
     *
     * @param id
     * @return
     */
    @Override
    public List<UserRFID> selectUserRFID(Long id) {
        if (id == null) {
            logger.error("查询用户的RFID卡id不能为空");
            throw new DriverException("userRFID.id.notFound");
        }
        return mapper.selectAllUserRFID(id)
                .stream()
                .map(item -> item.setCards(selectById(item.getRfidId())))
                .collect(Collectors.toList());
    }

    /**
     * 绑定用户与RFID
     *
     * @param userRFID
     * @return
     */
    @Override
    public Long addUserRFID(UserRFID userRFID) {
        if (userRFID == null) {
            logger.error("用户关联RFID对象为空");
            throw new UserException("userRFID.object");
        }

        if (userRFID.getId() != null) {
            logger.error("用户绑定RFID，id必须为空");
            throw new UserException("userRFID.add.id");
        }

        if (StringUtils.isNull(userRFID.getUserInfoId())) {
            logger.error("为用户绑定RFID，用户为空");
            throw new UserException("userRFID.add.userInfoId");
        }
        if (StringUtils.isNull(userRFID.getRfidId())) {
            logger.error("为用户绑定RFID，RFID为空！");
            throw new UserException("userRFID.add.RFIDId");
        }
        // 初始化值
        userRFID.setDeleted(false)
                .setCreateBy(SecurityUtils.getUsername());

        // 新增之前，停用其余所有的RFID
//        new UserRFID().setUserInfoId(userRFID.getUserInfoId()).setDeleted(true).setUpdateBy(SecurityUtils.getUsername());
//        updateUserRFID();

        return mapper.insertUserRFID(userRFID);
    }

    /**
     * 更新用户和RFID的关系
     *
     * @param userRFID
     * @return
     */
    @Override
    public Long updateUserRFID(UserRFID userRFID) {
        if (userRFID == null) {
            logger.error("用户关联RFID对象为空");
            throw new DriverException("userRFID.object");
        }
        if (userRFID.getId() == null) {
            logger.error("更新用户信息必须传id");
            throw new DriverException("userRFID.update.id");
        }

        // 初始化默认值
        userRFID.setUpdateBy(SecurityUtils.getUsername());

        return mapper.updateUserRFID(userRFID);
    }

    /**
     * 删除关系
     *
     * @param userRFID
     * @return
     */
    @Override
    public Long deleteUserRFID(UserRFID userRFID) {
        if (userRFID == null) {
            logger.error("用户关联RFID对象为空");
            throw new UserException("userRFID.object");
        }


        // id 和  userinfoId,RFIDId不能同时为空
        if (userRFID.getId() == null && userRFID.getUserInfoId() == null && userRFID.getRfidId() == null) {
            logger.error("删除用户关联RFID信息，必选唯一指定关系");
            throw new DriverException("userRFID.delete");
        }

        userRFID.setUpdateBy(SecurityUtils.getUsername());
        return mapper.deleteUserRFID(userRFID);
    }

    /**
     * 给用户绑定RFID
     *
     * @param userInfoId
     * @return
     */
    @Override
    public Long bindUserRFID(Long userInfoId) {
        // 1.判空
        if (userInfoId == null) {
            logger.error("用户绑定RFID信息，用户id不能为空");
            throw new DriverException("userRFID.add.userInfoId");
        }

        // 2.轮询获取刷卡的物理卡号

        // 3.确保获取到后，用物理卡号去查系统中卡的id ，查不到，说明这张卡未在系统中注册，能查到，下一步

        // 4.获取到系统中的RFIDId，构建用户绑定卡对象，赋予默认值

        // 5.保存数据
        UserRFID userRFID = new UserRFID();
        userRFID.setCreateBy(SecurityUtils.getUsername());
        return addUserRFID(userRFID.setUserInfoId(userInfoId)
                .setDeleted(false));

    }

    /**
     * 刷卡方法
     *
     * @param number
     */
    @Override
    public void swipe(String machineId,String number) {

        logger.debug("当前刷卡设备号: {}，当前卡号: {}",machineId,number);

	    switch (machineId) {
		    case ISwipeService.REGISTER:
		    	SwipeService.registerSwipe(machineId,number);

			    break;
		    case ISwipeService.NORMAL:
			    SwipeService.swipe(machineId,number);
			    break;
	    }
    }

    /**
     * 前端轮询读卡方法
     *
     * @return
     */
    @Override
    public RFIDCard testing() {

        RFIDCard rfidCard = redisCache.getCacheObject(swipeKey);

        if (StringUtils.isNull(rfidCard)) {
            logger.info("查询到的卡片信息为空");
            throw new DriverException("RFID.rw.object.notFound");
        }

        return rfidCard;
    }

    /**
     * 通过RFID的id查询 查询这张卡的所有持有者
     *
     * @param rfidId
     * @return
     */
    @Override
    public List<UserRFID> getUserByRFID(Long rfidId) {

        if(rfidId == null){
            logger.error("查询卡片持有者，卡片id不能为空");
            throw new DriverException("RFID.select.id.notFound");
        }

        return mapper.selectByRFID(rfidId);
    }
}
