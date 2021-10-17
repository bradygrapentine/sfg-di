package com.example.sfgdi.services;

//@Profile("English")
//@Service("i18nService")
public class I18nGEnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - English";
    }
}
