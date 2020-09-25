package com.project.mall.dao;

import com.project.mall.dao.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    /**
     * 根据订单id修改订单状态
     */
    @Modifying
    @Query(value = "update mall_order set order_state = ?1 where order_id = ?2", nativeQuery = true)
    int updateOrderStateById(String order_state, Long order_id);

    /**
     * 根据订单id修改订单配送地址
     */
    @Modifying
    @Query(value = "update mall_order set order_address = ?1 where order_id = ?2", nativeQuery = true)
    int updateOrderAddressById(String order_address, Long order_id);

    @Modifying
    @Query(value = "upate mall_order set order_num = ?1 and order_cost = ?2 where order_id = ?3", nativeQuery = true)
    int updateOrderNumandCostById(double order_num, double order_cost, Long order_id);
}