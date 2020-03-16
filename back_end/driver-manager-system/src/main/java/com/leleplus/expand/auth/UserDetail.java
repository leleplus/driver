package com.leleplus.expand.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName UserDetail
 * @date 2020-02-19 22:20
 * @description 用户安全认证模型, spring security使用的用户
 */
@AllArgsConstructor
public class UserDetail implements UserDetails {

    private static final long serialVersionUID = 2881499670972188583L;

    private String account;

    private String password;
//    private boolean isRemeber;
//    private String verifyCode;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetail(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return account;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
