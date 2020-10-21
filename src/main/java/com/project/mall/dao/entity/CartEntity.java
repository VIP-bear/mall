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

    /*
    购物车中商品数量
     */
    @Column(columnDefinition = "decimal(10,2)")
    private Double cart_num;
}
