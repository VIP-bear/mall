package com.project.mall.dao;

import com.project.mall.dao.entity.VerifyCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 验证码表的相关操作
 */

@Repository
public interface VerifyCodeRepository extends JpaRepository<VerifyCodeEntity, Long> {

    /**
     * 根据邮箱和验证码查找记录
     * @param email
     * @param code
     * @return
     */
    @Query(value = "select * from mall_verify_code where email = ?1 and code = ?2", nativeQuery = true)
    VerifyCodeEntity findVerifyCodeEntityByEmailAndCode(String email, Integer code);

}
