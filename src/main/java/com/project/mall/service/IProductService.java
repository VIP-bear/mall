package com.project.mall.service;

import com.project.mall.controller.req.merchant.MerchantChangeProductReq;
import com.project.mall.controller.req.merchant.MerchantUploadProductReq;
import com.project.mall.controller.res.ReqResult;

/**
 * 商品服务
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
     * @param updateProduct
     * @return
     */
    ReqResult updateProduct(MerchantChangeProductReq updateProduct);

    /**
     * 根据商品id更新商品库存
     * @param productStock
     * @param productId
     * @return
     */
    ReqResult updateProductStockByProductId(Double productStock, Long productId);

    /**
     * 根据商品id更新商品状态
     * @param productState
     * @param productId
     * @return
     */
    ReqResult updateProductStateByProductId(String productState, Long productId);


    /**
     * 根据商品id查询
     * @param productId
     * @return
     */
    ReqResult queryProductById(Long productId);

    /**
     * 分页查询商品
     * @param page
     * @param size
     * @return
     */
    ReqResult queryProductByPage(int page, int size);

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
