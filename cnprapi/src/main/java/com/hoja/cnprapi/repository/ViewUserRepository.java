package com.hoja.cnprapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.models.ViewUser;



public interface ViewUserRepository extends JpaRepository<ViewUser, Long>{
	
	 List<ViewUser> findByusernameAndEnabled(String username,boolean status);
	 
	 List<ViewUser> findByusername(String username);
	 
	 List<ViewUser> findByusernameAndPassword(String username,String password);
	
}
