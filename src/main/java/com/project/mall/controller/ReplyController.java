package com.project.mall.controller;

import com.project.mall.controller.req.merchant.AddReplyReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IReplyEvaluateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ReplyController {

    @Autowired
    IReplyEvaluateService replyEvaluateService;
    /**
     * 店铺回复用户评论
     * @param addReplyReq
     * @return
     */
    @PostMapping("/reply/addReply")
    @ResponseBody
    public ReqResult addReply(AddReplyReq addReplyReq) {
        log.info("/reply/addReply,addReplyReq:{}",addReplyReq);
        return replyEvaluateService.addReplyEvaluate(addReplyReq);
    }

    /**
     * 查看卖家回复
     * @param evaluateID
     * @return
     */
    @GetMapping("/reply/queryReply")
    @ResponseBody
    public ReqResult queryReply(@RequestParam(name = "evaluateID")Long evaluateID) {
        log.info("/reply/queryReply,evaluateID:{}",evaluateID);
        return  replyEvaluateService.queryReplyEvaluateByEvaluateId(evaluateID);
    }

}
