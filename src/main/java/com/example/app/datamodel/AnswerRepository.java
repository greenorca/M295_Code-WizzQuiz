package com.example.app.datamodel;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called questionRepository
// CRUD refers Create, Read, Update, Delete

public interface AnswerRepository extends CrudRepository<Answer, Integer> {

	Iterable<Answer> findAnswersByQuestion(Question q);

}	