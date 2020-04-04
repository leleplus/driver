package com.leleplus.project.system.mapper;

import com.leleplus.core.web.domain.BaseEntity;
import com.leleplus.project.system.domain.DriverLicense;
import com.leleplus.project.system.domain.SysUserInfo;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @interfaceName SysUserInfoMapper
 * @date 2020-04-03 16:25
 * @description 用户信息数据库接口
 */
public interface SysUserInfoMapper {

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    SysUserInfo selectByPrimaryKey(Long id);

    /**
     * 查询报考人数最多的驾照类型
     *
     * @return
     */
    DriverLicense selectMaxRegisterType();


    /**
     * 新增用户信息
     *
     * @param obj
     * @return
     */
    Long insert(SysUserInfo obj);


    /**
     * 删除用户信息，通过主键
     *
     * @param baseEntity
     * @return
     */
    Long deleteByPrimaryKey(BaseEntity baseEntity);

    /**
     * 批量删除用户信息
     *
     * @param setUpdateBy
     * @return
     */
    Long deleteBatch(BaseEntity setUpdateBy);

    /**
     * 更新用户信息
     *
     * @param sysUserInfo
     * @return
     */
    Long update(SysUserInfo sysUserInfo);
}
