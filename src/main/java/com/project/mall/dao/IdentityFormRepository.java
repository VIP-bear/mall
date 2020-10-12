package com.project.mall.dao;

import com.project.mall.dao.entity.IdentityFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 身份证信息查询
 */
@Repository
public interface IdentityFormRepository extends JpaRepository<IdentityFormEntity, Long> {

    IdentityFormEntity findByIdentifyNumber(String merchantRegisterID);

}
