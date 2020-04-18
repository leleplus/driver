package com.leleplus.project.system.domain;

import com.leleplus.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className RFIDCard
 * @date 2020-04-05 16:18
 * @description RFID卡片实体类
 */

@Data
@Accessors(chain = true)
public class RFIDCard extends BaseEntity {
    private static final long serialVersionUID = 5589334538236443797L;

    // 物理卡号
    private String phyNumber;

    // 颜色
    private String color;

    // 尺寸
    private String size;

    // 类型（白卡，异形卡）
    private String type;

    // 卡片状态（是否在使用）
    private String status;

    // 删除标志
    private Boolean deleted;

    // 管理员刷卡message()
    private Boolean isNew;

}
