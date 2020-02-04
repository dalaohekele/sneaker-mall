package com.sneaker.controller;

import com.sneaker.pojo.Orders;
import com.sneaker.service.MyOrdersService;
import com.sneaker.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Auther: le
 * @Date: 2020/2/3 16:57
 * @Description:
 */
@Controller
public class BaseController {
    public static final String FOODIE_SHOPCART = "shopcart";
    // 支付中心的调用地址
    String paymentUrl = "http://www.paymentUrl.com";

    //回调通知的url
    String payReturnUrl = "http://www.payReturnUrl.com";


    public static final Integer COMMON_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 20;

    @Autowired
    public MyOrdersService myOrdersService;

    /**
     * 用于验证用户和订单是否有关联关系，避免非法用户调用
     * @return
     */
    public JsonResult checkUserOrder(String userId, String orderId) {
        Orders order = myOrdersService.queryMyOrder(userId, orderId);
        if (order == null) {
            return JsonResult.errorMsg("订单不存在！");
        }
        return JsonResult.ok(order);
    }
}
