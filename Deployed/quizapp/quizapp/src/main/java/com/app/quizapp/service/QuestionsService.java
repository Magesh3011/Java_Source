package com.app.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.quizapp.model.Questions;
import com.app.quizapp.repository.QuestionsRepo;

@Service
public class QuestionsService {

	@Autowired
	private QuestionsRepo questionsRepo;

	public List<Questions> getAllQuestionFromDB() {
		// TODO Auto-generated method stub

		return questionsRepo.findAll();
	}

	public ResponseEntity<Void> createQuestion(@RequestBody Questions questions) {
		questionsRepo.save(questions);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteByID(int id) {
		// TODO Auto-generated method stub
		if (questionsRepo.existsById(id)) {
			questionsRepo.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
