package com.microservice.QuestionServiceV1_0.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.QuestionServiceV1_0.model.Questions;
import com.microservice.QuestionServiceV1_0.model.QuizWrapper;
import com.microservice.QuestionServiceV1_0.repository.QuestionsRepo;

@Service
public class QuestionsService {

	@Autowired
	private QuestionsRepo questionsRepo;
	
	public ResponseEntity<List<Integer>> getAllQuestionsNumFromDB(String cat) {
		// TODO Auto-generated method stub
List<Questions> qusList=questionsRepo.getByCategory(cat);
List<Integer> intList=new ArrayList<Integer>();
for(Questions question:qusList ) {
	intList.add(question.getId());
	
}
		return new ResponseEntity(intList, HttpStatus.OK);
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


	public ResponseEntity<List<QuizWrapper>> getquizWrapperObjFromService(List<Integer> qIds) {
		// TODO Auto-generated method stub
		List<QuizWrapper> qwrapper=new ArrayList<QuizWrapper>();
		for(int qno:qIds) {
			Questions ques=questionsRepo.findById(qno).get();
			if (ques != null) {
				qwrapper.add(new QuizWrapper(ques.getId(),ques.getQuestion(),ques.getOptionA(),ques.getOptionB(),ques.getOptionC(),ques.getOptionD()));
			}
		}

		
		return new ResponseEntity<List<QuizWrapper>>(qwrapper, HttpStatus.CREATED);
	}

}
