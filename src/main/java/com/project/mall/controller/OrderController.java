package com.project.mall.controller;

import com.project.mall.controller.req.buyer.CheckOrderReq;
import com.project.mall.controller.req.buyer.PurchsaeReq;
import com.project.mall.controller.req.buyer.QueryOrderReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ReqResult placeOrder(PurchsaeReq purchsaeReq) {
        log.info("purchaseMessage: {}" + purchsaeReq);
        return orderService.addOrder(purchsaeReq);
    }

    /**
     * 修改订单状态
     * @param ID
     * @param order_state
     * @return
     */
    @PutMapping("/changeOrderState")
    @ResponseBody
    public ReqResult changeOrderState(@RequestParam(name = "order_id")Long ID,
                                      @RequestParam(name = "order_state")String order_state) {
        return orderService.updateOrderState(ID,order_state);
    }

    /**
     * 拉取订单信息
     * @param ID
     * @return
     */
    @GetMapping("/checkOrder/checkOrderByBuyerID")
    @ResponseBody
    public ReqResult checkOrderByBuyerID(@RequestParam(name = "buyer_id")Long ID) {

        return orderService.getOrder(ID);
    }

    /**
     * 按订单状态查询商品
     * @param queryOrderReq
     * @return
     */
    @GetMapping("/checkOrder/checkOrderByOrderState")
    @ResponseBody
    public ReqResult checkOrderByOrderState(QueryOrderReq queryOrderReq) {
        return orderService.getOrderByState(queryOrderReq);
    }

    @DeleteMapping("/deleteOrder")
    @ResponseBody
    public ReqResult deleteOrder(@RequestParam(name = "order_id")Long ID) {
        return orderService.deleteOrder(ID);
    }
}
