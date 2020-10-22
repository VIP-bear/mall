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
    ;

    private Integer code;
}
