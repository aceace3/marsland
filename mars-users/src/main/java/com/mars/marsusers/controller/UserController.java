package com.mars.marsusers.controller;

import com.mars.marscommons.resp.Result;
import com.mars.marscommons.utils.CommonsTestClass;
import com.mars.marscommons.utils.CommonsTestInterface;
import com.mars.marscommons.utils.ResultUtil;
import com.mars.marsusers.bean.Users;
import com.mars.marsusers.service.UserRoleService;
import com.mars.marsusers.service.UserService;
import com.mars.marsusers.utils.JWTUtil;
import com.mars.marsusers.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private CommonsTestClass commonsTestClass;

    @Autowired
    private CommonsTestInterface commonsTestInterface;

    @Autowired
    private UserService userService;

    /*测速静态方法*/
    @GetMapping("/helloWorldStatic")
    public void helloWorldStatic(){
        CommonsTestClass.helloWorldStatic();
    }

    /*测试依赖注入类方法*/
    @GetMapping("/helloWorld")
    public void helloWorld(){
        commonsTestClass.helloWorld();
    }

    /*测试接口实现方法*/
    @GetMapping("/helloWorldInterface")
    public void helloWorldInterface(){
        commonsTestInterface.helloInterface();
    }

    /**
     * 获取用户列表
     * */
    @GetMapping("/getUsers")
    public List<Users> getUsers(){return userService.getUsers();}

    /**
     * 注册用户
     * */
    @PostMapping("/register")
    public Result registerUser(@RequestBody Users user){
        String res = userService.registerUser(user);
        if (res.equals("注册成功")){
            return ResultUtil.success(res);
        }
        return ResultUtil.fail(res);
    }

    /**
     * 判断用户名是否已存在
     * */
    @GetMapping("/checkUsername")
    public Result checkUsername(@RequestParam("username") String username){
        return ResultUtil.success(userService.checkUsername(username));
    }

    /**
     * 登录
     * */
    @PostMapping("/login")
    public Result login(@RequestParam("username")String username, @RequestParam("password")String password){
        String res = userService.login(username, password);
        if (!res.equals("登录失败")){
            return ResultUtil.success(res);
        }
        return ResultUtil.fail(res);
    }

    /**
     * 通过id查询user
     * */
    @GetMapping("/getUserById")
    public Result getUserById(@RequestParam("userId")Integer userId){
        return ResultUtil.success(userService.getUserById(userId));
    }

    /**
     * 退出登录
     * */
    @GetMapping("/logoutUser")
    public Result logoutUser(@RequestParam("userId")Integer userId){
        return ResultUtil.success(userService.logoutUser(userId));
    }

}
