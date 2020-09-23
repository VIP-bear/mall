package com.project.mall.service;

import com.project.mall.controller.req.buyer.CheckOrderReq;
import com.project.mall.controller.req.buyer.PurchsaeReq;
import com.project.mall.controller.res.ReqResult;

public interface IOrderService {

    /**
     * 买家创建订单
     * @param purchsaeReq
     * @return
     */
    ReqResult placeOrder(PurchsaeReq purchsaeReq);

    /**
     * 拉取买家的全部订单信息
     * @param checkOrderReq
     * @return
     */
    ReqResult checkOrder(CheckOrderReq checkOrderReq);
}
