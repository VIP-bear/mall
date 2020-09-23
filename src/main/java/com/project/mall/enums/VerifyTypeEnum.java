package com.project.mall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 验证状态
 */
@Getter
@AllArgsConstructor
public enum VerifyTypeEnum {

    VERIFY_CODE_ERROR(600),
    VERIFY_CODE_INVALID(601),
    VERIFY_CODE_SUCCESS(602);

    private Integer code;

}
