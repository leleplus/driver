package com.leleplus.utils;


import com.leleplus.expand.log.LoggerEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName LoggersUtils
 * @date 2020-01-15 22:16
 * @description 日志工具类
 */
public class LoggersUtils {
    
    /**
     * 获取业务日志
     * @return
     */
    public static Logger getBusinessLogger () {
        return LoggerFactory.getLogger(LoggerEnum.BUSINESS.getCode());
    }
    
    /**
     * 获取平台日志
     * @return
     */
    public static Logger getPlatformLogger () {
        return LoggerFactory.getLogger(LoggerEnum.PLATFORM.getCode());
    }
    
    /**
     * 获取数据库日志
     * @return
     */
    public static Logger getDatabasesLogger () {
        return LoggerFactory.getLogger(LoggerEnum.DATABASES.getCode());
    }
    
    /**
     * 获取错误日志
     * @return
     */
    public static Logger getErrorLogger () {
        return LoggerFactory.getLogger(LoggerEnum.ERROR.getCode());
    }
    
    /**
     * 获得任意类型的日志
     * @param loggerEnum LoggerEnum类型的对象，为空，获取平台日志
     * @return
     */
    public static Logger getAnyLogger(LoggerEnum loggerEnum){
        if(loggerEnum != null)
            return LoggerFactory.getLogger(loggerEnum.getCode());
        return getPlatformLogger();
    }
    
    /**
     * 获得所有的日志
     * @return List集合
     */
    public static List<Logger> getAllLogger(){
        List<Logger> list = new ArrayList<>();
        list.add(getBusinessLogger());
        list.add(getPlatformLogger());
        list.add(getErrorLogger());
        list.add(getDatabasesLogger());
        return list;
    }
}
