package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.app.datamodel.Answer;
import com.example.app.datamodel.AnswerRepository;
import com.example.app.datamodel.Category;
import com.example.app.datamodel.CategoryRepository;
import com.example.app.datamodel.Question;
import com.example.app.datamodel.QuestionRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/answer") // This means URL's start with /demo (after Application path)
public class AnswerController {
  @Autowired
  private AnswerRepository answerRepository;
  @Autowired
  private QuestionRepository questionRepo;
  
  @PostMapping(path="/add") // Map ONLY POST Requests	
  public @ResponseBody String addNewAnswer (
		  @RequestParam String answerText, 
		  @RequestParam Boolean correct, 
		  @RequestParam Integer idQuestion) {
	
	Question q = questionRepo.findById(idQuestion).get();
	if (q == null) {
		return "invalid question_id";
	}
	Answer answer = new Answer();
	answer.setAnswerText(answerText);
	answer.setCorrect(correct);
	answer.setQuestion(q);
    answerRepository.save(answer);
    return "Saved";
  }
  
  
  @GetMapping(path="/question/{id}")
  public @ResponseBody Iterable<Answer> getAnswersForQuestion(@PathVariable("id") int id) {
    Question q = questionRepo.findById(id).get();
    System.out.println("Loking up answers for "+q.getQuestionText());
    return answerRepository.findAnswersByQuestion(q);
  }
    
  
}