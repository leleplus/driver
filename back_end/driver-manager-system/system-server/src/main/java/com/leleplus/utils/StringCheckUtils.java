package com.leleplus.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 校验字符串是不是手机号
     *
     * @param tel 手机号字符串
     * @return true | false
     */
    public static Boolean isTel(@NotNull CharSequence tel) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (tel.length() != 11) return false;
        return Pattern.compile(regex).matcher(tel).matches();
    }

    /**
     * 身份证号合法性校验
     *
     * @param idCardNumber
     * @return
     */
    public static Boolean isIdCardNumber(@NotNull String idCardNumber) {
        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        final String regularExpression =
                "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|"
                        + "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

        boolean regResult = idCardNumber.matches(regularExpression);
        if (!regResult) return false;

        // 判断18位
        // 判断第18位校验值
        if (idCardNumber.length() != 18) return false;
        try {
            char[] charArray = idCardNumber.toCharArray();
            // 前十七位加权因子
            int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            // 这是除以11后，可能产生的11位余数对应的验证码
            String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
            int sum = 0;
            for (int i = 0; i < idCardWi.length; i++) {
                int current = Integer.parseInt(String.valueOf(charArray[i]));
                int count = current * idCardWi[i];
                sum += count;
            }
            char idCardLast = charArray[17];
            int idCardMod = sum % 11;
            //                        System.out.println("身份证最后一位:" + String.valueOf(idCardLast).toUpperCase()
            //                                + "错误,正确的应该是:" + idCardY[idCardMod].toUpperCase());
            return idCardY[idCardMod].toUpperCase()
                    .equals(String.valueOf(idCardLast).toUpperCase());

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 校验是否为邮箱格式
     * @param email
     * @return
     */
    public static Boolean isEmail(@NotNull String email) {
        String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    /**
     * 校验是否不包含中文和特殊字符
     * @param str
     * @return
     */
    public static Boolean isLegalUsername(@NotNull String str){
        String regex = "^[a-z0-9A-Z]+$";
        return str.matches(regex);
    }
}
