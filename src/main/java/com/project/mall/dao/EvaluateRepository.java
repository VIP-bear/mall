package com.project.mall.dao;

import com.project.mall.dao.entity.EvaluateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateRepository extends JpaRepository<EvaluateEntity, Long> {

    /**
     * 根据商品id分页查询评价
     * @param product_id
     * @param offset
     * @param size
     * @return
     */
    @Query(value = "select * from mall_evaluate where product_id = ?1 " +
            "limit ?2,?3", nativeQuery = true)
    List<EvaluateEntity> findAllByProductId(Long product_id, int offset, int size);

    /**
     * 根据买家id和商品id查询评价
     * @param product_id
     * @param buyer_id
     * @return
     */
    @Query(value = "select * from mall_evaluate where product_id = ?1 and buyer_id = ?2", nativeQuery = true)
    EvaluateEntity findAllByProductIdAndBuyerId(String product_id, String buyer_id);
}
