package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.CnprDocumentType;


public interface CnprDocumentTypeRepository extends JpaRepository<CnprDocumentType, Long>{


	
//	@Query("SELECT t FROM CnprDocumentType t")
//	Page<CnprDocumentType> getAllAutoEcole(Pageable pageable);
	
	@Query("SELECT t FROM CnprDocumentType t")
	List<CnprDocumentType> getAllCnprDocumentType();
	
	@Query("SELECT t FROM CnprDocumentType t where t.activeStatus=true")
	List<CnprDocumentType> getAllActiveCnprDocumentType();
}
