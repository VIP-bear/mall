package com.project.mall.domain;


import lombok.Data;

/**
 * 申请退款信息
 */
@Data
public class RefundMessage {

    /**
     * 订单id
     */
    private Long order_id;

    /**
     * 退款描述
     */
    private String refund_description;

    /**
     * 商品id
     */
    private Long product_id;

    /**
     * 购买数量
     */
    private Integer order_num;


    /**
     * 退款金额
     */
    private Double order_cost;

    /**
     * 商品名称
     */
    private String product_name;

    /**
     * 商品封面
     */
    private String product_cover;


}
