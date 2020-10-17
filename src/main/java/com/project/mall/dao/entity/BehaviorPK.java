package com.project.mall.dao.entity;

import java.io.Serializable;

public class BehaviorPK implements Serializable {

    private Long buyerId;
    private Long productId;

    public BehaviorPK(){}

    public BehaviorPK(Long buyerId, Long productId){
        this.buyerId = buyerId;
        this.productId = productId;
    }
}
