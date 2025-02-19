package com.hoja.cnprapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.Candidat;
import com.hoja.cnprapi.models.CnprQuestion;
import com.hoja.cnprapi.models.CnprUser;
import com.hoja.cnprapi.models.QuestionAnswer;
import com.hoja.cnprapi.models.ViewResult;
import com.hoja.cnprapi.repository.QuestionRepository;
import com.hoja.cnprapi.repository.UserRepository;
import com.hoja.cnprapi.repository.ViewResultRepository;



@Service
@Transactional
public class ResultServiceImpl implements ResultService{

	@Autowired
	ViewResultRepository viewResultRepo;

	@Autowired
	CandidatServiceImpl candidatServiceImpl;

	@SuppressWarnings("unchecked")
	@Override
	public String getUserResult(String codeUnique) {
		// TODO Auto-generated method stub
		JSONArray jsonArray = new JSONArray();
		JSONArray questionArray = new JSONArray();
		JSONObject questionObj = new JSONObject();
		JSONObject jsonObj = new JSONObject();
		
		boolean validityChanged = candidatServiceImpl.updatCodeValidity(codeUnique);
		
		List<ViewResult> userResults = viewResultRepo.getResultByCodeUnique(codeUnique);
		
		long nbCorrectAnswer = 0;
		long pourcentage=0;
		long totalQuestion = userResults.size();
		
		for(ViewResult a: userResults) {
			questionObj = new JSONObject();
			questionObj.put("questionId", a.getQuestionId());
			questionObj.put("answerId", a.getQuestionAnswerId());
			questionObj.put("candidateCode", a.getCodeUnique());
			questionObj.put("correct", a.isCorrect());
			questionObj.put("questionTitle", a.getQuestionTitle());
			questionObj.put("answerValue", a.getUserResponse());
			questionObj.put("questionAnswer", a.getQuestionReponse());
			
			if(a.isCorrect()==true) {
				nbCorrectAnswer++;
			}
			questionArray.add(questionObj);
//			QuestionAnswer qA = new QuestionAnswer();
//			qA.setAnswerValue(a.getUserResponse());
//			qA.setQuestionTitle(a.getQuestionTitle());
//			qA.setQuestionId(a.getQuestionId());
//			qA.setAnswerId(a.getQuestionAnswerId());
//			qA.setCandidateCode(a.getCodeUnique());
//			qA.setCorrect(a.isCorrect());
//			
//			questionsAndResponse.add(qA);
			
		}
		pourcentage = (nbCorrectAnswer*100)/totalQuestion;
		
		jsonObj.put("nbQuestions", totalQuestion);
		jsonObj.put("nbCorrect", nbCorrectAnswer);
		jsonObj.put("pourcentage", pourcentage);
		jsonObj.put("answers", questionArray);
		
		return jsonObj.toJSONString();
	}



	
}
