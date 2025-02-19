package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.CnprVehiculeType;


public interface CnprVehiculeTypeRepository extends JpaRepository<CnprVehiculeType, Long>{


	
//	@Query("SELECT t FROM CnprVehiculeType t")
//	Page<CnprVehiculeType> getAllAutoEcole(Pageable pageable);
	
	@Query("SELECT t FROM CnprVehiculeType t")
	List<CnprVehiculeType> getAllCnprVehiculeType();
	
	@Query("SELECT t FROM CnprVehiculeType t where t.activeStatus=true")
	List<CnprVehiculeType> getAllActiveCnprVehiculeType();
}
