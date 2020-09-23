package com.project.mall.controller;

import com.project.mall.controller.req.ConfirmShoppingCartReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IConfirmShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ConfirmShoppingCartController {
    @Autowired
    IConfirmShoppingCartService confirmShoppingCartService;

    @PostMapping("/confirmShoppingCart")
    @ResponseBody
    public ReqResult confirmShoppingCart(ConfirmShoppingCartReq confirmShoppingCartReq) {
        //
        return confirmShoppingCartService.settlement(confirmShoppingCartReq);
    }

}
