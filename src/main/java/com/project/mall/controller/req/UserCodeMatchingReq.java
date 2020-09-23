package com.project.mall.controller.req;

import lombok.Data;

/**
 * 匹配验证码
 */
@Data
public class UserCodeMatchingReq {

    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 验证码
     */
    private int code;
}
