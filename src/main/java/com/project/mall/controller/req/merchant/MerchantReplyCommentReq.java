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
    private Long evaluate_id;
    /**
     * 买家ID
     */
    private Long buyer_id;

    /**
     * 商品ID
     */
    private Long product_id;

    /**
     * 回复内容
     */
    private String reply_content;
}

