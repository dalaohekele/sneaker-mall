package com.sneaker.service;

import com.sneaker.pojo.Category;
import com.sneaker.pojo.vo.CategoryVO;
import com.sneaker.pojo.vo.NewItemsVO;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2020/2/2 11:03
 * @Description:
 */
public interface CategoryService {
    /**
     * 获取一级分类
     * @return
     */
    public List<Category> getCategory();

    /**
     * 获取商品子分类
     * @param rootCatId
     * @return
     */
    public List<CategoryVO> getCategoryVo(Integer rootCatId);

    /**
     * 查询首页每个一级分类下的6条最新商品数据
     * @param rootCatId
     * @return
     */
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);
}
