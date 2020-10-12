package com.project.mall.controller.req.buyer;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户对商品进行评论
 */
@Data
public class AddEvaluateReq {
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

    /**
     * 商品评分
     */
    private Double score;

    /**
     * 评价附带图片(至多3张)
     */
    private List<MultipartFile> evaluatePictureList;

}
