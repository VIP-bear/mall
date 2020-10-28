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
     * 根据订单id修改申请退款状态
     * @param orderId
     * @param refundState
     * @return
     */
    ReqResult updateRefundState(Long orderId, int refundState);

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
    ReqResult updateRefundStateById(Long id);
}
