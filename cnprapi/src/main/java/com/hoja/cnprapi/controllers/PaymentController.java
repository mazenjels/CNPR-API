package com.hoja.cnprapi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoja.cnprapi.models.Candidat;
import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.models.ViewAutoEcole;
import com.hoja.cnprapi.models.ViewUser;
import com.hoja.cnprapi.repository.ViewUserRepository;
import com.hoja.cnprapi.services.CandidatServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/api/cnpr")
public class PaymentController {

	@Autowired
	CandidatServiceImpl candidatServiceImpl;

//	@PostMapping("/auth")
//	  public ResponseEntity<ViewUser> createAutoEcole(@RequestBody ViewUser login) {
//		//bcrypted password 12345=? $2a$10$YmXE9lJhYOi7xt9CGISPeuR1XWtBdmFTeYaP/7UZ6Sj8HDgfE3nxy
//	    	//List<ViewUser> foundUserList = vwUserRepo.findByusernameAndEnabled(login.getUsername(),true);
//	    	List<ViewUser> foundUserList = vwUserRepo.findByusername(login.getUsername());
//	    	//System.out.println("Found user list size : "+foundUserList.size());
//	    	if(foundUserList.size()>0) {
//	    		
//	    		ViewUser successLogin = foundUserList.get(0);
//	    		 return new ResponseEntity<>(successLogin, HttpStatus.CREATED);
//	    	}
//	    	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//	    
//	  }
	@PostMapping("/checkCandidat")
	public ResponseEntity<String> getCandidatInfo(@RequestBody Candidat candidat) {
		try {
			String result = candidatServiceImpl.getInfoCandidat(candidat.getCodeUnique());
			
				return new ResponseEntity<>(result, HttpStatus.OK);


		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
