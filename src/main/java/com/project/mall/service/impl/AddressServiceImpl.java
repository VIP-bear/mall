package com.project.mall.service.impl;

import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IAddressService;
import org.springframework.stereotype.Service;

/**
 * 地址服务实现
 */
@Service
public class AddressServiceImpl implements IAddressService {
    /**
     * 添加地址
     * @return
     */
    @Override
    public ReqResult addAddress() {
        return null;
    }

    /**
     * 根据地址id删除地址
     * @param addressId
     * @return
     */
    @Override
    public ReqResult deleteAddress(Long addressId) {
        return null;
    }

    /**
     * 更新地址
     * @return
     */
    @Override
    public ReqResult updateAddress() {
        return null;
    }

    /**
     * 根据买家id获取默认地址
     * @param buyerId
     * @return
     */
    @Override
    public ReqResult getDefaultAddress(Long buyerId) {
        return null;
    }

    /**
     * 根据买家id获取地址列表
     * @param buyerId
     * @return
     */
    @Override
    public ReqResult getAllAddress(Long buyerId) {
        return null;
    }
}
