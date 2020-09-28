package com.project.mall.controller.req.merchant;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 卖家身份验证
 */
@Data
public class MerchantVerifyReq {


    /**
     * 真实姓名
     */
    private String merchantName;

    /**
     * 身份证号
     */
    private String identityNumber;

    /**
     * 营业执照注册号
     */
    private String merchantRegisterID;

    /**
     * 店铺名称
     */
    private String storeName;
}
