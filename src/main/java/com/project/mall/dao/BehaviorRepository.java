package com.project.mall.dao;

import com.project.mall.dao.entity.BehaviorEntity;
import com.project.mall.dao.entity.BehaviorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BehaviorRepository extends JpaRepository<BehaviorEntity, BehaviorPK> {

    /**
     * 根据买家id和行为加权分的降序来查询表内数据
     * @param buyerId
     * @param size
     * @return
     */
    @Query(value = "select * from mall_behavior where buyer_id = ?1 order by behavior_score DESC" +
            " limit ?2", nativeQuery = true)
    List<BehaviorEntity>  findBehaviorByBuyerIdOrdeOrderByScore(Long buyerId, int size);

    /**
     * 根据用户id和商品id更新用户行为加权分
     * @param behavior_score
     * @param buyer_id
     * @param product_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_behavior set behavior_score = behavior_score + ?1 where buyer_id = ?2 and product_id = ?3", nativeQuery = true)
    int updateScoreByBuyerAndProductId(int behavior_score, Long buyer_id, Long product_id);

    /**
     * 根据用户id和商品id查询表内数据
     * @param buyer_id
     * @param product_id
     * @return
     */
    @Query(value = "select * from mall_behavior where buyer_id = ?1 and product_id = ?2", nativeQuery = true)
    BehaviorEntity findByBuyerAndProductId(Long buyer_id, Long product_id);
}
