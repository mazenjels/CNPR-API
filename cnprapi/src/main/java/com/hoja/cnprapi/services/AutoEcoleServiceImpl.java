package com.hoja.cnprapi.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.models.District;
import com.hoja.cnprapi.repository.CnprAutoEcoleRepository;
import com.hoja.cnprapi.repository.DistrictRepository;




@Service
@Transactional
public class AutoEcoleServiceImpl implements AutoEcoleService{

	@Autowired
	CnprAutoEcoleRepository autoEcoleRepo;
	
	

	@Override
	public List<CnprAutoEcole> getAllCnprAutoEcole() {
		// TODO Auto-generated method stub
		return (List<CnprAutoEcole>)autoEcoleRepo.findAll();
	}


	public CnprAutoEcole updateItem(Long id, CnprAutoEcole updatedItem) {
        // Check if the item exists
		CnprAutoEcole existingItem = autoEcoleRepo.findById(id).get();

        // Update fields
        existingItem.setTypeDocuments(updatedItem.getTypeDocuments());
       
        // Save and return updated item
        return autoEcoleRepo.save(existingItem);
    }

	@Override
	public CnprAutoEcole getAutoEcoleById(long id) {
		// TODO Auto-generated method stub
		return autoEcoleRepo.getById(id);
	}
	
	public Optional<CnprAutoEcole> getAutoEcole(long id) {
		// TODO Auto-generated method stub
		return (Optional<CnprAutoEcole>)autoEcoleRepo.getAutoEcoleById(id);
	}


//	public CnprAutoEcole getAutoEcoleByCandidatId(long id) {
//		// TODO Auto-generated method stub
//		return autoEcoleRepo.getAutoEcoleByCandidatId(id);
//	}
	
	
	
}
