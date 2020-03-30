package com.leleplus.core.security.service;

import com.leleplus.common.enums.UserStatus;
import com.leleplus.common.exception.BaseException;
import com.leleplus.common.utils.StringUtils;
import com.leleplus.core.security.LoginUser;
import com.leleplus.project.system.domain.SysUser;
import com.leleplus.project.system.domain.vo.LoginCertificate;
import com.leleplus.project.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户验证处理
 *
 * @author witt
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private ISysUserService userService;

    @Autowired
    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String certificate) throws UsernameNotFoundException {
        // 使用正则匹配登录方式，登录名，手机号，身份证号，邮箱

        LoginCertificate loginCertificate = LoginCertificate.getInstance();

        if(StringUtils.isTelNumber(certificate)){
            loginCertificate.setTelPhone(certificate);
        }else if(StringUtils.isIdCardNumber(certificate)){
            loginCertificate.setId_number(certificate);
        }else if(StringUtils.isEmail(certificate)){
            loginCertificate.setEmail(certificate);
        }else {
            loginCertificate.setLoginId(certificate);
        }
        
        


        SysUser user = userService.selectUserByUserName(certificate);
        if (StringUtils.isNull(user)) {
            log.info("登录用户：{} 不存在.", certificate);
            throw new UsernameNotFoundException("登录用户：" + certificate + " 不存在");
        } else if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            log.info("登录用户：{} 已被删除.", certificate);
            throw new BaseException("对不起，您的账号：" + certificate + " 已被删除");
        } else if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            log.info("登录用户：{} 已被停用.", certificate);
            throw new BaseException("对不起，您的账号：" + certificate + " 已停用");
        }

        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user) {
        return new LoginUser(user, permissionService.getMenuPermission(user));
    }
}
