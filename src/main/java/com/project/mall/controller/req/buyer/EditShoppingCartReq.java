package com.project.mall.controller.req.buyer;

import lombok.Data;

/**
 * 修改购物车购买数量
 */
@Data
public class EditShoppingCartReq {
    /**
     * 购物车ID
     */
    private long cart_id;

    /**
     * 购买数量
     */
    private int product_num;
}
