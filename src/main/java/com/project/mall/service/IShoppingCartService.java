package com.project.mall.service;

import com.project.mall.controller.req.ShoppingCartReq;
import com.project.mall.controller.res.ReqResult;

public interface IShoppingCartService {

    ReqResult addShoppingCart(ShoppingCartReq shoppingCartReq);
}
