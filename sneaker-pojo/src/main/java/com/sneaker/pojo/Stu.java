package com.sneaker.pojo;

import lombok.Data;

import javax.persistence.Id;

/**
 * @Auther: le
 * @Date: 2020/1/12 14:17
 * @Description:
 */
@Data
public class Stu {
    @Id
    private Integer id;

    private String name;

    private Integer age;
}
