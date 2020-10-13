package com.project.mall.service.impl;

import com.project.mall.controller.req.merchant.MerchantVerifyReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.IdentityFormRepository;
import com.project.mall.dao.MerchantRepository;
import com.project.mall.dao.entity.IdentityFormEntity;
import com.project.mall.dao.entity.MerchantEntity;
import com.project.mall.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MerchantServiceImpl implements IMerchantService {

    @Autowired
    private IdentityFormRepository identityFormRepository;

    @Autowired
    private MerchantRepository merchantRepository;

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
        IdentityFormEntity entity = identityFormRepository.findByIdentifyNumber(merchantVerifyReq.getIdentityNumber());
        if (entity == null || !merchantVerifyReq.getMerchantName().equals(entity.getUsername())) {
            return new ReqResult(900, "未查询到此人");
        }
        if (!merchantVerifyReq.getMerchantLicense().equals(entity.getMerchant_license())) {
            return new ReqResult(901, "营业执照注册号无效");
        }
        // 将商家信息保存到数据库
        MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setMerchant_license(merchantVerifyReq.getMerchantLicense());
        merchantEntity.setMerchant_shopname(merchantVerifyReq.getStoreName());
        merchantEntity.setBuyer_id(merchantVerifyReq.getBuyerID());
        merchantEntity.setMerchant_state("可营业");
        merchantRepository.save(merchantEntity);
        return new ReqResult(902, "审核通过");
    }

}
