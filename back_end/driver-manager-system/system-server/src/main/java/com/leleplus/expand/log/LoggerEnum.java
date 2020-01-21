package com.leleplus.expand.log;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName LoggerEnum
 * @date 2020-01-15 22:19
 * @description 日志相关的枚举类
 */
public enum LoggerEnum {
    BUSINESS("business"),
    PLATFORM("platform"),
    DATABASES("databases"),
    ERROR("error");
    
    private String code;
    
    LoggerEnum (String code){
        this.code = code;
    }
    
    public String getCode () {
        return code;
    }
    
    public void setCode (String code) {
        this.code = code;
    }
}
