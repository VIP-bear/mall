package com.project.mall.service.impl;

import com.project.mall.controller.req.merchant.MerchantLoginReq;
import com.project.mall.controller.req.merchant.MerchantVerifyReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.IdentityFormRepository;
import com.project.mall.dao.MerchantRepository;
import com.project.mall.dao.entity.IdentityFormEntity;
import com.project.mall.dao.entity.MerchantEntity;
import com.project.mall.enums.ImageTypeEnum;
import com.project.mall.service.IMerchantService;
import com.project.mall.util.AliyunProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class MerchantServiceImpl implements IMerchantService {

    @Autowired
    private IdentityFormRepository identityFormRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    /**
     * 商家个人信息审核
     * @param merchantVerifyReq
     * @return
     */
    @Transactional
    @Override
    public ReqResult perInfoReview(MerchantVerifyReq merchantVerifyReq) {
        IdentityFormEntity entity = identityFormRepository.findByIdentifyNumber(merchantVerifyReq.getQualification_idnum());
        if (entity == null || !merchantVerifyReq.getQualification_realname().equals(entity.getUsername())) {
            return new ReqResult(900, "未查询到此人");
        }
        if (!merchantVerifyReq.getMerchant_license().equals(entity.getMerchant_license())) {
            return new ReqResult(901, "营业执照注册号无效");
        }
        // 将商家信息保存到数据库
        MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setMerchant_license(merchantVerifyReq.getMerchant_license());
        merchantEntity.setMerchant_shopname(merchantVerifyReq.getMerchant_shopname());
        merchantEntity.setBuyer_id(merchantVerifyReq.getBuyer_id());
        merchantEntity.setMerchant_state("可营业");
        merchantRepository.save(merchantEntity);
        return new ReqResult(902, "审核通过");
    }

}
