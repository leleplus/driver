package com.leleplus.project.system.mapper;

import com.leleplus.core.web.domain.BaseEntity;
import com.leleplus.project.system.domain.RFIDCard;
import com.leleplus.project.system.domain.UserRFID;

import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @interfaceName RFIDCardMapper
 * @date 2020-04-05 16:29
 * @description RFIDCard数据库接口
 */
public interface RFIDCardMapper {


    List<RFIDCard> selectByPage(RFIDCard rfidCard);

    /**
     * 通过主键查询
     *
     * @param id
     * @return
     */

    RFIDCard selectByPrimaryKey(Long id);


    /**
     * 新增RFID卡片信息
     *
     * @param rfidCard
     * @return
     */
    Long insert(RFIDCard rfidCard);

    /**
     * 删除批量
     *
     * @param baseEntity
     * @return
     */
    Long deleteBatch(BaseEntity baseEntity);

    /**
     * 更新
     *
     * @param rfidCard
     * @return
     */
    Long update(RFIDCard rfidCard);

    /**
     * 删除,通过主键
     *
     * @param id
     * @return
     */
    Long deleteByPrimaryKey(BaseEntity entity);

    /**
     * 根据物理卡号查询
     *
     * @param phyId
     * @return
     */
    RFIDCard selectByPhyNumber(String phyId);


    /*************************************   用户和RFID关系操作    ************************************************/


    /**
     * 查询某个用户拥有的卡
     *
     * @param userInfoId
     * @return
     */
    List<UserRFID> selectAllUserRFID(Long userInfoId);

    /**
     * 绑定用户和卡的新关系
     *
     * @param userRFID
     * @return
     */
    Long insertUserRFID(UserRFID userRFID);

    /**
     * 更新用户持有的卡
     *
     * @param userRFID
     * @return
     */
    Long updateUserRFID(UserRFID userRFID);

    /**
     * 禁用用户的卡
     *
     * @param entity
     * @return
     */
    Long deleteUserRFID(UserRFID userRFID);
}
