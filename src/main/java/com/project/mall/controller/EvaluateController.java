package com.project.mall.controller;

import com.project.mall.controller.req.buyer.AddEvaluateReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IEvaluateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 评论功能的控制层
 */
@Controller
@Slf4j
public class EvaluateController {

    @Autowired
    IEvaluateService evaluateService;
    /**
     * 用户添加评论
     * @param addEvaluateReq
     * @return
     */
    @PostMapping("/evaluate/addEvaluate")
    @ResponseBody
    public ReqResult addEvaluate(AddEvaluateReq addEvaluateReq) {

        return evaluateService.addEvaluate(addEvaluateReq);
    }

    /**
     * 看评论
     * @param id
     * @param page
     * @return
     */
    @GetMapping("/evaluate/queryEvaluate")
    @ResponseBody
    public ReqResult queryEvaluate(@RequestParam(name ="productID")Long id,
                                   @RequestParam(name = "page")int page) {

        return evaluateService.queryEvaluateByProductId(id,page,10);
    }
}
