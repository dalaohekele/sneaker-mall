package com.sneaker.service.impl;

import com.sneaker.enums.YesOrNo;
import com.sneaker.mapper.UserAddressMapper;
import com.sneaker.pojo.UserAddress;
import com.sneaker.pojo.bo.AddressBO;
import com.sneaker.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: le
 * @Date: 2020/2/2 15:33
 * @Description:
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    UserAddressMapper addressMapper;

    @Override
    public List<UserAddress> findAddressByUserId(String userId) {
        UserAddress address = new UserAddress();
        address.setUserId(userId);
        return addressMapper.select(address);
    }

    @Override
    public UserAddress findAddressById(String id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addUserAddress(AddressBO addressBO) {
        // 1. 判断当前用户是否存在地址，如果没有，则新增为‘默认地址’
        Integer isDefault = 0;
        List<UserAddress> userAddresses = findAddressByUserId(addressBO.getUserId());
        if (userAddresses.isEmpty()){
            isDefault=1;
        }
        UserAddress address = new UserAddress();
        BeanUtils.copyProperties(addressBO,address);

        address.setId(UUID.randomUUID().toString());
        address.setIsDefault(isDefault);
        address.setCreatedTime(new Date());
        address.setUpdatedTime(new Date());

        addressMapper.insert(address);

    }

    @Override
    public void updateAddress(AddressBO addressBO) {
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(addressBO,userAddress);
        userAddress.setId(addressBO.getAddressId());
        userAddress.setUpdatedTime(new Date());
        addressMapper.updateByPrimaryKeySelective(userAddress);
    }

    @Override
    public void setDefaultAddress(String userId, String addressId) {
        //将之前的默认值设置为非默认值
        Example addressExample = new Example(UserAddress.class);
        Example.Criteria addressCriteria = addressExample.createCriteria();
        addressCriteria.andEqualTo("isDefault",YesOrNo.YES.type);
        addressCriteria.andEqualTo("userId",userId);
        UserAddress userAddress  = addressMapper.selectOneByExample(addressExample);
        userAddress.setIsDefault(YesOrNo.NO.type);
        userAddress.setUpdatedTime(new Date());
        addressMapper.updateByPrimaryKeySelective(userAddress);
        //更新默认地址
        UserAddress newDefaultuAddress = new UserAddress();
        newDefaultuAddress.setId(addressId);
        newDefaultuAddress.setUpdatedTime(new Date());
        newDefaultuAddress.setIsDefault(YesOrNo.YES.type);
        addressMapper.updateByPrimaryKeySelective(newDefaultuAddress);
    }

    @Override
    public void delUserAddress(String userId, String addressId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(addressId);
        userAddress.setUserId(userId);

        addressMapper.delete(userAddress);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserAddress queryUserAddres(String userId, String addressId) {

        UserAddress singleAddress = new UserAddress();
        singleAddress.setId(addressId);
        singleAddress.setUserId(userId);

        return addressMapper.selectOne(singleAddress);
    }
}
