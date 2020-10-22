package com.project.mall.controller.req.buyer;

import lombok.Data;

/**
 * 用户按订单状态查询订单
 */
@Data
public class QueryOrderReq {
    /**
     * 买家id
     */
    private Long buyer_name;
    /**
     * 商品状态
     */
    private String order_state;
}
