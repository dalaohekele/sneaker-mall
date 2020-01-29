package com.sneaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: le
 * @Date: 2020/1/2 21:52
 * @Description:
 */
@RestController
public class HomeController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello world";
    }
}
