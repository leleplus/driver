package com.leleplus.service.impl;

import com.leleplus.bean.User;
import com.leleplus.bean.UserExample;
import com.leleplus.dao.UserMapper;
import com.leleplus.expand.auth.UserDetail;
import com.leleplus.utils.StringCheckUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName JwtUserDetailServiceImpl
 * @date 2020-02-19 22:32
 * @description
 */
@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetail loadUserByUsername(String account) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(account)) throw new UsernameNotFoundException("用户名不能为空");
        //使用正则表达式判断用户名类型
        UserExample userExample = new UserExample();
        if (StringCheckUtils.isIdCardNumber(account)) {
            // 身份证号登陆
            userExample.createCriteria().andIdCardEqualTo(account);
            logger.info("用户-->{} 通过身份证号登陆 ",account);
        } else if (StringCheckUtils.isTel(account)) {
            // 手机号登陆
            userExample.createCriteria().andTelphoneEqualTo(account);
            logger.info("用户-->{} 通过手机号登陆 ",account);
        } else if (StringCheckUtils.isEmail(account)) {
            // 邮箱登陆
            userExample.createCriteria().andEmailEqualTo(account);
            logger.info("用户-->{} 通过邮箱登陆 ",account);
        } else if (StringCheckUtils.isLegalUsername(account)) {
            // 系统用户名登陆
            int length = account.length();
            if (length < 6 || length > 8) throw new UsernameNotFoundException("用户名输入错误");
            userExample.createCriteria().andLoginIdEqualTo(account);
            logger.info("用户-->{} 通过用户名登陆 ",account);
        } else {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 从数据库中查出用户
        User user = userMapper.selectByExample(userExample).get(0);

        if (user == null) throw new UsernameNotFoundException("用户名不存在");

        // 将用户的角色存放在list中
        List<SimpleGrantedAuthority> roles = Arrays.stream(user.getRoleName().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new UserDetail(user.getUsername(),user.getPassword(),roles);
    }
}
