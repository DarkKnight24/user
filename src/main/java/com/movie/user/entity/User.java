package com.movie.user.entity;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class User {
    /**
    * user_id
    */
    private Long userId;

    /**
    * 用户账号
    */
    @NotNull
    private String userName;

    /**
    * 用户密码
    */
    @NotNull
    private String userPwd;

    /**
    * 用户邮箱
    */
    @Email
    private String userEmail;

    /**
    * 用户权限 0：普通会员 1：管理员
    */
    @NotNull
    private Integer userRole;

    /**
    * 用户头像地址
    */
    private String userHeadImg;
}