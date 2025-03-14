package com.hoja.cnprapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.PrixTypePermisAutoEcole;
import com.hoja.cnprapi.repository.PrixTypePermisRepository;



@Service
@Transactional
public class PrixPermisTypeAutoEcoleServiceImpl implements PrixPermisTypeAutoEcoleService{

	@Autowired
	PrixTypePermisRepository prixTypePermisRepo;
	
	@Override
	public List<PrixTypePermisAutoEcole> getAllPrixTypePermisAutoEcole() {
		// TODO Auto-generated method stub
		return (List<PrixTypePermisAutoEcole>)prixTypePermisRepo.getAllPrixTypePermisAutoEcole();
	}

	@Override
	public List<PrixTypePermisAutoEcole> getAllActivePrixTypePermisAutoEcole() {
		// TODO Auto-generated method stub
		return (List<PrixTypePermisAutoEcole>)prixTypePermisRepo.getAllActivePrixTypePermisAutoEcole();
	}
	
	public List<PrixTypePermisAutoEcole> getSingleActivePrixTypePermisAutoEcoleByTypePermisAndAutoEcole(long autoEcoleId, long typePermisId) {
		// TODO Auto-generated method stub
		return (List<PrixTypePermisAutoEcole>)prixTypePermisRepo.getSingleActivePrixTypePermisAutoEcoleByTypePermisAndAutoEcole(autoEcoleId,typePermisId);
	}

	@Override
	public PrixTypePermisAutoEcole saveOrUpdatePrixTypePermisAutoEcole(PrixTypePermisAutoEcole pers) {
		PrixTypePermisAutoEcole autoEcole = prixTypePermisRepo.save(pers);

		if (prixTypePermisRepo.findById(autoEcole.getId()) != null) {
			return autoEcole;
		}
		return null;
	}

	@Override
	public boolean deletePrixTypePermisAutoEcoleById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enableOrDisablePrixTypePermisAutoEcoleById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PrixTypePermisAutoEcole getPrixTypePermisAutoEcoleById(long id) {
		// TODO Auto-generated method stub
		return (PrixTypePermisAutoEcole) prixTypePermisRepo.getById(id);
	}
	
	public List<PrixTypePermisAutoEcole> getAllPrixTypePermisAutoEcoleById(long id) {
		// TODO Auto-generated method stub
		return (List<PrixTypePermisAutoEcole> ) prixTypePermisRepo.getAllPrixTypePermisAutoEcoleById(id);
	}

	
}
