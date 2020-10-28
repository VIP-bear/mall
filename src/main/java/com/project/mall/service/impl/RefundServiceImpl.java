package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.BuyerRefundReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.OrderRepository;
import com.project.mall.dao.ProductRepository;
import com.project.mall.dao.RefundRepository;
import com.project.mall.dao.entity.OrderEntity;
import com.project.mall.dao.entity.ProductEntity;
import com.project.mall.dao.entity.RefundEntity;
import com.project.mall.domain.OrderMessage;
import com.project.mall.service.IRefundService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 申请退款服务实现
 */

@Service
public class RefundServiceImpl implements IRefundService {

    @Autowired
    RefundRepository refundRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;
    /**
     * 申请退款
     *
     * @param buyerRefundReq
     * @return
     */
    @Transactional
    @Override
    public ReqResult addRefund(BuyerRefundReq buyerRefundReq) {
        RefundEntity refundEntity = new RefundEntity();
        BeanUtils.copyProperties(buyerRefundReq, refundEntity);
        refundEntity.setRefund_state(0);
        RefundEntity res = refundRepository.save(refundEntity);
        if (res == null) {
            return new ReqResult(450, "申请失败，请重试");
        }

        // 修改订单状态，退款中
        orderRepository.updateOrderStateById("refunding", buyerRefundReq.getOrder_id());

        return new ReqResult(451, "申请退款中");
    }

    /**
     * 根据订单id修改申请退款状态
     *
     * @param orderId
     * @param refundState
     * @return
     */
    @Transactional
    @Override
    public ReqResult updateRefundState(Long orderId, int refundState) {
        int row = refundRepository.updateStateByOrderId(refundState, orderId);
        if (row == 0) {
            return new ReqResult(452, "修改失败，请重试");
        }
        // 修改订单状态
        if (refundState == 1) {
            // 退款成功
            orderRepository.updateOrderStateById("refunded", orderId);
        } else {
            // 退款失败
            orderRepository.updateOrderStateById("refundfailed", orderId);
        }
        return new ReqResult(453, "操作成功");
    }

    /**
     * 获取所有处于申请退款的退款申请
     *
     * @return
     */
    @Override
    public ReqResult getAllRefund() {
        List<RefundEntity> allRefund = refundRepository.findAllByRefundState();
        return new ReqResult(454, "查询成功", allRefund);
    }

    /**
     * 根据买家id查询退款信息
     *
     * @param id
     * @return
     */
    @Override
    public ReqResult queryRefundStateById(Long id) {
        List<OrderEntity> refundEntityList = orderRepository.findAllRefundEntities(id);

        OrderServiceImpl orderService = new OrderServiceImpl();
        List<OrderMessage> orderMessageList = new ArrayList<>();
        // 获取商品名称和封面
        for (OrderEntity orderEntity : refundEntityList) {
            OrderMessage orderMessage = new OrderMessage();
            BeanUtils.copyProperties(orderEntity, orderMessage);
            System.out.println("product_id: " + orderEntity.getProduct_id());
            ProductEntity productEntity = productRepository.findByProductId(orderEntity.getProduct_id());

            orderMessage.setProduct_name(productEntity.getProduct_name());
            orderMessage.setProduct_cover(productEntity.getProduct_cover());
            orderMessageList.add(orderMessage);
        }
        if(refundEntityList == null)
            return new ReqResult(455,"为查询到退款信息");
        return new ReqResult(456,"查询成功", orderMessageList);
    }
}
