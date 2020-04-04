package com.leleplus.project.system.mapper;

import com.leleplus.core.web.domain.BaseEntity;
import com.leleplus.project.system.domain.DriverLicense;

import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @interfaceName DriverLicenseMapper
 * @date 2020-04-03 18:06
 * @description 驾驶证数据库操作接口
 */
public interface DriverLicenseMapper {

    /**
     * 根据code查询驾驶证
     *
     * @param code
     * @return
     */
    DriverLicense selectByCode(String code);

    /**
     * 通过id查询驾驶证
     *
     * @param id
     * @return
     */
    DriverLicense selectByPrimaryKey(Long id);

    /**
     * 查询所有的驾照类型
     * @return
     */
    List<DriverLicense> selectAll();

    /**
     * 添加新的驾驶证类型
     * @param obj
     * @return
     */
    Long insert(DriverLicense obj);

    /**
     * 通过主键删除
     * @param entity
     * @return
     */
    Long deleteByPrimaryKey(BaseEntity entity);

    /**
     * 批量删除
     * @param entity
     * @return
     */
    Long deleteBatch(BaseEntity entity);

    /**
     * 更新驾驶证类型
     * @param driverLicense
     * @return
     */
    Long update(DriverLicense driverLicense);
}
