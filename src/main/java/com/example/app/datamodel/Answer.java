package com.example.app.datamodel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="answer")
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String answerText;
	
	private Boolean correct;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Question question;
		
	public Integer getId() {
	  return id;
	}
	
	public void setId(Integer id) {
	  this.id = id;
	}

	public String getAnswerText() {
		return answerText;
	}
	
	public void setAnswerText(String answer) {
		this.answerText = answer;
	}

	public Question getQuestion() { return question; }

	public Boolean getCorrect() {
		return correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}

	public void setQuestion(Question q) {
		this.question = q;
	}
  
    
}
