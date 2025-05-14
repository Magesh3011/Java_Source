package com.microservice.QuizAppV1_0.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/*import com.microservice.QuizAppV1_0.model.Questions;*/
import com.microservice.QuizAppV1_0.model.Quiz;
/*import com.microservice.QuizAppV1_0.model.QuizWrapper;
import com.microservice.QuizAppV1_0.model.RequestAnswer;
import com.microservice.QuizAppV1_0.repository.QuestionsRepo;*/
import com.microservice.QuizAppV1_0.repository.QuizRepo;

@Service
public class QuizService {
	/*
	 * @Autowired private QuestionsRepo questionsRepo;
	 */

	@Autowired
	private QuizRepo quizRepo;

	public void createQuiz(List<Integer> newQuizListInt, String name) {
		// TODO Auto-generated method stub
		Quiz quiz= new Quiz();
		quiz.setName(name);
		quiz.setQuestions(newQuizListInt);
		
		quizRepo.save(quiz);
	}

	/*
	 * public ResponseEntity<List<QuizWrapper>> createQuizWithCatogery(String
	 * quizName, String catagery) {
	 * 
	 * }
	 * 
	 * public List<ResponseEntity<String>> validateAns(List<RequestAnswer> ans) {
	 * 
	 * }
	 */
}
