package com.project.mall.controller.res;

import lombok.Data;

/**
 * 对请求结果的封装
 */

@Data
public class ReqResult {

    private Integer code;
    private String msg;
    private Object data;

    public ReqResult(){
        this.code = Integer.valueOf(0);
        this.msg = "";
        this.data = null;
    }
    /**
     *返回状态码、信息、以及数据
     */
    public ReqResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    /**
     *只返回状态码，以及信息可以用于失败时候来使用
     */
    public ReqResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
    /**
     *只返回状态码和数据
     */
    public ReqResult(Integer code, Object data) {
        this.code = code;
        this.msg = "";
        this.data = data;
    }

}
