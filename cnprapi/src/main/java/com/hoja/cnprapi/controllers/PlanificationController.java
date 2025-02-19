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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoja.cnprapi.models.AutoEcoleTypePermis;
import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.models.CnprAutoEcoleVehiculeType;
import com.hoja.cnprapi.models.CnprDocumentType;
import com.hoja.cnprapi.models.CnprVehiculeType;
import com.hoja.cnprapi.models.Formateur;
import com.hoja.cnprapi.models.Planification;
import com.hoja.cnprapi.models.TypePermis;
import com.hoja.cnprapi.models.ViewAutoEcole;
import com.hoja.cnprapi.models.ViewPlanification;
import com.hoja.cnprapi.repository.AutoEcoleTypePermisRepository;
import com.hoja.cnprapi.repository.CnprAutoEcoleDocumentRepository;
import com.hoja.cnprapi.repository.CnprAutoEcoleRepository;
import com.hoja.cnprapi.repository.CnprAutoEcoleVehiculeRepository;
import com.hoja.cnprapi.repository.CnprDocumentTypeRepository;
import com.hoja.cnprapi.repository.CnprVehiculeTypeRepository;
import com.hoja.cnprapi.repository.FormateurRepository;
import com.hoja.cnprapi.repository.PlanificationRepository;
import com.hoja.cnprapi.repository.TypePermisRepository;
import com.hoja.cnprapi.repository.ViewAutoEcoleRepository;
import com.hoja.cnprapi.services.AutoEcoleServiceImpl;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/rest")
public class PlanificationController {

	@Autowired
	PlanificationRepository planificationRepo;

	@Autowired
	CnprAutoEcoleRepository autoecoleRepo;

	@Autowired
	AutoEcoleServiceImpl autoecoleServiceImpl;

	@Autowired
	FormateurRepository formateurRepo;

	@Autowired
	TypePermisRepository typePermisRepo;

	@Autowired
	CnprDocumentTypeRepository typeDocumentRepo;

	@Autowired
	CnprVehiculeTypeRepository typevehiculeRepo;

	@Autowired
	CnprAutoEcoleVehiculeRepository autoEcoleTypeVehiculeRepo;

	@Autowired
	CnprAutoEcoleDocumentRepository autoEcoleTypeDocumentRepo;

	@Autowired
	AutoEcoleTypePermisRepository autoEcoleTypePermisRepo;

	@Autowired
	ViewAutoEcoleRepository viewAutoEcoleRepo;

	@GetMapping("/planification")
	public ResponseEntity<List<ViewPlanification>> getAllActivePlanification(
			@RequestParam(required = false) String title) {
		try {
			List<ViewPlanification> planificationa = new ArrayList<ViewPlanification>();

			if (planificationa.size() == 0) {
				planificationRepo.findAll().forEach(p -> {
					if (p.getCurrentStatus().equals("launched") && p.isActiveStatus()== true) {
						planificationa.add(p);
					}
				});
			} else if (planificationa.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(planificationa, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/typepermis")
	public ResponseEntity<List<TypePermis>> getAllActiveTypeBrevet(@RequestParam(required = false) String title) {
		try {
			List<TypePermis> typePermisList = new ArrayList<TypePermis>();

			if (typePermisList.size() == 0) {
				typePermisRepo.findAll().forEach(p -> typePermisList.add(p));
			} else if (typePermisList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(typePermisList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/typevehicules")
	public ResponseEntity<List<CnprVehiculeType>> getAllActiveTypeVehicule(
			@RequestParam(required = false) String title) {
		try {
			List<CnprVehiculeType> typeVehiculeList = new ArrayList<CnprVehiculeType>();

			if (typeVehiculeList.size() == 0) {
				typevehiculeRepo.findAll().forEach(p -> typeVehiculeList.add(p));
			} else if (typeVehiculeList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(typeVehiculeList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/typedocuments")
	public ResponseEntity<List<CnprDocumentType>> getAllActiveTypeDocument(
			@RequestParam(required = false) String title) {
		try {
			List<CnprDocumentType> typeDocumentList = new ArrayList<CnprDocumentType>();

			if (typeDocumentList.size() == 0) {
				typeDocumentRepo.findAll().forEach(p -> typeDocumentList.add(p));
			} else if (typeDocumentList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(typeDocumentList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// @RequestMapping(value = "/planifications", method = RequestMethod.GET)
	@GetMapping("/planifications")
	public ResponseEntity<List<ViewPlanification>> getAllPlanifications() {
		try {
			List<ViewPlanification> autoEcoleList = new ArrayList<ViewPlanification>();
			// Planification plan = new Planification();
			if (autoEcoleList.size() == 0) {
				// autoecoleRepo.getAllEcoleByPlanificationId(planificationId).forEach(p ->
				// autoEcoleList.add(p));

				planificationRepo.findAll().forEach(p -> autoEcoleList.add(p));
			} else if (autoEcoleList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(autoEcoleList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/autoecoles/{planification}")
	public ResponseEntity<List<ViewAutoEcole>> getAllAutoEcoleByPlanification(@PathVariable long planification) {
		try {
			List<ViewAutoEcole> autoEcoleList = new ArrayList<ViewAutoEcole>();
			// Planification plan = new Planification();
			if (autoEcoleList.size() == 0) {
				viewAutoEcoleRepo.getAllAutoEcoleByPlanification(planification).forEach(p -> autoEcoleList.add(p));

				// viewAutoEcoleRepo.getAllAutoEcole().forEach(p -> autoEcoleList.add(p));

				// viewAutoEcoleRepo.findAll().forEach(p -> autoEcoleList.add(p));
			} else if (autoEcoleList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(autoEcoleList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/autoecole")
	public ResponseEntity<CnprAutoEcole> createAutoEcole(@RequestBody CnprAutoEcole autoEcole) {
		try {
			CnprAutoEcole autoecole = autoecoleRepo.save(autoEcole);
			return new ResponseEntity<>(autoecole, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addformateur")
	public ResponseEntity<Formateur> addFormateur(@RequestBody Formateur formateur) {
		try {
			Formateur forma = formateurRepo.save(formateur);
			return new ResponseEntity<>(forma, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addtypevehicule")
	public ResponseEntity<CnprAutoEcoleVehiculeType> addTypeVehicule(
			@RequestBody CnprAutoEcoleVehiculeType autoEcoleTypeVehicule) {
		try {
			CnprAutoEcoleVehiculeType typeVehiculeAddedToAutoEcole = autoEcoleTypeVehiculeRepo
					.save(autoEcoleTypeVehicule);
			return new ResponseEntity<>(typeVehiculeAddedToAutoEcole, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@PostMapping("/ajoutertypedocument")
//	  public CnprAutoEcole addtypedocument(@RequestBody CnprAutoEcole autoEcole) {
//	    try {
//	    	CnprAutoEcole updatedAutoEcole = autoecoleServiceImpl.getAutoEcoleById(autoEcole.getId());
//	    	System.out.println("autoEcole ID : "+autoEcole.getId());;
//	    	return updatedAutoEcole;
//	    } catch (Exception e) {
//	      return null;
//	    }
//	  }

	@PostMapping("/addtypepermis")
	public ResponseEntity<AutoEcoleTypePermis> addTypePermis(@RequestBody AutoEcoleTypePermis autoEcoleTypePermis) {
		try {
			AutoEcoleTypePermis typePermisAddedToAutoEcole = autoEcoleTypePermisRepo.save(autoEcoleTypePermis);
			return new ResponseEntity<>(typePermisAddedToAutoEcole, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
