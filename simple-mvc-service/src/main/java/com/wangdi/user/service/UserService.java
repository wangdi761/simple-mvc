package com.wangdi.user.service;

import com.wangdi.user.domain.User;

/**
 * Created by D on 2017/5/22.
 */
public interface UserService {

    User login(String loginname, String password);

}
