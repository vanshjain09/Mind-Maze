package com.vansh.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.vansh.quizapp.entity.Quiz;

@Component
@Repository
public interface quizdao extends JpaRepository<Quiz,Integer>{

}
