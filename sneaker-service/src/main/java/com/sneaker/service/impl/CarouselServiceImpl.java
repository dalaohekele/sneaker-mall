package com.sneaker.service.impl;

import com.sneaker.mapper.CarouselMapper;
import com.sneaker.pojo.Carousel;
import com.sneaker.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2020/2/2 10:30
 * @Description:
 */
@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    CarouselMapper carouseMapper;


    @Override
    public List<Carousel> getCarousel() {
        Example carouselExample = new Example(Carousel.class);
        Example.Criteria userCriteria = carouselExample.createCriteria();
        userCriteria.andEqualTo("isShow",1);

        List<Carousel> carouselList = carouseMapper.selectByExample(carouselExample);
        return carouselList;
    }




}
