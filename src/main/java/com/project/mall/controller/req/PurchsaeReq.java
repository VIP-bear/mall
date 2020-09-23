package com.project.mall.controller.req;

import lombok.Data;

/**
 * 用户直接购买商品
 */
@Data
public class PurchsaeReq {
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

    /**
     * 配送地址
     */
    private String address;
}
