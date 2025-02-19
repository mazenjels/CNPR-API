package com.hoja.cnprapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.CnprQuestion;
import com.hoja.cnprapi.repository.QuestionRepository;



@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionRepository questionRepo;
	
	@Override
	public List<CnprQuestion> getAllCnprQuestion() {
		// TODO Auto-generated method stub
		return (List<CnprQuestion>)questionRepo.getAllCnprQuestion();
	}
	
	
	public Page<CnprQuestion> getAllPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return (Page<CnprQuestion>)questionRepo.getAllPageable(pageable);
	}

	@Override
	public List<CnprQuestion> getAllActiveCnprQuestion() {
		// TODO Auto-generated method stub
		
		return (List<CnprQuestion>)questionRepo.getAllActiveCnprQuestion();
	}	

	@Override
	public CnprQuestion saveOrUpdateCnprQuestion(CnprQuestion pers) {
		CnprQuestion question = questionRepo.save(pers);

		if (questionRepo.findById(question.getId()) != null) {
			return question;
		}
		return null;
	}

	@Override
	public boolean deleteCnprQuestionById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enableOrDisableCnprQuestionById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CnprQuestion getCnprQuestionById(long id) {
		// TODO Auto-generated method stub
		return (CnprQuestion) questionRepo.getById(id);
	}




	
}
