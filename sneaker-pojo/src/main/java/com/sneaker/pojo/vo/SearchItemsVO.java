package com.sneaker.pojo.vo;

import lombok.Data;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:02
 * @Description: 用于展示商品搜索列表结果的VO
 */
@Data
public class SearchItemsVO {
    private String itemId;
    private String itemName;
    private int sellCounts;
    private String imgUrl;
    private int price;
}
