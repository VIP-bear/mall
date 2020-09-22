package com.project.mall.service.impl;

import com.project.mall.controller.req.UserLoginReq;
import com.project.mall.controller.req.UserRegisterReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.UserRepository;
import com.project.mall.dao.entity.UserEntity;
import com.project.mall.enums.UserTypeEnum;
import com.project.mall.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户服务实现
 */

@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 用户登录
     * @param userLoginReq
     * @return
     */
    @Override
    public ReqResult login(UserLoginReq userLoginReq) {
        // 根据用户名查找用户
        UserEntity userEntity = userRepository.findUserEntityByUsername(userLoginReq.getUsername());
        if (null == userEntity || !userLoginReq.getPassword().equals(userEntity.getPassword())) {
            return new ReqResult(UserTypeEnum.USERNAME_OR_PASSWORD_ERROR.getCode(), "用户名或者密码错误", null);
        }
        return new ReqResult(UserTypeEnum.LOGIN_SUCCESS.getCode(), "登录成功", null);
    }

    /**
     * 用户注册
     * @param userRegisterReq
     * @return
     */
    @Override
    public ReqResult register(UserRegisterReq userRegisterReq) {
        if (!userRegisterReq.getPassword().equals(userRegisterReq.getConfirmPassword())){
            // 两次密码不同
            return new ReqResult(UserTypeEnum.INCONSISTENT_PASSWORD_TWICE.getCode(), "两次密码不同", null);
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRegisterReq, userEntity);
        if (userRepository.findUserEntityByUsername(userRegisterReq.getUsername()) != null){
            // 用户已存在
            return new ReqResult(UserTypeEnum.USER_EXISTED.getCode(), "用户已存在", null);
        }
        if (userRepository.save(userEntity) == null){
            // 注册失败
            return new ReqResult(UserTypeEnum.REGISTER_FAILED.getCode(), "注册失败", null);
        }
        // 注册成功
        return new ReqResult(UserTypeEnum.REGISTER_SUCCESS.getCode(), "注册成功", null);
    }
}
