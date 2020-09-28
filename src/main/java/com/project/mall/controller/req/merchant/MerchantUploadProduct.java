package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 商家上传商品数据
 */
@Data
public class MerchantUploadProduct {
    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品类别
     */
    private String productType;

    /**
     * 商品图片
     */
    private String productPicture;

    /**
     * 商品单价
     */
    private int UnitPrice;

    /**
     * 商品销售单位
     */
    private String SalesUnit;
    /**
     * 商品库存
     */
    private String aaaa;
}
