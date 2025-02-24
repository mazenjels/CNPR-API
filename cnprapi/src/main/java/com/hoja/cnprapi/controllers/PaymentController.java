package com.hoja.cnprapi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
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
import com.hoja.cnprapi.models.CnprPayment;
import com.hoja.cnprapi.models.CnprUser;
import com.hoja.cnprapi.models.PaymentMode;
import com.hoja.cnprapi.models.ViewAutoEcole;
import com.hoja.cnprapi.models.ViewUser;
import com.hoja.cnprapi.repository.ViewUserRepository;
import com.hoja.cnprapi.services.CandidatServiceImpl;
import com.hoja.cnprapi.services.PaymentModeServiceImpl;
import com.hoja.cnprapi.services.PaymentServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/api/cnpr")
public class PaymentController {

	@Autowired
	CandidatServiceImpl candidatServiceImpl;

	@Autowired
	PaymentServiceImpl paymentServiceImpl;

	@Autowired
	PaymentModeServiceImpl paymentModeServiceImpl;

	@SuppressWarnings("unchecked")
	@PostMapping("/paymentRegister")
	public ResponseEntity<String> registerPayment(@RequestBody CnprPayment payment) {
		// bcrypted password 12345=?
		// $2a$10$YmXE9lJhYOi7xt9CGISPeuR1XWtBdmFTeYaP/7UZ6Sj8HDgfE3nxy
		// List<ViewUser> foundUserList =
		// vwUserRepo.findByusernameAndEnabled(login.getUsername(),true);
		try {
			PaymentMode paymentMode = paymentModeServiceImpl.getPaymentModeByDesignation(payment.getBank());
			CnprUser user = new CnprUser();
			user.setId(3);

			CnprAutoEcole autoEcole = new CnprAutoEcole();
			autoEcole.setId(71);

			payment.setPaymentMode(paymentMode);
			payment.setCreatedBy(user);
			payment.setAutoEcole(autoEcole);
			payment.setActiveStatus(true);

			CnprPayment registeredPayment = paymentServiceImpl.savePayment(payment);

			JSONObject json = new JSONObject();
			json.put("statusCode", 1);
			json.put("reference", payment.getReference());
			json.put("transactionId", payment.getTransactionId());
			json.put("message", "paid");

			return new ResponseEntity<>(json.toString(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

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
