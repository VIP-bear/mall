package com.project.mall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 评论状态
 */
@Getter
@AllArgsConstructor
public enum EvaluateTypeEnum {

    EVA_FAILED(750),
    EVA_SUCCESS(751),
    EVA_QUERY_SUCCESS(752),
    EVA_NOT_EXIST(753),
    EVA_REPLY_SUCCESS(754),
    ;

    private Integer code;
}
