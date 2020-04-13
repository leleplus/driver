package com.leleplus.core.config;


import com.google.common.base.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Swagger2的接口配置
 *
 * @author witt
 */
@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig {
	/**
	 * 系统基础配置
	 */
	@Autowired
	private DriverSystemConfiguration DriverSystemConfiguration;


	@Value ("${driver.swagger.package}")
	private String swagger_package;

	/**
	 * 创建API
	 */
	@Bean
	public Docket createRestApi() {

		log.info("--------------------------  Swagger Configuration -------------------------");

		return new Docket(DocumentationType.SWAGGER_2)
//                .pathMapping("/dev-api")
				// 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
				.apiInfo(apiInfo())
				// 设置哪些接口暴露给Swagger展示
				.select()
				// 扫描所有有注解的api，用这种方式更灵活
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				// 扫描指定包中的swagger注解
//                .apis(RequestHandlerSelectors.basePackage(swagger_package))

				// 重写basePackage方法，支持多包扫描
				.apis(basePackage(swagger_package))
//                 扫描所有
//				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				/* 设置安全模式，swagger可以设置访问token */
				.securitySchemes(securitySchemes())
				.securityContexts(securityContexts());
	}

	/**
	 * 安全模式，这里指定token通过Authorization头请求头传递
	 */
	private List<ApiKey> securitySchemes() {
		List<ApiKey> apiKeyList = new ArrayList<>();
		apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
		return apiKeyList;
	}

	/**
	 * 安全上下文
	 */
	private List<SecurityContext> securityContexts() {
		List<SecurityContext> securityContexts = new ArrayList<>();
		securityContexts.add(
				SecurityContext.builder()
						.securityReferences(defaultAuth())
						.forPaths(PathSelectors.regex("^(?!auth).*$"))
						.build());
		return securityContexts;
	}

	/**
	 * 默认的安全上引用
	 */
	private List<SecurityReference> defaultAuth() {
		List<SecurityReference> securityReferences = new ArrayList<>();
		securityReferences.add(new SecurityReference("Authorization", new AuthorizationScope[]{
				new AuthorizationScope("global", "accessEverything")
		}));
		return securityReferences;
	}

	/**
	 * 添加摘要信息
	 */
	private ApiInfo apiInfo() {
		// 用ApiInfoBuilder进行定制
		return new ApiInfoBuilder()
				// 设置标题
				.title("STM32驾校管理系统_接口文档")
				// 描述
				.description("一套整合STM32开发、Spring Boot + Vue 的毕业设计项目！")
				// 作者信息
				.contact(new Contact(DriverSystemConfiguration.getName(), "http://47.103.215.243/driver/", "fgwang.660@gmail.com"))
				// 版本
				.version("版本号:" + DriverSystemConfiguration.getVersion())
				.build();
	}

	/**
	 * 允许Swagger配置多包扫描
	 * com.google.common.base.Predicate<springfox.documentation.RequestHandler>
	 *
	 * @param basePackage
	 * @return
	 */
	public static Predicate<RequestHandler> basePackage(final String basePackage) {

		log.info("Swagger scan package : {} ", basePackage);

		return request -> Optional
				.ofNullable(request.declaringClass())
				// 有一个包能匹配成功，就可以了
				.map(clazz -> Arrays
						.stream(basePackage.split("[;]"))
						.anyMatch(item -> clazz
								.getPackage()
								.getName()
								.startsWith(item)))
				// 不匹配也返回true
				.orElse(true);
	}
}
