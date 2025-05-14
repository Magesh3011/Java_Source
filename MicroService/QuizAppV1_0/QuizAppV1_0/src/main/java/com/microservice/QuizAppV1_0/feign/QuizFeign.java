package com.microservice.QuizAppV1_0.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.QuizAppV1_0.model.QuizWrapper;

@FeignClient("QUESTIONSERVICEV1")
public interface QuizFeign {
	/*
	 * @GetMapping("/questions") public List<Questions> getAllQuestion();
	 * 
	 * @PostMapping("/addQuestion") public ResponseEntity<Void>
	 * createQuestion(@RequestBody Questions questions);
	 */

	@DeleteMapping("/deleteQuestion/{id}")
	public ResponseEntity<Void> deleteQusById(@PathVariable int id);
	
	@PostMapping("/questions")
	public ResponseEntity<List<Integer>> getAllQuestionNum(@RequestParam String category);

	@PostMapping("/createQuiz")
	public ResponseEntity<List<QuizWrapper>> getquizWrapperObj(@RequestBody List<Integer> qIds);
}
