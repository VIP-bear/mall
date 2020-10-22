package com.project.mall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态
 */
@Getter
@AllArgsConstructor
public enum OrderTypeEnum {

    ADD_SUCCESS(820),
    ADD_FAILED(821),
    DELETE_SUCCESS(822),
    UPDATE_SUCCESS(823),
    UPDATE_FAILED(824),
    QUERY_SUCCESS(825),
    QUERY_FAILED(826),
    ;

    private Integer code;
}
