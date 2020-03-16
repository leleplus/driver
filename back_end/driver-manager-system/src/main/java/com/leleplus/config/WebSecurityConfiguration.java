package com.leleplus.config;

import com.leleplus.web.filter.JWTAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName WebSecurityConfiration
 * @date 2020-02-19 22:44
 * @description web安全配置
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//保证post之前的注解可以使用
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTAuthFilter jwtAuthFilter;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }

    /**
     * 自动注入密码编码器，解决密码加密问题
     *
     * @return
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * 配置http安全相关的内容
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 禁用csft,详细了解https://baike.baidu.com/item/%E8%B7%A8%E7%AB%99%E8%AF%B7%E6%B1%82%E4%BC%AA%E9%80%A0/13777878?fromtitle=CSRF&fromid=2735433&fr=aladdin
                .csrf().disable()
                // 使用token,去除session,设置为无状态的
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 请求权限配置
                .and()

                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                // 让Spring security放行所有preflight request
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                // 忽略 OPTIONS 的请求, url 过滤规则为所有请求, OPTIONS 是跨域请求的预请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/","/api/**","/user/login/**",
                        "**/**.html",
                        "/favicon.ico"
                ).permitAll()
                //                需要admin访问
//                .antMatchers("/api/hiddenmessage").hasAuthority("ROLE_ADMIN")
                // 除了上面的请求，其余全部需要登录才能请求
                .anyRequest().authenticated()

                // 异常处理器配置
//                .exceptionHandling()
                // 认证失败，返回401 code 码，说明未登录
//                .authenticationEntryPoint(authenticationEntryPoint)
                // 权限不足处理
//                .accessDeniedHandler(new JwtHandlerAdapter())


                // 禁用请求头缓存
                .and().headers().cacheControl();
//                .and().apply(SecurityConfigurerAdapter);

    }

    @Bean
    public CorsFilter corsFilter(){
       final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
