package com.project.mall.controller;

import com.project.mall.controller.req.buyer.*;
import com.project.mall.controller.req.UserChangePasswordReq;
import com.project.mall.controller.req.UserCodeMatchingReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.enums.BuyerTypeEnum;
import com.project.mall.service.IAddressService;
import com.project.mall.service.IBuyerService;
import com.project.mall.util.RequestLimit;
import com.project.mall.variable.ConstantVar;
import com.project.mall.variable.GlobalVal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class BuyerController {

    @Autowired
    private IBuyerService buyerService;

    @Autowired
    private IAddressService addressService;

    /**
     * 买家登录
     * @return  登录结果
     */
    @PostMapping("/buyer/login")
    @RequestLimit(count = ConstantVar.MAX_REQUEST_COUNT,time = ConstantVar.REQUEST_TIMES)
    @ResponseBody
    public ReqResult login(HttpServletRequest request) {
        String ip = request.getLocalAddr();
        String url = request.getRequestURL().toString();
        String key = "req_limit_".concat(url).concat(ip);

        if (GlobalVal.loginEffective.get(key) == null||GlobalVal.loginEffective.get(key)) {
            BuyerLoginReq buyerLoginReq = new BuyerLoginReq();
            buyerLoginReq.setBuyer_name(request.getParameter("buyer_name"));
            buyerLoginReq.setBuyer_pwd(request.getParameter("buyer_pwd"));
            log.info("userMessage: {}" + buyerLoginReq);
            return buyerService.login(buyerLoginReq);
        }
        return new ReqResult(BuyerTypeEnum.REQUEST_FRE.getCode(), "请求过于频繁");
    }

    /**
     * 买家注册
     * @param buyerRegisterReq
     * @return
     */
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
    @GetMapping("/buyer/getCode")
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
    @PostMapping("/codeMatching")
    @ResponseBody
    public ReqResult codeMatching(UserCodeMatchingReq userCodeMatchingReq) {
        log.info("userCodeMatchingReq:{}",userCodeMatchingReq);
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
        log.info("userChangePasswordReq:{}",userChangePasswordReq);
        return buyerService.changePwd(userChangePasswordReq);
    }

    /**
     * 用户更改绑定的邮箱
     * @param changeEmailReq
     * @return
     */
    @PostMapping("/bindEmail")
    @ResponseBody
    public ReqResult bindEmail(ChangeEmailReq changeEmailReq) {
        log.info("changeEmailReqL{}",changeEmailReq);
        return buyerService.changeEmail(changeEmailReq);
    }

    /**
     * 买家添加地址
     * @param addAddressReq
     * @return
     */
    @PostMapping("/address/addAddress")
    @ResponseBody
    public ReqResult addAddress(AddAddressReq addAddressReq) {
        return addressService.addAddress(addAddressReq);
    }

    /**
     * 删除地址
     * @param ID
     * @return
     */
    @DeleteMapping("/address/deleteAddress")
    @ResponseBody
    public ReqResult deleteAddress(@RequestParam(name = "address_id")Long ID) {
        log.info("/address/deleteAddress, address_id: {}", ID);
        return addressService.deleteAddress(ID);
    }

    /**
     * 设置默认地址
     * @return
     */
    @GetMapping("/address/setDefaultAddress")
    @ResponseBody
    public ReqResult setDefaultAddress(@RequestParam(name = "address_id")Long addressId,
                                       @RequestParam(name = "buyer_id")Long buyerId) {
        log.info("/address/setDefaultAddress, address_id: {}, buyer_id: {}", addressId, buyerId);
        return addressService.setDefaultAddress(addressId, buyerId);
    }

    /**
     * 用户修改地址内容
     * @param changeAddressReq
     * @return
     */
    @PutMapping("/address/changeAddress")
    @ResponseBody
    public ReqResult changeAddress(ChangeAddressReq changeAddressReq) {

        return addressService.updateAddress(changeAddressReq);
    }

    /**
     * 查询默认地址
     * @param ID
     * @return
     */
    @GetMapping("/address/defaultAddress")
    @ResponseBody
    public ReqResult defaultAddress(@RequestParam(name = "buyer_id")Long ID) {
        return addressService.getDefaultAddress(ID);
    }

    /**
     * 查询一般地址
     * @param ID
     * @return
     */
    @GetMapping("/address/commonAddress")
    @ResponseBody
    public ReqResult commonAddress(@RequestParam(name = "buyer_id")Long ID) {
        return addressService.getAllAddress(ID);
    }

}
