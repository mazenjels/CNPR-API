package com.hoja.cnprapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.models.Planification;



public interface CnprAutoEcoleRepository extends JpaRepository<CnprAutoEcole, Long>{

	//@Query("SELECT t FROM CnprAutoEcole t where t.planification.id=?1")
	//public List<CnprAutoEcole> getAllEcoleByPlanificationId(long planificationId);
	
	@Query("SELECT t FROM CnprAutoEcole t")
	public List<CnprAutoEcole> getAllEcoles();
	
	@Query("SELECT t FROM CnprAutoEcole t where t.id=?1")
	public Optional<CnprAutoEcole> getAutoEcoleById(long id);

//	@Query("SELECT t FROM Candidat t where t.id=?1")
//	public CnprAutoEcole getAutoEcoleByCandidatId(long id);
}
