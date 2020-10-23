package com.project.mall.service;

import com.project.mall.controller.req.buyer.CheckOrderReq;
import com.project.mall.controller.req.buyer.PurchsaeReq;
import com.project.mall.controller.req.buyer.QueryOrderReq;
import com.project.mall.controller.res.ReqResult;

/**
 * 订单服务接口
 */
public interface IOrderService {

    /**
     * 买家创建订单
     * @param purchsaeReq
     * @return
     */
    ReqResult addOrder(PurchsaeReq purchsaeReq);

    /**
     * 根据订单id删除订单
     * @param orderId
     * @return
     */
    ReqResult deleteOrder(Long orderId);

    /**
     * 根据订单id修改订单状态
     * @param orderId
     * @param orderState
     * @return
     */
    ReqResult updateOrderState(Long orderId, String orderState);

    /**
     * 获取买家的全部订单信息
     * @param buyerId
     * @return
     */
    ReqResult getOrder(Long buyerId);

    /**
     * 根据订单状态查询订单
     * @return
     */
    ReqResult getOrderByState(QueryOrderReq queryOrderReq);
}
