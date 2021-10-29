package com.mars.marsusers.service;

import com.mars.marsusers.mapper.UserRoleMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    int addUserRole(Integer userId, Integer roleId){
        return userRoleMapper.addUserRole(userId, roleId);
    }

}
