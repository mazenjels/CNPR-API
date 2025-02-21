package com.hoja.cnprapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.CnprPayment;
import com.hoja.cnprapi.repository.PaymentRepository;


@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentRepository paymentRepo;
	
	@Override
	public List<CnprPayment> getAllCnprPayment() {
		// TODO Auto-generated method stub
		return (List<CnprPayment>)paymentRepo.getAllPayment();
	}
	
	public List<CnprPayment> getAllPaymentByAutoEcole(long autoEcoleId) {
		// TODO Auto-generated method stub
		return (List<CnprPayment>)paymentRepo.getAllPaymentByAutoEcole(autoEcoleId);
	}

	@Override
	public List<CnprPayment> getAllActiveCnprPayment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveOrUpdateCnprPayment(CnprPayment pers) {
		CnprPayment payment = paymentRepo.save(pers);

		if (paymentRepo.findById(payment.getId()) != null) {
			return true;
		}
		return false;
	}

	public CnprPayment savePayment(CnprPayment pers) {
		CnprPayment payment = paymentRepo.save(pers);

		if (paymentRepo.findById(payment.getId()) != null) {
			return payment;
		}
		return null;
	}
	
	@Override
	public boolean deleteCnprPaymentById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enableOrDisableCnprPaymentById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CnprPayment getCnprPaymentById(long id) {
		// TODO Auto-generated method stub
		return (CnprPayment) paymentRepo.getById(id);
	}


	
}
