package com.leleplus.service;

import com.leleplus.expand.exceptions.DriverException;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName IUserService
 * @date 2020-01-21 22:03
 * @description 用户表Service接口
 */
public interface IUserService extends ICURDService {

    /**
     * 登陆系统
     * 通过 身份证号，手机号，邮箱，用户名都可以登陆
     * @param account 账户
     * @param password 密码
     * @param isRemember 是否记住密码
     * @return token
     */
    String login(String account,String password,boolean isRemember) throws DriverException, Exception;
}
