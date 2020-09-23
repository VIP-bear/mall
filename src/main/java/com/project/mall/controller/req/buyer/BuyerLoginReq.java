package com.project.mall.controller.req.buyer;

import lombok.Data;

/**
 * 买家登录
 */
@Data
public class BuyerLoginReq {

    /**
     * 用户名
     */
    private String buyerName;

    /**
     * 用户密码
     */
    private String password;

}
