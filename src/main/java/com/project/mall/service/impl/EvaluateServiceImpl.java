package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.AddEvaluateReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.EvaluateRepository;
import com.project.mall.dao.entity.EvaluateEntity;
import com.project.mall.enums.EvaluateTypeEnum;
import com.project.mall.service.IEvaluateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * 评论服务
 */
@Service
public class EvaluateServiceImpl implements IEvaluateService {

    @Autowired
    private EvaluateRepository evaluateRepository;

    @Override
    public ReqResult queryEvaluateByProductId(Long productId, int page, int size) {
        int offset = (page - 1) * size;
        List<EvaluateEntity> evaluateList = evaluateRepository.findAllByProductId(productId, offset, size);
        return new ReqResult(EvaluateTypeEnum.EVA_QUERY_SUCCESS.getCode(), "查询成功", evaluateList);
    }

    @Override
    public ReqResult queryEvaluateByProductIdAndBuyerId(Long productId, Long buyerId) {
        EvaluateEntity evaluateEntity = evaluateRepository.findAllByProductIdAndBuyerId(productId, buyerId);
        if (evaluateEntity == null) {
            return new ReqResult(EvaluateTypeEnum.EVA_NOT_EXIST.getCode(), "评论不存在", null);
        }
        return new ReqResult(EvaluateTypeEnum.EVA_QUERY_SUCCESS.getCode(), "评论查询成功", evaluateEntity);
    }

    @Transactional
    @Override
    public ReqResult addEvaluate(AddEvaluateReq addEvaluateReq) {
        EvaluateEntity evaluateEntity = new EvaluateEntity();
        BeanUtils.copyProperties(addEvaluateReq, evaluateEntity);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        evaluateEntity.setEvaluate_time(now);


        evaluateRepository.save(evaluateEntity);
        return new ReqResult(EvaluateTypeEnum.EVA_SUCCESS.getCode(), "评论成功");
    }

}
