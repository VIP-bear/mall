package com.project.mall.controller;

import com.project.mall.controller.req.buyer.EditShoppingCartReq;
import com.project.mall.controller.req.buyer.PurchsaeReq;
import com.project.mall.controller.req.buyer.ShoppingCartReq;
import com.project.mall.controller.res.ReqResult;

import com.project.mall.service.IOrderService;
import com.project.mall.service.IShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/addShoppingCart")
    @ResponseBody
    public ReqResult addShoppingCart(ShoppingCartReq shoppingCartReq) {

        return shoppingCartService.addShoppingCart(shoppingCartReq);
    }

    /**
     * 用户清除购物车内指定商品
     * @param ID
     * @return
     */
    @DeleteMapping("/deleteShoppingCart")
    @ResponseBody
    public ReqResult deleteShoppingCart(@RequestParam(name = "shoppingCartID")List<Long> ID) {
        return shoppingCartService.deleteShoppingCart(ID);
    }

    /**
     * 在购物车修改商品购买数量
     * @param editShoppingCartReq
     * @return
     */
    @PutMapping("/editShoppingCart")
    @ResponseBody
    public ReqResult editShoppingCart(EditShoppingCartReq editShoppingCartReq) {
        return shoppingCartService.changeBuyProductNum(editShoppingCartReq);
    }

    @GetMapping("/queryShoppingCart")
    @ResponseBody
    public ReqResult queryShoppingCart(@RequestParam(name = "buyer_id")Long ID) {
        return shoppingCartService.getShoppingCartProduct(ID);
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
        
        return orderService.addOrder(purchsaeReq);
    }


}
