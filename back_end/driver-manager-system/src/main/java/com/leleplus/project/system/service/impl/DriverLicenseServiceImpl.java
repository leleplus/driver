package com.leleplus.project.system.service.impl;

import com.leleplus.common.exception.driver.DriverException;
import com.leleplus.common.utils.SecurityUtils;
import com.leleplus.common.utils.StringUtils;
import com.leleplus.core.web.domain.BaseEntity;
import com.leleplus.project.system.domain.DriverLicense;
import com.leleplus.project.system.mapper.DriverLicenseMapper;
import com.leleplus.project.system.service.IDriverLicenseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className DriverLicenseServiceImpl
 * @date 2020-04-03 17:26
 * @description 驾驶证Service实现类
 */

@Service
@Slf4j
public class DriverLicenseServiceImpl implements IDriverLicenseService {


    @Resource
    private DriverLicenseMapper mapper;

    /**
     * 查询所有
     *
     * @return 对象集合
     */
    @Override
    public List<DriverLicense> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 根据id查询单个对象
     *
     * @param id
     * @return 对象
     */
    @Override
    public DriverLicense selectById(Long id) {
        if (id == null) {
            log.error("查询驾驶证类型的id为空");
            throw new DriverException("驾驶证类型参数不正确");
        }
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 通过其他任意类型参数查询
     *
     * @param t
     * @return 对象
     */
    @Override
    public <K> DriverLicense selectByArg(K t) {
        if (!(t instanceof String) || StringUtils.isEmpty((String) t)) {
            log.error("驾驶证参数类型不正确或参数为空-->{}", t);
            throw new DriverException("driverlicense.info.param");
        }

        return mapper.selectByCode((String) t);
    }

    /**
     * 单个插入
     *
     * @param obj
     * @return 主键id
     */
    @Override
    @Transactional
    public Long addByObject(DriverLicense obj) {
        if (obj == null) {
            log.error("新增驾驶证类型对象为空");
            throw new DriverException("driverlicense.info.object");
        }

        if (obj.getId() != null) {
            log.error("新增驾驶证类型，id必须为空");
            throw new DriverException("driverlicense.info.add.id");
        }

        if (StringUtils.isEmpty(obj.getCode()) || StringUtils.isEmpty(obj.getAllowCarType())) {
            log.error("驾驶证类型的code和准驾车型为空");
            throw new DriverException("driverlicense.info.add.param");
        }

        // 初始化默认值
        obj.setDeleted(false)
                .setCreateBy(SecurityUtils.getUsername());
        return mapper.insert(obj);
    }

    /**
     * 批量插入
     *
     * @param objs
     * @return 添加条数
     */
    @Override
    public Long BatchAdd(List<DriverLicense> objs) {
        return null;
    }

    /**
     * 删除单个数据
     *
     * @param id
     * @return 删除条数
     */
    @Override
    @Transactional
    public Long deleteByPrimaryKey(Long id) {

        if (id == null) {
            log.error("删除驾驶证类型，id不能为空！");
            throw new DriverException("driverlicense.info.delete.param");
        }

        return mapper.deleteByPrimaryKey(new BaseEntity()
                .setId(id)
                .setUpdateBy(SecurityUtils.getUsername()));
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return 删除条数
     */
    @Override
    @Transactional
    public Long BatchDelete(String ids) {
        if (StringUtils.isEmpty(ids)) {
            log.error("批量删除驾驶证类型，id不能为空！");
            throw new DriverException("driverlicense.info.delete.param");
        }

        return mapper.deleteBatch(new BaseEntity()
                .setIds((Long[]) ConvertUtils.convert(ids.split("[,]"), Long.class))
                .setUpdateBy(SecurityUtils.getUsername()));
    }

    /**
     * 单个更新
     *
     * @param driverLicense 对象
     * @return 更新条数
     */
    @Override
    @Transactional
    public Long updateByArg(DriverLicense driverLicense) {
        if (driverLicense == null) {
            log.error("驾驶证更新对象为空");
            throw new DriverException("driverlicense.info.object");
        }
        if (driverLicense.getId() == null) {
            log.error("更新驾驶证类型时必须传id");
            throw new DriverException("driverlicense.info.update.id");
        }

        // 初始化默认值
        driverLicense.setUpdateBy(SecurityUtils.getUsername());


        return mapper.update(driverLicense);
    }

    /**
     * 批量更新
     *
     * @param objs 对象集合
     * @return 更新条数
     */
    @Override
    @Transactional
    public Long BatchUpdate(List<DriverLicense> objs) {
        return null;
    }
}
