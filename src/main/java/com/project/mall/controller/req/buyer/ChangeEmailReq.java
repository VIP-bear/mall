package com.project.mall.controller.req.buyer;

import lombok.Data;

/**
 * 用户修改/绑定邮箱
 */
@Data
public class ChangeEmailReq {
    /**
     * 买家/卖家ID
     */
    private int ID;

    /**
     * 绑定/修改的邮箱地址
     */
    private String email;
}
