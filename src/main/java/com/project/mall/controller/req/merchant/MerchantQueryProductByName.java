package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 买家依关键字查询商品信息
 */
@Data
public class MerchantQueryProductByName {
    /**
     * 商品名称
     */
    private String productName;

    /**
     * 卖家ID
     */

    private int MerchantID;
}
