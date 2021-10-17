package com.example.sfgdi.services;

//@Service
public class PropertyInjectedGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World - prop";
    }
}
