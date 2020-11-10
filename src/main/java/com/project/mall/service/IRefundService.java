package com.project.mall.service;

import com.project.mall.controller.req.buyer.BuyerRefundReq;
import com.project.mall.controller.res.ReqResult;

/**
 * 退款接口
 */
public interface IRefundService {

    /**
     * 申请退款
     * @param buyerRefundReq
     * @return
     */
    ReqResult addRefund(BuyerRefundReq buyerRefundReq);

    /**
     * 申请/拒绝退款
     * @param orderId
     * @param refundState
     * @return
     */
    ReqResult updateRefundState(Long orderId, Long productId, int refundState, int productNumber);

    /**
     * 获取所有处于申请退款的退款申请
     * @return
     */
    ReqResult getAllRefund();

    /**
     * 根据买家id查询退款信息
     * @param id
     * @return
     */
    ReqResult queryRefundStateById(Long id);
}
