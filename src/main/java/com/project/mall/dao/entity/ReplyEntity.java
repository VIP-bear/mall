package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "mall_reply")
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reply_id;

    /**
     * 被回复的评价id
     */
    @Column
    private Long evaluate_id;

    /**
     * 回复内容
     */
    @Column
    private String reply_content;
}
