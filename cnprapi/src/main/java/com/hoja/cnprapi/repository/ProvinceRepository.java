package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.Province;


public interface ProvinceRepository extends JpaRepository<Province, Long>{

	
	@Query("SELECT t FROM Province t")
	List<Province> getAllProvince();

	@Query("SELECT t FROM Province t where t.activeStatus=true")
	List<Province> getAllActiveProvince();
	

}
