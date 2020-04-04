package com.leleplus.project.system.domain;

import com.leleplus.core.aspect.lang.annotation.Excel;
import com.leleplus.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className SysUserInfo
 * @date 2020-03-31 14:03
 * @description 用户信息实体
 */

@Data
@Accessors(chain = true)
@ToString
public class SysUserInfo extends BaseEntity {

    private static final long serialVersionUID = -4464960271991939447L;

    /**
     * 公共属性
     */

    // 真实姓名
    private String realName;

    // 年龄
    private Integer age;

    // 出生日期
    private Date birthday;

    // 性别
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String gender;

    // 民族
    private String national;

    // 联系地址
    private String address;

    // 纸质档案编号
    private String paperFileNumber;

    // 驾照类型
    private Long driverType;

    // 体检时间
    private Date medicalTime;

    // 记录是否有效
    @Excel(name = "记录是否有效", readConverterExp = "0=有效,1=无效")
    private Boolean deleted;

    // 证件照片
    private String idPhoto;


    /**
     * 管理员属性
     */


    // 管理员教练公共属性

    // 教练车外键
    private Long carInfoId;

    // 工资
    private String wage;

    // 部门
    private Long deptId;

    // 职位
    private Long[] positionIds;


    /**
     * 教练属性
     */


    /**
     * 学员属性开始
     */

    // 经办人
    private Long agent;

    // 报名时间
    private Date signDate;

    // 毕业截止日期
    private Date expirationTime;

    // RFID卡片的id
    private Long RFIDId;

}
