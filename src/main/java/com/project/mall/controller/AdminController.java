package com.project.mall.controller;

import com.project.mall.controller.req.AdminLoginReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IAdminService;
import com.project.mall.service.IProductService;
import com.project.mall.service.IRefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 对管理员相关操作进行封装
 */
@Controller
@Slf4j
public class AdminController {
    @Autowired
    IAdminService adminService;
    @Autowired
    IProductService productService;
    @Autowired
    IRefundService refundService;

    /**
     * 管理员登陆
     * @param adminLoginReq
     * @return
     */
    @PostMapping("/admin/adminLogin")
    @ResponseBody
    public ReqResult adminLogin(@RequestBody AdminLoginReq adminLoginReq) {
        log.info("adminLoginReq:{}",adminLoginReq);
        return adminService.adminLogin(adminLoginReq);
    }

    /**
     * 管理员依据商品状态查询商品信息
     * @param state
     * @return
     */
    @GetMapping("/admin/queryState")
    @ResponseBody
    public ReqResult administratorQueryState(@RequestParam(name = "product_state")String state) {
        log.info("state:{}",state);
        return productService.queryProductByProductState(state);
    }

    /**
     * 管理员根据商品id修改商品状态
     * @return
     */
    @GetMapping("/admin/changeProductState")
    @ResponseBody
    public ReqResult administratorChangeState(@RequestParam(name = "product_id")Long product_id,
                                              @RequestParam(name = "product_state")String state) {
        log.info("product_id: {}, product_state: {}", product_id, state);
        return productService.updateProductStateByProductId(state, product_id);
    }

    /**
     * 管理员查看待处理退款申请
     * @return
     */
    @GetMapping("/admin/queryRefundApply")
    @ResponseBody
    public ReqResult administratorQueryRefundApply() {

        return refundService.getAllRefund();
    }


    /**
     * 申请/拒绝退款
     * @param orderId
     * @param productId
     * @param state
     * @param productNumber
     * @return
     */
    @GetMapping("/admin/disposeRefundApply")
    @ResponseBody
    public ReqResult administratorDisposeRefundApply(@RequestParam(name = "order_id")Long orderId,
                                                     @RequestParam(name = "product_id")Long productId,
                                                     @RequestParam(name = "refund_state")Integer state,
                                                     @RequestParam(name = "product_num")Integer productNumber) {
        return refundService.updateRefundState(orderId, productId, state, productNumber);
    }


}
