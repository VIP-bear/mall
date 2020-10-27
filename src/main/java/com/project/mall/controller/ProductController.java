package com.project.mall.controller;

import com.project.mall.controller.req.merchant.*;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ProductController {
    @Autowired
    IProductService productService;


    /**
     * 买家操作
     */

    /**
     * 登录首页实现推荐
     * @param id
     * @return
     */
    @GetMapping("/buyer/achieveRecommendProduct")
    @ResponseBody
    public ReqResult achieveRecommendProduct(@RequestParam(name = "buyer_id")Long id) {
        return productService.queryProductByRecommend(id,10);
    }
    /**
     * 随机拉取商品信息
     * @return
     */
    @GetMapping("/buyer/queryEachProductByPage")
    @ResponseBody
    public ReqResult queryEachProductByPage(){

        return productService.queryProductByRandom(10);
    }

    /**
     * 买家按商品名查询
     * @param productName
     * @param page
     * @return
     */
    @GetMapping("/buyer/queryProductByName")
    @ResponseBody
    public ReqResult buyerQueryProductByName(@RequestParam(name = "productName")String productName,
                                             @RequestParam(name = "page")int page){

        return productService.queryProductByProductName(productName,page,10);
    }

    /**
     * 买家按商类别查询
     * @param productType
     * @param page
     * @return
     */
    @GetMapping("/buyer/queryProductByType")
    @ResponseBody
    public ReqResult buyerQueryProductByType(@RequestParam(name = "productType")String productType,
                                             @RequestParam(name = "page")int page){

        return productService.queryProductByTag(productType,page,10);
    }

    /**
     * 按商品ID查询商品,查询详细信息
     * @param productID
     * @param buyerID
     * @return
     */
    @GetMapping("/buyer/queryProductByID")
    @ResponseBody
    public ReqResult buyerQueryProductByID(@RequestParam(name = "product_id")Long productID,
                                           @RequestParam(name = "buyer_id")Long buyerID) {
        //记录用户行为
        return productService.queryProductById(productID);
    }


    /**
     * 卖家操作
     */


    /**
     * 商家增加商品
     */
    @PostMapping("/merchant/addProduct")
    @ResponseBody
    public ReqResult addProduct(MerchantUploadProductReq merchantUploadProductReq){

        return productService.addProduct(merchantUploadProductReq);
    }

    /**
     * 删除一条商品信息即商品下架
     * @param productID
     * @return
     */
    @DeleteMapping("/merchant/deleteProduct")
    @ResponseBody
    public ReqResult deleteProduct(@RequestParam(name = "productID")Long productID){

        return productService.deleteProduct(productID);
    }

    /**
     * 卖家登录后依据卖家ID拉取相关商品信息
     * @param merchantID
     * @return
     */
    @GetMapping("/merchant/selectAllByMerchantID")
    @ResponseBody
    public ReqResult selectAllByMerchantID(@RequestParam(name = "MerchantID")long merchantID) {

        return productService.queryProductByMerchantId(merchantID);
    }

//
//    /**
//     * 卖家按商品名查询
//     * @param merchantQueryProductByNameReq
//     * @return
//     */
//    @GetMapping("/merchant/queryProductByName")
//    @ResponseBody
//    public ReqResult merchantQueryProductByName(MerchantQueryProductByNameReq merchantQueryProductByNameReq) {
//
//        return null;
//    }
//
//    /**
//     * 卖家按商品类别查询
//     * @param merchantQueryProductByTypeReq
//     * @return
//     */
//    @GetMapping("/merchant/queryProductByType")
//    @ResponseBody
//    public ReqResult merchantQueryProductByType(MerchantQueryProductByTypeReq merchantQueryProductByTypeReq) {
//
//        return null;
//    }

    /**
     * 卖家按商品状态查询
     * @param merchantQueryProductByStateReq
     * @return
     */
    @GetMapping("/merchant/queryProductByState")
    @ResponseBody
    public ReqResult merchantQueryProductByState(MerchantQueryProductByStateReq merchantQueryProductByStateReq) {

        return productService.queryProductByMerchantIdAndProductState(merchantQueryProductByStateReq.getBuyer_id(),
                merchantQueryProductByStateReq.getProduct_state());
    }

    /**
     * 商家修改商品信息
     * @param merchantChangeProductReq
     * @return
     */
    @PutMapping("/merchant/changeProductInfo")
    @ResponseBody
    public ReqResult merchantChangeProductInfo(MerchantChangeProductReq merchantChangeProductReq) {

        return productService.updateProduct(merchantChangeProductReq);
    }

    /**
     * 商家改变商品库存
     * @param stock
     * @param merchantID
     * @return
     */
    @PutMapping("/merchant/changeProductStock")
    @ResponseBody
    public ReqResult merchantChangeProductStock(@RequestParam(name = "stock")Integer stock,
                                                @RequestParam(name = "merchantID")Long merchantID) {
        return productService.updateProductStockByProductId(stock,merchantID);
    }





}
