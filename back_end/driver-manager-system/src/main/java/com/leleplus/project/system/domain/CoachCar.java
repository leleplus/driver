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
 * @className CoachCar
 * @date 2020-04-06 22:27
 * @description 教练车
 */

@Data
@Accessors(chain = true)
public class CoachCar extends BaseEntity {
    private static final long serialVersionUID = -3673996057141152763L;

    // 车牌号
    private String numberPlate;

    // 车辆型号
    private String model;

    // 车宽
    private String width;

    // 车高
    private String hight;

    // 车长
    private String length;

    // 颜色
    private String color;

    // 购买日期
    private Date purchaseDate;

    // 购买价格
    private String price;

    // 数据是否有效
    private Boolean isValid;

    // 是否删除记录
    private Boolean deleted;
}
