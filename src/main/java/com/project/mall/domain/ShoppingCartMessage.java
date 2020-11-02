package com.project.mall.domain;

import lombok.Data;

/**
 * 返回给前端的购物车信息
 */
@Data
public class ShoppingCartMessage {

    /**
     * 购物车id
     */
    private Long cart_id;

    /**
     * 买家id
     */
    private Long buyer_id;

    /**
     * 购物车中商品数量
     */
    private Integer cart_num;

    /**
     * 商品id
     */
    private Long product_id;

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
    private Integer product_stock = 0;

    /**
     * 商品状态（包括审核中verifying、出售中on offer、下架undercarriage）
     */
    private String product_state;

    /**
     * 商品评分（默认为0（但在界面不显示），评价超过十人后计算平均评分作为商品评分并显示在界面）
     */
    private Double product_score = 0.0;

    /**
     *买家地址
     */
    private String address;

    /**
     * 卖家id
     */
    private Long merchant_id;

}
