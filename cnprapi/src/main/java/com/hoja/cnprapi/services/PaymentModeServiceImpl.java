package com.hoja.cnprapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.PaymentMode;
import com.hoja.cnprapi.repository.PaymentModeRepository;



@Service
@Transactional
public class PaymentModeServiceImpl implements PaymentModeService{

	@Autowired
	PaymentModeRepository paymentModeRepo;

	@Override
	public List<PaymentMode> getAllPaymentMode() {
		// TODO Auto-generated method stub
		return (List<PaymentMode>)paymentModeRepo.getAllPaymentMode();
	}

	@Override
	public List<PaymentMode> getAllActivePaymentMode() {
		// TODO Auto-generated method stub
		return (List<PaymentMode>)paymentModeRepo.getAllActivePaymentMode();
	}

	@Override
	public boolean saveOrUpdatePaymentMode(PaymentMode pers) {
		// TODO Auto-generated method stub
		PaymentMode paymentMode = paymentModeRepo.save(pers);

		if (paymentModeRepo.findById(paymentMode.getId()) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePaymentModeById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enableOrDisablePaymentModeById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaymentMode getPaymentModeById(long id) {
		// TODO Auto-generated method stub
		return (PaymentMode) paymentModeRepo.getById(id);
	}

	
	
}
