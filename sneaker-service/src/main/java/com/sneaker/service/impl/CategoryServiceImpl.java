package com.sneaker.service.impl;

import com.sneaker.mapper.CategoryMapper;
import com.sneaker.mapper.CategoryMapperCustom;
import com.sneaker.pojo.Category;
import com.sneaker.pojo.vo.CategoryVO;
import com.sneaker.pojo.vo.NewItemsVO;
import com.sneaker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: le
 * @Date: 2020/2/2 11:04
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryMapperCustom categoryMapperCustom;

    @Override
    public List<Category> getCategory() {
        Example categoryExample = new Example(Category.class);
        Example.Criteria userCriteria = categoryExample.createCriteria();
        userCriteria.andEqualTo("type",1);

        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        return categoryList;
    }

    @Override
    public List<CategoryVO> getCategoryVo(Integer rootCatId) {
        List<CategoryVO> categoryVOS = categoryMapperCustom.getSubCatList(rootCatId);
        return categoryVOS;
    }

    @Override
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId) {
        Map<String, Object> map = new HashMap<>();
        map.put("rootCatId", rootCatId);

        return categoryMapperCustom.getSixNewItemsLazy(map);
    }
}
