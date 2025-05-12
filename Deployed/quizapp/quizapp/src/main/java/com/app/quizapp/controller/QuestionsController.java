package com.app.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.quizapp.model.Questions;
import com.app.quizapp.service.QuestionsService;

@RestController
public class QuestionsController {

	@Autowired
	private QuestionsService questionsService;

	@GetMapping("/questions")
	public List<Questions> getAllQuestion() {

		return questionsService.getAllQuestionFromDB();
	}

	@PostMapping("/addQuestion")
	public ResponseEntity<Void> createQuestion(@RequestBody Questions questions) {
		return questionsService.createQuestion(questions);
	}

	@DeleteMapping("/deleteQuestion/{id}")
	public ResponseEntity<Void> deleteQusById(@PathVariable int id) {

		System.out.println("Name : " + id);
		return questionsService.deleteByID(id);
	}
}
