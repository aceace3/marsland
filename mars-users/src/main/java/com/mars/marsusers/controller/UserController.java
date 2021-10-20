package com.mars.marsusers.controller;

import com.mars.marscommons.utils.CommonsTestClass;
import com.mars.marscommons.utils.CommonsTestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private CommonsTestClass commonsTestClass;

    @Autowired
    private CommonsTestInterface commonsTestInterface;

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

}
