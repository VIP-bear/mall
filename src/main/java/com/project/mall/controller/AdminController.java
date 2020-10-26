package com.project.mall.controller;

import com.project.mall.controller.req.AdminLoginReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 对管理员相关操作进行封装
 */
@Controller
@Slf4j
public class AdminController {
    @Autowired
    IAdminService adminService;

    @PostMapping("/admin/adminLogin")
    @ResponseBody
    public ReqResult adminLogin(AdminLoginReq adminLoginReq) {
        log.info("adminLoginReq:{}",adminLoginReq);
        return adminService.adminLogin(adminLoginReq);
    }
}
