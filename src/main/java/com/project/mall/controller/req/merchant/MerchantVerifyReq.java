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
    private String qualification_realname;

    /**
     * 身份证号
     */
    private String qualification_idnum;

    /**
     * 营业执照注册号
     */
    private String merchant_license;

    /**
     * 店铺名称
     */
    private String merchant_shopname;

    /**
     * 买家ID
     */
    private Long buyer_id;
}
