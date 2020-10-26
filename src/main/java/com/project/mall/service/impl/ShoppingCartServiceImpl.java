package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.EditShoppingCartReq;
import com.project.mall.controller.req.buyer.ShoppingCartReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.CartRepository;
import com.project.mall.dao.entity.CartEntity;
import com.project.mall.enums.ShoppingCartTypeEnum;
import com.project.mall.service.IShoppingCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 购物车服务实现
 */
@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {

    @Autowired
    private CartRepository cartRepository;

    /**
     * 添加至购物车
     * @param shoppingCartReq
     * @return
     */
    @Transactional
    @Override
    public ReqResult addShoppingCart(ShoppingCartReq shoppingCartReq) {
        CartEntity cartEntity = new CartEntity();
        BeanUtils.copyProperties(shoppingCartReq, cartEntity);
        cartEntity.setCart_num(shoppingCartReq.getProduct_num());
        CartEntity res = cartRepository.save(cartEntity);
        if (null == res) {
            return new ReqResult(ShoppingCartTypeEnum.ADD_FAILED.getCode(), "添加失败");
        }
        return new ReqResult(ShoppingCartTypeEnum.ADD_SUCCESS.getCode(), "添加成功");
    }

    /**
     * 删除购物车商品
     * @param cartIdList
     * @return
     */
    @Transactional
    @Override
    public ReqResult deleteShoppingCart(List<Long> cartIdList) {
        for (Long cartId : cartIdList) {
            cartRepository.deleteByCartId(cartId);
        }
        return new ReqResult(ShoppingCartTypeEnum.DELETE_SUCCESS.getCode(), "删除成功");
    }

    /**
     * 修改购物车商品数量
     * @return
     */
    @Transactional
    @Override
    public ReqResult changeBuyProductNum(EditShoppingCartReq editShoppingCartReq) {
        int row = cartRepository.updateCartNumByCartId(editShoppingCartReq.getProduct_num(), editShoppingCartReq.getCart_id());
        if (row == 0) {
            return new ReqResult(ShoppingCartTypeEnum.UPDATE_FAILED.getCode(), "更新失败");
        }
        return new ReqResult(ShoppingCartTypeEnum.UPDATE_SUCCESS.getCode(), "更新失败");
    }

    /**
     * 根据买家id获取购物车商品列表
     * @param buyerId
     * @return
     */
    @Override
    public ReqResult getShoppingCartProduct(Long buyerId) {
        List<CartEntity> shoppingCartList = cartRepository.findAllByBuyerId(buyerId);
        return new ReqResult(ShoppingCartTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", shoppingCartList);
    }
}
