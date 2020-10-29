package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 评价表
 * 用户在确认收货后可以对商品进行评价
 * 评价包括文字评价、图片和评分
 */

@Entity
@Data
@Table(name = "mall_evaluate")
public class EvaluateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long evaluate_id;
    /**
     *  被评价的商品id
     */
    @Column
    private Long product_id;

    /**
     * 评价的买家id
     */
    @Column
    private Long buyer_id;

    /**
     * 商品评分，默认为5.0分
     */
    @Column(columnDefinition = "decimal(2,1)")
    private Double evaluate_score;

    /**
     * 评价内容
     */
    @Column
    private String evaluate_content;

    /**
     * 评价图片1（评价可上传最多三张图片）
     */
    @Column
    private String evaluate_pic1;
    /**
     * 评价图片2
     */
    @Column
    private String evaluate_pic2;
    /**
     * 评价图片3
     */
    @Column
    private String evaluate_pic3;

    /**
     * 评价时间
     */
    @Column
    private Timestamp evaluate_time;
}
