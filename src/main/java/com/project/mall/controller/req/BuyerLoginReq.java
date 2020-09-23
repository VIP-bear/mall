package com.project.mall.controller.req;

import lombok.Data;

/**
 * 用户登录
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
