package com.project.mall.service.impl;

import com.project.mall.controller.req.merchant.AddReplyReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.ReplyRepository;
import com.project.mall.dao.entity.ReplyEntity;
import com.project.mall.enums.EvaluateTypeEnum;
import com.project.mall.service.IReplyEvaluateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 回复评论服务
 */
@Service
public class ReplyEvaluateServiceImpl implements IReplyEvaluateService {

    @Autowired
    private ReplyRepository replyRepository;

    /**
     * 根据评论id获取评论回复
     * @param evaluateId
     * @return
     */
    @Override
    public ReqResult queryReplyEvaluateByEvaluateId(Long evaluateId) {
        ReplyEntity replyEntity = replyRepository.findReplyByEvaluateId(evaluateId);
        if (replyEntity == null) {
            return new ReqResult(EvaluateTypeEnum.EVA_NOT_EXIST.getCode(), "评论不存在");
        }
        return new ReqResult(EvaluateTypeEnum.EVA_QUERY_SUCCESS.getCode(), "评论查询成功", replyEntity);
    }

    /**
     * 添加回复评论
     * @param addReplyReq
     * @return
     */
    @Transactional
    @Override
    public ReqResult addReplyEvaluate(AddReplyReq addReplyReq) {
        ReplyEntity replyEntity = new ReplyEntity();
        BeanUtils.copyProperties(addReplyReq, replyEntity);
        replyRepository.save(replyEntity);
        return new ReqResult(EvaluateTypeEnum.EVA_REPLY_SUCCESS.getCode(), "回复成功");
    }
}
