package com.example.app.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String categoryText;
	
	/*
	@OneToMany(mappedBy="category")
	@JsonManagedReference
	private Set<Question> questions; 
	public Set<Question> getQuestions() { return questions; }
	*/  
	public Integer getId() {
	  return id;
	}
	
	public void setId(Integer id) {
	  this.id = id;
	}

	public String getCategoryText() {
		return categoryText;
	}
	
	public void setCategoryText(String category) {
		this.categoryText = category;
	}

	
}
