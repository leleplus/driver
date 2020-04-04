package com.leleplus.common.exception.driver;

import com.leleplus.common.exception.BaseException;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className DriverException
 * @date 2020-04-03 17:59
 * @description Driver异常
 */
public class DriverException extends BaseException {
    private static final long serialVersionUID = -1293255067135073765L;

    public DriverException(String model,String code,Object[] args,String message){
        super(model,code,args,message);
    }


    public DriverException(String code){
        this("driver",code,null,null);
    }

}
