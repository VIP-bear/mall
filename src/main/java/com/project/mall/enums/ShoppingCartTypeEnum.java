package com.project.mall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 购物车状态
 */
@Getter
@AllArgsConstructor
public enum ShoppingCartTypeEnum {

    ADD_FAILED(750),
    ADD_SUCCESS(751),
    DELETE_SUCCESS(752),
    ;

    private Integer code;

}
