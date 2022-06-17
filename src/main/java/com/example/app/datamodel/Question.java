package com.example.app.datamodel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="question")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String questionText;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Category category;
		
	public Integer getId() {
	  return id;
	}
	
	public void setId(Integer id) {
	  this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}
	
	public void setQuestionText(String question) {
		this.questionText = question;
	}

	public Category getCategory() { return category; }

	public void setCategory(Category cat) {
		this.category = cat;
	}
	
	/*@OneToMany(mappedBy = "question")
	@JsonManagedReference
	private Set<Answer> answers;
	
	public Set<Answer> getAnswers() {
		return answers;
	}*/
	
	
  
    
}
