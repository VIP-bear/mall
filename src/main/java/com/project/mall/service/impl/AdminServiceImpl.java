package com.project.mall.service.impl;

import com.project.mall.controller.req.AdminLoginReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IAdminService;
import org.springframework.stereotype.Service;

/**
 * 管理员service实现类
 */
@Service
public class AdminServiceImpl implements IAdminService {

    /**
     * 管理员登陆接口
     *
     * @param adminLoginReq
     * @return
     */
    @Override
    public ReqResult adminLogin(AdminLoginReq adminLoginReq) {
        return null;
    }
}
