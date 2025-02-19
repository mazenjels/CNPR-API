package com.hoja.cnprapi.services;

import java.util.List;

import com.hoja.cnprapi.models.CnprQuestionResponse;


public interface QuestionReponseService {

	public List<CnprQuestionResponse> getAllCnprQuestionResponse();

	public List<CnprQuestionResponse> getAllActiveCnprQuestionResponse();

	public boolean saveOrUpdateCnprQuestionResponse(CnprQuestionResponse pers);

	public boolean deleteCnprQuestionResponseById(long id);

	public void enableOrDisableCnprQuestionResponseById(long id);

	public CnprQuestionResponse getCnprQuestionResponseById(long id);
}
