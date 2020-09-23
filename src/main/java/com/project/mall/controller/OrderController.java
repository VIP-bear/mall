package com.project.mall.controller;

import com.project.mall.controller.req.buyer.CheckOrderReq;
import com.project.mall.controller.req.buyer.PurchsaeReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class OrderController {
    @Autowired
    IOrderService orderService;

    /**
     * 购买下单
     * @param purchsaeReq
     * @return
     */
    @PostMapping("/placeOrder")
    @ResponseBody
    public ReqResult purchase(PurchsaeReq purchsaeReq) {
        log.info("purchaseMessage: {}" + purchsaeReq);
        return orderService.placeOrder(purchsaeReq);
    }

    /**
     * 拉取订单信息
     * @param checkOrderReq
     * @return
     */
    @GetMapping("/checkOrder")
    @ResponseBody
    public ReqResult checkOrder(CheckOrderReq checkOrderReq) {

        return orderService.checkOrder(checkOrderReq);
    }
}
