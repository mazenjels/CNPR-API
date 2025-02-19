package com.hoja.cnprapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.models.Formateur;



public interface FormateurRepository extends JpaRepository<Formateur, Long>{

	
}
