package com.project.mall.controller.req;

import lombok.Data;

@Data
public class UserChangePasswordReq {
    /**
     * 用户邮箱
     */
    private String mail;

    /**
     * 用户新密码
     */
    private String newPassword;

}
