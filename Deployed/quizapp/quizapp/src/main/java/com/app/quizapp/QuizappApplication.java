package com.app.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*") // Allow all origins, or specify "http://localhost"
@SpringBootApplication
public class QuizappApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizappApplication.class, args);
	}

}
