package com.leleplus.enums;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName DriverExceptionEnum
 * @date 2020-01-19 17:44
 * @description 异常枚举类
 */
public enum DriverExceptionEnum {
    ;
    private String code;
    private String description;
    
    DriverExceptionEnum (String code, String description) {
        this.code = code;
        this.description = description;
    }
    
    public String getCode () {
        return code;
    }
    
    public String getDescription () {
        return description;
    }
}
