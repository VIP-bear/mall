package com.project.mall.controller.req.merchant;

import lombok.Data;

import javax.persistence.Column;

/**
 * 商家回复评论的数据封装
 */
@Data
public class AddReplyReq {
    /**
     * 被回复的评价id
     */
    private Long evaluate_id;

    /**
     * 回复内容
     */
    private String reply_content;
}
