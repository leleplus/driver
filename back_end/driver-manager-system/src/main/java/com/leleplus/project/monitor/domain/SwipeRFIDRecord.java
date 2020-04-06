package com.leleplus.project.monitor.domain;

import com.leleplus.common.utils.SecurityUtils;
import com.leleplus.core.web.domain.BaseEntity;
import com.leleplus.project.monitor.enums.SwipeType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className SwipeRFIDRecord
 * @date 2020-04-06 21:16
 * @description 刷卡记录实体对象
 */

@Data
@Accessors(chain = true)
public class SwipeRFIDRecord extends BaseEntity {
    private static final long serialVersionUID = 7311903055885283542L;

    // RFID主键
    private Long rfidId;

    // 刷卡人id
    private Long userInfoId;

    // 刷卡类型
    private String swipeType;

    // 状态
    private String status;

    // 活动记录
    private String action;


    /**
     * 获的实例对象
     *
     * @return
     */
    public static SwipeRFIDRecord getInstance() {
        return new SwipeRFIDRecord();
    }

    /**
     * 刷卡记录方法
     *
     * @param userInfoId
     * @param rfidId
     * @param type
     * @param status
     * @param action
     * @param remark
     * @return
     */
    public static SwipeRFIDRecord swipe(Long userInfoId, Long rfidId, SwipeType type, String status, String action, String remark) {
        SwipeRFIDRecord swipe = getInstance()
                .setUserInfoId(userInfoId)
                .setRfidId(rfidId)
                .setSwipeType(type.getCode())
                .setStatus(status)
                .setAction(action);
        swipe.setCreateBy(SecurityUtils.getUsername());
        swipe.setRemark(remark);
        return swipe;
    }
}
