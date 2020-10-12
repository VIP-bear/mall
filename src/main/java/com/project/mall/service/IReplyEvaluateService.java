package com.project.mall.service;

import com.project.mall.controller.req.merchant.AddReplyReq;
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

    /**
     * 添加回复评论
     * @param addReplyReq
     * @return
     */
    ReqResult addReplyEvaluate(AddReplyReq addReplyReq);

}
