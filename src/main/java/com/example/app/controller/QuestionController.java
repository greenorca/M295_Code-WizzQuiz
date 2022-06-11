package com.example.app.controller;

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
  
  
  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewCategory (@RequestParam Question question) {

    questionRepository.save(question);
    return "Saved";
  }
  
  /*@GetMapping(path="/for-category/{id}")
  public @ResponseBody Iterable<Question> getQuestionForCategory(@PathVariable("id") int id) {
    // This returns a JSON or XML with the questions
	Category cat = catRepo.findById(id).get();
	System.out.println("Cat found: "+id+": "+cat.getCategoryText());
    return questionRepository.findByCategory(cat);
  }*/
  
  @GetMapping(path="/question/{id}")
  public @ResponseBody Question getQuestion(@PathVariable("id") int id) {
    // This returns a JSON or XML with the questions
    return questionRepository.findById(id).get();
  }
  
  @GetMapping(path="/all")
  public @ResponseBody Iterable<Question> getAllQuestiona() {
    // This returns a JSON or XML with the questions
    return questionRepository.findAll();
  }
  
  
  
}