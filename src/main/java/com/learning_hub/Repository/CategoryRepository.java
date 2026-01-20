package com.learning_hub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning_hub.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	
	List<Category> findByType(String type);
	List<Category> findAllByOrderByNameAsc();
	
	
}
