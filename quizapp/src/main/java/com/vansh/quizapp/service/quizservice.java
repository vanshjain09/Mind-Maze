package com.vansh.quizapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vansh.quizapp.entity.*;
import com.vansh.quizapp.dao.questiondao;
import com.vansh.quizapp.dao.quizdao;
import com.vansh.quizapp.entity.QuestionWrapper;
import com.vansh.quizapp.entity.Quiz;
import com.vansh.quizapp.entity.Response;

@Service
@Component
public class quizservice {
	@Autowired
	private quizdao quizda;
	@Autowired
	private questiondao questiondao;
	public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
		try {
		List<Question> all = questiondao.findAllByCategory(category);
		
		//get numQ questions
		Collections.shuffle(all); // Shuffle the list
		List<Question> list = all.subList(0, Math.min(numQ, all.size()));
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(list);
		quizda.save(quiz);
		return new ResponseEntity<>("Here is your Quiz",HttpStatus.CREATED);
		}
		catch(Exception e) {e.printStackTrace();}
		return new ResponseEntity<>("Failed to get Quiz",HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
		try {
			Optional<Quiz> quiz = quizda.findById(id);
			List<Question> questionformDB = quiz.get().getQuestions();
			//now change these questions into question wrapper
			List<QuestionWrapper> questionforUser = new ArrayList<>();
			for(Question q : questionformDB) {
				QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
				questionforUser.add(qw);
			}
			return new ResponseEntity<>(questionforUser,HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

}
	public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> responses) {
		Optional<Quiz> quiz = quizda.findById(id);
		List<Question> questions = quiz.get().getQuestions();
		int count=0,i=0;
		for(Response r : responses) {
			if(r.getResponse().equals(questions.get(i).getRightAnswer())) count++;
			i++;
		}
		return new ResponseEntity<>(count,HttpStatus.OK); 
	}
}
