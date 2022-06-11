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

@Controller // This means that this class is a Controller
@RequestMapping(path="/cat") // This means URL's start with /demo (after Application path)
public class CategoryController {
  @Autowired
  private CategoryRepository categoryRepository;
  
  
  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewCategory (@RequestParam String categoryName) {

    Category c = new Category();
    c.setCategoryText(categoryName);
    categoryRepository.save(c);
    return "Saved";
  }
  
  @GetMapping(path="/all")
  public @ResponseBody Iterable<Category> getAllCategories() {
    
    return categoryRepository.findAll();
  }
  
  @GetMapping(path="/category/{cat_id}")
  public @ResponseBody Category getCategory(@PathVariable("cat_id") int catId) {
    
    return categoryRepository.findById(catId).get();
  }
  
  
}