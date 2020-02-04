package com.sneaker.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:00
 * @Description: 用户中心，我的订单列表嵌套商品VO
 */
@Data
public class MySubOrderItemVO {
    private String itemId;
    private String itemImg;
    private String itemName;
    private String itemSpecName;
    private Integer buyCounts;
    private Integer price;
}
