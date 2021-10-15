package com.example.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"Spanish", "default"}) // default profile
@Service("i18nService")
public class I18nGSpanishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hola Mundo - Spanish";
    }
}
