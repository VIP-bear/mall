package com.project.mall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 验证状态
 */
@Getter
@AllArgsConstructor
public enum ProductTypeEnum {

    ADD_FAILED(700),
    ADD_SUCCESS(701),
    DELETE_SUCCESS(702),
    QUERY_SUCCESS(703),
    UPDATE_FAILED(704),
    UPDATE_SUCCESS(705),
    ;

    private Integer code;
}
