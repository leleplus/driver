package com.leleplus.project.system.domain;

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
 * @className SysStudentCoach
 * @date 2020-03-31 13:01
 * @description 学员教练关联表 sys_student_coach
 * <p>
 * 实际上是User表中，多对多的桥表关联
 */
@Data
@Accessors(chain = true)
@ToString
public class SysStudentCoach extends BaseEntity {

    private static final long serialVersionUID = -7986259728749744343L;

    // 学员id（用户信息表，学员id）
    private Long studentId;

    // 教练id (用户信息表，教练id)
    private Long coachId;

    // 绑定时间
    private Date bindTime;

    // 是否解绑
    private Boolean isUntieBind;

}
