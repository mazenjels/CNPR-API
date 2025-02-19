package com.hoja.cnprapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.ViewPlanification;
import com.hoja.cnprapi.repository.PlanificationRepository;



@Service
@Transactional
public class PlanificationServiceImpl implements PlanificationService{

	@Autowired
	PlanificationRepository planificationRepo;
	
	

	@Override
	public List<ViewPlanification> getAllActivePlanification() {
		// TODO Auto-generated method stub
		return (List<ViewPlanification>)planificationRepo.getAllActivePlanification();
	}

	
	
}
