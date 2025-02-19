package com.hoja.cnprapi.services;

import java.util.List;

import com.hoja.cnprapi.models.CnprQuestion;


public interface QuestionService {

	public List<CnprQuestion> getAllCnprQuestion();

	public List<CnprQuestion> getAllActiveCnprQuestion();

	public CnprQuestion saveOrUpdateCnprQuestion(CnprQuestion pers);

	public boolean deleteCnprQuestionById(long id);

	public void enableOrDisableCnprQuestionById(long id);

	public CnprQuestion getCnprQuestionById(long id);
}
