package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.PurchaseReq;
import com.project.mall.controller.req.buyer.QueryOrderReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.OrderRepository;
import com.project.mall.dao.ProductRepository;
import com.project.mall.dao.entity.OrderEntity;
import com.project.mall.dao.entity.ProductEntity;
import com.project.mall.enums.OrderTypeEnum;
import com.project.mall.service.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * 订单服务实现
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * 买家创建订单
     *
     * @param purchaseReq
     * @return
     */
    @Transactional
    @Override
    public ReqResult addOrder(PurchaseReq purchaseReq) {
        // 查询商品库存
        ProductEntity productEntity = productRepository.findById(purchaseReq.getProduct_id()).get();
        if (productEntity.getProduct_stock() < purchaseReq.getOrder_num()) {
            return new ReqResult(OrderTypeEnum.ADD_FAILED.getCode(), "库存不足");
        }
        // 减少商品库存
        productRepository.updateProductStockByProductId(productEntity.getProduct_stock()
                - purchaseReq.getOrder_num(), purchaseReq.getProduct_id());
        // 保存订单信息
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(purchaseReq, orderEntity);
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
    @Transactional
    @Override
    public ReqResult deleteOrder(Long orderId) {
        orderRepository.deleteByOrderId(orderId);
        return new ReqResult(OrderTypeEnum.DELETE_SUCCESS.getCode(), "删除成功");
    }

    /**
     * 根据订单id修改订单状态
     *
     * @param orderId
     * @param orderState
     * @return
     */
    @Transactional
    @Override
    public ReqResult updateOrderState(Long orderId, String orderState) {
        int row = orderRepository.updateOrderStateById(orderState, orderId);
        if (row == 0) {
            return new ReqResult(OrderTypeEnum.UPDATE_FAILED.getCode(), "更新失败");
        }
        return new ReqResult(OrderTypeEnum.UPDATE_SUCCESS.getCode(), "更新成功");
    }

    /**
     * 获取买家的全部订单信息
     *
     * @param buyerId
     * @return
     */
    @Override
    public ReqResult getOrder(Long buyerId) {
        List<OrderEntity> allOrder = orderRepository.findAllByBuyerId(buyerId);
        return new ReqResult(OrderTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", allOrder);
    }

    /**
     * 根据状态查询订单
     *
     * @return
     */
    @Override
    public ReqResult getOrderByState(QueryOrderReq queryOrderReq) {
        List<OrderEntity> allOrder = orderRepository.findAllByOrderState(queryOrderReq.getOrder_state(), queryOrderReq.getBuyer_name());
        return new ReqResult(OrderTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", allOrder);
    }
}

