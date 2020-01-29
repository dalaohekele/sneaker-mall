package com.sneaker.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther: le
 * @Date: 2020/1/12 14:22
 * @Description:
 */
@Data
public class ItemsImg {
    /**
     * 图片主键
     */
    @Id
    private String id;

    /**
     * 商品外键id 商品外键id
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * 图片地址 图片地址
     */
    private String url;

    /**
     * 顺序 图片顺序，从小到大
     */
    private Integer sort;

    /**
     * 是否主图 是否主图，1：是，0：否
     */
    @Column(name = "is_main")
    private Integer isMain;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;
}
