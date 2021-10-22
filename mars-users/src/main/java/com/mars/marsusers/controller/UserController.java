package com.mars.marsusers.controller;

import com.mars.marscommons.utils.CommonsTestClass;
import com.mars.marscommons.utils.CommonsTestInterface;
import com.mars.marsusers.bean.Users;
import com.mars.marsusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
