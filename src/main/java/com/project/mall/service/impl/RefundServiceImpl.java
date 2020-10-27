package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.BuyerRefundReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.OrderRepository;
import com.project.mall.dao.RefundRepository;
import com.project.mall.dao.entity.RefundEntity;
import com.project.mall.service.IRefundService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 申请退款
     *
     * @param buyerRefundReq
     * @return
     */
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
}
