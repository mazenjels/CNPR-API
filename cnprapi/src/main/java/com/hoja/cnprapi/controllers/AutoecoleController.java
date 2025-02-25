package com.hoja.cnprapi.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoja.cnprapi.models.Candidat;
import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.models.CnprUser;
import com.hoja.cnprapi.models.ViewUser;
import com.hoja.cnprapi.repository.ViewUserRepository;
import com.hoja.cnprapi.services.AutoEcoleServiceImpl;
import com.hoja.cnprapi.services.CandidatServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/api")
public class AutoecoleController {

	@Autowired
	ViewUserRepository vwUserRepo;
	
	@Autowired
	CandidatServiceImpl candidatService;
	
	@Autowired
	AutoEcoleServiceImpl autoEcoleServiceImpl;

	@GetMapping("/autoecoles")
	public String getAllActiveAutoecole() {
		String autoEcoles = autoEcoleServiceImpl.getAllJsonActiveAutoecole();

		return autoEcoles;
	}
}
