package com.mars.marsusers.service;

import com.mars.marsusers.bean.Users;
import com.mars.marsusers.bean.enums.UserRoleEnum;
import com.mars.marsusers.mapper.UserMapper;
import com.mars.marsusers.mapper.UserRoleMapper;

import com.mars.marsusers.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    public List<Users> getUsers(){
        return userMapper.getUsers();
    }

    /**
     * 查询当前用户名是否已使用
     * */
    public String checkUsername(String username){
        Users hasUser = userMapper.getUserByUsername(username);
        if (hasUser != null){
            return "用户名已存在";
        }
        return "用户名可以使用";
    }

    /**
     * 注册用户
     * */
    public String registerUser(Users user){
        String checkResult = checkUsername(user.getUsername());
        if (checkResult.equals("用户名已存在")){
            return checkResult;
        }

        try {
            //注册时间
            Date date = new Date();
            Timestamp registerTime = new Timestamp(date.getTime());
            user.setRegTime(registerTime);
            //向users表插入数据
            userMapper.registerUser(user);
            //获取当前注册用户id
            Integer userId = user.getId();
            //向中间表插入数据,默认普通用户
            userRoleMapper.addUserRole(userId, UserRoleEnum.USER_ROLE_USERS);
        }catch (Exception e){
            return e.getMessage();
        }
        return "注册成功";
    }

    /**
     * 登录
     * */
    public String login(String username, String password){
        Users user = userMapper.getUserByUsernameAndPassword(username, password);
        if (user == null){
            return "登陆失败";
        }
        String token = JWTUtil.genJWT(user.getId().toString());
        return token;
    }
}
