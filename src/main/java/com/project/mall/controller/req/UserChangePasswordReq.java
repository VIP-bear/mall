package com.project.mall.controller.req;

import lombok.Data;

/**
 * 用户修改密码
 */
@Data
public class UserChangePasswordReq {
    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户新密码
     */
    private String newPassword;

}
