package com.project.mall.service;

import com.project.mall.controller.req.merchant.MerchantLoginReq;
import com.project.mall.controller.req.merchant.MerchantRegisterReq;
import com.project.mall.controller.res.ReqResult;

/**
 * 商家服务接口
 */
public interface IMerchantService {

    /**
     * 商家登录
     * @param merchantLoginReq
     * @return
     */
    ReqResult login(MerchantLoginReq merchantLoginReq);

    ReqResult perInfoReview();


}
