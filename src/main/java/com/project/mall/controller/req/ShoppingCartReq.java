package com.project.mall.controller.req;


import lombok.Data;

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
