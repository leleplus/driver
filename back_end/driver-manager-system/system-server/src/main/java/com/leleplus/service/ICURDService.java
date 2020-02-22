package com.leleplus.service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName ICURDService
 * @date 2020-01-20 23:30
 * @description 增删改查超级接口
 */

public interface ICURDService {
    
    /**
     * 查询全部
     *
     * @param <T> 对应的类类型
     * @return List集合
     */
    <T> List<T> getAll () throws Exception;
    
    /**
     * 通过主键查询
     *
     * @param id  主键
     * @param <T> 对应的类类型
     * @return 类对象
     */
    <T> T getById (@NotNull Long id) throws Exception;
    
    /**
     * 指定字段查询
     *
     * @param arg 指定的参数
     * @param <T> 对应的类类型
     * @param <t> 对应类型的字段
     * @return 类对象
     */
    <T, t> T getByArg (@NotNull t arg) throws Exception;
    
    /**
     * 数据库新增接口
     *
     * @param t   类对象
     * @param <T> 对应的类对象
     * @return 新增之后，mysql自动生成的id
     */
    <T> int addNew (@NotNull T t) throws Exception;
    
    /**
     * 通过id删除数据
     *
     * @param id 主键id
     */
    void deleteById (@NotNull Long id) throws Exception;
    
    /**
     * 数据库表中某字段删除
     *
     * @param arg 删除条件
     * @param <T> 字段的类型
     */
    <T> void deleteByArg (@NotNull T arg) throws Exception;
    
    /**
     * 批量删除
     *
     * @param ids 批量删除的每一个主键
     */
    void deleteByids (@NotNull List<Long> ids) throws Exception;
    
    /**
     * 通过id更新数据
     *
     * @param id 主键id
     * @return 改动了几行数据
     */
    int updateById (@NotNull Long id) throws Exception;
    
    /**
     * 通过指定的条件更新
     *
     * @param arg 更新条件
     * @param <T> 条件对应的类型
     * @return 更新条数
     */
    <T> int updateByArg (@NotNull T arg) throws Exception;
}