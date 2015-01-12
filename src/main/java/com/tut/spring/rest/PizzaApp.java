package com.tut.spring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:META-INF/spring-context.xml")
public class PizzaApp {

	public static void main(String[] args) {
		SpringApplication.run(PizzaApp.class, args);
	}
}
