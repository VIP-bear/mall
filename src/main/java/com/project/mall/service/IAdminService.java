package com.project.mall.service;

import com.project.mall.controller.req.AdminLoginReq;
import com.project.mall.controller.res.ReqResult;

public interface IAdminService {
    /**
     * 管理员登陆接口
     * @param adminLoginReq
     * @return
     */
    ReqResult adminLogin(AdminLoginReq adminLoginReq);
}
