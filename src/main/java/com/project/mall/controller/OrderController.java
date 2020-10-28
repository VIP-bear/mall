package com.project.mall.controller;

import com.project.mall.controller.req.buyer.BuyerRefundReq;
import com.project.mall.controller.req.buyer.PurchaseReq;
import com.project.mall.controller.req.buyer.QueryOrderReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IOrderService;
import com.project.mall.service.IRefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class OrderController {
    @Autowired
    IOrderService orderService;
    @Autowired
    IRefundService refundService;

    /**
     * 购买下单
     * @param purchaseReq
     * @return
     */
    @PostMapping("/placeOrder")
    @ResponseBody
    public ReqResult placeOrder(PurchaseReq purchaseReq) {
        log.info("purchaseMessage: {}" + purchaseReq);
        return orderService.addOrder(purchaseReq);
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
     * 用户退款接口
     * @param buyerRefundReq
     * @return
     */
    @PostMapping("/refundOrder")
    @ResponseBody
    public ReqResult refundOrder(BuyerRefundReq buyerRefundReq) {

        return refundService.addRefund(buyerRefundReq);
    }

    @GetMapping("/queryRefundOrder")
    @ResponseBody
    public ReqResult queryRefundOrder(@RequestParam(name = "buyer_id")Long ID) {


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
    @PostMapping("/checkOrder/checkOrderByOrderState")
    @ResponseBody
    public ReqResult checkOrderByOrderState(QueryOrderReq queryOrderReq) {
        return orderService.getOrderByState(queryOrderReq);
    }

    /**
     * 删除订单
     * @param ID
     * @return
     */
    @DeleteMapping("/deleteOrder")
    @ResponseBody
    public ReqResult deleteOrder(@RequestParam(name = "order_id")Long ID) {
        return orderService.deleteOrder(ID);
    }
}
