package com.project.mall.dao;

import com.project.mall.dao.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

    /**
     * 根据评价id查询回复
     * @param evaluate_id
     * @return
     */
    @Query(value = "select * from mall_reply where evaluate_id = ?1", nativeQuery = true)
    ReplyEntity findReplyByEvaluateId(Long evaluate_id);

}
