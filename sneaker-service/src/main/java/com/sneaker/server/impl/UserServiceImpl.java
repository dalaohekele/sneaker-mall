package com.sneaker.server.impl;

import com.sneaker.mapper.UsersMapper;
import com.sneaker.pojo.Users;
import com.sneaker.pojo.bo.UserBO;
import com.sneaker.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Auther: le
 * @Date: 2020/1/20 10:49
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UsersMapper usersMapper;

}
