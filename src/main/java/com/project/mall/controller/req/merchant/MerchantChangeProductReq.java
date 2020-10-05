package com.project.mall.controller.req.merchant;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 更新商品信息
 */
@Data
public class MerchantChangeProductReq {
    /**
     * 商品id
     */
    private Long ID;

    /**
     * 商品名称
     */
    private String merchantName;

    /**
     * 商品描述
     */
    private String merchantDescribe;

    /**
     * 商品库存
     */
    private String merchantStock;

    /**
     * 商品单价
     */
    private Double unitPrice;

    /**
     * 销售单位
     */
    private String SalesUnit;

    /**
     * 商品类别
     */
    private String type;

    /**
     * 商品图片
     */
    private MultipartFile productPicture;


}
