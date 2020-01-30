package com.sneaker.server;


import com.sneaker.pojo.Users;
import com.sneaker.pojo.bo.UserBO;

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

}
