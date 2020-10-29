package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;

/*
购物车表
 */
@Entity
@Data
@Table(name = "mall_cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cart_id;

    @Column
    private Long product_id;

    @Column
    private Long buyer_id;

    @Column
    private String cart_address;
    /*
    购物车中商品数量
     */
    @Column
    private Integer cart_num;
}
