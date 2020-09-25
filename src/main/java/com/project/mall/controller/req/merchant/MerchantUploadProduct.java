package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 商家上传商品数据
 */
@Data
public class MerchantUploadProduct {
    /**
     * 商品类别
     */
    private String product_category;

    /**
     * 商品名称
     */
    private String product_name;

    /**
     * 商品描述
     */
    private String product_description;

    /**
     * 商品封面
     */
    private String product_cover;

    /**
     * 商品单价
     */
    private Double product_price;

    /**
     * 商品单位
     */
    private String product_unit;

    /**
     * 商品库存
     */
    private Double product_stock = 0.00;

    /**
     * 商品状态（包括审核中verifying、出售中on offer、下架undercarriage）
     */
    private String product_state;

    /**
     * 商品评分（默认为0（但在界面不显示），评价超过十人后计算平均评分作为商品评分并显示在界面）
     */
    private Double product_score = 0.0;

    /**
     * 卖家id
     */
    private Long merchant_id;
}
