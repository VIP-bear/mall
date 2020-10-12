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
    private String buyer_name;

    /**
     * 用户密码
     */
    private String buyer_pwd;

    /**
     * 用户邮箱
     */
    private String buyer_email;
}
