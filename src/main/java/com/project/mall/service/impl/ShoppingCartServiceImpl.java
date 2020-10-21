package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.ShoppingCartReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车服务实现
 */
@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {

    /**
     * 添加至购物车
     * @param shoppingCartReq
     * @return
     */
    @Override
    public ReqResult addShoppingCart(ShoppingCartReq shoppingCartReq) {
        return null;
    }

    /**
     * 删除购物车商品
     * @param cartIdList
     * @return
     */
    @Override
    public ReqResult deleteShoppingCart(List<Long> cartIdList) {

        return null;
    }

    /**
     * 修改购物车商品数量
     * @return
     */
    @Override
    public ReqResult changeBuyProductNum() {
        return null;
    }
}
