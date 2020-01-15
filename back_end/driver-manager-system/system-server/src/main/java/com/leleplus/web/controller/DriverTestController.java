package com.leleplus.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @ApiOperation("测试接口")
    @GetMapping("index")
    public String index(){
        
        logger.info("测试info日志");
        logger.trace("测试trace日志");
        logger.warn("测试warn日志");
        logger.error("测试error日志");
        logger.debug("测试debug日志");
        return "欢迎访问物联网驾校管理系统！";
        
    }
    
}
