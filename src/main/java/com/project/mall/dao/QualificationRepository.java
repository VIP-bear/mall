package com.project.mall.dao;

import com.project.mall.dao.entity.QualificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<QualificationEntity, Long> {
}
