package com.project.mall.service;

import com.project.mall.controller.req.merchant.MerchantChangeProductReq;
import com.project.mall.controller.req.merchant.MerchantUploadProductReq;
import com.project.mall.controller.res.ReqResult;

/**
 * 商品服务接口
 */
public interface IProductService {

    /**
     * 添加商品
     * @param uploadProduct
     * @return
     */
    ReqResult addProduct(MerchantUploadProductReq uploadProduct);

    /**
     * 删除商品
     * @param productId
     * @return
     */
    ReqResult deleteProduct(Long productId);

    /**
     * 修改商品
     * @param changeProductReq
     * @return
     */
    ReqResult updateProduct(MerchantChangeProductReq changeProductReq);

    /**
     * 根据商品id更新商品库存
     * @param productStock
     * @param productId
     * @return
     */
    ReqResult updateProductStockByProductId(Integer productStock, Long productId);

    /**
     * 根据商品id更新商品状态
     * @param productState
     * @param productId
     * @return
     */
    ReqResult updateProductStateByProductId(String productState, Long productId);

    /**
     * 根据商品名称模糊查询(分页)
     * @param productName
     * @param page
     * @param size
     * @return
     */
    ReqResult queryProductByProductName(String productName, int page, int size);

    /**
     * 根据商品类别查询(分页)
     * @param tag
     * @param page
     * @param size
     * @return
     */
    ReqResult queryProductByTag(String tag, int page, int size);

    /**
     * 根据商品id查询
     * @param productId
     * @return
     */
    ReqResult queryProductById(Long buyerId, Long productId);

    /**
     * 推荐商品
     * @param size 查询记录数
     * @return
     */
    ReqResult queryProductByRecommend(Long buyerId, int size);

    /**
     * 随机推荐商品
     * @param size
     * @return
     */
    ReqResult queryProductByRandom(int size);

    /**
     * 根据商家id查询商品
     * @param merchantId
     * @return
     */
    ReqResult queryProductByMerchantId(Long merchantId);

    /**
     * 根据商品状态查询商品
     * @param productState
     * @return
     */
    ReqResult queryProductByProductState(String productState);

    /**
     * 根据商家id和商品状态查询
     * @param merchantId
     * @param productState
     * @return
     */
    ReqResult queryProductByMerchantIdAndProductState(Long merchantId, String productState);


}
