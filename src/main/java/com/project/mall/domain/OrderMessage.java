package com.project.mall.domain;

import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * 订单详细信息
 */
@Data
public class OrderMessage {

    /**
     * 订单id
     */
    private Long order_id;

    /**
     * 买家id
     */
    private Long buyer_id;

    /**
     * 商品id
     */
    private Long product_id;

    /**
     * 商品名称
     */
    private String product_name;

    /**
     * 购买数量
     */
    private Integer order_num;

    /**
     * 商品单位（个、只、条等等）
     */
    private String order_unit;

    /**
     * 花费金钱
     */
    private Double order_cost;

    /**
     * 配送地址信息
     */
    private String order_address;

    /**
     * 订单创建时间
     */
    private Timestamp create_time;

    /**
     * 订单状态(包括已支付payed、未支付unpayed、已取消canceled、配送中delivering、已完成completed、已退款refunded)
     */
    private String order_state;
}
