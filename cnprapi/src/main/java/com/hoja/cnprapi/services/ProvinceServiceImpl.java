package com.hoja.cnprapi.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.Province;
import com.hoja.cnprapi.repository.ProvinceRepository;


@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService{

	@Autowired
	ProvinceRepository provinceRepo;
	
	

	@Override
	public List<Province> getAllActiveProvince() {
		// TODO Auto-generated method stub
		return (List<Province>)provinceRepo.getAllActiveProvince();
	}

	
}
