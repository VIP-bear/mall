package com.project.mall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户登录、注册等状态
 */
@Getter
@AllArgsConstructor
public enum BuyerTypeEnum {

    LOGIN_SUCCESS(120),
    LOGIN_FAILED(121),
    USER_NOT_EXIST(122),
    PASSWORD_NOT_CORRECT(123),
    REGISTER_SUCCESS(124),
    REGISTER_FAILED(125),
    USER_EXISTED(126),
    INCONSISTENT_PASSWORD_TWICE(127),
    USERNAME_OR_PASSWORD_ERROR(128),
    EMAIL_NOT_EXIST(129),
    EMAIL_INVALID(130),
    CHANGE_PWD_SUCCESS(131),
    CHANGE_PWD_FAILED(132),
    ;

    private Integer code;

}
