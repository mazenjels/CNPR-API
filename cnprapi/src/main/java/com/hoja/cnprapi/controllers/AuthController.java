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
public class AuthController {

	@Autowired
	ViewUserRepository vwUserRepo;
	
	@Autowired
	CandidatServiceImpl candidatService;
	
	@Autowired
	AutoEcoleServiceImpl autoEcoleServiceImpl;

	@PostMapping("/auth")
	public ResponseEntity<ViewUser> createAutoEcole(@RequestBody ViewUser login) {
		// bcrypted password 12345=?
		// $2a$10$YmXE9lJhYOi7xt9CGISPeuR1XWtBdmFTeYaP/7UZ6Sj8HDgfE3nxy
		// List<ViewUser> foundUserList =
		// vwUserRepo.findByusernameAndEnabled(login.getUsername(),true);
		List<ViewUser> foundUserList = vwUserRepo.findByusername(login.getUsername());
		// System.out.println("Found user list size : "+foundUserList.size());
		if (foundUserList.size() > 0) {

			ViewUser successLogin = foundUserList.get(0);
			return new ResponseEntity<>(successLogin, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

	@CrossOrigin(origins = "*")
	@PostMapping("/subscribe")
	public ResponseEntity<Candidat> subscribe(@RequestBody Candidat candidat) {

		try {
			System.out.println("auto ecole id : "+candidat.getCnprAutoEcole().getId());
			CnprAutoEcole autoEcole = autoEcoleServiceImpl.getAutoEcoleById(1);
			//autoEcole.setId(1);
			candidat.setCnprAutoEcole(autoEcole);
			candidat.setLieuNaissance("Na");
			
			CnprUser user = new CnprUser();
			user.setId(3);
			candidat.setCreatedBy(user);
			
//			Candidat candidat = candidatService.getCandidatById(id);
//			candidat.setRecyclageValide(true);
			
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String currentDateTime = dateFormatter.format(new Date());

			LocalDate currentdate = LocalDate.now();
			Month currentMonth = currentdate.getMonth();

			Calendar calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int min = calendar.get(Calendar.MINUTE);
			int sec = calendar.get(Calendar.SECOND);
			
			String codeUnique=""+year;//202521133656
			String times= ""+currentMonth.getValue()+day+hour+min+sec;
			codeUnique=autoEcole.getCodeUnique()+"-"+year+candidatService.shuffleString(times);
			candidat.setCodeUnique(codeUnique);
			
			boolean created= this.candidatService.saveOrUpdateCandidat(candidat);
			return new ResponseEntity<>(candidat, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
