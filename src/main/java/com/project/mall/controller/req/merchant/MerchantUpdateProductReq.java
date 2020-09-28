package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 更新商品信息
 */
@Data
public class MerchantUpdateProductReq {
    /**
     * 商品id
     */
    private Long ID;

    /**
     * 商品名称
     */
    private String merchantName;


}
