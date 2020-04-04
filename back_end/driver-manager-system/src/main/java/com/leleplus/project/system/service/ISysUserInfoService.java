package com.leleplus.project.system.service;

import com.leleplus.common.service.ICRUDService;
import com.leleplus.project.system.domain.DriverLicense;
import com.leleplus.project.system.domain.SysUserInfo;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @interfaceName ISysUserInfoService
 * @date 2020-04-03 15:49
 * @description 用户信息Service层
 */
public interface ISysUserInfoService extends ICRUDService<SysUserInfo> {

    /**
     * 查询报考人数最多的驾照类型
     *
     * @return
     */
    DriverLicense getMaxRegisterType();

}
