package com.sneaker.mapper;

import com.sneaker.my.mapper.MyMapper;
import com.sneaker.pojo.ItemsComments;
import com.sneaker.pojo.vo.MyCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:28
 * @Description:
 */
public interface ItemsCommentsMapperCustom extends MyMapper<ItemsComments> {
    public void saveComments(Map<String, Object> map);

    public List<MyCommentVO> queryMyComments(@Param("paramsMap") Map<String, Object> map);

}
