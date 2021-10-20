package com.mars.marscommons.utils;

import org.springframework.stereotype.Component;

@Component
public class CommonsTestClass {

    public void helloWorld(){
        System.out.println("Hello World.");
    }

    public static void helloWorldStatic(){
        System.out.println("Hello World.(static)");
    }

}
