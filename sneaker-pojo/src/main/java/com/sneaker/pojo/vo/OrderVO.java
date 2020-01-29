package com.sneaker.pojo.vo;

import lombok.Data;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:01
 * @Description:
 */
@Data
public class OrderVO {
    private String orderId;
    private MerchantOrdersVO merchantOrdersVO;
}
