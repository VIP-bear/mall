package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "mall_behavior")
public class BehaviorEntity {

    @Id
    @Column
    private Long buyer_id;

    @Id
    @Column
    private Long product_id;

    @Column
    private  int behavior_score;

}
