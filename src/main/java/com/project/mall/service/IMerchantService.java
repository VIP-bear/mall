package com.project.mall.service;

import com.project.mall.controller.req.merchant.MerchantLoginReq;
import com.project.mall.controller.req.merchant.MerchantRegisterReq;
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
     * @param merchantRegisterReq
     * @return
     */
    ReqResult register(MerchantRegisterReq merchantRegisterReq);
}
