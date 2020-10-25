package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.AddEvaluateReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.EvaluateRepository;
import com.project.mall.dao.entity.EvaluateEntity;
import com.project.mall.enums.EvaluateTypeEnum;
import com.project.mall.service.IEvaluateService;
import com.project.mall.util.AliyunProvider;
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

    @Autowired
    private AliyunProvider aliyunProvider;

    /**
     * 根据商品id分页查询评论
     * @param productId
     * @param page
     * @param size
     * @return
     */
    @Override
    public ReqResult queryEvaluateByProductId(Long productId, int page, int size) {
        int offset = (page - 1) * size;
        List<EvaluateEntity> evaluateList = evaluateRepository.findAllByProductId(productId, offset, size);
        return new ReqResult(EvaluateTypeEnum.EVA_QUERY_SUCCESS.getCode(), "查询成功", evaluateList);
    }

    /**
     * 根据商品id和用户id查询评论
     * @param productId
     * @param buyerId
     * @return
     */
    @Override
    public ReqResult queryEvaluateByProductIdAndBuyerId(Long productId, Long buyerId) {
        EvaluateEntity evaluateEntity = evaluateRepository.findAllByProductIdAndBuyerId(productId, buyerId);
        if (evaluateEntity == null) {
            return new ReqResult(EvaluateTypeEnum.EVA_NOT_EXIST.getCode(), "评论不存在", null);
        }
        return new ReqResult(EvaluateTypeEnum.EVA_QUERY_SUCCESS.getCode(), "评论查询成功", evaluateEntity);
    }

    /**
     * 添加评论
     * @param addEvaluateReq
     * @return
     */
    @Transactional
    @Override
    public ReqResult addEvaluate(AddEvaluateReq addEvaluateReq) {

        // 判断当前用户是否评论过
        ReqResult reqResult = queryEvaluateByProductIdAndBuyerId(addEvaluateReq.getProduct_id(), addEvaluateReq.getBuyer_id());
        if (null == reqResult.getData()) {
            // 当前用户评论过
            return reqResult;
        }

        // 当前用户没有评论过当前商品
        EvaluateEntity evaluateEntity = new EvaluateEntity();
        BeanUtils.copyProperties(addEvaluateReq, evaluateEntity);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        evaluateEntity.setEvaluate_time(now);
        // 上传图片到服务器返回图片url
        if (addEvaluateReq.getEvaluate_pic1() != null) {
            evaluateEntity.setEvaluate_pic1(aliyunProvider.upload(addEvaluateReq.getEvaluate_pic1(), "comment_pic/"));
        }
        if (addEvaluateReq.getEvaluate_pic2() != null) {
            evaluateEntity.setEvaluate_pic2(aliyunProvider.upload(addEvaluateReq.getEvaluate_pic2(), "comment_pic/"));
        }
        if (addEvaluateReq.getEvaluate_pic3() != null) {
            evaluateEntity.setEvaluate_pic3(aliyunProvider.upload(addEvaluateReq.getEvaluate_pic3(), "comment_pic/"));
        }
        // 保存评论
        evaluateRepository.save(evaluateEntity);
        return new ReqResult(EvaluateTypeEnum.EVA_SUCCESS.getCode(), "评论成功");
    }

}
