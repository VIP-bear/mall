package com.project.mall.controller;

import com.project.mall.controller.req.buyer.PurchsaeReq;
import com.project.mall.controller.req.buyer.ShoppingCartReq;
import com.project.mall.controller.res.ReqResult;

import com.project.mall.service.IOrderService;
import com.project.mall.service.IShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ShoppingCartController {
    @Autowired
    private IShoppingCartService shoppingCartService;

    /**
     * 添加至购物车
     * @param shoppingCartReq
     * @return
     */
    @PostMapping("/shoppingCart")
    @ResponseBody
    public ReqResult shoppingCart(ShoppingCartReq shoppingCartReq) {
        //
        return shoppingCartService.addShoppingCart(shoppingCartReq);
    }

    @Autowired
    IOrderService orderService;

    /**
     * 结算购物车，跳至下订单后续操作
     * @param purchsaeReq
     * @return
     */
    @PostMapping("/confirmShoppingCart")
    @ResponseBody
    public ReqResult confirmShoppingCart(PurchsaeReq purchsaeReq) {
        //
        return orderService.placeOrder(purchsaeReq);
    }


}
