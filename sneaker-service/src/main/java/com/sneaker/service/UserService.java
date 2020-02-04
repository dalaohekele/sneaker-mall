package com.sneaker.service;


import com.sneaker.pojo.Users;
import com.sneaker.pojo.bo.UserBO;
import com.sneaker.pojo.bo.center.CenterUserBO;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:48
 * @Description:
 */
public interface UserService {
    /**
     * 是否已存在用户名
     * @param userName
     * @return
     */
    public boolean isUserNameExit(String userName);

    /**
     * 添加用户
     * @param userBO
     * @return
     */
    public Users addUser(UserBO userBO);

    /**
     * 登陆
     * @param userName
     * @param passWord
     * @return
     */
    public Users queryUserLogin(String userName,String passWord);

    /**
     * 通过Id查询用户信息
     * @param userId
     * @return
     */
    public Users getUserById(String userId);

    /**
     * 修改用户信息
     * @param userId,centerUserBO
     * @return
     */
    public Users updateUserInfo(String userId,CenterUserBO centerUserBO);

}
