package com.wangdi.user.service.impl;

import com.wangdi.user.domain.User;
import com.wangdi.user.mapper.UserMapper;
import com.wangdi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by D on 2017/5/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String loginname, String password) {
        return userMapper.findWithLoginnameAndPassword(loginname, password);
    }

}
