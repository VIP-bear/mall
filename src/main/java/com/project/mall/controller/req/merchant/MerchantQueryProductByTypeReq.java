package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 买家依关键字查询商品信息
 */
@Data
public class MerchantQueryProductByTypeReq {
    /**
     * 商品类别
     */
    private String product_category;

    /**
     * 卖家ID
     */

    private Long buyer_id;
}
