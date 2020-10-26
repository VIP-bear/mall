package com.project.mall.controller.req;

import lombok.Data;

/**
 * 管理员登陆信息封装
 */
@Data
public class AdminLoginReq {
    /**
     * 管理员账号
     */
    private String admin_username;
    /**
     * 管理员密码
     */
    private String admin_pwd;
}
