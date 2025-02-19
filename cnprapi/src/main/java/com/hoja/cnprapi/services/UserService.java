package com.hoja.cnprapi.services;

import java.util.Optional;

import com.hoja.cnprapi.models.CnprUser;


public interface UserService {

	public Optional<CnprUser> getCnprUser(String username);
	 
	 
	
}
