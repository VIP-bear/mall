package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.PurchaseReq;
import com.project.mall.controller.req.buyer.QueryOrderReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.BehaviorRepository;
import com.project.mall.dao.OrderRepository;
import com.project.mall.dao.ProductRepository;
import com.project.mall.dao.entity.BehaviorEntity;
import com.project.mall.dao.entity.OrderEntity;
import com.project.mall.dao.entity.ProductEntity;
import com.project.mall.domain.OrderMessage;
import com.project.mall.enums.OrderTypeEnum;
import com.project.mall.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
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

    @Autowired
    private BehaviorRepository behaviorRepository;

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
        orderEntity.setOrder_state("unpaid");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        orderEntity.setCreate_time(now);
        OrderEntity res = orderRepository.save(orderEntity);
        if (null == res) {
            return new ReqResult(OrderTypeEnum.ADD_FAILED.getCode(), "创建订单失败");
        }
        // 记录用户点击商品的行为
        BehaviorEntity behaviorEntity = behaviorRepository
                .findByBuyerAndProductId(purchaseReq.getBuyer_id(), purchaseReq.getProduct_id());
        if (behaviorEntity == null) {
            // 用户以前没有对该商品进行过操作, 记录用户点击行为
            behaviorEntity.setBuyer_id(purchaseReq.getBuyer_id());
            behaviorEntity.setProduct_id(purchaseReq.getProduct_id());
            behaviorEntity.setBehavior_score(5);
            behaviorRepository.save(behaviorEntity);
        } else {
            // 用户以前对该商品进行过操作, 更新加权分
            behaviorRepository.updateScoreByBuyerAndProductId(5,
                    purchaseReq.getBuyer_id(), purchaseReq.getProduct_id());
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
        return new ReqResult(OrderTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", getOrderMessage(allOrder));
    }

    /**
     * 根据状态查询订单
     *
     * @return
     */
    @Override
    public ReqResult getOrderByState(QueryOrderReq queryOrderReq) {
        List<OrderEntity> allOrder = orderRepository.findAllByOrderState(queryOrderReq.getOrder_state(), queryOrderReq.getBuyer_name());
        return new ReqResult(OrderTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", getOrderMessage(allOrder));
    }

    /**
     * 获取订单详细信息
     * @param allOrder
     * @return
     */
    public List<OrderMessage> getOrderMessage(List<OrderEntity> allOrder) {
        List<OrderMessage> orderMessageList = new ArrayList<>();
        // 获取商品名称和封面
        for (OrderEntity orderEntity : allOrder) {
            OrderMessage orderMessage = new OrderMessage();
            BeanUtils.copyProperties(orderEntity, orderMessage);
            System.out.println("product_id: " + orderEntity.getProduct_id());
            ProductEntity productEntity = productRepository.findByProductId(orderEntity.getProduct_id());

            orderMessage.setProduct_name(productEntity.getProduct_name());
            orderMessage.setProduct_cover(productEntity.getProduct_cover());
            orderMessageList.add(orderMessage);
        }
        return orderMessageList;
    }

}

