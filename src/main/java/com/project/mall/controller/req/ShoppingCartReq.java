package com.project.mall.controller.req;


import lombok.Data;

/**
 * 添加购物车
 */
@Data
public class ShoppingCartReq {
    /**
     * 商品ID
     */
    private long productID;

    /**
     * 用户ID
     */
    private long buyerID;

    /**
     * 购买数量
     */
    private int productNum;
}
