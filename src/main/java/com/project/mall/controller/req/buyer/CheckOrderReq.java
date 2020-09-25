package com.project.mall.controller.req.buyer;

import lombok.Data;

/**
 * 拉取订单信息
 */
@Data
public class CheckOrderReq {
    /**
     * 买家id
     */
    private int buyerID;
}
