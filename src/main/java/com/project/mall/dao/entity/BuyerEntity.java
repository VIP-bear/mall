package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户表
 */

@Entity
@Data
@Table(name = "mall_buyer")
public class BuyerEntity {

    /**
     * 用户id,自增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long buyer_id;

    /**
     * 用户名
     */
    @Column
    private String buyer_name;

    /**
     * 用户密码
     */
    @Column
    private String buyer_pwd;

    /**
     * 用户邮箱
     */
    @Column
    private String buyer_email;

    /**
     * 默认地址
     */
    @Column
    private String address_default;

    /**
     * 电话
     */
    @Column
    private Long buyer_phone;

}
