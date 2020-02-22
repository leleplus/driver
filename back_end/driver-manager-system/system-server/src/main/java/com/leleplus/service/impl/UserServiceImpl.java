package com.leleplus.service.impl;

import com.leleplus.bean.User;
import com.leleplus.bean.UserExample;
import com.leleplus.dao.AdministratorMapper;
import com.leleplus.dao.CoachArchivesMapper;
import com.leleplus.dao.StudentArchivesMapper;
import com.leleplus.dao.UserMapper;
import com.leleplus.domain.UserPlus;
import com.leleplus.expand.enums.SystemCodeEnum;
import com.leleplus.expand.exceptions.DriverExceptionEnum;
import com.leleplus.expand.exceptions.NullArgsException;
import com.leleplus.service.IUserService;
import com.leleplus.utils.StringCheckUtils;
import com.leleplus.utils.TokenProviderUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName UserService
 * @date 2020-01-21 22:03
 * @description 用户表Service实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserMapper userMapper;

    @Resource
    private StudentArchivesMapper studentArchivesMapper;

    @Resource
    private CoachArchivesMapper coachArchivesMapper;

    @Resource
    private AdministratorMapper administratorMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenProviderUtil tokenProviderUtil;

    /**
     * 查询全部
     *
     * @return List集合
     */
    @Override
    public List<User> getAll() throws Exception {
        logger.info("->>>   查询所有的用户");
        List<User> users = userMapper.selectByExample(new UserExample());

        if (users == null) {
            logger.info("没有查询到任何用户");
            users = new ArrayList<>();
        }

        return users;
    }

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return 类对象
     */
    @Override
    public User getById(@NotNull Long id) throws Exception {
        if (id == null) {
            logger.error(">>>>>  查询索引不能为空");
            throw new NullArgsException("查询索引不能为空");
        }

        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            logger.info(id + " ---> 索引对应的数据不存在");
            throw new NullArgsException(id + " ---> 索引对应的数据不存在");
        }

        return user;
    }

    /**
     * 指定字段查询
     *
     * @param arg 指定的参数
     * @return 类对象
     */
    @Override
    public <T, t> T getByArg(@NotNull t arg) throws Exception {
        if (arg instanceof String && StringUtils.isNotEmpty((String) arg)) {
            String temp = (String) arg;
            // 判难是不是手机号
            UserExample userExample = new UserExample();
            if (StringCheckUtils.isTel(temp)) {
                userExample.createCriteria().andTelphoneEqualTo(temp);
                List<User> users = userMapper.selectByExample(userExample);
                if (users != null && users.size() == 0) {
                    return (T) users.get(0);
                }
            }


        }

        return null;
    }

    /**
     * 数据库新增接口
     *
     * @param t 类对象
     * @return 新增之后，mysql自动生成的id
     */
    @Override
    public <T> int addNew(@NotNull T t) throws Exception {
        // 添加新用户
        UserPlus user = (UserPlus) t;
        // 手机号不能为空
        if (StringUtils.isEmpty(user.getTelphone())) {
            throw new NullArgsException(DriverExceptionEnum.NULL_VALUE.setDescription("新增用户的手机号不能为空"));
        }

        // 身份证号不能为空
        if (StringUtils.isEmpty(user.getIdCard())) {
            throw new NullArgsException(DriverExceptionEnum.NULL_VALUE.setDescription("新增用户的身份证号不能为空"));
        }

        // 角色
        String roleCode = user.getRoleCode();
        if (StringUtils.isEmpty(roleCode)) {
            throw new NullArgsException(DriverExceptionEnum.NULL_VALUE.setDescription("新增用户必须赋予一个身份角色"));
        }

        /**
         * 赋予默认值
         */
        // 用户身份证号
        String idCard = user.getIdCard();
        // 默认密码为身份证号后六位
        user.setPassword(idCard.substring(idCard.length() - 6));

        // 初始化账户状态
        user.setEnable(Integer.parseInt(SystemCodeEnum.ACCOUNT_NORMAL.getCode()));

        // 判断角色身份

        Integer userId = null;
        if (SystemCodeEnum.ID_STUDENT.getCode().equals(roleCode)) {
            // 学员
            user.setRoleName(SystemCodeEnum.ID_STUDENT.getName());

            userId = userMapper.insert(user);
//            studentArchivesMapper

        } else if (SystemCodeEnum.ID_COACH.getCode().equals(roleCode)) {
            // 教练
            user.setRoleName(SystemCodeEnum.ID_STUDENT.getName());
            userId = userMapper.insert(user);

        } else if (SystemCodeEnum.ID_ADMINISTRATOR.getCode().equals(roleCode)) {
            // 管理员
            user.setRoleName(SystemCodeEnum.ID_ADMINISTRATOR.getName());
            userId = userMapper.insert(user);

        } else {
            // 游客
            user.setRoleName(SystemCodeEnum.ID_UNKNOWN.getName());
        }


        return 0;
    }

    /**
     * 通过id删除数据
     *
     * @param id 主键id
     */
    @Override
    public void deleteById(@NotNull Long id) throws Exception {

    }

    /**
     * 数据库表中某字段删除
     *
     * @param arg 删除条件
     */
    @Override
    public <T> void deleteByArg(@NotNull T arg) throws Exception {

    }

    /**
     * 批量删除
     *
     * @param ids 批量删除的每一个主键
     */
    @Override
    public void deleteByids(@NotNull List<Long> ids) throws Exception {

    }

    /**
     * 通过id更新数据
     *
     * @param id 主键id
     * @return 改动了几行数据
     */
    @Override
    public int updateById(@NotNull Long id) throws Exception {
        return 0;
    }

    /**
     * 通过指定的条件更新
     *
     * @param arg 更新条件
     * @return 更新条数
     */
    @Override
    public <T> int updateByArg(@NotNull T arg) throws Exception {
        return 0;
    }


    /**
     * 登陆系统
     * 通过 身份证号，手机号，邮箱，用户名都可以登陆
     *
     * @param account    账户
     * @param password   密码
     * @param isRemember 是否记住密码
     * @return token
     */
    @Override
    public String login(String account, String password, boolean isRemember) throws Exception {

        if (StringUtils.isEmpty(account))
            throw new NullArgsException(DriverExceptionEnum.USER_NULL_VALUE.setDescription("用户名不能为空"));
        if (StringUtils.isEmpty(password))
            throw new NullArgsException(DriverExceptionEnum.USER_NULL_VALUE.setDescription("密码不能为空"));

        UsernamePasswordAuthenticationToken AuthenticationToken = new UsernamePasswordAuthenticationToken(account, password);
        final Authentication authenticate = authenticationManager.authenticate(AuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        UserDetails userDetails = userDetailsService.loadUserByUsername(account);
        return tokenProviderUtil.generateToken(userDetails, isRemember);
    }
}
