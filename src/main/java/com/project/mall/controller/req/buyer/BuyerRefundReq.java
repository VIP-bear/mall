package com.project.mall.controller.req.buyer;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 买家退款
 */
@Data
public class BuyerRefundReq {
    /**
     * 订单id作为主键
     */
    private Long order_id;

    /**
     * 退款描述
     */
    private String refund_description;

    /**
     * 退款图片
     */
    private String refund_pic;




}
