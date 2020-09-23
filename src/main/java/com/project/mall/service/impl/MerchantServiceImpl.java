package com.project.mall.service.impl;

import com.project.mall.controller.req.merchant.MerchantLoginReq;
import com.project.mall.controller.req.merchant.MerchantRegisterReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IMerchantService;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements IMerchantService {

    /**
     * 卖家登录
     * @param merchantLoginReq
     * @return
     */
    @Override
    public ReqResult login(MerchantLoginReq merchantLoginReq) {
        return null;
    }

    /**
     * 卖家登录
     * @param merchantRegisterReq
     * @return
     */
    @Override
    public ReqResult register(MerchantRegisterReq merchantRegisterReq) {
        return null;
    }
}
