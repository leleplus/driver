package com.leleplus.core.manager.factory;

import com.leleplus.common.constant.Constants;
import com.leleplus.common.utils.LogUtils;
import com.leleplus.common.utils.ServletUtils;
import com.leleplus.common.utils.ip.AddressUtils;
import com.leleplus.common.utils.ip.IpUtils;
import com.leleplus.common.utils.spring.SpringUtils;
import com.leleplus.project.monitor.domain.SysLogininfor;
import com.leleplus.project.monitor.domain.SysOperLog;
import com.leleplus.project.monitor.service.ISysLogininforService;
import com.leleplus.project.monitor.service.ISysOperLogService;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 * @author witt
 */
public class AsyncFactory {
    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

//    @Resource
//    private static SysLogininforMapper sysLogininforMapper;

    /**
     * 记录登陆信息
     *
     * @param account 用户登录时使用的账户
     * @param status  状态
     * @param message 消息
     * @param args    列表
     * @return 任务task
     */
    public static TimerTask recordLogininfor(final String account, final String status, final String message, final Object... args) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        return new TimerTask() {
            @Override
            public void run() {
                String address = AddressUtils.getRealAddressByIP(ip);
                // 打印信息到日志
                sys_user_logger.info(LogUtils.getBlock(ip) +
                        address +
                        LogUtils.getBlock(account) +
                        LogUtils.getBlock(status) +
                        LogUtils.getBlock(message), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                SysLogininfor logininfor =
                        new SysLogininfor()
                                .setAccount(account)
                                .setIpaddr(ip)
                                .setLoginLocation(address)
                                .setBrowser(browser)
                                .setOs(os)
                                .setMsg(message);
                // 日志状态
                if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
                    logininfor.setStatus(Constants.SUCCESS);
                } else if (Constants.LOGIN_FAIL.equals(status)) {
                    logininfor.setStatus(Constants.FAIL);
                }
                // 插入数据
                SpringUtils.getBean(ISysLogininforService.class).insertLogininfor(logininfor);


//              相当于  sysLogininforMapper.insertLogininfor(logininfor);
            }
        };
    }

    /**
     * 操作日志记录
     *
     * @param operLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final SysOperLog operLog) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
                operLog.setOperLocation(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
                SpringUtils.getBean(ISysOperLogService.class).insertOperlog(operLog);
            }
        };
    }
}
