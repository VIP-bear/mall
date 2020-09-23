package com.project.mall.controller.req;

import lombok.Data;

/**
 * 确认购物车
 */
@Data
public class ConfirmShoppingCartReq {

    /**
     *配送地址
     */
    private String address;

    /**
     * 商品ID
     */
    private long productID;

    /**
     * 用户ID
     */
    private long userID;

    /**
     * 购买数量
     */
    private int productNum;
}
