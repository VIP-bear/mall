package com.project.mall.service;

import com.project.mall.controller.req.merchant.MerchantLoginReq;
import com.project.mall.controller.req.merchant.MerchantVerifyReq;
import com.project.mall.controller.res.ReqResult;

/**
 * 商家服务接口
 */
public interface IMerchantService {

    /**
     * 商家个人信息审核
     * @param merchantVerifyReq
     * @return
     */
    ReqResult perInfoReview(MerchantVerifyReq merchantVerifyReq);


}
