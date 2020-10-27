package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "mall_refund")
public class RefundEntity {

    /**
     * 订单id作为主键
     */
    @Id
    private Long order_id;

    /**
     * 退款描述
     */
    @Column
    private String refund_description;

    /**
     * 退款图片
     */
    @Column
    private String refund_pic;

    /**
     * 退款状态（1代表退款成功，0代表申请退款中，-1代表退款失败）
     */
    @Column
    private Integer refund_state;
}
