package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.BuyerLoginReq;
import com.project.mall.controller.req.buyer.BuyerRegisterReq;
import com.project.mall.controller.req.UserChangePasswordReq;
import com.project.mall.controller.req.UserCodeMatchingReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.BuyerRepository;
import com.project.mall.dao.VerifyCodeRepository;
import com.project.mall.dao.entity.BuyerEntity;
import com.project.mall.dao.entity.VerifyCodeEntity;
import com.project.mall.enums.BuyerTypeEnum;
import com.project.mall.enums.VerifyTypeEnum;
import com.project.mall.service.IBuyerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private VerifyCodeRepository verifyCodeRepository;

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
            buyerEntity = buyerRepository.findBuyerEntityByBuyerEmail(buyerLoginReq.getBuyerName());
        } else {
            // 根据用户名查找用户
            buyerEntity = buyerRepository.findBuyerEntityByBuyerName(buyerLoginReq.getBuyerName());
        }
        if (null == buyerEntity || !bCryptPasswordEncoder.matches(buyerLoginReq.getPassword(), buyerEntity.getBuyer_pwd())) {
            // 没有查找到用户或者密码不正确
            return new ReqResult(BuyerTypeEnum.USERNAME_OR_PASSWORD_ERROR.getCode(), "用户名或者密码错误", null);
        }
        buyerEntity.setBuyer_pwd(buyerLoginReq.getPassword());
        return new ReqResult(BuyerTypeEnum.LOGIN_SUCCESS.getCode(), "登录成功", buyerEntity);
    }

    /**
     * 用户注册
     * 使用Spring Security对密码进行加密
     * @param buyerRegisterReq
     * @return
     */
    @Transactional
    @Override
    public ReqResult register(BuyerRegisterReq buyerRegisterReq) {
        if (buyerRepository.findBuyerEntityByBuyerName(buyerRegisterReq.getBuyerName()) != null){
            // 用户已存在
            return new ReqResult(BuyerTypeEnum.USER_EXISTED.getCode(), "用户已存在", null);
        }

        BuyerEntity buyerEntity = new BuyerEntity();
        buyerEntity.setBuyer_name(buyerRegisterReq.getBuyerName());
        // 对密码进行加密
        buyerEntity.setBuyer_pwd(bCryptPasswordEncoder.encode(buyerRegisterReq.getPassword()));

        if (buyerRepository.save(buyerEntity) == null){
            // 注册失败
            return new ReqResult(BuyerTypeEnum.REGISTER_FAILED.getCode(), "注册失败", null);
        }
        // 注册成功
        return new ReqResult(BuyerTypeEnum.REGISTER_SUCCESS.getCode(), "注册成功", null);
    }

    /**
     * 生成验证码并发送至邮箱，然后将验证码保存至数据库
     * @param email
     * @return
     */
    @Transactional
    @Override
    public ReqResult getCode(String email) {

        // 验证邮箱是否有效(还未实现)

        // 验证邮箱是否已经注册
        BuyerEntity buyerEntity = buyerRepository.findBuyerEntityByBuyerEmail(email);
        if (null == buyerEntity) {
            // 该邮箱没有被绑定过，邮箱无效
            return new ReqResult(BuyerTypeEnum.EMAIL_INVALID.getCode(), "邮箱无效");
        }

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
        verifyCodeRepository.save(verifyCodeEntity);
        return null;
    }

    /**
     * 修改密码
     * @param userChangePasswordReq
     * @return
     */
    @Transactional
    @Override
    public ReqResult changePwd(UserChangePasswordReq userChangePasswordReq) {
        // 密码加密
        userChangePasswordReq.setNewPassword(bCryptPasswordEncoder.encode(userChangePasswordReq.getNewPassword()));
        // 修改密码，返回受影响的行数
        int influenceRow = buyerRepository.changePasswordByEmail(userChangePasswordReq.getEmail(), userChangePasswordReq.getNewPassword());
        if (influenceRow != 1) {
            return new ReqResult(BuyerTypeEnum.CHANGE_PWD_FAILED.getCode(), "密码修改失败");
        }
        return new ReqResult(BuyerTypeEnum.CHANGE_PWD_SUCCESS.getCode(), "密码修改成功");
    }

    /**
     * 检验验证码
     * 验证码有效时长5分钟
     * 检验验证码是否正确
     * @param userCodeMatchingReq
     * @return
     */
    @Override
    public ReqResult codeMatching(UserCodeMatchingReq userCodeMatchingReq) {
        VerifyCodeEntity verifyCodeEntity = verifyCodeRepository
                .findVerifyCodeEntityByEmailAndCode(userCodeMatchingReq.getEmail(), userCodeMatchingReq.getCode());
        if (null == verifyCodeEntity) {
            // 验证码错误
            return new ReqResult(VerifyTypeEnum.VERIFY_CODE_ERROR.getCode(), "验证码错误");
        }
        long timeDiff = System.currentTimeMillis() - verifyCodeEntity.getSend_time().getTime(); // 时间差
        ReqResult reqResult;
        if (timeDiff > 5 * 60 * 1000) {
            // 验证码失效
            reqResult = new ReqResult(VerifyTypeEnum.VERIFY_CODE_INVALID.getCode(), "验证码已失效");
        } else {
            reqResult = new ReqResult(VerifyTypeEnum.VERIFY_CODE_SUCCESS.getCode(), "验证成功");
        }

        // 删除验证码记录
        verifyCodeRepository.deleteById(verifyCodeEntity.getId());
        return reqResult;
    }
}
