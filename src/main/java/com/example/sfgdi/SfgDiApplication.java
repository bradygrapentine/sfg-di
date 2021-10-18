package com.example.sfgdi;

import com.example.sfgdi.config.BgConfig;
import com.example.sfgdi.config.ConstructorConfig;
import com.example.sfgdi.controllers.*;
import com.example.sfgdi.datasource.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@ComponentScan(basePackages = {"org.example.pets", "com.example.sfgdi"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayGreeting());

		MyController myController = (MyController) ctx.getBean("myController"); // bean == component
		// spring provides construction of new controller, framework does the heavy lifting

		System.out.println("------------Primary Bean");

		System.out.println(myController.sayHello());

		System.out.println("------------Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------------Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------------Constructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcUrl());

		System.out.println("----------- Config Props Bean");
		BgConfig bgConfig = ctx.getBean(BgConfig.class);
		System.out.println(bgConfig.getUsername());
		System.out.println(bgConfig.getPassword());
		System.out.println(bgConfig.getJdbcUrl());

		System.out.println("----Constructor Binding");

		ConstructorConfig constructorConfig = ctx.getBean(ConstructorConfig.class);
		System.out.println(constructorConfig.getUsername());
		System.out.println(constructorConfig.getPassword());
		System.out.println(constructorConfig.getJdbcUrl());
	}

}
