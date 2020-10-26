package com.project.mall.controller;

import com.project.mall.controller.req.AdminLoginReq;
import com.project.mall.controller.req.AdministratorChangeStateReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IAdminService;
import com.project.mall.service.IProductService;
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

    /**
     * 管理员登陆
     * @param adminLoginReq
     * @return
     */
    @PostMapping("/admin/adminLogin")
    @ResponseBody
    public ReqResult adminLogin(AdminLoginReq adminLoginReq) {
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
    public ReqResult administratorQueryState(@RequestParam(name = "state")String state) {
        log.info("state:{}",state);
        return productService.queryProductByProductState(state);
    }

    /**
     * 管理员审批通过商品上架
     * @param administratorChangeStateReq
     * @return
     */
    @PutMapping("/admin/changeState")
    @ResponseBody
    public ReqResult administratorChangeState(AdministratorChangeStateReq administratorChangeStateReq) {
        log.info("administratorChangeStateReq:{}",administratorChangeStateReq);
        return productService.updateProductStateByProductId(administratorChangeStateReq.getProduct_state(),
                administratorChangeStateReq.getProduct_id());
    }
}
