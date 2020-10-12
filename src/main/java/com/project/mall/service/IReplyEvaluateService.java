package com.project.mall.service;

import com.project.mall.controller.req.buyer.AddEvaluateReq;
import com.project.mall.controller.res.ReqResult;

/**
 * 回复评论接口
 */
public interface IReplyEvaluateService {

    /**
     * 根据评论id获取评论回复
     * @param evaluateId
     * @return
     */
    ReqResult queryReplyEvaluateByEvaluateId(Long evaluateId);

}
