package com.leleplus.expand.exceptions;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName NullArgsException
 * @date 2020-01-21 20:19
 * @description 空参数异常
 */
public class NullArgsException extends DriverException {
    
    private static final long serialVersionUID = -1174637544617290281L;
    
    public NullArgsException (String msg) {
        super(msg);
    }
    
    public NullArgsException (DriverExceptionEnum driverExceptionEnum) {
        super(driverExceptionEnum);
    }
    
    @Override
    public String getErrCode () {
        return super.getErrCode();
    }
}
