package com.project.mall.dao;

import com.project.mall.dao.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    /**
     *根据买家id查询地址
     * @param buyer_id
     * @return
     */
    @Query(value = "select * from mall_address where buyer_id = ?1", nativeQuery = true)
    List<AddressEntity> findAddressEntitiesByBuyerId(Long buyer_id);

    /**
     * 根据买家id查询默认地址
     * @param buyer_id
     * @return
     */
    @Query(value = "select * from mall_address where buyer_id = ?1 and address_default = 1",nativeQuery = true)
    AddressEntity findDefaultAddressEntityByBuyerId(Long buyer_id);

}
