package com.project.mall.service.impl;

import com.project.mall.controller.req.AdminLoginReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.AdminRepository;
import com.project.mall.dao.entity.AdminEntity;
import com.project.mall.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员service实现类
 */
@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    AdminRepository adminRepository;
    /**
     * 管理员登陆接口
     *
     * @param adminLoginReq
     * @return
     */
    @Override
    public ReqResult adminLogin(AdminLoginReq adminLoginReq) {
        AdminEntity adminEntity = null;
        adminEntity = adminRepository.findByAdminIdAndPwd(adminLoginReq.getAdmin_username(),adminLoginReq.getAdmin_pwd());
        if(adminEntity == null)
            return new ReqResult(201,"用户名或密码错误");
        return new ReqResult(200,"管理员登陆成功",adminEntity);
    }
}
