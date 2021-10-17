package com.example.sfgdi.services;

import com.example.sfgdi.repositories.EnglishGreetingRepository;

//@Profile("English")
//@Service("i18nService")
public class I18nGEnglishGreetingService implements GreetingService {

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nGEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello World - English";
    }
}
