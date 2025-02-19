package com.hoja.cnprapi.services;

import java.util.List;

import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.models.District;


public interface AutoEcoleService {


	public List<CnprAutoEcole> getAllCnprAutoEcole();
	
	public CnprAutoEcole getAutoEcoleById(long id) ;

}
