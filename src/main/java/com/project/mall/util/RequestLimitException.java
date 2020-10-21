package com.project.mall.util;

/**
 * 定义一个异常类
 */
public class RequestLimitException extends Exception {
    //private static final long serialVersionUID = 1L;

    public RequestLimitException(){
        System.out.println("HTTP请求超出设定的限制");
        //super("HTTP请求超出设定的限制");
    }

    public RequestLimitException(String message){
        super(message);
    }
}
