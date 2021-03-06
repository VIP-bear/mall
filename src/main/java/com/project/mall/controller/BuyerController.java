package com.project.mall.controller;

import com.project.mall.controller.req.BuyerLoginReq;
import com.project.mall.controller.req.BuyerRegisterReq;
import com.project.mall.controller.req.UserChangePasswordReq;
import com.project.mall.controller.req.UserCodeMatchingReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IBuyerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
@Slf4j
public class BuyerController {

    @Autowired
    private IBuyerService buyerService;

    /**
     * 用户登录
     * @return  登录结果
     */
    @GetMapping("/buyer/login")
    @ResponseBody
    public ReqResult login(BuyerLoginReq buyerLoginReq) {
        log.info("userMessage: {}" + buyerLoginReq);
        return buyerService.login(buyerLoginReq);
    }

    @PostMapping("/buyer/register")
    @ResponseBody
    public ReqResult register(BuyerRegisterReq buyerRegisterReq) {
        log.info("userMessage: {}" + buyerRegisterReq);
        return buyerService.register(buyerRegisterReq);
    }

    /**
     * 发送验证码到邮箱
     * @param email
     * @return
     */
    @PostMapping("/buyer/getCode")
    @ResponseBody
    public ReqResult getCode(@RequestParam(name = "email")String email) throws MessagingException {
        log.info("email: {}", email);
        return buyerService.getCode(email);
    }

    /**
     * 验证码匹配
     * @param userCodeMatchingReq
     * @return
     */
    @GetMapping("/codeMatching")
    @ResponseBody
    public ReqResult codeMatching(UserCodeMatchingReq userCodeMatchingReq) {
        return buyerService.codeMatching(userCodeMatchingReq);
    }

    /**
     * 修改密码
     * @param userChangePasswordReq
     * @return
     */
    @PutMapping("/changePassword")
    @ResponseBody
    public ReqResult changePassword(UserChangePasswordReq userChangePasswordReq) {
        return buyerService.changePwd(userChangePasswordReq);
    }


}
