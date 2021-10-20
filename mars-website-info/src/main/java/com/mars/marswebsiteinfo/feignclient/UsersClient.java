package com.mars.marswebsiteinfo.feignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "mars-users")
public interface UsersClient {

    @GetMapping("/helloWorld")
    public void helloWorld();

}
