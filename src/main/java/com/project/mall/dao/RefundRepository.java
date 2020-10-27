package com.project.mall.dao;

import com.project.mall.dao.entity.RefundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefundRepository extends JpaRepository<RefundEntity, Long> {

    /**
     * 查询所有处于退款中状态的退款申请
     * @return
     */
    @Query(value = "select * from mall_refund where refund_state = 0", nativeQuery = true)
    List<RefundEntity> findAllByRefundState();

    /**
     * 根据订单id修改退款申请的状态
     * @param refund_state
     * @param order_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_refund set refund_state = ?1 where order_id = ?2", nativeQuery = true)
    int updateStateByOrderId(int refund_state, Long order_id);
}
