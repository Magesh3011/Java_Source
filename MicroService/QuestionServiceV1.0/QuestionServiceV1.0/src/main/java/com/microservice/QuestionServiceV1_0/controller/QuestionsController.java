package com.microservice.QuestionServiceV1_0.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.QuestionServiceV1_0.model.Questions;
import com.microservice.QuestionServiceV1_0.model.QuizWrapper;
import com.microservice.QuestionServiceV1_0.service.QuestionsService;
import com.netflix.discovery.converters.Auto;

@RestController
public class QuestionsController {

	@Autowired
	private QuestionsService questionsService;
	
	@Autowired
	private Environment environment;
	
	
	
	@PostMapping("/addQuestion")
	public ResponseEntity<Void> createQuestion(@RequestBody Questions questions) {
		return questionsService.createQuestion(questions);
	}

	@DeleteMapping("/deleteQuestion/{id}")
	public ResponseEntity<Void> deleteQusById(@PathVariable int id) {

		System.out.println("Name : " + id);
		return questionsService.deleteByID(id);
	}
	
	@PostMapping("/questions")
	public ResponseEntity<List<Integer>> getAllQuestionNum(@RequestParam String category) {

		return questionsService.getAllQuestionsNumFromDB(category);
	}
	
	@PostMapping("/createQuiz")
	public ResponseEntity<List<QuizWrapper>> getquizWrapperObj(@RequestBody List<Integer> qIds){
		System.out.println(environment.getProperty("local.server.port"));
	
    System.out.print("qids list q num values : ");
		qIds.stream().forEach(System.out::println);
		return questionsService.getquizWrapperObjFromService(qIds);
	}
}
