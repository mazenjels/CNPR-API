package com.hoja.cnprapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.models.ViewResult;
import com.hoja.cnprapi.models.ViewUser;



public interface ViewResultRepository extends CrudRepository<ViewResult, Long>{
	
	 List<ViewResult> getResultByCodeUnique(String codeUnique);
	
}
