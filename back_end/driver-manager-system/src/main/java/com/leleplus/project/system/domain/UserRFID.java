package com.leleplus.project.system.domain;

import com.leleplus.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className UserRFID
 * @date 2020-04-05 20:17
 * @description 用户和RFID关联实体
 */

@Data
@Accessors(chain = true)
public class UserRFID extends BaseEntity {

    private static final long serialVersionUID = -5369615691473953983L;

    // 用户信息Id
    private Long userInfoId;

    // 用户对应RFID的Id
    private Long rfidId;

    // 是否正常关联
    private Boolean deleted;

    // 一对多关系
    private RFIDCard cards;

}

