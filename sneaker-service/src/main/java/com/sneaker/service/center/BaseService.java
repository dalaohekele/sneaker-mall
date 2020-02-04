package com.sneaker.service.center;

import com.github.pagehelper.PageInfo;
import com.sneaker.utils.PagedGridResult;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2020/2/3 18:44
 * @Description:
 */
public class BaseService {
    public PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return grid;
    }
}
