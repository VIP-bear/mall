package com.project.mall.service.impl;

import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IEvaluateService;
import org.springframework.stereotype.Service;

/**
 * 评论服务
 */
@Service
public class EvaluateServiceImpl implements IEvaluateService {

    @Override
    public ReqResult queryEvaluateByProductId(Long productId, int page, int size) {
//        int offset = (page - 1) * size;
//        List<EvaluateEntity> evaluateList = evaluateRepository.findAllEvaluateByProductId(productId, offset, size);
//        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", evaluateList);
        return null;
    }

    @Override
    public ReqResult queryEvaluateByProductIdAndBuyerId(Long productId, Long buyerId) {

        return null;
    }

}
