package com.hoja.cnprapi.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoja.cnprapi.dto.QuestionDTO;
import com.hoja.cnprapi.dto.QuestionReponseDTO;
import com.hoja.cnprapi.models.CnprLesson;
import com.hoja.cnprapi.models.CnprQuestion;
import com.hoja.cnprapi.models.CnprQuestionResponse;

@Service
public class MappingQuestionReponseService {

	@Autowired
	QuestionServiceImpl questionServiceImpl;

	@Autowired
	QuestionReponseServiceImpl questionReponseServiceImpl;

	public List<QuestionDTO> getAllQuestions() {
		return ((List<CnprQuestion>) questionServiceImpl.getAllActiveCnprQuestion()).stream()
				.map(this::convertDataIntoDTO).collect(Collectors.toList());
	}

	private QuestionDTO convertDataIntoDTO(CnprQuestion questionData) {

		// create instance of our UserLocationDTO class
		QuestionDTO dto = new QuestionDTO();

		// set username and userId in dto from the userData
		dto.setId(questionData.getId());
		dto.setLesson(questionData.getLesson().getTitle());
		dto.setLessonModule(questionData.getLessonModule().getTitle());
		dto.setReponse(questionData.getReponse());
		dto.setTitle(questionData.getTitle());
		dto.setTypeBrevet(questionData.getTypePermis().getCategorie());
		dto.setVideoUrl(questionData.getVideoUrl());
		// create instance of the Location class
		
		
		return dto;
	}
	
	public List<QuestionReponseDTO> getAllQuestionsResponses(List<Long> questionIds) {
		return ((List<CnprQuestionResponse>) questionReponseServiceImpl.getAllCnprQuestionResponseByQuestionIds(questionIds)).stream()
				.map(this::convertQuestionReponseIntoDTO).collect(Collectors.toList());
	}
	
	private QuestionReponseDTO convertQuestionReponseIntoDTO(CnprQuestionResponse questionReponseData) {

		// create instance of our UserLocationDTO class
		QuestionReponseDTO dto = new QuestionReponseDTO();

		// set username and userId in dto from the userData
		dto.setId(questionReponseData.getId());
		dto.setCorrect(questionReponseData.isCorrect());
		dto.setQuestionId(questionReponseData.getQuestion().getId());
		dto.setQuestionTitle(questionReponseData.getQuestion().getTitle());
		dto.setValue(questionReponseData.getValue());
		// create instance of the Location class
		
		
		return dto;
	}
	
	@SuppressWarnings("unchecked")
	public String getQuestions() {
		JSONArray jsonArray = new JSONArray();
		JSONArray assertionnArray = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		JSONObject assertObj = new JSONObject();
		try {
			List<QuestionDTO> questionList = getAllQuestions();
			List<QuestionDTO> shuffledQuestios = questionList.stream()
		            .collect(Collectors.collectingAndThen(
		                Collectors.toList(),
		                collected -> {
		                    Collections.shuffle(collected);
		                    return collected;
		                }
		            ));

			List<Long> questionIds = new ArrayList<Long>();
			Map<QuestionDTO, Object> mapQuestionTitles = new HashMap<QuestionDTO, Object>();
			shuffledQuestios.forEach(q -> {
				mapQuestionTitles.put(q, null);
				questionIds.add(q.getId());
			});
			List<QuestionReponseDTO> questionReponses = getAllQuestionsResponses(questionIds);
			List<QuestionReponseDTO> shuffledQuestionReponses = questionReponses.stream()
		            .collect(Collectors.collectingAndThen(
		                Collectors.toList(),
		                collected -> {
		                    Collections.shuffle(collected);
		                    return collected;
		                }
		            ));
//			List<QuestionReponseDTO> questionsAssertions = new ArrayList<QuestionReponseDTO>();
//			Map<QuestionDTO, List<QuestionReponseDTO>> mapQuestion = new HashMap<QuestionDTO, List<QuestionReponseDTO>>();
			long count=1;
			for (Map.Entry<QuestionDTO, Object> entry : mapQuestionTitles.entrySet()) {
				// String qTitle = entry.getKey();
				;
				System.out.println("Count "+count);
				count++;
				QuestionDTO question = entry.getKey();
				jsonObj = new JSONObject();
				
				jsonObj.put("id", question.getId());
				jsonObj.put("title", question.getTitle());
				jsonObj.put("reponse", question.getReponse());
				jsonObj.put("lesson", question.getLesson());
				jsonObj.put("module", question.getLessonModule());
				jsonObj.put("typePermis", question.getTypeBrevet());
				
				// Object val = entry.getValue();
				for (Iterator iterator = shuffledQuestionReponses.iterator(); iterator.hasNext();) {
					QuestionReponseDTO cnprQuestionResponse = (QuestionReponseDTO) iterator.next();

					if (cnprQuestionResponse.getQuestionTitle().equals(question.getTitle())) {
						assertObj = new JSONObject();
						assertObj.put("id", cnprQuestionResponse.getId());
						assertObj.put("value", cnprQuestionResponse.getValue());
						assertObj.put("isCorrect", cnprQuestionResponse.isCorrect());
						assertionnArray.add(assertObj);
						
						jsonObj.put("assertions", assertionnArray);
						
						
					} else {

					}
					
//					
				}
				jsonArray.add(jsonObj);	
				assertionnArray = new JSONArray();
				
				continue;

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return (jsonArray.toString());
	}
}
