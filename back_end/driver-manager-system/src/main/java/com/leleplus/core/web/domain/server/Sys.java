package com.leleplus.core.web.domain.server;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 系统相关信息
 *
 * @author witt
 */
@Data
@Accessors(chain = true)
public class Sys {
    /**
     * 服务器名称
     */
    private String computerName;

    /**
     * 服务器Ip
     */
    private String computerIp;

    /**
     * 项目路径
     */
    private String userDir;

    /**
     * 操作系统
     */
    private String osName;

    /**
     * 系统架构
     */
    private String osArch;
}
