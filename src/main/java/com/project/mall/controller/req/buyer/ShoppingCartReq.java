package com.project.mall.controller.req.buyer;


import lombok.Data;

/**
 * 添加购物车
 */
@Data
public class ShoppingCartReq {
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
    private int product_num;

    /**
     * 地址
     */
    private String cart_address;
}
