package com.project.mall.controller.req;

import lombok.Data;

/**
 * 管理员修改商品状态
 */
@Data
public class AdministratorChangeStateReq {
    /**
     * 商品ID
     */
    private Long product_id;
    /**
     * 商品状态
     */
    private String product_state;
}
