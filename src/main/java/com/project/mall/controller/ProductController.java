package com.project.mall.controller;

import com.project.mall.controller.req.merchant.MerchantQueryProductByNameReq;
import com.project.mall.controller.req.merchant.MerchantQueryProductByStateReq;
import com.project.mall.controller.req.merchant.MerchantQueryProductByTypeReq;
import com.project.mall.controller.req.merchant.MerchantUploadProductReq;
import com.project.mall.controller.res.ReqResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ProductController {
    @Autowired

    /**
     * 商家增加商品
     */
    @PostMapping("/addProduct")
    @ResponseBody
    public ReqResult addProduct(MerchantUploadProductReq merchantUploadProductReq){
            ReqResult reqResult = new ReqResult();
        return reqResult;
    }

    /**
     * 删除一条商品信息即商品下架
     * @param productID
     * @return
     */
    @DeleteMapping("/deleteProduct")
    @ResponseBody
    public ReqResult deleteProduct(@RequestParam(name = "productID")String productID){

        return null;
    }

    /**
     * 拉取全部商品信息
     * @return
     */
    @GetMapping("/buyerQueryEachProduct")
    @ResponseBody
    public ReqResult queryEachProduct(){
        return null;
    }

    /**
     * 买家按商品名查询
     * @return
     */
    @GetMapping("/buyerQueryProductByName")
    @ResponseBody
    public ReqResult buyerQueryProductByName(@RequestParam(name = "productName")String productName){

        return null;
    }
    /**
     * 买家按商类别查询
     * @return
     */
    @GetMapping("/buyerQueryProductByType")
    @ResponseBody
    public ReqResult buyerQueryProductByType(@RequestParam(name = "productType")String productType){

        return null;
    }

    /**
     * 卖家按商品名查询
     * @param merchantQueryProductByNameReq
     * @return
     */
    @GetMapping("/MerchantQueryProductByName")
    @ResponseBody
    public ReqResult MerchantQueryProductByName(MerchantQueryProductByNameReq merchantQueryProductByNameReq) {

        return null;
    }

    /**
     * 卖家按商品类别查询
     * @param merchantQueryProductByTypeReq
     * @return
     */
    @GetMapping("/MerchantQueryProductByType")
    @ResponseBody
    public ReqResult MerchantQueryProductByType(MerchantQueryProductByTypeReq merchantQueryProductByTypeReq) {

        return null;
    }

    /**
     * 卖家按商品状态查询
     * @param merchantQueryProductByStateReq
     * @return
     */
    @GetMapping("/MerchantQueryProductByState")
    @ResponseBody
    public ReqResult MerchantQueryProductByState(MerchantQueryProductByStateReq merchantQueryProductByStateReq) {

        return null;
    }


}
