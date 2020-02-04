package com.sneaker.mapper;

import com.sneaker.pojo.vo.CategoryVO;
import com.sneaker.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:29
 * @Description:
 */
public interface CategoryMapperCustom {
    public List<CategoryVO> getSubCatList(Integer rootCatId);

    public List<NewItemsVO> getSixNewItemsLazy(@Param("paramsMap") Map<String, Object> map);

}
