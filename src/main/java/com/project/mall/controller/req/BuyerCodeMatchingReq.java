package com.project.mall.controller.req;

import lombok.Data;

@Data
public class BuyerCodeMatchingReq {

    /**
     * 用户邮箱
     */
    private String mail;
    /**
     * 验证码
     */
    private int code;
}
