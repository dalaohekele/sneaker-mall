package com.sneaker.service;

import com.sneaker.pojo.Carousel;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2020/2/2 10:28
 * @Description:
 */
public interface CarouselService {
    /**
     * 获取展示的轮播图
     * @return
     */
    public List<Carousel> getCarousel();
}
