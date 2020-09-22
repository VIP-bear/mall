package com.project.mall.service;

import com.project.mall.controller.req.UserLoginReq;
import com.project.mall.controller.req.UserRegisterReq;
import com.project.mall.controller.res.ReqResult;

/**
 * 用户服务接口
 */
public interface IUserService {

    /**
     * 用户登录
     * @param userLoginReq
     * @return
     */
    ReqResult login(UserLoginReq userLoginReq);

    /**
     * 用户注册
     * @param userRegisterReq
     * @return
     */
    ReqResult register(UserRegisterReq userRegisterReq);

}
