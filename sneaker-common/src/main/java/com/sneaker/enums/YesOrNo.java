package com.sneaker.enums;

/**
 * @Auther: le
 * @Date: 2020/1/12 10:22
 * @Description:
 */
public enum YesOrNo {
    NO(0, "否"),
    YES(1, "是");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
