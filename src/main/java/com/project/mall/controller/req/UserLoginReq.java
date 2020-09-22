package com.project.mall.controller.req;

import lombok.Data;

@Data
public class UserLoginReq {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

}
