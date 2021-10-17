package com.example.sfgdi.services;


//@Primary
//@Service
public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World - from the primary bean";
    }
}
