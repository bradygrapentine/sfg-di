package com.example.sfgdi.config;

import com.example.sfgdi.datasource.FakeDataSource;
import com.example.sfgdi.repositories.EnglishGreetingRepository;
import com.example.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.example.sfgdi.services.*;
import org.example.pets.PetService;
import org.example.pets.PetServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

//@PropertySource("classpath:datasource.properties")
@Configuration
public class GreetingServiceConfig {

    @Bean
//    FakeDataSource fakeDataSource(@Value("${bg.username}") String username, @Value("${bg.password}") String password, @Value("${bg.jdbcUrl}") String jdbcUrl)
    FakeDataSource fakeDataSource(BgConfig bgConfig)  {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setPassword(bgConfig.getPassword());
        fakeDataSource.setJdbcUrl(bgConfig.getJdbcUrl());
        fakeDataSource.setUsername(bgConfig.getUsername());
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

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
