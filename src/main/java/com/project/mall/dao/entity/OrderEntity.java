package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DecimalFormat;

/**
 * 订单表
 */
@Entity
@Data
@Table(name = "mall_order")
public class OrderEntity {

    /**
     * 订单id，自增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long order_id;

    /**
     * 买家id
     */
    @Column
    private Long buyer_id;

    /**
     * 商品id
     */
    @Column
    private Long product_id;

    /**
     * 购买数量
     */
    @Column
    private Integer order_num;

    /**
     * 商品单位（个、只、条等等）
     */
    @Column
    private String order_unit;

    /**
     * 花费金钱
     */
    @Column(columnDefinition = "decimal(10,2)")
    private Double order_cost;

    /**
     * 配送地址信息
     */
    @Column
    private String order_address;

    /**
     * 订单创建时间
     */
    @Column
    private Timestamp create_time;

    /**
     * 订单状态(包括未支付unpayed、配送中delivering、已完成completed、已退款refunded、退款中refunding)
     */
    @Column
    private String order_state;
}
