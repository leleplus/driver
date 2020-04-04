package com.leleplus.project.system.domain;

import com.leleplus.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className DriverLicense
 * @date 2020-04-03 17:11
 * @description 驾驶证实体
 */

@Data
@Accessors(chain = true)
public class DriverLicense extends BaseEntity {

    private static final long serialVersionUID = -517169175299546682L;

    // 驾驶证代号
    private String code;

    // 准假车型
    private String allowCarType;

    // 准予驾驶的其他车辆
    private String otherTypes;

    //     @Excel(name = "记录是否有效", readConverterExp = "0=有效,1=无效")

    private Boolean deleted;

    public DriverLicense() {
    }

    public DriverLicense(String code, String allowCarType, String otherTypes, Boolean deleted) {
        this.code = code;
        this.allowCarType = allowCarType;
        this.otherTypes = otherTypes;
        this.deleted = deleted;
    }
}
