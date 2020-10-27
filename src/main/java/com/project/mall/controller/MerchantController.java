package com.project.mall.controller;
import com.project.mall.controller.req.merchant.MerchantVerifyReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.service.IMerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class MerchantController {
    @Autowired
    IMerchantService merchantService;

    /**
     * 商家注册
     * @param merchantVerifyReq
     * @return
     */
    @PostMapping("/merchant/register")
    @ResponseBody
    public ReqResult merchantRegister(MerchantVerifyReq merchantVerifyReq) {

        return merchantService.perInfoReview(merchantVerifyReq);
    }

    /**
     * 登录时验证是否为卖家
     * @param ID
     * @return
     */
    @GetMapping("/merchant/confirm")
    @ResponseBody
    public ReqResult merchantConfirm(@RequestParam(name = "buyer_id")Long ID) {

        return merchantService.merchantConfirm(ID);
    }
}
