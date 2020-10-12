package com.project.mall.dao;

import com.project.mall.dao.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    /**
     * 分页查询所有商品
     * @param pageable
     * @return
     */
    Page<ProductEntity> findAllByPageable(Pageable pageable);

    /**
     * 查询对应商家的所有商品
     * @param merchant_id
     * @return
     */
    @Query(value = "select * from mall_product where merchant_id = ?1", nativeQuery = true)
    List<ProductEntity> findAllByMerchantId(Long merchant_id);

    /**
     * 根据商品状态查询所有商品（管理员查找待审核商品）
     * @param product_state
     * @return
     */
    @Query(value = "select * from mall_product where product_state = ?1",nativeQuery = true)
    List<ProductEntity> findAllByProductState(String product_state);

    /**
     * 根据商家id和商品状态来查询商品
     * @param merchant_id
     * @param product_state
     * @return
     */
    @Query(value = "select * from mall_product where merchant_id = ?1 and product_state = ?2", nativeQuery = true)
    List<ProductEntity> findAllByMerchantIdAndProductState(Long merchant_id, String product_state);


    /**
     * 根据商品id更新商品库存
     * @param product_stock
     * @param product_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_product set product_stock = ?1 where product_id = ?2", nativeQuery = true)
    int updateProductStockByProductId(Double product_stock, Long product_id);

    /**
     * 根据商品id更新商品状态
     * @param product_state
     * @param product_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_product set product_state = ?1 where product_id = ?2", nativeQuery = true)
    int updateProductStateByProductId(String product_state, Long product_id);

    /**
     * 根据商品名称模糊查询（分页）
     * @param productName
     * @param offset
     * @param size
     * @return
     */
    @Query(value = "select * from mall_product where product_name like concat('%',:productName,'%') " +
            "limit ?2,?3", nativeQuery = true)
    List<ProductEntity> findProductByName(@Param(value = "productName") String productName, int offset, int size);

    /**
     * 根据类别查询商品
     * @param product_category
     * @param offset
     * @param size
     * @return
     */
    @Query(value = "selecct * from mall_product where product_category = ?1 " +
            "limit ?2,?3",nativeQuery = true)
    List<ProductEntity> findProductByCategory(String product_category, int offset, int size);


}
