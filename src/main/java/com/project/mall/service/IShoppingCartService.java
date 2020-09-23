package com.project.mall.service;

import com.project.mall.controller.req.buyer.ShoppingCartReq;
import com.project.mall.controller.res.ReqResult;

public interface IShoppingCartService {

    /**
     * 买家添加购物车
     * @param shoppingCartReq
     * @return
     */
    ReqResult addShoppingCart(ShoppingCartReq shoppingCartReq);
}
