package com.app.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.quizapp.model.Questions;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions, Integer> {

	List<Questions> getByCategory(String catagery);

}
