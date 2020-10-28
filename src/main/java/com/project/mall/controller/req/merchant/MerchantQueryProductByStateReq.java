package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 买家依关键字查询商品信息
 */
@Data
public class MerchantQueryProductByStateReq {
    /**
     * 商品状态
     */
    private String product_state;

    /**
     * 卖家ID
     */

    private Long merchant_id;
}
