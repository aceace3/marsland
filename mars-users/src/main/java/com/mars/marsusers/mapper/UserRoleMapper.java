package com.mars.marsusers.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper {

    int addUserRole(@Param("userId")Integer userId, @Param("roleId")Integer roleId);

}
