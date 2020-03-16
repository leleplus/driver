package com.leleplus.web.controller;

import com.leleplus.expand.result.ResponseResult;
import com.leleplus.expand.result.ResultEnum;
import com.leleplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName UserController
 * @date 2020-02-22 20:27
 * @description 用户前端控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login/{username}/{password}")
    public ResponseResult login(@PathVariable String username, @PathVariable String password) {
        try {
            String token = userService.login(username, password, true);
            return ResponseResult.back(ResultEnum.SUCCESS, token);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.back(e);
        }
    }
}
