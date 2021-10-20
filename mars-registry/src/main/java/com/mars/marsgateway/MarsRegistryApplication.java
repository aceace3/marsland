package com.mars.marsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MarsRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarsRegistryApplication.class, args);
    }

}
