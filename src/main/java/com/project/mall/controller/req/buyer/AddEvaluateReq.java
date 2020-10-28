package com.project.mall.controller.req.buyer;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.List;

/**
 * 用户对商品进行评论
 */
@Data
public class AddEvaluateReq {

    /**
     * 被评价的商品id
     */
    private Long product_id;

    /**
     * 评价的买家id
     */

    private Long buyer_id;

    /**
     * 商品评分，默认为5.0分
     */

    private Double evaluate_score;

    /**
     * 评价内容
     */

    private String evaluate_content;

    /**
     * 评价图片1（评价可上传最多三张图片）
     */

    private MultipartFile evaluate_pic1;
    /**
     * 评价图片2
     */

    private MultipartFile evaluate_pic2;
    /**
     * 评价图片3
     */

    private MultipartFile evaluate_pic3;




}
