package com.leleplus.common.enums;

import lombok.Getter;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @enumName LoginType
 * @date 2020-03-31 21:22
 * @description 登录类型
 */
@Getter
public enum LoginType {
    USERNAME(1, "用户名"),
    IDCARD(1, "身份证号"),
    TELPHONE(3, "手机号"),
    EMAIL(4, "邮箱");

    // 编码
    private Integer code;

    // 描述
    private String description;

    LoginType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
