package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.PaymentMode;


public interface PaymentModeRepository extends JpaRepository<PaymentMode, Long>{

	
	@Query("SELECT t FROM PaymentMode t")
	List<PaymentMode> getAllPaymentMode();
	
	@Query("SELECT t FROM PaymentMode t where t.activeStatus=true")
	List<PaymentMode> getAllActivePaymentMode();

	
}
