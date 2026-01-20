package com.learning_hub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning_hub.Entity.Category;
import com.learning_hub.Repository.CategoryRepository;

@Service
public class CategoryService {
	

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public List<Category> getAllCategories (){
		return categoryRepository.findAll();
		
	}
	
	
	public List<Category> getCategoriesByType(String type){
		return categoryRepository.findByType(type);
		
	}
	
	public Optional<Category> getCategoryById(Long id){
		return categoryRepository.findById(id);
		
	}
	
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
		
	}

}
