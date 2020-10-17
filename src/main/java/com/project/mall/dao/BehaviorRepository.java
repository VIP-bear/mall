package com.project.mall.dao;

import com.project.mall.dao.entity.BehaviorEntity;
import com.project.mall.dao.entity.BehaviorPK;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
