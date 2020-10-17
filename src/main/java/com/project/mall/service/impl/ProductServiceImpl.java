package com.project.mall.service.impl;

import com.project.mall.controller.req.merchant.MerchantChangeProductReq;
import com.project.mall.controller.req.merchant.MerchantUploadProductReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.BehaviorRepository;
import com.project.mall.dao.BuyerRepository;
import com.project.mall.dao.ProductRepository;
import com.project.mall.dao.entity.BehaviorEntity;
import com.project.mall.dao.entity.BuyerEntity;
import com.project.mall.dao.entity.ProductEntity;
import com.project.mall.enums.ProductTypeEnum;
import com.project.mall.service.IProductService;
import com.project.mall.util.RecommendProductProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品服务
 */

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private BehaviorRepository behaviorRepository;


    @Transactional
    @Override
    public ReqResult addProduct(MerchantUploadProductReq uploadProduct) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(uploadProduct, productEntity);
        if (null == productRepository.save(productEntity)) {
            return new ReqResult(ProductTypeEnum.ADD_FAILED.getCode(), "发布失败");
        }
        return new ReqResult(ProductTypeEnum.ADD_SUCCESS.getCode(), "发布成功");
    }

    @Transactional
    @Override
    public ReqResult deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return new ReqResult(ProductTypeEnum.DELETE_SUCCESS.getCode(), "删除成功");
    }

    @Transactional
    @Override
    public ReqResult updateProduct(MerchantChangeProductReq changeProductReq) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(changeProductReq, productEntity);  // 有些问题
        productRepository.save(productEntity);  // 更新
        return null;
    }

    @Transactional
    @Override
    public ReqResult updateProductStockByProductId(Double productStock, Long productId) {
        int row = productRepository.updateProductStockByProductId(productStock, productId);
        if (row != 1) {
            return new ReqResult(ProductTypeEnum.UPDATE_FAILED.getCode(), "更新失败");
        }
        return new ReqResult(ProductTypeEnum.UPDATE_SUCCESS.getCode(), "更新成功");
    }

    @Transactional
    @Override
    public ReqResult updateProductStateByProductId(String productState, Long productId) {
        int row = productRepository.updateProductStateByProductId(productState, productId);
        if (row != 1) {
            return new ReqResult(ProductTypeEnum.UPDATE_FAILED.getCode(), "更新失败");
        }
        return new ReqResult(ProductTypeEnum.UPDATE_SUCCESS.getCode(), "更新成功");
    }

    @Override
    public ReqResult queryProductByProductName(String productName, int page, int size) {
        int offset = (page - 1) * size;
        List<ProductEntity> productList = productRepository.findProductByName(productName, offset, size);
        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", productList);
    }

    @Override
    public ReqResult queryProductByTag(String tag, int page, int size) {
        int offset = (page - 1) * size;
        List<ProductEntity> productList = productRepository.findProductByCategory(tag, offset, size);
        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", productList);
    }

    @Override
    public ReqResult queryProductById(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId).get();
        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", productEntity);
    }

    @Override
    public ReqResult queryProductByRecommend(Long buyerId, int size) {
        // 查询所有用户
        List<BuyerEntity> buyerEntities = buyerRepository.findAll();
        // 存储所有用户感兴趣的商品
        Map<Long, List<Long>> buyerAndProductMap = new HashMap<>(buyerEntities.size());
        // 用户感兴趣的商品
        List<BehaviorEntity> temp;
        for (int i = 0; i < buyerEntities.size(); i++) {
            temp = behaviorRepository.findBehaviorByBuyerIdOrdeOrderByScore(buyerEntities.get(i).getBuyer_id(), size);
            List<Long> productIdList = new ArrayList<>();
            for (BehaviorEntity behaviorEntity : temp) {
                productIdList.add(behaviorEntity.getProduct_id());
            }
            buyerAndProductMap.put(buyerEntities.get(i).getBuyer_id(), productIdList);
        }
        // 推荐商品
        RecommendProductProvider recommendProductProvider = new RecommendProductProvider();
        List<Long> productIdList =  recommendProductProvider.recommendProduct(buyerId, size, buyerAndProductMap);

        // 查询推荐的商品
        List<ProductEntity> productList = new ArrayList<>();
        for (Long productId : productIdList) {
            productList.add(productRepository.findById(productId).get());
        }

        // 如果推荐商品数量不够，随机推荐一些商品
        if (productList.size() < size) {
            ReqResult reqResult = queryProductByRandom(size - productList.size());
            productList.addAll((List<ProductEntity>)reqResult.getData());
        }

        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", productList);
    }

    @Override
    public ReqResult queryProductByRandom(int size) {
        List<ProductEntity> productList = productRepository.findProductByRandom(size);
        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", productList);
    }

    @Override
    public ReqResult queryProductByMerchantId(Long merchantId) {
        List<ProductEntity> productEntityList = productRepository.findAllByMerchantId(merchantId);
        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", productEntityList);
    }

    @Override
    public ReqResult queryProductByProductState(String productState) {
        List<ProductEntity> productEntityList = productRepository.findAllByProductState(productState);
        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", productEntityList);
    }

    @Override
    public ReqResult queryProductByMerchantIdAndProductState(Long merchantId, String productState) {
        List<ProductEntity> productEntityList = productRepository.findAllByMerchantIdAndProductState(merchantId, productState);
        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", productEntityList);
    }
}
