package com.leleplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Configuration
public class DriverApplication extends SpringBootServletInitializer {

    /**
     * 部署在Web容器中的配置
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DriverApplication.class);
    }


    /**
     * 启动主类
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.setProperty("spring.devtools.restart.enabled","true");
        SpringApplication.run(DriverApplication.class, args);
    }


}
