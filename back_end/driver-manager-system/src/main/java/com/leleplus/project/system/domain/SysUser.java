package com.leleplus.project.system.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leleplus.common.enums.RoleKeys;
import com.leleplus.core.aspect.lang.annotation.Excel;
import com.leleplus.core.aspect.lang.annotation.Excel.ColumnType;
import com.leleplus.core.aspect.lang.annotation.Excel.Type;
import com.leleplus.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * 用户对象 sys_user
 *
 * @author witt
 */
@Data
@Accessors(chain = true)
@ToString
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Excel(name = "用户序号", cellType = ColumnType.NUMERIC, prompt = "用户编号")
    private Long id;

    /**
     * 用户账号
     */
    @Excel(name = "登录名称")
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
    private String username;

    /**
     * 用户昵称
     */
    @Excel(name = "用户名称")
    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    private String nickName;

    /**
     * 用户邮箱
     */
    @Excel(name = "用户邮箱")
    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    private String email;

    /**
     * 手机号码
     */
    @Excel(name = "手机号码")
    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    private String telphone;

    @Excel(name = "身份证号")
    private String idCard;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 密码
     */
    @JsonProperty
    private String password;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 帐号状态（0正常 1停用）
     */
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 最后登陆IP
     */
    @Excel(name = "最后登陆IP", type = Type.EXPORT)
    private String loginIp;

    /**
     * 最后登陆时间
     */
    @Excel(name = "最后登陆时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    private Date loginDate;

    /**
     * 部门对象
     */
//    @Excels({
//            @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
//            @Excel(name = "部门负责人", targetAttr = "leader", type = Type.EXPORT)
//    })
//    private SysDept dept;

    /**
     * 角色对象
     */
    private List<SysRole> roles;

    /**
     * 角色组
     */
//    private Long[] roleIds;

//    /**
//     * 岗位组
//     */
//    private Long[] postIds;

    /**
     * 用户信息id(表关联在用户信息表中)
     */
    private Long userInfoId;


    /**
     * 级联用户信息页面对象
     */
    private SysUserInfo userInfo;

    // 登录code
    private String code;

    // 登录uuid
    private String uuid;

    public SysUser() {

    }

    public SysUser(Long id) {
        this.id = id;
    }


    /**
     * 判断是不是管理员
     *
     * @return
     */
    public boolean isAdmin() {
        return checkRole(this.getRoles(), RoleKeys.ADMIN);
    }

    /**
     * 判断角色
     *
     * @param roles
     * @return
     */
    public static boolean checkRole(List<SysRole> roles, RoleKeys key) {
        if (roles == null || roles.size() == 0) {
            return false;
        }
        return roles.stream().anyMatch(item -> key.getRoleKey().equals(item.getRoleKey()));
    }

    /**
     * 判断是不是教练
     *
     * @return
     */
    public boolean isCoach() {
        return checkRole(this.getRoles(), RoleKeys.COACH);
    }

    /**
     * 判断是不是学员
     *
     * @return
     */
    public boolean isStudent() {
        return checkRole(this.getRoles(), RoleKeys.STUDENT);
    }

}
