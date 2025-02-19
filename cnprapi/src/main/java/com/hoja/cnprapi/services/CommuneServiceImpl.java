package com.hoja.cnprapi.services;

import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.Commune;
import com.hoja.cnprapi.repository.CommuneRepository;




@Service
@Transactional
public class CommuneServiceImpl implements CommuneService{

	@Autowired
	CommuneRepository communeRepo;
	
	

	@Override
	public List<Commune> getAllActiveCommune() {
		// TODO Auto-generated method stub
		return (List<Commune>)communeRepo.getAllActiveCommune();
	}
	



	
}
