package com.project.mall.util;

import java.util.*;

/**
 * 推荐商品
 * 基于用户的协同过滤推荐算法
 */
public class RecommendProductProvider {

    // 用户-商品表
    private Map<Long, List<Long>> buyerAndProductMap;
    // 商品-用户表
    private Map<Long, List<Long>> productAndBuyerMap;
    // 目标用户与其它用户之间喜欢商品得分表
    private Map<Long, Integer> buyerProductScore;
    // 目标用户与其它用户之间相似度表
    private Map<Long, Double> buyerSimilar;
    // 相似用户集
    private List<Long> similarBuyerList;
    // 推荐商品集合
    private List<Long> recommendProductList;


    // 推荐商品
    public List<Long> recommendProduct(Long buyerId, int size, Map<Long, List<Long>> buyerAndProductMap) {
        this.buyerAndProductMap = buyerAndProductMap;

        transferForm();
        getBuyerProductScore(buyerId);
        calBuyerSimilar(buyerId);
        getSimilarBuyerList();
        getRecommendProductList(buyerId, size);

        return recommendProductList;
    }

    // 获取推荐商品集合
    private void getRecommendProductList(Long targetBuyerId, int size) {
        recommendProductList = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        // 相似用户商品去重
        for (Long buyerId : similarBuyerList) {
            set.addAll(buyerAndProductMap.get(buyerId));
        }
        // 目标用户和相似用户商品去重
        List<Long> productList = buyerAndProductMap.get(targetBuyerId);
        if (productList == null) return;

        for (Long productId : productList) {
            if (set.contains(productId)) {
                set.remove(productId);
            }
        }

        // 计算目标用户对候选商品感兴趣程度
        Map<Long, Double> targetBuyerXp = new HashMap<>();
        for (Long productId : productList) {
            List<Long> buyerIdList = productAndBuyerMap.get(productId);
            Double xp = 0.0;
            for (Long buyerId : buyerIdList) {
                xp += buyerSimilar.get(buyerId);
            }
            targetBuyerXp.put(productId, xp);
        }
        // 对感兴趣商品排序
        List<Map.Entry<Long, Double>> list = new ArrayList<>(targetBuyerXp.entrySet()); //转换为list
        list.sort((o1, o2) -> {
            return o2.getValue().compareTo(o1.getValue());
        });
        // 得到前size个推荐商品
        int k = 0;
        for (Map.Entry<Long, Double> map : list) {
            if (k >= 10) break;
            recommendProductList.add(map.getKey());
            k++;
        }
    }

    // 寻找前3个与目标用户相似度较高的用户
    private void getSimilarBuyerList() {
        similarBuyerList = new ArrayList<>();
        List<Map.Entry<Long, Double>> list = new ArrayList<>(buyerSimilar.entrySet()); //转换为list
        list.sort((o1, o2) -> {
            return o2.getValue().compareTo(o1.getValue());
        });
        int k = 0;
        for (Map.Entry<Long, Double> map : list) {
            if (k == 3) break;
            similarBuyerList.add(map.getKey());
            k++;
        }
    }

    // 计算目标用户与其他用户相似度
    private void calBuyerSimilar(Long targetBuyerId) {
        buyerSimilar = new HashMap<>();
        for (Long buyerId : buyerProductScore.keySet()) {
            Set<Long> set = new HashSet<>();    // 存储商品id，用于去重
            if (buyerId != targetBuyerId) {
                set.addAll(buyerAndProductMap.get(targetBuyerId));
                set.addAll(buyerAndProductMap.get(buyerId));
                buyerSimilar.put(buyerId, 1.0 * buyerProductScore.get(buyerId) / set.size());
            }
        }
    }

    // 获取用户商品得分表
    private void getBuyerProductScore(Long targetBuyerId) {
        buyerProductScore = new HashMap<>();
        for (Long productId : productAndBuyerMap.keySet()) {
            List<Long> buyerIdList = productAndBuyerMap.get(productId);
            boolean isExist = false;
            for (Long buyerId : buyerIdList) {
                if (buyerId == targetBuyerId) {
                    isExist = true;
                }
            }
            // 存在目标用户
            if (isExist) {
                for (Long buyerId : buyerIdList) {
                    if (buyerId != targetBuyerId) {
                        buyerProductScore.put(buyerId, buyerProductScore.getOrDefault(buyerId, 0) + 1);
                    }
                }
            }
        }

    }

    // 用户-商品表转商品-用户表
    private void transferForm() {
        productAndBuyerMap = new HashMap<>();
        for (Long buyerId : buyerAndProductMap.keySet()) {
            List<Long> productIdList = buyerAndProductMap.get(buyerId);
            for (Long productId : productIdList) {
                List<Long> buyerIdList;
                if (productAndBuyerMap.containsKey(productId)) {
                    buyerIdList = productAndBuyerMap.get(productId);
                } else {
                    buyerIdList = new ArrayList<>();
                }
                buyerIdList.add(buyerId);
                productAndBuyerMap.put(productId, buyerIdList);
            }
        }
    }

}
