package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 卖家表
 * 买家通过资质审查成为卖家（所以卖家表中会出现买家id）
 * 营业执照注册表在资质审查表中作为审查信息
 */
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
     * 店铺名称（有名命要求）
     */
    private String merchant_shopname;

    /**
     * 营业执照注册号
     */
    private String merchant_license;

    /**
     * 卖家状态（可营业（open for business)，不可营业(closed)）
     */
    private String merchant_state;

}
