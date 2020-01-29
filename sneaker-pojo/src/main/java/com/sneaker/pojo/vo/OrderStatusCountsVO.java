package com.sneaker.pojo.vo;

import lombok.Data;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:01
 * @Description: 订单状态概览数量VO
 */
@Data
public class OrderStatusCountsVO {
    private Integer waitPayCounts;
    private Integer waitDeliverCounts;
    private Integer waitReceiveCounts;
    private Integer waitCommentCounts;
}
