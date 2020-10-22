package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.CheckOrderReq;
import com.project.mall.controller.req.buyer.PurchsaeReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.OrderRepository;
import com.project.mall.dao.entity.OrderEntity;
import com.project.mall.enums.OrderTypeEnum;
import com.project.mall.service.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * 订单服务实现
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 买家创建订单
     *
     * @param purchsaeReq
     * @return
     */
    @Override
    public ReqResult addOrder(PurchsaeReq purchsaeReq) {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(purchsaeReq, orderEntity);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        orderEntity.setCreate_time(now);
        OrderEntity res = orderRepository.save(orderEntity);
        if (null == res) {
            return new ReqResult(OrderTypeEnum.ADD_FAILED.getCode(), "创建订单失败");
        }
        return new ReqResult(OrderTypeEnum.ADD_SUCCESS.getCode(), "创建订单成功");
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

