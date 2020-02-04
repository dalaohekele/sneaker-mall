package com.sneaker.service;

import com.sneaker.pojo.OrderItems;
import com.sneaker.pojo.bo.center.OrderItemsCommentBO;
import com.sneaker.utils.PagedGridResult;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2020/2/3 18:38
 * @Description:
 */
public interface MyCommentsService {

    /**
     * 根据订单id查询关联的商品
     * @param orderId
     * @return
     */
    public List<OrderItems> queryPendingComment(String orderId);

    /**
     * 保存用户的评论
     * @param orderId
     * @param userId
     * @param commentList
     */
    public void saveComments(String orderId, String userId, List<OrderItemsCommentBO> commentList);


    /**
     * 我的评价查询 分页
     * @param userId
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult queryMyComments(String userId, Integer page, Integer pageSize);

}
