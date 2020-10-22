package com.project.mall.service;

import com.project.mall.controller.res.ReqResult;

/**
 * 地址服务接口
 */
public interface IAddressService {

    /**
     * 添加地址
     * @return
     */
    ReqResult addAddress();

    /**
     * 根据地址id删除地址
     * @param addressId
     * @return
     */
    ReqResult deleteAddress(Long addressId);

    /**
     * 更新地址
     * @return
     */
    ReqResult updateAddress();

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

}
