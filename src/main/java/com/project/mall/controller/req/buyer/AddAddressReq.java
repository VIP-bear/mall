package com.project.mall.controller.req.buyer;

import lombok.Data;

import javax.persistence.Column;

/**
 * 添加地址
 */
@Data
public class AddAddressReq {

    /**
     * 标记该地址是否为默认地址，1代表是默认地址，0代表非默认地址（默认值为0）
     */
    private int address_default;

    /**
     *地址内容
     */
    private String address_content;

    /**
     * 买家id
     */
    private Long buyer_id;
}
