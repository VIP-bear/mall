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
     * 照片
     */
    private MultipartFile photo;

    /**
     * 营业执照注册号
     */
    private String merchantRegisterID;
}
