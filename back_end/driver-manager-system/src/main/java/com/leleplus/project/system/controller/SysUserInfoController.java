package com.leleplus.project.system.controller;

import com.leleplus.core.web.controller.BaseController;
import com.leleplus.core.web.domain.AjaxResult;
import com.leleplus.project.system.domain.SysUserInfo;
import com.leleplus.project.system.service.ISysUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className SysUserInfoController
 * @date 2020-04-05 15:56
 * @description 用户信息前端控制器
 */
@Api(tags = "用户信息接口")
@RestController
@RequestMapping("/userInfo")
public class SysUserInfoController extends BaseController {

    @Autowired
    private ISysUserInfoService userInfoService;

    /**
     * 根据用户信息id获取用户详细信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询用户信息")
    @PreAuthorize ("@ss.hasPermi('system:userinfo:query')")
    @GetMapping("/{userInfoId}")
    public AjaxResult getUserInfo(@PathVariable(value = "userInfoId", required = false) Long id) {
        AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, userInfoService.selectById(id));
        return ajax;
    }

    /**
     * 新增用户信息
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "新增用户信息",notes = "需要将用户信息的主键绑定到对应的User对象中")
    @PostMapping
    public AjaxResult newUserInfo(@RequestBody SysUserInfo userInfo) {
        AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, userInfoService.addByObject(userInfo));
        return ajax;
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "更新用户信息",notes = "通过id更新用户信息")
    @PutMapping
    public AjaxResult updateUserInfo(@RequestBody SysUserInfo userInfo) {
        userInfoService.updateByArg(userInfo);
        return AjaxResult.success();
    }

    /**
     * 删除用户信息（支持批量删除），需要前端拼接id，使用,
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除用户信息",notes = "根据id删除用户信息（支持批量删除）")
    @DeleteMapping
    public AjaxResult delUserInfo(@RequestBody String ids) {
        userInfoService.BatchDelete(ids);
        return AjaxResult.success();
    }
}
