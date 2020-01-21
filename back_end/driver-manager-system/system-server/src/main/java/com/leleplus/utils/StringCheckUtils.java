package com.leleplus.utils;

import javax.validation.constraints.NotNull;
import java.util.regex.Pattern;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName StringCheckUtils
 * @date 2020-01-21 22:56
 * @description 字符串校验工具类
 */
public class StringCheckUtils {
    
    /**
     * 校验字符串是不是手机号
     * @param tel 手机号字符串
     * @return true | false
     */
    public static Boolean isTel (@NotNull CharSequence tel) {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        return Pattern.compile(regExp).matcher(tel).matches();
    }
}
