package com.leleplus.project.system.controller;

import com.leleplus.common.constant.Constants;
import com.leleplus.common.utils.ServletUtils;
import com.leleplus.core.security.LoginUser;
import com.leleplus.core.security.service.SysLoginService;
import com.leleplus.core.security.service.SysPermissionService;
import com.leleplus.core.security.service.TokenService;
import com.leleplus.core.web.domain.AjaxResult;
import com.leleplus.project.system.domain.SysMenu;
import com.leleplus.project.system.domain.SysUser;
import com.leleplus.project.system.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * 登录验证
 *
 * @author witt
 */
@Api(tags = "系统登录接口")
@RestController
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录方法
     *
     * @param user 登录用户
     * @return 结果
     */
    @ApiOperation(value = "登录接口", notes = "登录账户可以为用户名，身份证号，手机号，邮箱")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody SysUser user) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(user.getUsername(), user.getPassword(), user.getCode(), user.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */

    @ApiOperation("获取用户信息")
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */

    @ApiOperation("获取路由信息")
    @GetMapping("getRouters")
    public AjaxResult getRouters() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getId());
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
