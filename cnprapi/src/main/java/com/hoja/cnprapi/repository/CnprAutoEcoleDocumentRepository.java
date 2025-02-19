package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.CnprAutoEcoleDocumentType;


public interface CnprAutoEcoleDocumentRepository extends JpaRepository<CnprAutoEcoleDocumentType, Long>{


	
//	@Query("SELECT t FROM CnprAutoEcoleDocumentType t")
//	Page<CnprAutoEcoleDocumentType> getAllCnprAutoEcoleDocumentType(Pageable pageable);
	
	@Query("SELECT t FROM CnprAutoEcoleDocumentType t")
	List<CnprAutoEcoleDocumentType> getAllCnprAutoEcoleDocumentType();
	
	@Query("SELECT t FROM CnprAutoEcoleDocumentType t where t.cnprAutoEcole.id=?1")
	List<CnprAutoEcoleDocumentType> getAllCnprAutoEcoleDocumentTypeByAutoEcoleid(long id);

	
}
