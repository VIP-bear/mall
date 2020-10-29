package com.project.mall.controller.req.merchant;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商家上传商品数据
 */
@Data
public class MerchantUploadProductReq {
    /**
     * 商品类别
     */
    private String product_category;

    /**
     * 商品名称
     */
    private String product_name;

    /**
     * 商品描述
     */

    private String product_description;

    /**
     * 商品封面
     */

    private MultipartFile product_cover;

    /**
     * 商品单价
     */

    private Double product_price;

    /**
     * 商品单位
     */

    private String product_unit;

    /**
     * 商品库存
     */

    private Integer product_stock;


    /**
     * 卖家id
     */

    private Long merchant_id;

}
