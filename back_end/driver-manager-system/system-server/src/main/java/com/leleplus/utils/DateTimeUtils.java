package com.leleplus.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName DateTimeUtils
 * @date 2020-01-21 21:38
 * @description 日期时间工具类
 */
public class DateTimeUtils {
    
    /**
     * 得到当前的系统时间，精确到毫秒
     *
     * @return
     */
    public static String getNowTimeToMs () {
        return new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒SSS").format(new Date(System.currentTimeMillis()));
    }
    
    /**
     * 得到当前时间
     * @param format 日期格式
     * @return 对应时间格式的日期
     */
    public static String getNowTime (String format) {
        try {
            return new SimpleDateFormat(format).format(new Date(System.currentTimeMillis()));
        }catch (Exception e){
            throw new RuntimeException("时间格式错误,不支持的日期格式 ----> "+format);
        }
    }
}
