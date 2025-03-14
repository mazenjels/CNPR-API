package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.PrixTypePermisAutoEcole;




public interface PrixTypePermisRepository extends JpaRepository<PrixTypePermisAutoEcole, Long>{


	
//	@Query("SELECT t FROM TypePermis t")
//	Page<TypePermis> getAllAutoEcole(Pageable pageable);
	
	@Query("SELECT t FROM PrixTypePermisAutoEcole t")
	List<PrixTypePermisAutoEcole> getAllPrixTypePermisAutoEcole();
	
	@Query("SELECT t FROM PrixTypePermisAutoEcole t where t.activeStatus=true")
	List<PrixTypePermisAutoEcole> getAllActivePrixTypePermisAutoEcole();

	@Query("SELECT t FROM PrixTypePermisAutoEcole t where  t.autoEcole.id=?1")
	List<PrixTypePermisAutoEcole> getAllPrixTypePermisAutoEcoleById(long id);
	
	@Query("SELECT t FROM PrixTypePermisAutoEcole t where t.activeStatus=true and t.autoEcole.id=?1 and t.typePermis.id=?2")
	List<PrixTypePermisAutoEcole> getSingleActivePrixTypePermisAutoEcoleByTypePermisAndAutoEcole(long autoEcoleId, long typePermisId);
}
