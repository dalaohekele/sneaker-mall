package com.sneaker.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2020/1/20 09:42
 * @Description: 二级分类VO
 */
@Data
public class CategoryVO {
    private Integer id;
    private String name;
    private String type;
    private Integer fatherId;

    // 三级分类vo list
    private List<SubCategoryVO> subCatList;
}
