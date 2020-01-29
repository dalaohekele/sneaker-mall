package com.sneaker.pojo.bo.center;

import lombok.Data;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:12
 * @Description:
 */
@Data
public class OrderItemsCommentBO {
    private String commentId;
    private String itemId;
    private String itemNamse;
    private String itemSpecId;
    private String itemSpecName;
    private Integer commentLevel;
    private String content;
}
