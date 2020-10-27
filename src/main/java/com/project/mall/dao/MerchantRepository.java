package com.project.mall.dao;

import com.project.mall.dao.entity.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 卖家数据库操作方法
 */
@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, Long> {

    /**
     * 根据卖家的id来更新卖家状态
     * @param merchant_state
     * @param merchant_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_merchant set merchant_state = ?1 where merchant_id = ?2", nativeQuery = true)
    int updateMerchantStateById(String merchant_state, Long merchant_id);

    /**
     * 根据商家状态获取所有的商家信息（用于管理员查看处于审核状态中的）
     * @param merchant_state
     * @return
     */
    @Query(value = "select * from mall_merchant where merchant_state = ?1",nativeQuery = true)
    List<MerchantEntity> findAllByMerchantState(String merchant_state);

    /**
     * 根据商家id修改商家的店铺名称
     * @param merchant_shopname
     * @param merchant_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_merchant set merchant_shopname = ?1 where merchant_id = ?2", nativeQuery = true)
    int updateMerchantShopNameById(String merchant_shopname, Long merchant_id);

    /**
     * 根据买家id查询卖家信息
     * @param buyer_id
     * @return
     */
    @Query(value = "select * from mall_merchant where buyer_id = ?1", nativeQuery = true)
    MerchantEntity findByBuyerId(Long buyer_id);
}
