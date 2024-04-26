package com.vansh.quizapp.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vansh.quizapp.dao.questiondao;
import com.vansh.quizapp.entity.*;
@Service
public class questionservice {
    
    @Autowired
    private questiondao questionDao;
    
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            List<Question> questions = questionDao.findAll();
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }
    
    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }
    
    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Successfully added question", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to add question", HttpStatus.BAD_REQUEST);
        }
    }
}
