package com.project.mall.service;

import com.project.mall.controller.req.buyer.ShoppingCartReq;
import com.project.mall.controller.res.ReqResult;

import java.util.List;

public interface IShoppingCartService {

    /**
     * 买家添加购物车
     * @param shoppingCartReq
     * @return
     */
    ReqResult addShoppingCart(ShoppingCartReq shoppingCartReq);

    /**
     * 买家删除购物车商品
     * @param cartIdList
     * @return
     */
    ReqResult deleteShoppingCart(List<Long> cartIdList);
}
