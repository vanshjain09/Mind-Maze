package com.vansh.quizapp.controller;
import com.vansh.quizapp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vansh.quizapp.service.quizservice;
import java.util.*;
@RestController
@RequestMapping("quiz")
public class quizController {
	@Autowired
	private quizservice obj;
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(
	        @RequestParam String category,
	        @RequestParam Integer numQ,
	        @RequestParam String title) {
	    return obj.createQuiz(category, numQ, title);
	}
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
		return obj.getQuiz(id);
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
		return obj.submitQuiz(id,responses);
	}

}
