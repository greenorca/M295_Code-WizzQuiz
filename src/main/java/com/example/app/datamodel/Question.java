package com.example.app.datamodel;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="question")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idQuestion;
	
	private String questionText;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
		
	public Integer getIdQuestion() {
	  return idQuestion;
	}
	
	public void setIdQuestion(Integer id) {
	  this.idQuestion = id;
	}

	public String getQuestionText() {
		return questionText;
	}
	
	public void setQuestionText(String question) {
		this.questionText = question;
	}

	public Category getCategory() { return category; }
	
	@OneToMany(mappedBy = "question")
	private Set<Answer> answers;
	
	public Set<Answer> getAnswers() {
		return answers;
	}
	
	
  
    
}