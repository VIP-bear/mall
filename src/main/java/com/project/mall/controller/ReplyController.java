package com.project.mall.controller;

import com.project.mall.controller.req.merchant.AddReplyReq;
import com.project.mall.controller.res.ReqResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ReplyController {


    /**
     * 店铺回复用户评论
     * @param addReplyReq
     * @return
     */
    @PostMapping("/reply/addReply")
    @ResponseBody
    public ReqResult addReply(AddReplyReq addReplyReq) {

        return null;
    }

    @GetMapping("/reply/queryReply")
    @ResponseBody
    public ReqResult queryReply(@RequestParam(name = "replyID")Long reply_id) {

        return  null;
    }

}
