package com.leleplus.project.system.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
public class SysStudentCoach {

    private Long id;

    // 学员id
    private Long studentId;

    // 教练id
    private Long coachId;

    // 绑定时间
    private Date bindTime;

    // 状态
    private String status;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("studentId", getStudentId())
                .append("coachId", getCoachId())
                .append("bindTime", getBindTime())
                .append("status", getStatus())
                .toString();
    }
}
