package com.example.sfgdi.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String sayHello() {
        System.out.println("I'm alive!");
        return "Hi Folks!";
    }
}
