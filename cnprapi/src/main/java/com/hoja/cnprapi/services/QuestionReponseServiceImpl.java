package com.hoja.cnprapi.services;

import java.util.Iterator;
import java.util.List;

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
import com.hoja.cnprapi.repository.QuestionReponseRepository;




@Service
@Transactional
public class QuestionReponseServiceImpl implements QuestionReponseService{

	@Autowired
	QuestionReponseRepository questionResponseRepo;
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	 

	@Override
	public List<CnprQuestionResponse> getAllCnprQuestionResponse() {
		// TODO Auto-generated method stub
		return (List<CnprQuestionResponse>)questionResponseRepo.findAll();
	}
	
	public Page<CnprQuestionResponse> getAllPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return (Page<CnprQuestionResponse>)questionResponseRepo.getAllPageable(pageable);
	}
	
	public List<CnprQuestionResponse> getAllCnprQuestionResponseByQuestionId(long questionId){
		return (List<CnprQuestionResponse>)questionResponseRepo.getAllCnprQuestionResponseByQuestionId(questionId);
	}

	@Override
	public List<CnprQuestionResponse> getAllActiveCnprQuestionResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deactivateAllByQuestionId(CnprQuestion pers) {
		List<CnprQuestionResponse> questionReponses = questionResponseRepo.getAllCnprQuestionResponseByQuestionId(pers.getId());
		questionReponses.forEach(p->{
			p.setCorrect(false);
			questionResponseRepo.save(p);
		});
		
	}
	
	@Override
	public boolean saveOrUpdateCnprQuestionResponse(CnprQuestionResponse pers) {
		CnprQuestionResponse questionReponse = questionResponseRepo.save(pers);

		if (questionResponseRepo.findById(questionReponse.getId()) != null) {
			return true;
		}
		return false;
	}
//	
//	public void bulkInsertQuestionResponses(List<CnprQuestionResponse> questResp) {
//		// TODO Auto-generated method stub
//		 String sql = "INSERT INTO public.tb_cnpr_question_response (is_correct,value,created_by,question) VALUES (false,?,?,?)";
//	        jdbcTemplate.batchUpdate(sql, questResp, 5, (ps, ts) -> {
//	            ps.setString(1, ts.getValue());
//	            ps.setLong(2, ts.getCreatedBy().getId());
//	            ps.setLong(3, ts.getQuestion().getId());
//	        });
//	}
//	public void bulkInsertQuestionReponse(List<Permission> allPermissions, CnprRole role) {
//		String sql = "INSERT INTO public.tb_role_permission (role_id,permission_id,active_status) VALUES (?,?,true)";
//        jdbcTemplate.batchUpdate(sql, allPermissions, 5, (ps, ts) -> {
//            ps.setLong(1, role.getId());
//            ps.setLong(2, ts.getId());
//        });
//		
//	}

	@Override
	public boolean deleteCnprQuestionResponseById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enableOrDisableCnprQuestionResponseById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CnprQuestionResponse getCnprQuestionResponseById(long id) {
		// TODO Auto-generated method stub
		return (CnprQuestionResponse) questionResponseRepo.getById(id);
	}

	public List<CnprQuestionResponse> getAllCnprQuestionResponseByQuestionIds(List<Long> questionIds) {
		// TODO Auto-generated method stub
		return (List<CnprQuestionResponse>) questionResponseRepo.getAllCnprQuestionResponseByQuestionIds(questionIds);
	}
	
	



	
}
