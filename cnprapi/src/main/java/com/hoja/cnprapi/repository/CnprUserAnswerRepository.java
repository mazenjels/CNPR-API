package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.CnprQuestion;
import com.hoja.cnprapi.models.CnprQuestionResponse;
import com.hoja.cnprapi.models.CnprUserAnswer;



public interface CnprUserAnswerRepository extends JpaRepository<CnprUserAnswer, Long>{

	
	@Query("SELECT t FROM CnprUserAnswer t where t.candidatCode=?1")
	List<CnprUserAnswer> getAllCnprUserAnswerByCandidatCode(String candidatCode);
	

	

	
}
