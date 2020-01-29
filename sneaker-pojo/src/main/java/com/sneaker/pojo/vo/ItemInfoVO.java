package com.sneaker.pojo.vo;

import com.sneaker.pojo.Items;
import com.sneaker.pojo.ItemsImg;
import com.sneaker.pojo.ItemsParam;
import com.sneaker.pojo.ItemsSpec;
import lombok.Data;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2020/1/20 09:57
 * @Description: 商品详情VO
 */
@Data
public class ItemInfoVO {
    private Items item;
    private List<ItemsImg> itemImgList;
    private List<ItemsSpec> itemSpecList;
    private ItemsParam itemParams;
}
