package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.ViewAutoEcole;



public interface ViewAutoEcoleRepository extends JpaRepository<ViewAutoEcole, Long>{
	
//	ViewUser findByUsername(String username);
	@Query("select t from ViewAutoEcole t where t.planification=?1")
	List<ViewAutoEcole> getAllAutoEcoleByPlanification(long planification);
	
	@Query("select t from ViewAutoEcole t")
	List<ViewAutoEcole> getAllAutoEcole();

}
