package com.vansh.quizapp.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vansh.quizapp.entity.Question;
import com.vansh.quizapp.service.questionservice;
import com.vansh.quizapp.entity.*;
@RestController
@RequestMapping("Questions")
public class QuestionConroller {
	@Autowired
	private questionservice obj;
	//get all questions
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getallQuestion() {
		return obj.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public List<Question> getquestionbyCategory(@PathVariable String category ){
		return obj.getQuestionsByCategory(category);
	}
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question q) {
		return obj.addQuestion(q);
	}
}
