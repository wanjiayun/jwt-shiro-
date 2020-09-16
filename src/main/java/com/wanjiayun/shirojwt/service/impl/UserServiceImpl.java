package com.wanjiayun.shirojwt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wanjiayun.shirojwt.entity.User;
import com.wanjiayun.shirojwt.mapper.UserMapper;
import com.wanjiayun.shirojwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    @Override
    public User getUserDetailInfoByUserName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        return userMapper.selectOne(wrapper);
    }
}
