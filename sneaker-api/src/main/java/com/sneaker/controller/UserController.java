package com.sneaker.controller;

import com.sneaker.pojo.Users;
import com.sneaker.pojo.bo.UserBO;
import com.sneaker.pojo.bo.center.CenterUserBO;
import com.sneaker.service.UserService;
import com.sneaker.utils.CookieUtils;
import com.sneaker.utils.JsonResult;
import com.sneaker.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public JsonResult regist(@RequestBody UserBO userBO) {
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

    @ApiOperation(value = "用户信息展示", notes = "用户信息展示", httpMethod = "POST")
    @PostMapping("/info")
    public JsonResult getUserInfo(@RequestParam String userId) {
        Users user = userService.getUserById(userId);
        return JsonResult.ok(user);
    }

    @ApiOperation(value = "修改用户信息",notes = "修改用户信息",httpMethod = "POST")
    @PostMapping("/info_update")
    public JsonResult updateUserInfo(@RequestParam String userId,@RequestBody CenterUserBO centerUserBO){
        Users user = userService.updateUserInfo(userId,centerUserBO);
        return JsonResult.ok(user);
    }

    @ApiOperation(value = "用户登陆", notes = "用户登陆", httpMethod = "POST")
    @PostMapping("/login")
    public JsonResult regist(@RequestBody UserBO userBO,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userName = userBO.getUsername();
        String password = userBO.getPassword();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(userName) ||
                StringUtils.isBlank(password)) {
            return JsonResult.errorMsg("用户名或密码不能为空");
        }
        Users user = userService.queryUserLogin(userName,password);
        if (user==null){
            return JsonResult.errorMsg("用户名或密码错误");
        }
        user = setNullProperty(user);

        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(user), true);

        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据

        return JsonResult.ok(user);
    }


    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }

    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public JsonResult logout(@RequestParam String userId,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        // 清除用户的相关信息的cookie
        CookieUtils.deleteCookie(request, response, "user");

        // TODO 用户退出登录，需要清空购物车
        // TODO 分布式会话中需要清除用户数据

        return JsonResult.ok();
    }

    @ApiOperation(value = "修改头像", notes = "修改头像", httpMethod = "POST")
    @PostMapping("/update_face_image")
    public JsonResult updateFaceImage(@RequestParam String userId,@ApiParam(name = "file", value = "用户头像", required = true)
            MultipartFile file,HttpServletRequest request, HttpServletResponse response){

        //TODO 图片上传逻辑
        return JsonResult.ok();

    }
}
