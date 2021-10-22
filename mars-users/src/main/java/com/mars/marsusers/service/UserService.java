package com.mars.marsusers.service;

import com.mars.marsusers.bean.Users;
import com.mars.marsusers.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<Users> getUsers(){
        return userMapper.getUsers();
    }
}
