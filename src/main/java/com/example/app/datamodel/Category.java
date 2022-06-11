package com.example.app.datamodel;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCategory;
	
	private String categoryText;
	
	@OneToMany(mappedBy="category")
	private Set<Question> questions; 
	
	public Integer getIdCategory() {
	  return idCategory;
	}
	
	public void setIdCategory(Integer id) {
	  this.idCategory = id;
	}

	public String getCategoryText() {
		return categoryText;
	}
	
	public void setCategoryText(String category) {
		this.categoryText = category;
	}

	public Set<Question> getQuestions() { return questions; }
  
}
