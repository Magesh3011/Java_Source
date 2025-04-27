package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DefaultApplication {

	public static void main(String[] args) {

		// By using context we can get the IOC container objects,
		// to obj in the container @Component, spring will create in the container
		ApplicationContext context;

		context = SpringApplication.run(DefaultApplication.class, args);

		Home home = context.getBean(Home.class);
		home.build();
	}

}
