package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 地址表
 * 存储所有用户的所有地址
 * 包含默认地址的标记
 */
@Entity
@Data
@Table(name = "mall_address")
public class AddressEntity {

    /**
     *地址id，自增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long address_id;

    /**
     * 标记该地址是否为默认地址，1代表是默认地址，0代表非默认地址（默认值为0）
     */
    @Column
    private int address_default;

    /**
     *地址内容
     */
    @Column
    private String address_content;

    /**
     * 买家id
     */
    @Column
    private Long buyer_id;


}
