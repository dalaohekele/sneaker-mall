package com.sneaker.controller;

import com.sneaker.pojo.Carousel;
import com.sneaker.pojo.Category;
import com.sneaker.pojo.vo.CategoryVO;
import com.sneaker.pojo.vo.NewItemsVO;
import com.sneaker.service.CarouselService;
import com.sneaker.service.CategoryService;
import com.sneaker.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2020/2/2 10:22
 * @Description:
 */
@Api(value = "首页相关接口", tags = {"首页相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    CarouselService carouselService;

    @Autowired
    CategoryService categoryService;

    @ApiOperation(value = "轮播图", notes = "轮播图", httpMethod = "GET")
    @GetMapping("/carousel")
    public JsonResult getCarousel(){
        List<Carousel> carouselList =  carouselService.getCarousel();
        return JsonResult.ok(carouselList);
    }

    @ApiOperation(value = "一级分类", notes = "一级分类", httpMethod = "GET")
    @GetMapping("/category")
    public JsonResult getCategory(){
        List<Category> categoryList =  categoryService.getCategory();
        return JsonResult.ok(categoryList);
    }

    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public JsonResult subCat(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {

        if (rootCatId == null) {
            return JsonResult.errorMsg("分类不存在");
        }

        List<CategoryVO> list = categoryService.getCategoryVo(rootCatId);
        return JsonResult.ok(list);
    }

    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据", notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public JsonResult sixNewItems(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {

        if (rootCatId == null) {
            return JsonResult.errorMsg("分类不存在");
        }

        List<NewItemsVO> list = categoryService.getSixNewItemsLazy(rootCatId);
        return JsonResult.ok(list);
    }

}
