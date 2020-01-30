package com.sneaker.controller;

import com.sneaker.pojo.bo.UserBO;
import com.sneaker.server.UserService;
import com.sneaker.utils.JsonResult;
import com.sneaker.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: le
 * @Date: 2020/1/30 18:31
 * @Description:
 */
@Api(value = "用户相关", tags = {"用户的相关接口"})
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/regist")
    public JsonResult regist(@RequestBody UserBO userBO,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        String userName = userBO.getUsername();

        if (userService.isUserNameExit(userName)){
            return JsonResult.errorMsg("已存在用户名");
        }

        String passWord = userBO.getPassword();
        String confirmPassWord = userBO.getConfirmPassword();

        if(!passWord.equals(confirmPassWord)){
            return JsonResult.errorMsg("两次输入密码不一致");
        }

        userService.addUser(userBO);
        return JsonResult.ok();
    }



}
