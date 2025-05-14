package com.microservice.QuestionServiceV1_0.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.QuestionServiceV1_0.model.Questions;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions, Integer> {

	List<Questions> getByCategory(String catagery);
	//List<Integer> getByCategory(String catagery);
}
