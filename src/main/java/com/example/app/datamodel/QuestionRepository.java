package com.example.app.datamodel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.app.datamodel.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called questionRepository
// CRUD refers Create, Read, Update, Delete

public interface QuestionRepository extends CrudRepository<Question, Integer> {

	public List<Question> findByCategory(Category cat);
}	