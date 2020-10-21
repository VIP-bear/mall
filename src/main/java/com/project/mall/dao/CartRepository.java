package com.project.mall.dao;

import com.project.mall.dao.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

    /**
     * 修改购物车内商品数量
     * @param cart_num
     * @param cart_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_cart set cart_num = ?1 where cart_id = ?2", nativeQuery = true)
    int updateCartNumByCartId(Double cart_num, Long cart_id);

    /**
     * 根据购物车id删除购物车商品
     * @param cart_id
     */
    @Modifying
    @Query(value = "delete from mall_cart where cart_id = ?1", nativeQuery = true)
    void deleteByCartId(Long cart_id);
}
