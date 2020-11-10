package com.project.mall.dao;

import com.project.mall.dao.entity.IdentityFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 身份证信息查询
 */
@Repository
public interface IdentityFormRepository extends JpaRepository<IdentityFormEntity, Long> {

    /**
     * 根据身份证号查询
     * @param username
     * @return
     */
    @Query(value = "select * from identity_form where username = ?1", nativeQuery = true)
    IdentityFormEntity findByIdentifyNumber(String username);

    /**
     * 根据id更新used
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update identity_form set used = 1 where id = ?1", nativeQuery = true)
    int updateUsed(Long id);
}
