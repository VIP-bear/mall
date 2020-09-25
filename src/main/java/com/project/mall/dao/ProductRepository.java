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
     * 根据商品id更新商品类别
     * @param product_category
     * @param product_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_product set product_category = ?1 where product_id = ?2", nativeQuery = true)
    int updateProductCategoryByProductId(String product_category, Long product_id);

    /**
     * 根据商品id更新商品名称
     * @param product_name
     * @param product_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_product set product_name = ?1 where product_id = ?2", nativeQuery = true)
    int updateProductNameByProductId(String product_name, Long product_id);

    /**
     * 根据商品id更新商品描述
     * @param product_description
     * @param product_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_product set product_description = ?1 where product_id = ?2", nativeQuery = true)
    int updateProductDescriptionByProductId(String product_description, Long product_id);

    /**
     * 根据商品id更新商品封面
     * @param product_cover
     * @param product_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_product set product_cover = ?1 where product_id = ?2", nativeQuery = true)
    int updateProductCoverByProductId(String product_cover, Long product_id);

    /**
     * 根据商品id更新商品单价
     * @param product_price
     * @param product_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_product set product_price = ?1 where product_id = ?2", nativeQuery = true)
    int updateProductPriceByProductId(Double product_price, Long product_id);

    /**
     * 根据商品id更新商品单位
     * @param product_unit
     * @param product_id
     * @return
     */
    @Modifying
    @Query(value = "update mall_product set product_unit = ?1 where product_id = ?2", nativeQuery = true)
    int updateProductUnitByProductId(String product_unit, Long product_id);

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
