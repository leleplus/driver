package com.leleplus.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName SwaggerConfigration
 * @date 2020-01-12 20:08
 * @description Swagger配置类
 */

@Configuration
@MapperScan("com.leleplus.dao")
public class SystemConfiguration extends ResourceConfig implements EnvironmentAware {

    private static final String SWAGGER_PREFIX = "driver.swagger";

    @Override
    public void setEnvironment(Environment environment) {

    }

    /**
     * 配置Swagger Docket对象的自动注入
     * @return 配置好的Docket对象
     * Swagger基本使用方式
     * <code>@Api</code>                描述类/接口的主要用途
     * <code>@ApiOperation</code>       描述方法用途
     * <code>@ApiImplicitParam</code>   描述方法的参数
     * <code>@ApiImplicitParams</code>  描述方法的参数(Multi - Params)
     * <code>@ApiIgnore</code>          忽略某类/方法/参数的文档
     *
     */
//    @Bean
//    public Docket swaggerApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                    .apiInfo(new ApiInfoBuilder()
//                    .title("Driver Manager System Java Server API Documents")
//                    .description("基于物联网的驾校管理系统Server端")
//                    .contact(new Contact("lele","http://www.leleplus.fun","fgwang.660@gmail.com"))
//                    .version("1.0.0")
//                    .build())
//                .groupName("System-Server")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.leleplus.web.controller"))
//                .build();
//    }


}
