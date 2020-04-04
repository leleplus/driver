package com.leleplus.project.system.service.impl;

import com.leleplus.common.exception.driver.DriverException;
import com.leleplus.common.exception.user.UserException;
import com.leleplus.common.utils.SecurityUtils;
import com.leleplus.common.utils.StringUtils;
import com.leleplus.core.web.domain.BaseEntity;
import com.leleplus.project.system.domain.DriverLicense;
import com.leleplus.project.system.domain.SysUserInfo;
import com.leleplus.project.system.mapper.SysUserInfoMapper;
import com.leleplus.project.system.service.ISysUserInfoService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className SysUserInfoServiceImpl
 * @date 2020-04-03 16:01
 * @description 用户信息Service实现类
 */

@Service
public class SysUserInfoServiceImpl implements ISysUserInfoService {

    // logger日志全局初始化
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysUserInfoMapper mapper;

    /**
     * 查询所有
     *
     * @return 对象集合
     */
    @Override
    public List<SysUserInfo> selectAll() {
        return null;
    }

    /**
     * 根据id查询单个对象
     *
     * @param id
     * @return 对象
     */
    @Override
    public SysUserInfo selectById(Long id) {

        if (id == null) {
            logger.error("查询用户信息id为空");
            throw new UserException("user.info.notfound");
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
    public <K> SysUserInfo selectByArg(K t) {
        return null;
    }

    /**
     * 单个插入
     *
     * @param obj
     * @return 主键id
     */
    @Override
    @Transactional
    public Long addByObject(SysUserInfo obj) {
        if (obj == null) {
            logger.error("用户信息对象为空");
            throw new UserException("user.info.object");
        }

        if (obj.getId() != null) {
            logger.error("新增用户信息，id必须为空");
            throw new UserException("user.info.add.id");
        }

        if (StringUtils.isEmpty(obj.getRealName())) {
            logger.error("用户信息真实姓名未填写！");
            throw new UserException("user.info.realName");
        }

        if (StringUtils.isNull(obj.getSignDate())) {
            logger.error("用户信息报名日期未填写！");
            throw new UserException("user.info.signDate");
        }

        // 初始化值
        obj.setDriverType(getMaxRegisterType().getId())
                .setDeleted(false)
                .setCreateBy(SecurityUtils.getUsername());


        // 初始报到截止时间
        if (obj.getSignDate() != null) {
            // 定义calendar对象
            Calendar calendar = new GregorianCalendar();
            // 把当前报道日期赋值给calendar
            calendar.setTime(obj.getSignDate());
            // 在日期中增加5年
            calendar.add(Calendar.YEAR, 5);
            // 把calendar转换回日期格式，同时设置报名过期时间
            obj.setExpirationTime(calendar.getTime());
        }

        return mapper.insert(obj);
    }

    /**
     * 批量插入
     *
     * @param objs
     * @return 添加条数
     */
    @Override
    @Transactional
    public Long BatchAdd(List<SysUserInfo> objs) {
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
            logger.error("删除用户信息，主键不能为空");
            throw new UserException("user.info.delete.id");
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
            logger.error("批量删除用户信息，id不能为空！");
            throw new DriverException("user.info.delete.id");
        }

        return mapper.deleteBatch(new BaseEntity()
                .setIds((Long[]) ConvertUtils.convert(ids.split("[,]"), Long.class))
                .setUpdateBy(SecurityUtils.getUsername()));
    }

    /**
     * 单个更新
     *
     * @param sysUserInfo 对象
     * @return 更新条数
     */
    @Override
    @Transactional
    public Long updateByArg(SysUserInfo sysUserInfo) {
        if (sysUserInfo == null) {
            logger.error("用户信息更新对象为空");
            throw new DriverException("user.info.object");
        }
        if (sysUserInfo.getId() == null) {
            logger.error("更新用户信息必须传id");
            throw new DriverException("user.info.update.id");
        }

        // 初始化默认值
        sysUserInfo.setUpdateBy(SecurityUtils.getUsername());

        return mapper.update(sysUserInfo);
    }

    /**
     * 批量更新
     *
     * @param objs 对象集合
     * @return 更新条数
     */
    @Override
    @Transactional
    public Long BatchUpdate(List<SysUserInfo> objs) {
        return null;
    }

    /**
     * 查询报考人数最多的驾照类型
     *
     * @return
     */
    @Override
    public DriverLicense getMaxRegisterType() {
        return mapper.selectMaxRegisterType();
    }
}
