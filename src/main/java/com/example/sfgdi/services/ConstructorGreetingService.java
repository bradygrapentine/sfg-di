package com.example.sfgdi.services;

//@Service
public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - constructor";
    }
}
