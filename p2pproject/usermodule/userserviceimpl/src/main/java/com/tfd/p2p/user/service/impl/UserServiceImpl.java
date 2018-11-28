package com.tfd.p2p.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tfd.p2p.user.mapper.UserMapper;
import com.tfd.p2p.user.pojo.User;
import com.tfd.p2p.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
