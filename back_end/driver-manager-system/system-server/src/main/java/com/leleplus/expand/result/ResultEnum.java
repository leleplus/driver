package com.leleplus.expand.result;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName ResultEnum
 * @date 2020-01-21 21:24
 * @description 响应结果枚举类
 */
@Accessors(chain = true)
public enum ResultEnum {
    // 成功
    SUCCESS(0, "successfully"),
    // 错误
    ERROR(-1, "error");

    @Getter
    private int code;

    @Setter
    @Getter
    private String message;
    
    ResultEnum (int code, String message) {
        this.code = code;
        this.message = message;
    }
}
