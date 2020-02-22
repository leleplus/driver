package com.leleplus.expand.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName SystemCodeEnum
 * @date 2020-02-2020 21:12
 * @description 系统代码枚举类
 */
@AllArgsConstructor
public enum SystemCodeEnum {

    /***用户身份代码*****/
    ID_STUDENT("_SYS_ID_A","学员"),
    ID_COACH("_SYS_ID_B","教练"),
    ID_ADMINISTRATOR("_SYS_ID_C","管理员"),
    ID_UNKNOWN("_SYS_ID_N","游客"),

    /****账户状态******/
    ACCOUNT_NORMAL("1","正常使用"),
    ;

    @Getter
    public String code;
    @Getter
    public String name;

}

