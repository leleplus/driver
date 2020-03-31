package com.leleplus.common.enums;

import lombok.Getter;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @enumName IdentityAssociationStatus
 * @date 2020-03-31 13:11
 * @description 身份关联状态枚举
 */
public enum IdentityAssociationStatus {
    NORMAL("_SYS_CS_ASSOC_1", "正常关联"),
    NORMAL_FINISHED("_SYS_CS_ASSOC_2", "正常已毕业"),
    EXPIRED("_SYS_CS_ASSOC_3", "失效已换绑"),

    // 数据不可用状态
    EXPIRED_deleted("_SYS_CS_ASSOC_3", "失效已注销"),

    ;


    @Getter
    private String code;

    @Getter
    private String description;

    IdentityAssociationStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
