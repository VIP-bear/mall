package com.project.mall.controller.req.buyer;

import lombok.Data;

/**
 * 用户注册
 */
@Data
public class BuyerRegisterReq {

    /**
     * 用户名
     */
    private String buyerName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 确认密码
     */
    private String confirmPassword;

}
