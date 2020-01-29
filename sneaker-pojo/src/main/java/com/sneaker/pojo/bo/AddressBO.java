package com.sneaker.pojo.bo;

import lombok.Data;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:12
 * @Description:
 */
@Data
public class AddressBO {
    private String addressId;
    private String userId;
    private String receiver;
    private String mobile;
    private String province;
    private String city;
    private String district;
    private String detail;
}
