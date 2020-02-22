package com.leleplus.utils;

import com.sun.istack.internal.NotNull;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName JWTTokenProvider
 * @date 2020-02-22 14:08
 * @description Token提供器
 */
@Component
@Data
public class TokenProviderUtil implements Serializable {

    private static final long serialVersionUID = -4302515349281459807L;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String secret;

    private final String header;

    // 未记住我时token过期时间
    private final long TOKEN_EXPIRATION_TIME;

    // 记住我时token的过期时间
    private final long TOKEN_EXPIRATION_TIME_REMEMBER;

    /**
     * 构造器注入值
     *
     * @param secret
     * @param expirationTime
     * @param expirationTimeRemember
     */
    public TokenProviderUtil(
            @Value("${driver.token.secret}") String secret,
            @Value("${driver.token.header}") String header,
            @Value("${driver.token.expiration-ime}") long expirationTime,
            @Value("${driver.token.expiration-time-remember}") long expirationTimeRemember) {
        this.secret = secret;
        this.header = header;
        this.TOKEN_EXPIRATION_TIME = expirationTime * 1000;
        this.TOKEN_EXPIRATION_TIME_REMEMBER = expirationTimeRemember * 1000;
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    public String generateToken(Map<String, Object> claims, boolean isremeber) {
        long time = 0;
        // 是否记住了密码
        if (isremeber) {
            time = TOKEN_EXPIRATION_TIME_REMEMBER + System.currentTimeMillis();
        } else {
            time = TOKEN_EXPIRATION_TIME + System.currentTimeMillis();
        }

        return Jwts.builder()
//                .setHeader()
                .setClaims(claims)
                .setExpiration(new Date(time))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 根据登录用户生成令牌
     *
     * @param userDetails 用户信息
     * @return 令牌
     */
    public String generateToken(UserDetails userDetails, boolean isRemember) {
        ConcurrentHashMap<String, Object> claims = new ConcurrentHashMap<>(2);
        claims.put(Claims.SUBJECT, userDetails.getUsername());
        claims.put("created", new Date());
        // 存放其他的数据
        return generateToken(claims, isRemember);
    }

    /**
     * 从token中获的数据声明
     *
     * @param token
     * @return
     */
    public Claims getClaimsFromToken(final String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 获取token中的用户名
     *
     * @param token
     * @return
     */
    public String getUsernameFromToken(final String token) {
        return getClaimsFromToken(token).getSubject();
    }

    /**
     * token是否过期
     *
     * @param token
     * @return
     */
    public boolean isExpires(final String token) {
        return getClaimsFromToken(token).getExpiration().before(new Date());
    }

    /**
     * 刷新token，即更新token的创建时间
     *
     * @param token
     * @return
     */
    public String flushToken(@NotNull final String token, final boolean isRemember) {
        Claims claims = getClaimsFromToken(token);
        claims.put("created", new Date());
        return generateToken(claims, isRemember);
    }

    /**
     * 校验token，token中的用户名匹配，token不过期
     *
     * @param token
     * @param userDetails
     * @return
     */
    public boolean checkToken(@NotNull final String token, @NotNull UserDetails userDetails) {
        String usernameFromToken = getUsernameFromToken(token);
        return usernameFromToken.equals(userDetails.getUsername()) && !isExpires(token);

    }
}
