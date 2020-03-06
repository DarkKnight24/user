package com.movie.user.entity;

import com.movie.base.constant.UserConstant;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class User {
    /**
     * user_id
     */
    private Long userId;

    /**
     * 用户账号
     */
    @NotNull(message = "用户名不能为空")
    private String userName;

    /**
     * 用户密码
     */
    @NotNull(message = "用户密码不能为空")
    private String userPwd;

    /**
     * 用户邮箱
     */
    @Email(message = "邮箱格式错误")
    private String userEmail;

    /**
     * 用户权限 0：普通会员 1：管理员
     */
    @NotNull(message = "用户角色不能为空")
    private Integer userRole;

    /**
     * 用户头像地址
     */
    private String userHeadImg = UserConstant.DEFAULT_IMAGE;
}