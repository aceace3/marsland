package com.mars.marscommons.utils;

import org.springframework.stereotype.Component;

@Component
public class CTIimpl implements CommonsTestInterface{
    @Override
    public void helloInterface() {
        System.out.println("hello interface");
    }
}
