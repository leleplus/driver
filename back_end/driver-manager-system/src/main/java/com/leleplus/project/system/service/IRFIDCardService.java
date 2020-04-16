package com.leleplus.project.system.service;

import com.leleplus.common.service.ICRUDService;
import com.leleplus.project.system.domain.RFIDCard;
import com.leleplus.project.system.domain.UserRFID;

import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @interfaceName IRFIDService
 * @date 2020-04-05 16:25
 * @description RFIDService层接口
 */
public interface IRFIDCardService extends ICRUDService<RFIDCard> {


    /**
     * 根据条件分页查询RFID数据
     *
     * @param rfidCard
     * @return
     */
    List<RFIDCard> getAll(RFIDCard rfidCard);

    /**
     * 通过物理卡号查询卡片信息，及刷卡操作
     *
     * @param phyId
     * @return
     */
    RFIDCard selectByPhyNumber(String phyId);

    /**********************     用户和卡片关联       *******************/


    /**
     * 查询用户的RFID
     *
     * @param id
     * @return
     */
    List<UserRFID> selectUserRFID(Long id);

    /**
     * 绑定用户与RFID
     *
     * @param userRFID
     * @return
     */
    Long addUserRFID(UserRFID userRFID);

    /**
     * 更新用户和RFID的关系
     *
     * @param userRFID
     * @return
     */
    Long updateUserRFID(UserRFID userRFID);


    /**
     * 删除关系
     *
     * @param userRFID
     * @return
     */
    Long deleteUserRFID(UserRFID userRFID);


    /**
     * 给用户绑定RFID
     *
     * @param userInfoId
     * @return
     */
    Long bindUserRFID(Long userInfoId);

    /**
     * 刷卡方法接口
     * @param machineId
     * @param number
     */
    void swipe(String machineId,String number);

    /**
     * 前端轮询读卡方法
     *
     * @return
     */
    RFIDCard testing();
}
