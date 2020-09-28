package com.project.mall.controller;

import com.project.mall.controller.req.AdministratorChangeStateReq;
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
    IProductService iProductService;


    /**
     * 买家操作
     */

    /**
     * 分页拉取商品信息
     * @return
     */
    @GetMapping("/buyerQueryEachProductByPage")
    @ResponseBody
    public ReqResult queryEachProductByPage(@RequestParam(name = "page")int page){

        return iProductService.queryProductByPage(page,10);
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
     * 卖家操作
     */


    /**
     * 商家增加商品
     */
    @PostMapping("/addProduct")
    @ResponseBody
    public ReqResult addProduct(MerchantUploadProductReq merchantUploadProductReq){

        return iProductService.addProduct(merchantUploadProductReq);
    }

    /**
     * 删除一条商品信息即商品下架
     * @param productID
     * @return
     */
    @DeleteMapping("/deleteProduct")
    @ResponseBody
    public ReqResult deleteProduct(@RequestParam(name = "productID")Long productID){

        return iProductService.deleteProduct(productID);
    }

    /**
     * 卖家登录后依据卖家ID拉取相关商品信息
     * @param merchantID
     * @return
     */
    @GetMapping("/selectAllByMerchantID")
    @ResponseBody
    public ReqResult selectAllByMerchantID(@RequestParam(name = "MerchantID")long merchantID) {

        return iProductService.queryProductByMerchantId(merchantID);
    }


    /**
     * 卖家按商品名查询
     * @param merchantQueryProductByNameReq
     * @return
     */
    @GetMapping("/MerchantQueryProductByName")
    @ResponseBody
    public ReqResult merchantQueryProductByName(MerchantQueryProductByNameReq merchantQueryProductByNameReq) {

        return null;
    }

    /**
     * 卖家按商品类别查询
     * @param merchantQueryProductByTypeReq
     * @return
     */
    @GetMapping("/MerchantQueryProductByType")
    @ResponseBody
    public ReqResult merchantQueryProductByType(MerchantQueryProductByTypeReq merchantQueryProductByTypeReq) {

        return null;
    }

    /**
     * 卖家按商品状态查询
     * @param merchantQueryProductByStateReq
     * @return
     */
    @GetMapping("/merchant/queryProductByState")
    @ResponseBody
    public ReqResult merchantQueryProductByState(MerchantQueryProductByStateReq merchantQueryProductByStateReq) {

        return iProductService.queryProductByMerchantIdAndProductState(merchantQueryProductByStateReq.getMerchantID(),
                merchantQueryProductByStateReq.getProductState());
    }

    /**
     * 商家修改商品信息
     * @param merchantChangeProductReq
     * @return
     */
    @PutMapping("/merchant/changeProductInfo")
    @ResponseBody
    public ReqResult merchantChangeProductInfo(MerchantChangeProductReq merchantChangeProductReq) {

        return iProductService.updateProduct(merchantChangeProductReq);
    }

    @PutMapping("/merchant/changeProduct")
    @ResponseBody
    public ReqResult merchantChangeProductStock(@RequestParam(name = "stock")Double stock,@RequestParam(name = "merchantID")Long merchantID){
        return iProductService.updateProductStockByProductId(stock,merchantID);
    }

    /**
     * 管理员操作
     */

    /**
     * 管理员依据商品状态查询商品信息
     * @param state
     * @return
     */
    @GetMapping("/administrator/queryState")
    @ResponseBody
    public ReqResult administratorQueryState(@RequestParam(name = "state")String state) {
        return iProductService.queryProductByProductState(state);
    }

    @PutMapping("/administrator/changeState")
    @ResponseBody
    public ReqResult administratorChangeState(AdministratorChangeStateReq administratorChangeStateReq) {
        return iProductService.updateProductStateByProductId(administratorChangeStateReq.getState(),
                administratorChangeStateReq.getMerchantID());
    }

}
