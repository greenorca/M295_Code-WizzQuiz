package com.example.app.datamodel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="answer")
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAnswer;
	
	private String answerText;
	
	private Boolean correct;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Question question;
		
	public Integer getIdAnswer() {
	  return idAnswer;
	}
	
	public void setIdAnswer(Integer id) {
	  this.idAnswer = id;
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
  
    
}
