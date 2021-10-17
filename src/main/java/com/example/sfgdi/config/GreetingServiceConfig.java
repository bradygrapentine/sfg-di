package com.example.sfgdi.config;

import com.example.sfgdi.repositories.EnglishGreetingRepository;
import com.example.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.example.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean // annotates ConstructorGreetingService as spring component
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean // annotates ConstructorGreetingService as spring component
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }

    @Bean // annotates ConstructorGreetingService as spring component
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Profile("English")
    @Bean
    I18nGEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nGEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"Spanish", "default"}) // default profile
    @Bean("i18nService")
    I18nGSpanishGreetingService i18nGSpanishGreetingService() {
        return new I18nGSpanishGreetingService();
    }
}
