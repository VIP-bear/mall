package com.project.mall.controller.req.merchant;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商家上传商品数据
 */
@Data
public class MerchantUploadProductReq {
    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品类别
     */
    private String productType;

    /**
     * 商品图片
     */
    private MultipartFile productPicture;

    /**
     * 商品单价
     */
    private Double UnitPrice;

    /**
     * 商品销售单位
     */
    private String SalesUnit;
    /**
     * 商品库存
     */
    private String productStock;
    /**
     * 商品描述
     */
    private String productDescribe;

}
