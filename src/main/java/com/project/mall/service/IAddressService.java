package com.project.mall.service;

import com.project.mall.controller.req.buyer.AddAddressReq;
import com.project.mall.controller.req.buyer.ChangeAddressReq;
import com.project.mall.controller.res.ReqResult;

/**
 * 地址服务接口
 */
public interface IAddressService {

    /**
     * 添加地址
     * @return
     * @param addAddressReq
     */
    ReqResult addAddress(AddAddressReq addAddressReq);

    /**
     * 根据地址id删除地址
     * @param addressId
     * @return
     */
    ReqResult deleteAddress(Long addressId);

    /**
     * 更新地址
     * @return
     * @param changeAddressReq
     */
    ReqResult updateAddress(ChangeAddressReq changeAddressReq);

    /**
     * 根据买家id获取默认地址
     * @param buyerId
     * @return
     */
    ReqResult getDefaultAddress(Long buyerId);

    /**
     * 根据买家id获取地址列表
     * @param buyerId
     * @return
     */
    ReqResult getAllAddress(Long buyerId);

    /**
     * 设置默认地址
     * @param id
     * @return
     */
    ReqResult setDefaultAddress(Long id);
}
