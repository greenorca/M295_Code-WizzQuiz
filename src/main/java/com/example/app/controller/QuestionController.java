package com.example.app.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.app.datamodel.Category;
import com.example.app.datamodel.CategoryRepository;
import com.example.app.datamodel.Question;
import com.example.app.datamodel.QuestionRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/question") // This means URL's start with /demo (after Application path)
public class QuestionController {
  @Autowired
  private QuestionRepository questionRepository;
  @Autowired
  private CategoryRepository catRepo;
  
  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewQuestion (@RequestParam String questionText, 
		  @RequestParam int idCategory) {
	Category cat = catRepo.findById(idCategory).get();
	Question question = new Question();
	question.setQuestionText(questionText);
	question.setCategory(cat);
    questionRepository.save(question);
    return "Saved";
  }
  

  @GetMapping(path="/category/{id}")
  public @ResponseBody Iterable<Question> getQuestionByCategory(@PathVariable("id") int id) {
    Category cat = catRepo.findById(id).get();
    return questionRepository.findByCategory(cat);
  }

  @GetMapping(path="/question/{id}")
  public @ResponseBody Question getQuestion(@PathVariable("id") int id) {
    return questionRepository.findById(id).get();
  }
  
  @GetMapping(path="/game/{id}")
  public @ResponseBody Iterable<Question> getGameQuestions(@PathVariable("id") int id) {    
    Category cat = catRepo.findById(id).get();
    List<Question> allQuestions = questionRepository.findByCategory(cat);
    Collections.shuffle(allQuestions);
    return allQuestions.subList(0, Math.min(3, allQuestions.size()));
  }
  
  @GetMapping(path="/all")
  public @ResponseBody Iterable<Question> getAllQuestiona() {
    return questionRepository.findAll();
  }
  
  
  
}