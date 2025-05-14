package com.microservice.QuizAppV1_0.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.QuizAppV1_0.feign.QuizFeign;
import com.microservice.QuizAppV1_0.model.QuizWrapper;
//import com.app.quizapp.model.QuizWrapper;
//import com.app.quizapp.model.RequestAnswer;
import com.microservice.QuizAppV1_0.service.QuizService;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Path;

@RestController
public class QuizController {

	@Autowired
	private QuizFeign quizFeign;
	
	@Autowired
	private QuizService quizService;

@PostMapping("/delete/{id}")
public ResponseEntity<Integer> deleteByID(@PathVariable int id){
	
	return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
}

@PostMapping("/create")
public ResponseEntity<List<QuizWrapper>> createQuiz(@RequestParam String category, @RequestParam String name){
	ResponseEntity<List<Integer>> quizQuestions=quizFeign.getAllQuestionNum(category);
	
	System.out.println(quizQuestions.getStatusCode());
	
	List<Integer> newQuizListInt=quizQuestions.getBody();
	quizService.createQuiz(newQuizListInt,name);
	
	List<QuizWrapper> quizWrappers=quizFeign.getquizWrapperObj(newQuizListInt).getBody();
	return new ResponseEntity<>(quizWrappers,HttpStatus.CREATED);
}



}
