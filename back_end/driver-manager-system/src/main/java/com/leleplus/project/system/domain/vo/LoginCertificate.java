package com.leleplus.project.system.domain.vo;

import lombok.Data;
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

@Data
@Accessors
public class LoginCertificate {

    // 用户名登录
    private String loginId;

    // 身份证号登录
    private String id_number;

    // 电话登录
    private String telPhone;

    // 邮箱登录
    private String email;

    private LoginCertificate() {
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
