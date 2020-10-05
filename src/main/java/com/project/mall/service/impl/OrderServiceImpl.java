package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.CheckOrderReq;
import com.project.mall.controller.req.buyer.PurchsaeReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    /**
     * 买家创建订单
     * @param purchsaeReq
     * @return
     */
    @Override
    public ReqResult placeOrder(PurchsaeReq purchsaeReq) {
        return null;
    }

    /**
     * 拉取买家的全部订单信息
     * @param checkOrderReq
     * @return
     */
    @Override
    public ReqResult checkOrder(CheckOrderReq checkOrderReq) {
        return null;
    }
}

