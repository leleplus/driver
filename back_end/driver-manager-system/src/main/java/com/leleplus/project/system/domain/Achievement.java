package com.leleplus.project.system.domain;

import com.leleplus.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className Achievement
 * @date 2020-04-06 22:50
 * @description 成绩表
 */

@Data
@Accessors(chain = true)
public class Achievement extends BaseEntity {
    private static final long serialVersionUID = 4831520767228001970L;

    // 考生
    private String userInfoId;

    //  科目
    private String subject;

    // 成绩(第一次)
    private float score;

    // 是否合格
    private Boolean isPass = score >= 80;

    // 考试类型
    private String type;

    // 考试时间
    private Date examTime;

    // 考场
    private String examRoom;

    // 设备号
    private String deviceNo;

}