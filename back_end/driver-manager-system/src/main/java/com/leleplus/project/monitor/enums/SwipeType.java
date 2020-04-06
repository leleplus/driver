package com.leleplus.project.monitor.enums;


import lombok.Getter;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @enumName SwipeType
 * @date 2020-04-06 21:33
 * @description 刷卡类型
 */
public enum SwipeType {
    DOOR(1, "门禁", "_SWIPE_1", 'Y', '0', "门禁刷卡"),
    CAR_DOOR(2, "车门禁", "_SWIPE_2", 'N', '0', "开车，门禁刷卡"),
    ACCELERATOR(3, "油门", "_SWIPE_3", 'N', '0', "油门上限触发"),
    GEAR(4, "档位", "_SWIPE_4", 'N', '0', "档位上限触发");

    @Getter
    private Integer sort;

    @Getter
    private String label;

    @Getter
    private String code;

    @Getter
    private char isDefault;

    @Getter
    private char status;

    @Getter
    private String remark;

    SwipeType(Integer sort, String label, String code, char isDefault, char status, String remark) {
        this.sort = sort;
        this.label = label;
        this.code = code;
        this.isDefault = isDefault;
        this.status = status;
        this.remark = remark;
    }
}
