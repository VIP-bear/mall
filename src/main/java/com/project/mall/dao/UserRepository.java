package com.project.mall.dao;

import com.project.mall.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 用户访问数据库数据
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * 使用本地sql查询
     * ?1:代表第一个参数
     * nativeQuery=true:开启本地查询
     * @param username
     * @return
     */

    @Query(value = "select * from mall_buyer where username = ?1", nativeQuery = true)
    UserEntity findUserEntityByUsername(String username);

}
