package com.leleplus.core.security.service;

import com.leleplus.common.constant.Constants;
import com.leleplus.common.exception.CustomException;
import com.leleplus.common.exception.user.CaptchaException;
import com.leleplus.common.exception.user.UserPasswordNotMatchException;
import com.leleplus.common.utils.MessageUtils;
import com.leleplus.common.utils.SecurityUtils;
import com.leleplus.common.utils.StringUtils;
import com.leleplus.core.manager.AsyncManager;
import com.leleplus.core.manager.factory.AsyncFactory;
import com.leleplus.core.redis.RedisCache;
import com.leleplus.core.security.LoginUser;
import com.leleplus.project.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录校验方法
 *
 * @author witt
 */
@Component
@Slf4j
public class SysLoginService {


    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysUserService userService;

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 原始密码
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid) {

        // debug信息，打出登录信息
        log.debug("login user -> {} - {}<-password", username, SecurityUtils.encryptPassword(password));

        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        // 从redis里拿到验证码后，立即删除
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);

        // 获取异步任务管理器实例
        AsyncManager asyncManagerInstance = AsyncManager.getInstance();

        // 验证码过期(从redis里没有拿到验证码)
        if (StringUtils.isEmpty(captcha)) {
            asyncManagerInstance.execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.expire")));
            throw new CaptchaException();
        }
        // 验证码错误
        if (!code.equalsIgnoreCase(captcha)) {
            asyncManagerInstance.execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error")));
            throw new CaptchaException();
        }
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                asyncManagerInstance.execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            } else {
                asyncManagerInstance.execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new CustomException(e.getMessage());
            }
        }
        asyncManagerInstance.execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 生成token
        return tokenService.createToken(loginUser);
    }
}
