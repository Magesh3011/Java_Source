package com.app.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.quizapp.model.Questions;
import com.app.quizapp.model.Quiz;
import com.app.quizapp.model.QuizWrapper;
import com.app.quizapp.model.RequestAnswer;
import com.app.quizapp.repository.QuestionsRepo;
import com.app.quizapp.repository.QuizRepo;

@Service
public class QuizService {
	@Autowired
	private QuestionsRepo questionsRepo;

	@Autowired
	private QuizRepo quizRepo;

	public ResponseEntity<List<QuizWrapper>> createQuizWithCatogery(String quizName, String catagery) {
		// TODO Auto-generated method stub
		List<Questions> quizcat = questionsRepo.getByCategory(catagery);

		System.out.println(quizcat.size());
		Quiz quiz = new Quiz();
		quiz.setName(quizName);
		quiz.setQuestions(quizcat);

		quizRepo.save(quiz);
		List<Quiz> quizList = quizRepo.findAll();

		List<QuizWrapper> quizWrappers = new ArrayList<QuizWrapper>();

		for (Questions quiz1 : quizList.get(quiz.getId() - 1).getQuestions()) {
			quizWrappers.add(new QuizWrapper(quiz.getId(), quiz1.getId(), quiz1.getQuestion(), quiz1.getOptionA(),
					quiz1.getOptionB(), quiz1.getOptionC(), quiz1.getOptionD()));
		}
		if (quizWrappers.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<>(quizWrappers, HttpStatus.CREATED);
	}

	public List<ResponseEntity<String>> validateAns(List<RequestAnswer> ans) {
		// TODO Auto-generated method
		List<ResponseEntity<String>> res = new ArrayList<>();
		for (RequestAnswer requestAnswer : ans) {
			Optional<Quiz> quizfindId = quizRepo.findById(requestAnswer.getQuizId());
			if (quizfindId.isPresent()) {
				Quiz quiz = quizfindId.get();

				// get the question id from the quiz table
				int qusIDFromClient = requestAnswer.getQuestionId();
				String qusAnsFromClient = requestAnswer.getAns();

				List<Questions> questions = quiz.getQuestions();
				boolean qusMatch = questions.stream().anyMatch(p -> p.getId() == qusIDFromClient);
				boolean qusAns = questions.stream()
						.anyMatch(p -> p.getId() == qusIDFromClient & p.getAnswer().equals(qusAnsFromClient));

				if (qusAns) {
					res.add(ResponseEntity
							.ok("Valid answer :  question id is " + qusIDFromClient + " ans: " + qusAnsFromClient));
				} else {
					if (qusMatch) {
						res.add(new ResponseEntity<>("Wrong answer", HttpStatus.OK));
						continue;
					}
					res.add(new ResponseEntity<String>("Question not found ", HttpStatus.NOT_FOUND));
					continue;
				}

			} else {
				res.add(new ResponseEntity<String>("QuizId not found ", HttpStatus.NOT_FOUND));

			}

		}
		return res;

	}

}
