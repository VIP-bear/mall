package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 卖家依关键字查询商品信息
 */
@Data
public class MerchantQueryProductByNameReq {
    /**
     * 商品名称
     */
    private String product_name;

    /**
     * 卖家ID
     */

    private Long buyer_id;
}
