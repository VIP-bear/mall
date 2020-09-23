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

    /**
     * 用户邮箱
     */
    private String mail;

    /**
    *用户手机
    */
    private long phoneNumber;


}
