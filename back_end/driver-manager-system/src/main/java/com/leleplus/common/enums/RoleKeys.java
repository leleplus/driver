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

    ADMIN(new SysRole().setRoleName("管理员").setRoleKey("ADMIN").setRoleSort("1").setDataScope(DataScopeAspect.DATA_SCOPE_ALL).setStatus("0").setDelFlag("0")),
    COACH(new SysRole().setRoleName("教练").setRoleKey("COACH").setRoleSort("2").setDataScope(DataScopeAspect.DATA_SCOPE_COACH).setStatus("0").setDelFlag("0")),
    STUDENT(new SysRole().setRoleName("学员").setRoleKey("STUDENT").setRoleSort("3").setDataScope(DataScopeAspect.DATA_SCOPE_STUDENT).setStatus("0").setDelFlag("0")),

    ;


    @Getter
    private SysRole role;

    RoleKeys(SysRole role) {
        this.role = role;
    }

    public String getRoleKey(){
        return this.getRole().getRoleKey();
    }
}
