package com.project.mall.service.impl;

import com.project.mall.controller.req.buyer.EditShoppingCartReq;
import com.project.mall.controller.req.buyer.ShoppingCartReq;
import com.project.mall.controller.res.ReqResult;
import com.project.mall.dao.BehaviorRepository;
import com.project.mall.dao.CartRepository;
import com.project.mall.dao.ProductRepository;
import com.project.mall.dao.entity.BehaviorEntity;
import com.project.mall.dao.entity.CartEntity;
import com.project.mall.dao.entity.ProductEntity;
import com.project.mall.domain.ShoppingCartMessage;
import com.project.mall.enums.ShoppingCartTypeEnum;
import com.project.mall.service.IShoppingCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车服务实现
 */
@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BehaviorRepository behaviorRepository;

    /**
     * 添加至购物车
     * @param shoppingCartReq
     * @return
     */
    @Transactional
    @Override
    public ReqResult addShoppingCart(ShoppingCartReq shoppingCartReq) {
        CartEntity cartEntity = new CartEntity();
        BeanUtils.copyProperties(shoppingCartReq, cartEntity);
        cartEntity.setCart_num(shoppingCartReq.getProduct_num());
        CartEntity res = cartRepository.save(cartEntity);
        if (null == res) {
            return new ReqResult(ShoppingCartTypeEnum.ADD_FAILED.getCode(), "添加失败");
        }
        // 记录用户点击商品的行为
        BehaviorEntity behaviorEntity = behaviorRepository
                .findByBuyerAndProductId(shoppingCartReq.getBuyer_id(), shoppingCartReq.getProduct_id());
        if (behaviorEntity == null) {
            // 用户以前没有对该商品进行过操作, 记录用户点击行为
            behaviorEntity.setBuyer_id(shoppingCartReq.getBuyer_id());
            behaviorEntity.setProduct_id(shoppingCartReq.getProduct_id());
            behaviorEntity.setBehavior_score(3);
            behaviorRepository.save(behaviorEntity);
        } else {
            // 用户以前对该商品进行过操作, 更新加权分
            behaviorRepository.updateScoreByBuyerAndProductId(3,
                    shoppingCartReq.getBuyer_id(), shoppingCartReq.getProduct_id());
        }
        return new ReqResult(ShoppingCartTypeEnum.ADD_SUCCESS.getCode(), "添加成功");
    }

    /**
     * 删除购物车商品
     * @param cartIdList
     * @return
     */
    @Transactional
    @Override
    public ReqResult deleteShoppingCart(List<Long> cartIdList) {
        for (Long cartId : cartIdList) {
            cartRepository.deleteByCartId(cartId);
        }
        return new ReqResult(ShoppingCartTypeEnum.DELETE_SUCCESS.getCode(), "删除成功");
    }

    /**
     * 修改购物车商品数量
     * @return
     */
    @Transactional
    @Override
    public ReqResult changeBuyProductNum(EditShoppingCartReq editShoppingCartReq) {
        int row = cartRepository.updateCartNumByCartId(editShoppingCartReq.getProduct_num(), editShoppingCartReq.getCart_id());
        if (row == 0) {
            return new ReqResult(ShoppingCartTypeEnum.UPDATE_FAILED.getCode(), "更新失败");
        }
        return new ReqResult(ShoppingCartTypeEnum.UPDATE_SUCCESS.getCode(), "更新成功");
    }

    /**
     * 根据买家id获取购物车商品列表
     * @param buyerId
     * @return
     */
    @Override
    public ReqResult getShoppingCartProduct(Long buyerId) {
        // 查询购物车表
        List<CartEntity> shoppingCartList = cartRepository.findAllByBuyerId(buyerId);
        List<ShoppingCartMessage> cartMessageList = new ArrayList<>();
        // 查询商品表
        for (CartEntity cartEntity : shoppingCartList) {
            ProductEntity product = productRepository.findById(cartEntity.getProduct_id()).get();
            ShoppingCartMessage cartMessage = new ShoppingCartMessage();
            BeanUtils.copyProperties(product, cartMessage);
            cartMessage.setCart_id(cartEntity.getCart_id());
            cartMessage.setBuyer_id(cartEntity.getBuyer_id());
            cartMessage.setCart_num(cartEntity.getCart_num());
            cartMessageList.add(cartMessage);
        }
        return new ReqResult(ShoppingCartTypeEnum.QUERY_SUCCESS.getCode(), "查询成功", cartMessageList);
    }
}
