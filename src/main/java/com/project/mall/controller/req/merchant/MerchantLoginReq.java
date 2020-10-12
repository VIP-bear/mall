package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 卖家登录
 */
@Data
public class MerchantLoginReq {

    /**
     * 用户名
     */
    private String buyer_mame;

    /**
     * 用户密码
     */
    private String buyer_password;

}
