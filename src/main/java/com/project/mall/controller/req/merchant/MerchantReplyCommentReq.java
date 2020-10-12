package com.project.mall.controller.req.merchant;

import lombok.Data;

/**
 * 卖家回复评论数据封装
 */
@Data
public class MerchantReplyCommentReq {
    /**
     * 评论ID
     */
    private Long commentID;
    /**
     * 买家ID
     */
    private Long buyerID;

    /**
     * 商品ID
     */
    private Long productID;

    /**
     * 回复内容
     */
    private String commentMessage;
}
