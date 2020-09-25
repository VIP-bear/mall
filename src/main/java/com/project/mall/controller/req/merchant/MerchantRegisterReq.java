package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 卖家注册
 */
@Data
public class MerchantRegisterReq {

    /**
     * 用户名
     */
    private String MerchantAccountName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 确认密码
     */
    private String confirmPassword;

    /**
     * 用户邮箱
     */
    private String mail;

    /**
    *用户手机
    */
    private long phoneNumber;

    /**
     * 真实姓名
     */
    private String MerchantName;

    /**
     * 照片链接
     */
    private String photo;
}
