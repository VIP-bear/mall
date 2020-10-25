package com.project.mall.service.impl;

import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.AddressRepository;
import com.project.mall.dao.entity.AddressEntity;
import com.project.mall.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 地址服务实现
 */
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    AddressRepository addressRepository;

    /**
     * 添加地址
     * @return
     */
    @Transactional
    @Override
    public ReqResult addAddress() {
        return null;
    }

    /**
     * 根据地址id删除地址
     * @param addressId
     * @return
     */
    @Transactional
    @Override
    public ReqResult deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
        return new ReqResult(620, "删除成功");
    }

    /**
     * 更新地址
     * @return
     */
    @Transactional
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
        AddressEntity addressEntity = addressRepository.findDefaultAddressEntityByBuyerId(buyerId);
        return new ReqResult(621, "查询成功", addressEntity);
    }

    /**
     * 根据买家id获取地址列表
     * @param buyerId
     * @return
     */
    @Override
    public ReqResult getAllAddress(Long buyerId) {
        List<AddressEntity> addressEntityList = addressRepository.findAddressEntitiesByBuyerId(buyerId);
        return new ReqResult(621, "查询成功", addressEntityList);
    }
}
