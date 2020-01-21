package com.leleplus.expand.result;

import com.leleplus.utils.DateTimeUtils;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName ResponseResult
 * @date 2020-01-21 20:33
 * @description 响应结果统一处理
 */

public class ResponseResult {
    
    /**
     * 返回前台响应的方法
     * @param resultEnum 枚举类，成功或者失败
     * @param data 数据
     * @param <T> 数据类型
     * @return 对应的数据类型
     */
    public static <T> Result back (ResultEnum resultEnum, T data) {
        return new Result<T>()
                .setStatusCode(resultEnum.getCode())
                .setMessage(resultEnum.getDesc())
                .setData(data)
                .setTime(getResponseTime());
    }
    
    @Data
    @Accessors(chain = true)
    private static class Result <T> {
        // 响应状态码
        private int statusCode;
        // 响应消息
        private String message;
        // 数据
        private T data;
        // 响应时间
        private String time;
    }
    
    /**
     * 获的响应时间的方法
     * @return 当前系统时间
     */
    private static String getResponseTime(){
        return DateTimeUtils.getNowTime("yyyy-MM-dd HH:mm:ss");
    }
}
