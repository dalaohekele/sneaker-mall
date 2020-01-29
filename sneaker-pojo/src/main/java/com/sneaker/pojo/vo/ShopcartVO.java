package com.sneaker.pojo.vo;

import lombok.Data;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:02
 * @Description:
 */
@Data
public class ShopcartVO {
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private String priceDiscount;
    private String priceNormal;
}
