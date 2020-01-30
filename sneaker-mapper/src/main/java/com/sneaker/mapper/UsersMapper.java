package com.sneaker.mapper;

import com.sneaker.my.mapper.MyMapper;
import com.sneaker.pojo.Users;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:22
 * @Description:
 */
public interface UsersMapper extends MyMapper<Users> {
    public Users selectUserByName(String userName);

    public void addUsers(Users users);
}
