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
    UPDATE_FAILED(753),
    UPDATE_SUCCESS(754),
    QUERY_SUCCESS(755),
    ;

    private Integer code;

}
