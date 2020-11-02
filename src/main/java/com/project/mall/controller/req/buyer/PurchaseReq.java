package com.project.mall.controller.req.buyer;

import lombok.Data;

/**
 * 用户直接购买商品
 */
@Data
public class PurchaseReq {
    /**
     * 商品ID
     */
    private long product_id;

    /**
     * 用户ID
     */
    private long buyer_id;

    /**
     * 购买数量
     */
    private int order_num;

    /**
     * 商品单位
     */
    private String product_unit;

    /**
     * 订单总价
     */
    private Double order_cost;
    /**
     * 配送地址
     */
    private String order_address;
}
