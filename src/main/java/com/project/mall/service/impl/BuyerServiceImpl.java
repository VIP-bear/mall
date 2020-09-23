package com.project.mall.service.impl;

import com.project.mall.controller.req.BuyerLoginReq;
import com.project.mall.controller.req.BuyerRegisterReq;
import com.project.mall.controller.req.BuyerChangePasswordReq;
import com.project.mall.controller.req.BuyerCodeMatchingReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.BuyerRepository;
import com.project.mall.dao.entity.BuyerEntity;
import com.project.mall.dao.entity.VerifyCodeEntity;
import com.project.mall.enums.BuyerTypeEnum;
import com.project.mall.service.IBuyerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Timestamp;
import java.util.Random;

/**
 * 用户服务实现
 */

@Component
public class BuyerServiceImpl implements IBuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    // 用于加密和解密
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // 邮箱名
    @Value("${spring.mail.username}")
    private String mailUsername;

    // 发送邮件
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 用户登录
     * 使用Spring Security对密码进行解密
     * @param buyerLoginReq
     * @return
     */
    @Override
    public ReqResult login(BuyerLoginReq buyerLoginReq) {
        BuyerEntity buyerEntity = null;
        if (buyerLoginReq.getBuyerName().endsWith(".com")) {
            // 根据邮箱查找用户
            buyerEntity = buyerRepository.findUserEntityByUserEmail(buyerLoginReq.getBuyerName());
        } else {
            // 根据用户名查找用户
            buyerEntity = buyerRepository.findUserEntityByUsername(buyerLoginReq.getBuyerName());
        }
        if (null == buyerEntity || !bCryptPasswordEncoder.matches(buyerLoginReq.getPassword(), buyerEntity.getBuyer_pwd())) {
            // 没有查找到用户或者密码不正确
            return new ReqResult(BuyerTypeEnum.USERNAME_OR_PASSWORD_ERROR.getCode(), "用户名或者密码错误", null);
        }
        return new ReqResult(BuyerTypeEnum.LOGIN_SUCCESS.getCode(), "登录成功", buyerEntity);
    }

    /**
     * 用户注册
     * 使用Spring Security对密码进行加密
     * @param buyerRegisterReq
     * @return
     */
    @Override
    public ReqResult register(BuyerRegisterReq buyerRegisterReq) {
        BuyerEntity buyerEntity = new BuyerEntity();
        BeanUtils.copyProperties(buyerRegisterReq, buyerEntity);
        // 对密码进行加密
        buyerEntity.setBuyer_pwd(bCryptPasswordEncoder.encode(buyerEntity.getBuyer_pwd()));
        if (buyerRepository.findUserEntityByUsername(buyerRegisterReq.getBuyerName()) != null){
            // 用户已存在
            return new ReqResult(BuyerTypeEnum.USER_EXISTED.getCode(), "用户已存在", null);
        }
        if (buyerRepository.save(buyerEntity) == null){
            // 注册失败
            return new ReqResult(BuyerTypeEnum.REGISTER_FAILED.getCode(), "注册失败", null);
        }
        // 注册成功
        return new ReqResult(BuyerTypeEnum.REGISTER_SUCCESS.getCode(), "注册成功", null);
    }

    @Override
    public ReqResult getCode(String email) {

        // 验证邮箱是否存在(还未实现)

        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);  // 生成验证码

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head><title></title></head><body>");
        stringBuilder.append("您好<br/>");
        stringBuilder.append("您的验证码是：").append(verifyCode).append("<br/>");
        stringBuilder.append("您可以复制此验证码并返回至掏包网，以验证您的邮箱。<br/>");
        stringBuilder.append("此验证码只能使用一次，在5分钟内有效。验证成功则自动失效。<br/>");
        stringBuilder.append("如果您没有进行上述操作，请忽略此邮件。");
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(mailUsername);    // 发送方
            mimeMessageHelper.setTo(email);     // 接收方
            mimeMessageHelper.setSubject("邮箱验证-掏包网");   // 主题
            mimeMessageHelper.setText(stringBuilder.toString(), true);  // 正文
            mailSender.send(mimeMessageHelper.getMimeMessage());    // 发送邮件
        } catch (MailSendException | MessagingException e) {
            // 邮箱不存在
            System.out.println("hello");
            return new ReqResult(BuyerTypeEnum.EMAIL_NOT_EXIST.getCode(), "邮箱不存在");
        }

        // 将验证码存储到数据库
        VerifyCodeEntity verifyCodeEntity = new VerifyCodeEntity();
        verifyCodeEntity.setCode(Integer.valueOf(verifyCode));
        verifyCodeEntity.setEmail(email);
        verifyCodeEntity.setSend_time(new Timestamp(System.currentTimeMillis()));

        return null;
    }

    @Override
    public ReqResult changePwd(BuyerChangePasswordReq buyerChangePasswordReq) {
        return null;
    }

    @Override
    public ReqResult codeMatching(BuyerCodeMatchingReq buyerCodeMatchingReq) {
        return null;
    }
}
