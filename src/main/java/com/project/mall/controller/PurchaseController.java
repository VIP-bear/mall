package com.project.mall.controller;

import com.project.mall.controller.req.PurchsaeReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IPurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class PurchaseController {
    @Autowired
    IPurchaseService purchase;

    @PostMapping("/purchase")
    @ResponseBody
    public ReqResult purchase(PurchsaeReq purchsaeReq) {
        log.info("purchaseMessage: {}" + purchsaeReq);
        return purchase.buy(purchsaeReq);
    }
}
