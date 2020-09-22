package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户表
 */

@Entity
@Data
@Table(name = "mall_buyer")
public class UserEntity {

    /**
     * 用户id,自增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @Column
    private String username;

    /**
     * 用户密码
     */
    @Column
    private String password;

    /**
     * 默认地址
     */
    @Column
    private String default_address;

    /**
     * 电话
     */
    @Column
    private Long phone;

}
