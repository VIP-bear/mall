package com.project.mall.dao;

import com.project.mall.dao.entity.QualificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<QualificationEntity, Long> {

    /**
     * 根据商家的身份证明号和真实姓名以及营业执照注册号确定商家身份
     * @param qualification_idnum
     * @param qualification_realname
     * @param merchant_license
     * @return
     */
    @Query(value = "select * from mall_qualification where qualification_idnum = ?1 and qualification_realname = ?2 and merchant_license = ?3", nativeQuery = true)
    QualificationEntity findAllByQualificationIDNumAndRealName(String qualification_idnum, String qualification_realname, String merchant_license);
}
