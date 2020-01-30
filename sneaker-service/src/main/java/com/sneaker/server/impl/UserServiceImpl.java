package com.sneaker.server.impl;

import com.sneaker.enums.Sex;
import com.sneaker.mapper.UsersMapper;
import com.sneaker.pojo.Users;
import com.sneaker.pojo.bo.UserBO;
import com.sneaker.server.UserService;
import com.sneaker.utils.DateUtil;
import com.sneaker.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
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

    private static final String USER_FACE = "image/default.png";

    @Override
    public boolean isUserNameExit(String userName) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username",userName);

        Users result = usersMapper.selectOneByExample(userExample);

        return result != null;
    }

    @Override
    public Users addUser(UserBO userBO) {
        Users users = new Users();
        String id = UUID.randomUUID().toString();
        users.setId(id);
        // 默认头像
        users.setFace(USER_FACE);
        try {
            users.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        users.setSex(Sex.secret.type);
        users.setCreatedTime(DateUtil.getCurrentDateTime());
        users.setUpdatedTime(DateUtil.getCurrentDateTime());

        usersMapper.insert(users);
        return users;
    }
}
