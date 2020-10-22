package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.CheckOrderReq;
import com.project.mall.controller.req.buyer.PurchsaeReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * 订单服务实现
 */
@Service
public class OrderServiceImpl implements IOrderService {


    /**
     * 买家创建订单
     *
     * @param purchsaeReq
     * @return
     */
    @Override
    public ReqResult addOrder(PurchsaeReq purchsaeReq) {
        return null;
    }

    /**
     * 根据订单id删除订单
     *
     * @param orderId
     * @return
     */
    @Override
    public ReqResult deleteOrder(Long orderId) {
        return null;
    }

    /**
     * 根据订单id修改订单状态
     *
     * @param orderId
     * @param orderState
     * @return
     */
    @Override
    public ReqResult updateOrderState(Long orderId, String orderState) {
        return null;
    }

    /**
     * 获取买家的全部订单信息
     *
     * @param checkOrderReq
     * @return
     */
    @Override
    public ReqResult getOrder(CheckOrderReq checkOrderReq) {
        return null;
    }

    /**
     * 根据状态查询订单
     *
     * @return
     */
    @Override
    public ReqResult getOrderByState() {
        return null;
    }
}

