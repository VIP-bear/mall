package com.project.mall.dao;

import com.project.mall.dao.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

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
    List<ProductEntity> findAllByMerchantIdandProductState(Long merchant_id, String product_state);

//    /**
//     *
//     * @param product_category
//     * @return
//     */
//    @Query(value = "select * from mall_product where product_category = ?1 " +
//            "order by product_score", nativeQuery = true)
//    Page<ProductEntity> findAllByProductCategoryOrderByScore(String product_category);


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


}
