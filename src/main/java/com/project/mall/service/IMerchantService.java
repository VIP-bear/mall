package com.project.mall.service;

import com.project.mall.controller.req.merchant.MerchantLoginReq;
import com.project.mall.controller.req.merchant.MerchantVerifyReq;
import com.project.mall.controller.res.ReqResult;

public interface IMerchantService {

    /**
     * 商家登录
     * @param merchantLoginReq
     * @return
     */
    ReqResult login(MerchantLoginReq merchantLoginReq);

    /**
     * 商家注册
     * @param merchantVerifyReq
     * @return
     */
    ReqResult register(MerchantVerifyReq merchantVerifyReq);
}
