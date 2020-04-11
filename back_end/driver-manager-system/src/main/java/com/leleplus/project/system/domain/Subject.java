package com.leleplus.project.system.domain;

import com.leleplus.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className Subject
 * @date 2020-04-06 22:44
 * @description 科目表
 */

@Data
@Accessors(chain = true)
public class Subject extends BaseEntity {
    private static final long serialVersionUID = -8626995085579900214L;

    // 科目名称
    private String name;

    // 科目代码
    private String code;


}
