package com.leleplus.web.filter;

import com.leleplus.utils.TokenProviderUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName JWTFilter
 * @date 2020-02-22 14:03
 * @description JWT拦截器
 */
@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private TokenProviderUtil tokenProviderUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(tokenProviderUtil.getHeader());
        // 存在token，但是没有权限
        if (StringUtils.isNotEmpty(token)) {
            String username = tokenProviderUtil.getUsernameFromToken(token);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            // 存在用户名，但是没有权限，再去查权限
            if (StringUtils.isNoneEmpty(username) && authentication == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                // 检验token是否有效
                if (tokenProviderUtil.checkToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        // 放行
        filterChain.doFilter(request,response);
    }
}
