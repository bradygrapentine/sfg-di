package com.example.sfgdi.services;

//@Service
public class SetterInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - setter";
    }
}
