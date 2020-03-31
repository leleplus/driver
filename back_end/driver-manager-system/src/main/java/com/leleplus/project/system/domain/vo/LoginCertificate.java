package com.leleplus.project.system.domain.vo;

import com.leleplus.common.enums.LoginType;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className LoginCertificate
 * @date 2020-03-30 23:56
 * @description 登录凭证
 */

@Accessors
public class LoginCertificate {

    // 用户名登录
    @Getter
    private String loginId;

    // 身份证号登录
    @Getter
    private String id_number;

    // 电话登录
    @Getter
    private String telPhone;

    // 邮箱登录
    @Getter
    private String email;

    // 记录登录类型
    @Getter
    private LoginType type;

    private LoginCertificate() {
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
        this.type = LoginType.USERNAME;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
        this.type = LoginType.IDCARD;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
        this.type = LoginType.TELPHONE;
    }

    public void setEmail(String email) {
        this.email = email;
        this.type = LoginType.EMAIL;
    }

    /**
     * 创建实例
     *
     * @return
     */
    public static LoginCertificate getInstance() {
        return new LoginCertificate();
    }


}
