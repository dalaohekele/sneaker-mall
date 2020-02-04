package com.sneaker.enums;

/**
 * @Auther: le
 * @Date: 2020/2/4 18:36
 * @Description:
 */
public enum PayMethod {
    WEIXIN(1, "微信"),
    ALIPAY(2, "支付宝");

    public final Integer type;
    public final String value;

    PayMethod(Integer type, String value){
        this.type = type;
        this.value = value;
    }
}
