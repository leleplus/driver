package com.leleplus.expand.exceptions;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName DriverException
 * @date 2020-01-19 17:32
 * @description 系统异常处理类
 */
public class DriverException extends Exception {
    
    
    private static final long serialVersionUID = 61764579649765444L;
    
    private String errCode;
    
    public DriverException (String msg) {
        super(msg);
    }
    
    public DriverException (DriverExceptionEnum driverExceptionEnum) {
        super(driverExceptionEnum.getDescription());
        this.errCode = driverExceptionEnum.getCode();
    }
    
    public String getErrCode () {
        return errCode;
    }
}
