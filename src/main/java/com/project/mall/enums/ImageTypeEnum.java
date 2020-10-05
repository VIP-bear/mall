package com.project.mall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 图片处理状态
 */
@Getter
@AllArgsConstructor
public enum ImageTypeEnum {

    IMAGE_UPLOAD_FAILED(800),
    ;

    private Integer code;

}
