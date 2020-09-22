package com.project.mall.controller.req;

import lombok.Data;

@Data
public class UserRegisterReq {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 确认密码
     */
    private String confirmPassword;
}
