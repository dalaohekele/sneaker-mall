package com.sneaker.pojo.vo;

import lombok.Data;

/**
 * @Auther: le
 * @Date: 2020/1/20 09:44
 * @Description: 用于展示商品评价数量的vo
 */
@Data
public class CommentLevelCountsVO {
    public Integer totalCounts;
    public Integer goodCounts;
    public Integer normalCounts;
    public Integer badCounts;
}
