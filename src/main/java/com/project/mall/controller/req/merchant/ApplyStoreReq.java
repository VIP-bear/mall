package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 申请成为商户数据封装
 */
@Data
public class ApplyStoreReq {
    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String identityNumber;

    /**
     * 营业执照注册号
     */
    private String merchantRegisterID;
}
