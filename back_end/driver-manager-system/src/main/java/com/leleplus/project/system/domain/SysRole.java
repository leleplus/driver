package com.leleplus.project.system.domain;


import com.leleplus.common.enums.RoleKeys;
import com.leleplus.core.aspect.lang.annotation.Excel;
import com.leleplus.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 角色表 sys_role
 *
 * @author witt
 */

@Data
@Accessors(chain = true)
@ToString
public class SysRole extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @Excel(name = "角色序号", cellType = Excel.ColumnType.NUMERIC)
    private Long roleId;

    /**
     * 角色名称
     */
    @Excel(name = "角色名称")
    @NotBlank(message = "角色名称不能为空")
    @Size(min = 0, max = 30, message = "角色名称长度不能超过30个字符")
    private String roleName;

    /**
     * 角色权限
     */
    @Excel(name = "角色权限")
    @NotBlank(message = "权限字符不能为空")
    @Size(min = 0, max = 100, message = "权限字符长度不能超过100个字符")
    private String roleKey;

    /**
     * 角色排序
     */
    @Excel(name = "角色排序")
    @NotBlank(message = "显示顺序不能为空")
    private String roleSort;

    /**
     * 数据范围（1：所有数据权限（管理员）；2：教练数据权限；3：学员数据权限；4：自定义数据权限）
     */
    @Excel(name = "数据范围", readConverterExp = "1=所有数据权限（管理员）,2=教练数据权限,3=学员数据权限,4=自定义数据权限")
//    @Excel(name = "数据范围", readConverterExp = "1=所有数据权限,2=自定义数据权限,3=本部门数据权限,4=本部门及以下数据权限")
    private String dataScope;

    /**
     * 角色状态（0正常 1停用）
     */
    @Excel(name = "角色状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 用户是否存在此角色标识 默认不存在
     */
    private boolean flag = false;

    /**
     * 菜单组
     */
    private Long[] menuIds;

    /**
     * 部门组（数据权限）
     */
    private Long[] deptIds;

    public SysRole() {
    }

    public SysRole(Long roleId) {
        this.roleId = roleId;
    }

    public SysRole(String roleName, String roleKey, String roleSort, String dataScope, String status, String delFlag) {
        this.roleName = roleName;
        this.roleKey = roleKey;
        this.roleSort = roleSort;
        this.dataScope = dataScope;
        this.status = status;
        this.delFlag = delFlag;
    }


    public void setRoleKey(RoleKeys roleKey) {
        this.roleKey = roleKey.getRole().getRoleKey();
    }

    public boolean isAdmin() {
        return isAdmin(this);
    }

    /**
     * 判断是不是管理员
     *
     * @param role
     * @return
     */
    public static boolean isAdmin(SysRole role) {
        if (role == null) {
            return false;
        }
        return RoleKeys.ADMIN.getRole().getRoleKey().equals(role.getRoleKey());
    }
}
