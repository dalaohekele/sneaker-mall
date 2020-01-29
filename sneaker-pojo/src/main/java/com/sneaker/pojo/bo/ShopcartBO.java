package com.sneaker.pojo.bo;

import lombok.Data;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:12
 * @Description:
 */
@Data
public class ShopcartBO {
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private Integer buyCounts;
    private String priceDiscount;
    private String priceNormal;
}
