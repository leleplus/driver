package com.leleplus.project.system.mapper;


import com.leleplus.project.system.domain.SysUser;
import com.leleplus.project.system.domain.vo.LoginCertificate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表 数据层
 *
 * @author witt
 */
public interface SysUserMapper {
    /**
     * 根据条件分页查询用户列表
     *
     * @param sysUser 用户信息
     * @return 用户信息集合信息
     */
    List<SysUser> selectUserList(SysUser sysUser);

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return 用户对象信息
     */
    SysUser selectUserByUserName(String username);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    SysUser selectUserById(Long userId);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int insertUser(SysUser user);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int updateUser(SysUser user);

    /**
     * 修改用户头像
     *
     * @param username 用户名
     * @param avatar   头像地址
     * @return 结果
     */
    int updateUserAvatar(@Param("username") String username, @Param("avatar") String avatar);

    /**
     * 重置用户密码
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    int resetUserPwd(@Param("username") String username, @Param("password") String password);

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    int deleteUserById(Long userId);

    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的用户ID
     * @return 结果
     */
    int deleteUserByIds(Long[] userIds);

    /**
     * 校验用户名称是否唯一
     *
     * @param username 用户名称
     * @return 结果
     */
    int checkUserNameUnique(String username);

    /**
     * 校验手机号码是否唯一
     *
     * @param telphone 手机号码
     * @return 结果
     */
    SysUser checkPhoneUnique(String telphone);

    /**
     * 校验email是否唯一
     *
     * @param email 用户邮箱
     * @return 结果
     */
    SysUser checkEmailUnique(String email);

    /**
     * 通过登录凭证查询，需要携带角色信息
     *
     * @param loginCertificate
     * @return
     */
    SysUser selectUserByLoginCertificate(LoginCertificate loginCertificate);

    /**
     * 查询用户，根据角色
     *
     * @param roleKey
     * @return
     */
    SysUser selectUserByRoleKey(String roleKey);
}
