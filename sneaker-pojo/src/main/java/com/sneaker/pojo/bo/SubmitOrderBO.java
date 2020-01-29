package com.sneaker.pojo.bo;

import lombok.Data;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:11
 * @Description: 用于创建订单的BO对象
 */
@Data
public class SubmitOrderBO {
    private String userId;
    private String itemSpecIds;
    private String addressId;
    private Integer payMethod;
    private String leftMsg;
}
