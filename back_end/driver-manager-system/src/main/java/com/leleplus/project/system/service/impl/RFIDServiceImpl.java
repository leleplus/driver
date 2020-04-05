package com.leleplus.project.system.service.impl;

import com.leleplus.common.exception.driver.DriverException;
import com.leleplus.common.exception.user.UserException;
import com.leleplus.common.utils.SecurityUtils;
import com.leleplus.common.utils.StringUtils;
import com.leleplus.core.web.domain.BaseEntity;
import com.leleplus.project.system.domain.RFIDCard;
import com.leleplus.project.system.mapper.RFIDCardMapper;
import com.leleplus.project.system.service.IRFIDCardService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className RFIDServiceImpl
 * @date 2020-04-05 16:26
 * @description RFIDService实现类
 */

@Service
public class RFIDServiceImpl implements IRFIDCardService {

    // logger日志全局初始化
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RFIDCardMapper mapper;

    /**
     * 查询所有
     *
     * @return 对象集合
     */
    @Override
    public List<RFIDCard> selectAll() {
        return null;
    }

    /**
     * 根据id查询单个对象
     *
     * @param id
     * @return 对象
     */
    @Override
    public RFIDCard selectById(Long id) {
        if (id == null) {
            logger.error("查询RFID卡信息id为空");
            throw new UserException("RFID.select.id.notFound");
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
    public <K> RFIDCard selectByArg(K t) {
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
    public Long addByObject(RFIDCard obj) {
        if (obj == null) {
            logger.error("RFID信息对象为空");
            throw new UserException("RFID.object.notFound");
        }

        if (obj.getId() != null) {
            logger.error("新增RFID信息，id必须为空");
            throw new UserException("RFID.object.add.id");
        }

        if (StringUtils.isEmpty(obj.getPhyNumber())) {
            logger.error("RFID物理卡号为空！");
            throw new UserException("RFID.phy_number");
        }

        // 初始化值
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
    @Transactional
    public Long BatchAdd(List<RFIDCard> objs) {
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
            logger.error("删除RFID信息，主键不能为空");
            throw new UserException("RFID.delete.id");
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
            logger.error("批量删除RFID信息，id不能为空！");
            throw new DriverException("RFID信息删除时，必须传id");
        }

        return mapper.deleteBatch(new BaseEntity()
                .setIds((Long[]) ConvertUtils.convert(ids.split("[,]"), Long.class))
                .setUpdateBy(SecurityUtils.getUsername()));
    }

    /**
     * 单个更新
     *
     * @param rfidCard 对象
     * @return 更新条数
     */
    @Override
    @Transactional
    public Long updateByArg(RFIDCard rfidCard) {
        if (rfidCard == null) {
            logger.error("RFID信息更新对象为空");
            throw new DriverException("RFID.object.notFound");
        }
        if (rfidCard.getId() == null) {
            logger.error("更新用户信息必须传id");
            throw new DriverException("RFID.update.id");
        }

        // 初始化默认值
        rfidCard.setUpdateBy(SecurityUtils.getUsername());

        return mapper.update(rfidCard);
    }

    /**
     * 批量更新
     *
     * @param objs 对象集合
     * @return 更新条数
     */
    @Override
    @Transactional
    public Long BatchUpdate(List<RFIDCard> objs) {
        return null;
    }


    /**
     * 根据条件分页查询RFID数据
     *
     * @param rfidCard
     * @return
     */
    @Override
    public List<RFIDCard> getAll(RFIDCard rfidCard) {
        return mapper.selectByPage(rfidCard);
    }
}
