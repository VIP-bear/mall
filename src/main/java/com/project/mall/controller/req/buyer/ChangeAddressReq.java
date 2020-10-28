package com.project.mall.controller.req.buyer;

import lombok.Data;

/**
 * 用户修改地址
 */
@Data
public class ChangeAddressReq {
    /**
     *地址内容
     */
    private String address_content;

    /**
     * 地址id
     */
    private Long address_id;
}
