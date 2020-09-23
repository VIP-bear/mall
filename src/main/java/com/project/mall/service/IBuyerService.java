package com.project.mall.service;

import com.project.mall.controller.req.BuyerLoginReq;
import com.project.mall.controller.req.BuyerRegisterReq;
import com.project.mall.controller.req.UserChangePasswordReq;
import com.project.mall.controller.req.UserCodeMatchingReq;
import com.project.mall.controller.res.ReqResult;

import javax.mail.MessagingException;

/**
 * 用户服务接口
 */
public interface IBuyerService {

    /**
     * 用户登录
     * @param buyerLoginReq
     * @return
     */
    ReqResult login(BuyerLoginReq buyerLoginReq);

    /**
     * 用户注册
     * @param buyerRegisterReq
     * @return
     */
    ReqResult register(BuyerRegisterReq buyerRegisterReq);

    /**
     * 发送验证码到邮箱
     * @param email
     * @return
     */
    ReqResult getCode(String email) throws MessagingException;


    ReqResult codeMatching(UserCodeMatchingReq userCodeMatchingReq);

    ReqResult changePwd(UserChangePasswordReq userChangePasswordReq);
}
