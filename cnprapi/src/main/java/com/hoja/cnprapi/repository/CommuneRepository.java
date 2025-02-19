package com.hoja.cnprapi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.Commune;


public interface CommuneRepository extends JpaRepository<Commune, Long>{

	
	@Query("SELECT t FROM Commune t")
	List<Commune> getAllCommune();
	
	@Query("SELECT t FROM Commune t where t.activeStatus=true")
	List<Commune> getAllActiveCommune();
	
	@Query("SELECT t FROM Commune t where t.activeStatus=true and t.district.id=?1")
	List<Commune> getAllActiveCommunePlanification(Long districtId);

	@Query("SELECT t FROM Commune t WHERE t.district.id= ?1")
	List<Commune> findAllDistrictsByProvinceId(long districtId);
	

}
