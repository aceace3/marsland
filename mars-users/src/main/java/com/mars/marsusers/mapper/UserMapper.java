package com.mars.marsusers.mapper;

import com.mars.marsusers.bean.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<Users> getUsers();

}
