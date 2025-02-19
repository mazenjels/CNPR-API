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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoja.cnprapi.models.Candidat;
import com.hoja.cnprapi.models.CnprUser;
import com.hoja.cnprapi.models.ViewAutoEcole;
import com.hoja.cnprapi.services.CandidatServiceImpl;
import com.hoja.cnprapi.services.ResultServiceImpl;
import com.hoja.cnprapi.services.UserServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "user")
public class UserController {

	@Autowired
	UserServiceImpl userService = null;

	@Autowired
	CandidatServiceImpl candidatService = null;
	
	@Autowired
	ResultServiceImpl resultServiceImpl;

//	 @GetMapping("/get")
//	    public CnprUser getCustomer(@RequestParam(name = "username") String username) {
//		 if (customerOptional.isPresent()) {
//	        return userService.getCnprUser(username);
//	    }

	@GetMapping("/get")
	public ResponseEntity<CnprUser> getUsern(@RequestParam(name = "username") String username) {
		try {
			Optional<CnprUser> customerOptional = userService.getCnprUser(username);
			if (customerOptional.isPresent()) {
				CnprUser user = customerOptional.get();
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//		 @GetMapping("/getCode")
//			public ResponseEntity<Candidat> getCodeUnique(@RequestParam(name = "codeUnique") String codeUnique) {
//				try {
//					Optional<Candidat> customerOptional = candidatService.getCandidat(codeUnique);
//					if (customerOptional.isPresent()) {
//						Candidat candidat = customerOptional.get();
//						return new ResponseEntity<>(candidat, HttpStatus.OK);
//					}else {
//						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//					}
//					
//
//				} catch (Exception e) {
//					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//				}
//			}

	@GetMapping("/getCode")
	public String getCandidat(@RequestParam(name = "codeUnique") String codeUnique) {
		String candidats = candidatService.getCandidat(codeUnique);

		return candidats;
	}
	
//	@PostMapping("/result")
//	public String getResult(@RequestBody Candidat candidat) {
//		String result = resultServiceImpl.getUserResult(candidat.getCodeUnique());
//
//		return result;
//	}
	
	@GetMapping("/result")
	public String getResult(@RequestParam(name = "codeUnique") String codeUnique) {
		String result = resultServiceImpl.getUserResult(codeUnique);

		return result;
	}
	
	@PostMapping("/auth")
	public String authenticate(@RequestBody Candidat candidat) {
		String candidats = candidatService.getCandidat(candidat.getCodeUnique());

		return candidats;
	}
	
	
	
	
}
