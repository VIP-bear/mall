package com.project.mall.controller.req.buyer;

import lombok.Data;

/**
 * 用户对商品进行评论
 */
@Data
public class AddCommentReq {
    /**
     * 买家ID
     */
    private Long buyerID;

    /**
     * 商品ID
     */
    private Long productID;

    /**
     * 评价内容
     */
    private String commentMessage;

}
