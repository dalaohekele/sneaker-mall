package com.sneaker.service;

import com.sneaker.pojo.UserAddress;
import com.sneaker.pojo.bo.AddressBO;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2020/2/2 15:32
 * @Description:
 */
public interface AddressService {
    /**
     * 通过Id查找地址
     * @param userId
     * @return
     */
    public List<UserAddress> findAddressByUserId(String userId);

    /**
     * 通过addressId查询
     * @param id
     * @return
     */
    public UserAddress findAddressById(String id);
    /**
     * 新增用户地址
     * @param addressBO
     */
    public void addUserAddress(AddressBO addressBO);

    /**
     * 修改地址
     * @param addressBO
     */
    public void updateAddress(AddressBO addressBO);

    /**
     * 设置默认地址
     * @param userId
     * @param addressId
     */
    public void setDefaultAddress(String userId,String addressId);
    /**
     * 删除地址
     * @param userId
     * @param addressId
     */
    public void delUserAddress(String userId,String addressId);

    /**
     * 根据用户id和地址id，查询具体的用户地址对象信息
     * @param userId
     * @param addressId
     * @return
     */
    public UserAddress queryUserAddres(String userId, String addressId);
}
