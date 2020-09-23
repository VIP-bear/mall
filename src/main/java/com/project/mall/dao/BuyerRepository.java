package com.project.mall.dao;

import com.project.mall.dao.entity.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 用户访问数据库数据
 */

@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity, Long> {

    /**
     * 使用本地sql查询
     * ?1:代表第一个参数
     * nativeQuery=true:开启本地查询
     * @param username
     * @return
     */

    /**
     * 根据用户名查询用户
     * @param buyerName
     * @return
     */
    @Query(value = "select * from mall_buyer where buyer_name = ?1", nativeQuery = true)
    BuyerEntity findUserEntityByUsername(String buyerName);

    /**
     * 根据邮箱查询用户
     * @param buyerEmail
     * @return
     */
    @Query(value = "select * from mall_buyer where buyer_email = ?1", nativeQuery = true)
    BuyerEntity findUserEntityByUserEmail(String buyerEmail);
}
