package com.mars.marsusers.mapper;

import com.mars.marsusers.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<Users> getUsers();

    /**
     * 注册用户
     * */
    int registerUser(Users user);

    Users getUserByUsername(@Param("username") String username);

    Users getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    Users getUserById(@Param("userId")Integer userId);
}
