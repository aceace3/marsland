package com.mars.marswebsiteinfo.controller;

import com.mars.marswebsiteinfo.feignclient.UsersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSiteInfoController {

    @Autowired
    private UsersClient usersClient;

    /*测试feign调用其他项目方法*/
    @GetMapping("/helloWorld")
    public void helloWorld(){
        System.out.println("进来了---------------------------");
        usersClient.helloWorld();
    }

}
