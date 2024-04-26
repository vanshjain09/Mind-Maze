package com.vansh.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.vansh.quizapp.entity.*;
@Component
@Repository
public interface questiondao extends JpaRepository<Question,Integer>{

	

	List<Question> findByCategory(String category);
	@Query(value = "SELECT * FROM Question q WHERE q.category = :category", nativeQuery = true)
	List<Question> findAllByCategory(@Param("category") String category);
}