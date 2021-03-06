package com.leleplus.common.exception.user;


import com.leleplus.common.exception.BaseException;

/**
 * 用户信息异常类
 *
 * @author witt
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }

    public UserException(String code){
        super("user.info", code, null, null);
    }
}
