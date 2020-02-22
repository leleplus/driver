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
@Data
@Accessors(chain = true)
public class ResponseResult {
    // 响应状态码
    private int statusCode;
    // 响应消息
    private String message;
    // 数据
    private Object data;
    // 响应时间
    private String time;
    /**
     * 返回前台响应的方法
     * @param resultEnum 枚举类，成功或者失败
     * @param data 数据
     * @return 对应的数据类型
     */
    public static ResponseResult back(ResultEnum resultEnum, Object data) {
        return new ResponseResult ()
                .setStatusCode(resultEnum.getCode())
                .setMessage(resultEnum.getMessage())
                .setData(data)
                .setTime(getResponseTime());
    }

    /**
     * 返回前台的响应，无数据
     * @param resultEnum
     * @return
     */
    public static ResponseResult back(ResultEnum resultEnum) {
        return new ResponseResult ()
                .setStatusCode(resultEnum.getCode())
                .setMessage(resultEnum.getMessage())
                .setTime(getResponseTime());
    }


    /**
     * 返回前台响应，异常
     * @param throwable
     * @return
     */
    public static ResponseResult back(Throwable throwable) {
        return new ResponseResult ()
                .setStatusCode(ResultEnum.ERROR.getCode())
                .setMessage(throwable.getMessage())
                .setTime(getResponseTime());
    }


    /**
     * 获的响应时间的方法
     * @return 当前系统时间
     */
    private static String getResponseTime(){
        return DateTimeUtils.getNowTime("yyyy-MM-dd HH:mm:ss");
    }
}
