package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "mall_behavior")
@IdClass(BehaviorPK.class)
public class BehaviorEntity implements Serializable {

    @Id
    @Column(name = "buyer_id")
    private Long buyer_id;

    @Id
    @Column(name = "product_id")
    private Long product_id;

    /*
    用户行为加权分
     */
    @Column
    private int behavior_score;


}
