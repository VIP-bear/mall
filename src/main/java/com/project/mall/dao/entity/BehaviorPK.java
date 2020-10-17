package com.project.mall.dao.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BehaviorPK implements Serializable {

    private Long buyer_id;
    private Long product_id;



    public BehaviorPK(){}

    public BehaviorPK(Long buyer_id, Long product_id){
        this.buyer_id = buyer_id;
        this.product_id = product_id;
    }

    //重写hashCode方法
    @Override
    public int hashCode(){
        int result = 1;
        int prime = 31;
        result = prime * result + ((buyer_id == null) ? 0 : buyer_id.hashCode());
        result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;
        BehaviorPK other = (BehaviorPK)obj;

        if (buyer_id == null) {
            if (other.buyer_id != null)
                return false;
        } else if (!buyer_id.equals(other.buyer_id))
            return false;

        if (product_id == null) {
            if (other.product_id != null)
                return false;
        } else if (!product_id.equals(other.product_id))
            return false;

        return true;
    }
}
