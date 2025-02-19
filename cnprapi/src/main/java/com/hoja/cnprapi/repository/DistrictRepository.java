package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.District;

public interface DistrictRepository extends JpaRepository<District, Long>{

	
	@Query("SELECT t FROM District t")
	List<District> getAllDistrict();

	@Query("SELECT t FROM District t WHERE t.province.id= ?1")
	List<District> findAllDistrictsByProvinceId(Long provinceId);
	
	@Query("SELECT t FROM District t where t.activeStatus=true ")
	List<District> getAllActiveDistrict();
	
	@Query("SELECT t FROM District t where t.activeStatus=true and t.province.id=?1")
	List<District> getAllActiveDistrictPlanification(Long provinceId);
	

}
