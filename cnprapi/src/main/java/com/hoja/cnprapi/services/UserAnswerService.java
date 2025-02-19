package com.hoja.cnprapi.services;

import java.util.List;

import com.hoja.cnprapi.models.CnprQuestionResponse;
import com.hoja.cnprapi.models.CnprUserAnswer;


public interface UserAnswerService {

	public List<CnprUserAnswer> getAllCnprUserAnswerByCandidatCode(String candidatCode);


	public CnprUserAnswer saveOrUpdateCnprUserAnswer(CnprUserAnswer pers);
	

}
