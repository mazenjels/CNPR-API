package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.ViewPlanification;


public interface PlanificationRepository extends JpaRepository<ViewPlanification, Long>{

	
	@Query("SELECT t FROM Planification t")
	List<ViewPlanification> getAllPlanification();
	
	@Query("SELECT t FROM Planification t where t.activeStatus=true")
	List<ViewPlanification> getAllActivePlanification();
	

}
