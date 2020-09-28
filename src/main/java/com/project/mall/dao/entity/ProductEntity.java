package com.project.mall.dao.entity;

import lombok.Data;
import org.dom4j.swing.XMLTableColumnDefinition;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Data
@Table(name = "mall_product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;

    /**
     * 商品类别
     */
    @Column
    private String product_category;

    /**
     * 商品名称
     */
    @Column
    private String product_name;

    /**
     * 商品描述
     */
    @Column
    private String product_description;

    /**
     * 商品封面
     */
    @Column
    private String product_cover;

    /**
     * 商品单价
     */
    @Column(columnDefinition = "decimal(10,2)")
    private Double product_price;

    /**
     * 商品单位
     */
    @Column
    private String product_unit;

    /**
     * 商品库存
     */
    @Column(columnDefinition = "decimal(10,2)")
    private Double product_stock = 0.00;

    /**
     * 商品状态（包括审核中verifying、出售中on offer、下架undercarriage）
     */
    @Column
    private String product_state;

    /**
     * 商品评分（默认为0（但在界面不显示），评价超过十人后计算平均评分作为商品评分并显示在界面）
     */
    @Column(columnDefinition = "decimal(10,1)")
    private Double product_score = 0.0;

    /**
     * 卖家id
     */
    @Column
    private Long merchant_id;
}
