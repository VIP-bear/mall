package com.project.mall.dao;

import com.project.mall.dao.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    /**
     * 根据买家id查询非默认地址
     * @param buyer_id
     * @return
     */
    @Query(value = "select * from mall_address where buyer_id = ?1 and address_default = 0", nativeQuery = true)
    List<AddressEntity> findUnDefaultAddressByBuyerId(Long buyer_id);

    /**
     * 根据地址id修改地址内容
     * @param address_content
     * @param address_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_address set address_content = ?1 where address_id = ?2", nativeQuery = true)
    int updateAddressById(String address_content, Long address_id);

}
