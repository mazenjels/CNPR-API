package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.CnprPayment;



public interface PaymentRepository extends JpaRepository<CnprPayment, Long>{

	
	@Query("SELECT t FROM CnprPayment t")
	List<CnprPayment> getAllPayment();
	
	@Query("SELECT t FROM CnprPayment t where t.autoEcole.id=?1")
	List<CnprPayment> getAllPaymentByAutoEcole(long autoEcoleId);
	


}
