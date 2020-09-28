package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "mall_merchant")
public class MerchantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long merchant_id;

    /**
     * 买家id（卖家由买家（普通用户）经过资质审查注册而来，所以卖家表中存储买家id）
     */
    @Column
    private Long buyer_id;

    /**
     * 用户名（同买家用户名）
     */
    private String buyer_name;

    /**
     * 店铺名称（有名命要求）
     */
    private String merchant_shopname;

    /**
     * 营业执照注册号
     */
    private String merchant_license;

    /**
     * 卖家状态（审核中(under review)，可营业（open for business)，不可营业(closed)）
     */
    private String merchant_state;

}