package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 该表为卖家的资质审查表，资质审查表中数据由后台提供，
 * 前端数据余数据库中数据进行比对来确定卖家有无设立商家资格
 */

@Entity
@Data
@Table(name = "mall_qualification")
public class QualificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qualification_id;

    /**
     * 身份证明号（与真实姓名和用户面部共同确定卖家身份）
     */
    @Column
    private String qualification_idnum;

    /**
     * 真实姓名
     */
    @Column
    private String qualification_realname;

    /**
     * 面部图片（用于面部识别确定卖家身份）
     */
    @Column
    private String qualification_face;

}
