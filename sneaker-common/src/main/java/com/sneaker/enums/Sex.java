package com.sneaker.enums;

/**
 * @Auther: le
 * @Date: 2020/1/12 10:21
 * @Description:
 */
public enum Sex {
    woman(0, "女"),
    man(1, "男"),
    secret(2, "保密");

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
