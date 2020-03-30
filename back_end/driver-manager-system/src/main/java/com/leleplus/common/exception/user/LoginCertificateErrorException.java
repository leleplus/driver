package com.leleplus.common.exception.user;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className LoginCertificateErrorException
 * @date 2020-03-31 0:41
 * @description 登录凭证过多异常
 */
public class LoginCertificateErrorException extends UserException {
    private static final long serialVersionUID = 5341433450500516892L;

    public LoginCertificateErrorException() {
        super("user.logincertificate.not.match", null);
    }
}
