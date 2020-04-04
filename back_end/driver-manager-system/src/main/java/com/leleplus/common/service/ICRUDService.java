package com.leleplus.common.service;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @interfaceName ICRUDService
 * @date 2020-03-23 19:57
 * @description 顶级增删改查接口
 */

public interface ICRUDService<T> {

    /**
     * 查询所有
     *
     * @return 对象集合
     */
    List<T> selectAll();

    /**
     * 根据id查询单个对象
     *
     * @param id
     * @return 对象
     */
    T selectById(Long id);

    /**
     * 通过其他任意类型参数查询
     *
     * @param t
     * @param <K>
     * @return 对象
     */
    <K> T selectByArg(K t);

    /**
     * 单个插入
     *
     * @param obj
     * @return 主键id
     */
    @Transactional
    Long addByObject(T obj);

    /**
     * 批量插入
     *
     * @param objs
     * @return 添加条数
     */
    @Transactional
    Long BatchAdd(List<T> objs);

    /**
     * 删除单个数据
     *
     * @param id
     * @return 删除条数
     */
    @Transactional
    Long deleteByPrimaryKey(Long id);

    /**
     * 批量删除
     *
     * @param ids
     * @return 删除条数
     */
    @Transactional
    Long BatchDelete(String ids);

    /**
     * 单个更新
     *
     * @param t 对象
     * @return 更新条数
     */
    @Transactional
    Long updateByArg(T t);

    /**
     * 批量更新
     *
     * @param objs 对象集合
     * @return 更新条数
     */
    @Transactional
    Long BatchUpdate(List<T> objs);

}
