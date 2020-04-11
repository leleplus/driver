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
 * @className AppointmentRecord
 * @date 2020-04-07 12:39
 * @description 预约记录
 */

@Data
@Accessors(chain = true)
public class AppointmentRecord extends BaseEntity {

    private static final long serialVersionUID = -4770002359296594592L;

    // 预约人
    private Long userInfoId;

    // 预约开始时间begin
    private Date reservation_begin_time;

    // 预约结束时间end
    private Date reservation_end_time;

    // 预约项目
    private String subject;

    // 预约详细信息
    private String details;

    // 预约状态（预约中，预约成功，已完成，未执行）
    private String status;

}
