package com.microservice.QuizAppV1_0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.microservice.QuizAppV1_0.feign")
public class QuizAppV10Application {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppV10Application.class, args);
	}

}
