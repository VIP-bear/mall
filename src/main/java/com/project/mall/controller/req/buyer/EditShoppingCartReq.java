package com.project.mall.controller.req.buyer;

import lombok.Data;

/**
 * 修改购物车购买数量
 */
@Data
public class EditShoppingCartReq {
    /**
     * 商品ID
     */
    private long product_id;

    /**
     * 购买数量
     */
    private int product_num;
}
