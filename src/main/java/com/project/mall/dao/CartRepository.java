package com.project.mall.dao;

import com.project.mall.dao.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

    /**
     * 根据买家id查询购物车
     * @param buyer_id
     * @return
     */
    @Query(value = "select * from mall_cart where buyer_id = ?1", nativeQuery = true)
    List<CartEntity> findAllByBuyerId(Long buyer_id);

    /**
     * 修改购物车内商品数量
     * @param cart_num
     * @param cart_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_cart set cart_num = ?1 where cart_id = ?2", nativeQuery = true)
    int updateCartNumByCartId(Integer cart_num, Long cart_id);

    /**
     * 根据购物车id删除购物车商品
     * @param cart_id
     */
    @Modifying
    @Query(value = "delete from mall_cart where cart_id = ?1", nativeQuery = true)
    void deleteByCartId(Long cart_id);

    /**
     * 根据买家id和商品id删除购物车
     * @param buyer_id
     * @param product_id
     * @return
     */
    @Modifying
    @Query(value = "delete from mall_cart where buyer_id = ?1 and product_id = ?2", nativeQuery = true)
    void deleteCartByBuyerIdAndProductId(long buyer_id, long product_id);


    /**
     * 根据买家id和商品id查询购物车
     * @param buyer_id
     * @param product_id
     * @return
     */
    @Query(value = "select * from mall_cart where buyer_id = ?1 and product_id = ?2", nativeQuery = true)
    CartEntity findCartByBuyerIdAndProductId(long buyer_id, long product_id);
}
