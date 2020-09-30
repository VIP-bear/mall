package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 评论表
 * 通过评论者id（买家id）、被评论的商品id来进行标记
 */
@Entity
@Data
@Table(name = "mall_assessment")
public class AssessmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long assessment_id;

    /**
     * 买家id
     */
    @Column
    private Long buyer_id;

    /**
     * 商品id
     */
    @Column
    private Long product_id;

    /**
     * 评论内容
     */
    @Column
    private String assessment_content;
}
