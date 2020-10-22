package com.project.mall.dao;

import com.project.mall.dao.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    /**
     * 根据订单id修改订单状态
     * @param  order_state
     * @param order_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_order set order_state = ?1 where order_id = ?2", nativeQuery = true)
    int updateOrderStateById(String order_state, Long order_id);

    /**
     * 根据订单id修改订单配送地址
     * @param order_address
     * @param order_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_order set order_address = ?1 where order_id = ?2", nativeQuery = true)
    int updateOrderAddressById(String order_address, Long order_id);

    /**
     * 根据订单id修改订单中的商品数量和花费总额
     * @param order_num
     * @param order_cost
     * @param order_id
     * @return
     */
    @Modifying
    @Query(value = "upate mall_order set order_num = ?1 and order_cost = ?2 where order_id = ?3", nativeQuery = true)
    int updateOrderNumandCostById(double order_num, double order_cost, Long order_id);

    /**
     * 根据订单状态查询订单
     * @param order_state
     * @return
     */
    @Query(value = "select * from mall_order where order_state = ?1 and buyer_id = ?2", nativeQuery = true)
    List<OrderEntity> findAllByOrderState(String order_state, Long buyer_id);

    /**
     * 删除指定订单id的订单
     * @param order_id
     */
    @Modifying
    @Query(value = "delete from mall_order where order_id = ?1", nativeQuery = true)
    void deleteByOrderId(Long order_id);

    /**
     * 根据买家id查询所有订单
     * @param buyer_id
     * @return
     */
    @Query(value = "select * from mall_order where buyer_id = ?1", nativeQuery = true)
    List<OrderEntity> findAllByBuyerId(Long buyer_id);
}