package com.project.mall.controller.req.buyer;

/**
 * 用户创建订单
 */

import lombok.Data;
@Data
public class AddOrderReq {
    /**
     * 买家id
     */
    private Long buyer_id;

    /**
     * 商品id
     */
    private Long product_id;

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


}
