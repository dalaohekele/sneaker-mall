package com.sneaker.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: le
 * @Date: 2020/1/20 09:59
 * @Description:
 */
@Data
public class MyCommentVO {
    private String commentId;
    private String content;
    private Date createdTime;
    private String itemId;
    private String itemName;
    private String specName;
    private String itemImg;
}
