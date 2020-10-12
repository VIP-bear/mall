package com.project.mall.service.impl;

import com.project.mall.controller.req.merchant.MerchantChangeProductReq;
import com.project.mall.controller.req.merchant.MerchantUploadProductReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.ProductRepository;
import com.project.mall.dao.entity.ProductEntity;
import com.project.mall.enums.ProductTypeEnum;
import com.project.mall.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品服务
 */

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

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
//        int offset = (page - 1) * size;
//        List<ProductEntity> productList = productRepository.findAllByProductName(productName, offset, size);
//        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", productList);
        return null;
    }

    @Override
    public ReqResult queryProductByTag(String tag, int page, int size) {
//        int offset = (page - 1) * size;
//        List<ProductEntity> productList = productRepository.findAllByTag(tag, offset, size);
//        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", productList);
        return null;
    }

    @Override
    public ReqResult queryEvaluateByProductId(Long productId, int page, int size) {
//        int offset = (page - 1) * size;
//        List<EvaluateEntity> evaluateList = evaluateRepository.findAllEvaluateByProductId(productId, offset, size);
//        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", evaluateList);
        return null;
    }

    @Override
    public ReqResult queryProductById(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId).get();
        return new ReqResult(ProductTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", productEntity);
    }

    @Override
    public ReqResult queryProductByPage(int page, int size) {
        // 按评分排序
        PageRequest request = PageRequest.of(page, size,
                Sort.by(Sort.Direction.DESC, "product_score"));
        Page<ProductEntity> productEntities = productRepository.findAllByPageable(request);
        List<ProductEntity> productList = productEntities.getContent();
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
