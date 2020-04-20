package com.leleplus.core.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 *
 * @author witt
 */
@Component
@ConfigurationProperties(prefix = "driver")
@Data
@Accessors(chain = true)
public class DriverSystemConfiguration {
    /**
     * 项目名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 版权年份
     */
    private String copyrightYear;

    /**
     * 实例演示开关
     */
    private boolean demoEnabled;

    /**
     * 上传路径
     */
    private static String profile;

    /**
     * 获取地址开关
     */
    private static boolean addressEnabled;

    // 刷卡存放redis中的key值
    private String swipeKey;

    // 刷卡时间
    private Integer swipeTime;


    public void setProfile(String profile) {
        DriverSystemConfiguration.profile = profile;
    }

    public void setAddressEnabled(boolean addressEnabled) {
        DriverSystemConfiguration.addressEnabled = addressEnabled;
    }

    public static String getProfile() {
        return profile;
    }

    public static boolean isAddressEnabled() {
        return addressEnabled;
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath() {
        return getProfile() + "/avatar";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath() {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath() {
        return getProfile() + "/upload";
    }

}