package com.hoja.cnprapi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.models.CnprUser;
import com.hoja.cnprapi.models.CnprUserAnswer;
import com.hoja.cnprapi.models.QuestionAnswer;
import com.hoja.cnprapi.models.UserData;
import com.hoja.cnprapi.models.ViewResult;
import com.hoja.cnprapi.repository.CnprUserAnswerRepository;
import com.hoja.cnprapi.services.MappingQuestionReponseService;
import com.hoja.cnprapi.services.ResultServiceImpl;
import com.hoja.cnprapi.services.UserAnswerServiceImpl;
import com.hoja.cnprapi.services.UserServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest")
public class QuestionController {

	@Autowired
	MappingQuestionReponseService mappingQuestionReponseService;

	@Autowired
	UserAnswerServiceImpl userAnswerServiceImpl;
	
	

	@Autowired
	ResultServiceImpl resultServiceImpl;

	@GetMapping("/questions")
	public String getAllQuestions() {
		String questions = mappingQuestionReponseService.getQuestions();

		return questions;
	}

	@PostMapping("/questions")
	public String saveUserAnswers(@RequestBody UserData userData) {

		List<QuestionAnswer> answers = new ArrayList<QuestionAnswer>();
		userData.getAnswers().forEach((key, value) -> {
			answers.add(new QuestionAnswer(Long.parseLong(key), value, userData.getCodeUnique()));
		});

		userAnswerServiceImpl.submitResponse(answers);

		String result = resultServiceImpl.getUserResult(userData.getCodeUnique());

		return result;
	}

}
