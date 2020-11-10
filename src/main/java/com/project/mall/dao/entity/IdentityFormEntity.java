package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 身份信息表
 */

@Entity
@Data
@Table(name = "identity_form")
public class IdentityFormEntity {
    /**
     * 用户id,自增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    @Column
    private String username;

    /**
     * 身份证号
     */
    @Column
    private String identify_number;

    /**
     * 营业执照注册号
     */
    @Column
    private String merchant_license;

    /**
     * 是否被使用(0表示未被注册，1表示已被注册)
     */
    @Column
    private Integer used;

}
