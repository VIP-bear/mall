package com.project.mall.dao;

import com.project.mall.dao.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String> {

    /**
     * 根据管理员id和密码查询管理员
     * @param admin_id
     * @param admin_pwd
     * @return
     */
    @Query(value = "select * from mall_admin where admin_id = ?1 and  admin_pwd = ?2", nativeQuery = true)
    AdminEntity findByAdminIdAndPwd(String admin_id, String admin_pwd);
}
