package com.leleplus.common.enums;


import com.leleplus.core.aspect.DataScopeAspect;
import com.leleplus.project.system.domain.SysRole;
import lombok.Getter;
import lombok.ToString;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @enumName RoleKeys
 * @date 2020-03-31 14:48
 * @description 角色枚举
 */
@ToString
public enum RoleKeys {

    ADMIN(new SysRole("管理员", "ADMIN", "1", DataScopeAspect.DATA_SCOPE_ALL, "0", "0")),
    COACH(new SysRole("教练", "COACH", "2", DataScopeAspect.DATA_SCOPE_COACH, "0", "0")),
    STUDENT(new SysRole("学员", "STUDENT", "3", DataScopeAspect.DATA_SCOPE_STUDENT, "0", "0")),

    ;


    @Getter
    private final SysRole role;

    RoleKeys(SysRole role) {
        this.role = role;
    }

    public String getRoleKey() {
        return this.getRole().getRoleKey();
    }
}
