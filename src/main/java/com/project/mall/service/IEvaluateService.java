package com.project.mall.service;

import com.project.mall.controller.req.buyer.AddEvaluateReq;
import com.project.mall.controller.res.ReqResult;

/**
 * 评论接口
 */
public interface IEvaluateService {

    /**
     * 根据商品id分页查询评论
     * @param productId
     * @param page
     * @param size
     * @return
     */
    ReqResult queryEvaluateByProductId(Long productId, int page, int size);

    /**
     * 根据商品id和用户id查询商品
     * @param productId
     * @param buyerId
     * @return
     */
    ReqResult queryEvaluateByProductIdAndBuyerId(Long productId, Long buyerId);

    /**
     * 添加评论
     * @param addEvaluateReq
     * @return
     */
    ReqResult addEvaluate(AddEvaluateReq addEvaluateReq);

}
