package com.project.mall.controller.req.buyer;

import lombok.Data;

/**
 * 修改/绑定手机号
 */
@Data
public class ChangePhoneNumberReq {
    /**
     * 买家/卖家ID
     */
    private Long ID;

    /**
     * 电话号
     */
    private Long phoneNumber;
}
