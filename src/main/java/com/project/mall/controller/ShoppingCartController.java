package com.project.mall.controller;

import com.project.mall.controller.req.ShoppingCartReq;
import com.project.mall.controller.res.ReqResult;
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

    @PostMapping("/shoppingCart")
    @ResponseBody
    public ReqResult shoppingCart(ShoppingCartReq shoppingCartReq) {
        //
        return shoppingCartService.addShoppingCart(shoppingCartReq);
    }


}
