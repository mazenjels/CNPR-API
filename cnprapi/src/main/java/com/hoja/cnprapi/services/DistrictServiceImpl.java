package com.hoja.cnprapi.services;

import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.District;
import com.hoja.cnprapi.repository.DistrictRepository;




@Service
@Transactional
public class DistrictServiceImpl implements DistrictService{

	@Autowired
	DistrictRepository districtRepo;
	
	

	@Override
	public List<District> getAllActiveDistrict() {
		// TODO Auto-generated method stub
		return (List<District>)districtRepo.getAllActiveDistrict();
	}
	
	
	
}
