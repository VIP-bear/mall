package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 买家依关键字查询商品信息
 */
@Data
public class MerchantQueryProductByType {
    /**
     * 商品类别
     */
    private String productType;

    /**
     * 卖家ID
     */

    private int MerchantID;
}
