package com.sneaker.controller;

import com.sneaker.enums.YesOrNo;
import com.sneaker.pojo.UserAddress;
import com.sneaker.pojo.bo.AddressBO;
import com.sneaker.service.AddressService;
import com.sneaker.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2020/2/2 12:37
 * @Description:
 */
@Api(value = "地址相关接口", tags = {"地址相关接口"})
@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @ApiOperation(value = "获取用户地址", notes = "获取用户地址", httpMethod = "POST")
    @PostMapping("/list")
    public JsonResult listAddress(@RequestParam String userId){
        List<UserAddress> addressList = addressService.findAddressByUserId(userId);
        return JsonResult.ok(addressList);

    }

    @ApiOperation(value = "用户新增地址", notes = "用户新增地址", httpMethod = "POST")
    @PostMapping("/add")
    public JsonResult addAddress(@RequestBody AddressBO addressBO){
        addressService.addUserAddress(addressBO);
        return JsonResult.ok();
    }

    @ApiOperation(value = "更新地址", notes = "更新地址", httpMethod = "POST")
    @PostMapping("/update")
    public JsonResult updateAddress(@RequestBody AddressBO addressBO){
        addressService.updateAddress(addressBO);
        return JsonResult.ok();
    }

    @ApiOperation(value = "设置默认地址", notes = "设置默认地址", httpMethod = "POST")
    @PostMapping("/set_default")
    public JsonResult setDefaultAddress(@RequestParam String userId,@RequestParam String addressId){
        UserAddress address = addressService.findAddressById(addressId);
        if (YesOrNo.YES.type.equals(address.getIsDefault())){
            return JsonResult.errorMsg("当前地址是默认地址");
        }
        addressService.setDefaultAddress(userId,addressId);
        return JsonResult.ok();
    }


    @ApiOperation(value = "删除地址",notes = "用户新增地址", httpMethod = "POST")
    @PostMapping("/delete")
    public JsonResult delAddress(@RequestParam String userId,@RequestParam String addressId){
        addressService.delUserAddress(userId,addressId);
        return JsonResult.ok();
    }

}
