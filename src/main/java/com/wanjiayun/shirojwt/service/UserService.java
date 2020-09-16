package com.wanjiayun.shirojwt.service;

import com.wanjiayun.shirojwt.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    //获取用户信息,包括角色和权限
    User getUserDetailInfoByUserName(String username);
}
