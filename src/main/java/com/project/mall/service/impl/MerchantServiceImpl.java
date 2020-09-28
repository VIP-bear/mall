package com.project.mall.service.impl;

import com.project.mall.controller.req.merchant.MerchantLoginReq;
import com.project.mall.controller.req.merchant.MerchantVerifyReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.IdentityFormRepository;
import com.project.mall.enums.ImageTypeEnum;
import com.project.mall.service.IMerchantService;
import com.project.mall.util.AliyunProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MerchantServiceImpl implements IMerchantService {

    @Autowired
    private IdentityFormRepository identityFormRepository;

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
     * 商家个人信息审核
     * @param merchantVerifyReq
     * @return
     */
    @Transactional
    @Override
    public ReqResult perInfoReview(MerchantVerifyReq merchantVerifyReq) {
        identityFormRepository.findByIdentifyNumber(merchantVerifyReq.getMerchantRegisterID());
        return null;
    }

    @Override
    public ReqResult storeReview() {
        return null;
    }

}
