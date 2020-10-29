package com.project.mall.exception;

import com.project.mall.controller.res.ReqResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * 处理controller层抛出的异常
 */

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ReqResult unknownException(Exception e) {
        log.error("发生了未知异常", e);
        return new ReqResult(-1, "系统出现错误, 请联系开发人员!");
    }

}
