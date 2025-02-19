package com.hoja.cnprapi.services;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.CnprQuestion;
import com.hoja.cnprapi.models.CnprQuestionResponse;
import com.hoja.cnprapi.models.CnprUserAnswer;
import com.hoja.cnprapi.models.QuestionAnswer;
import com.hoja.cnprapi.repository.CnprUserAnswerRepository;
import com.hoja.cnprapi.repository.QuestionReponseRepository;




@Service
@Transactional
public class UserAnswerServiceImpl implements UserAnswerService{

	@Autowired
	CnprUserAnswerRepository userAnswerRepo;
	


	@Override
	public List<CnprUserAnswer> getAllCnprUserAnswerByCandidatCode(String candidatCode) {
		// TODO Auto-generated method stub
		return (List<CnprUserAnswer>)userAnswerRepo.getAllCnprUserAnswerByCandidatCode(candidatCode);
	}
	


	@Override
	public CnprUserAnswer saveOrUpdateCnprUserAnswer(CnprUserAnswer pers) {
		// TODO Auto-generated method stub
		CnprUserAnswer userAnswer = userAnswerRepo.save(pers);

		if (userAnswerRepo.findById(userAnswer.getId()) != null) {
			return userAnswer;
		}
		return null;
	}
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	public void submitResponse( List<QuestionAnswer> answers) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO public.tb_cnpr_question_answer (question,question_answer,candidat_code) VALUES (?,?,?)";
        jdbcTemplate.batchUpdate(sql, answers, 5, (ps, ts) -> {
            ps.setLong(1, ts.getQuestionId());
            ps.setLong(2, ts.getAnswerId());
            ps.setString(3, ts.getCandidateCode());
        });
		
	}
	
	



	
}
