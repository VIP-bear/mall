package com.project.mall.controller;

import com.project.mall.controller.req.UserChangePasswordReq;
import com.project.mall.controller.req.UserCodeMatchingReq;
import com.project.mall.controller.req.UserLoginReq;
import com.project.mall.controller.req.UserRegisterReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @return  登录结果
     */
    @PostMapping("/login")
    @ResponseBody
    public ReqResult login(UserLoginReq userLoginReq) {
        log.info("userMessage: {}" + userLoginReq);
        return userService.login(userLoginReq);
    }

    @PostMapping("/register")
    @ResponseBody
    public ReqResult register(UserRegisterReq userRegisterReq) {
        log.info("userMessage: {}" + userRegisterReq);
        return userService.register(userRegisterReq);
    }

    @PostMapping("/CodeMatching")
    @ResponseBody
    public ReqResult codeMatching(UserCodeMatchingReq userCodeMatchingReq) {
        return userService.codeMatching(userCodeMatchingReq);
    }

    @PostMapping("/changePassword")
    @ResponseBody
    public ReqResult changePassword(UserChangePasswordReq userChangePasswordReq) {
        return userService.changePwd(userChangePasswordReq);
    }

}
