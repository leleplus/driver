package com.leleplus.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName DriverTestController
 * @date 2020-01-12 19:54
 * @description Driver测试接口
 */
@RequestMapping("/")
@RestController
@Api(description = "驾校管理系统测试接口")
public class DriverTestController {
    
    @ApiOperation("测试接口")
    @GetMapping("index")
    public String index(){
        
        return "欢迎访问物联网驾校管理系统！";
        
    }
    
}
