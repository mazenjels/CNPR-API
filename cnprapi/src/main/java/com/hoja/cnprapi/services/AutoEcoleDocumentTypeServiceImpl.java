package com.hoja.cnprapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.CnprAutoEcoleDocumentType;
import com.hoja.cnprapi.repository.CnprAutoEcoleDocumentRepository;



@Service
@Transactional
public class AutoEcoleDocumentTypeServiceImpl implements AutoEcoleDocumentTypeService{

	@Autowired
	CnprAutoEcoleDocumentRepository autoDocumentRepo;
	
	@Override
	public List<CnprAutoEcoleDocumentType> getAllAutoEcoleDocumentType() {
		// TODO Auto-generated method stub
		return (List<CnprAutoEcoleDocumentType>) autoDocumentRepo.getAllCnprAutoEcoleDocumentType();
	}

	@Override
	public List<CnprAutoEcoleDocumentType> getAllActiveAutoEcoleDocumentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveOrUpdateAutoEcoleDocumentType(CnprAutoEcoleDocumentType pers) {
		CnprAutoEcoleDocumentType autoEcoleVeh = autoDocumentRepo.save(pers);

		if (autoDocumentRepo.findById(autoEcoleVeh.getId()) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAutoEcoleDocumentTypeById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enableOrDisableAutoEcoleDocumentTypeById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CnprAutoEcoleDocumentType getAutoEcoleDocumentTypeById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CnprAutoEcoleDocumentType> getAllAutoEcoleDocumentTypeByAutoEcoleId(long id) {
		// TODO Auto-generated method stub
		return (List<CnprAutoEcoleDocumentType>) autoDocumentRepo.getAllCnprAutoEcoleDocumentTypeByAutoEcoleid(id);
	}

	
}
