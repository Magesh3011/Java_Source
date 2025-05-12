package com.app.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.quizapp.model.QuizWrapper;
import com.app.quizapp.model.RequestAnswer;
import com.app.quizapp.service.QuizService;

@RestController
public class QuizController {

	@Autowired
	private QuizService quizService;

	@PostMapping("/create")
	public ResponseEntity<List<QuizWrapper>> createQuiz(@RequestParam String QuizName, @RequestParam String category) {

		return quizService.createQuizWithCatogery(QuizName, category);
	}

	@PostMapping("/submit")
	public List<ResponseEntity<String>> submitQuiz(@RequestBody List<RequestAnswer> ans) {
		ans.stream().forEach(
				item -> System.out.println(item.getQuizId() + "::" + item.getQuestionId() + "::" + item.getAns()));
		return quizService.validateAns(ans);
	}

}
