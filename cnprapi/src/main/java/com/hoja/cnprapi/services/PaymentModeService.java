package com.hoja.cnprapi.services;

import java.util.List;

import com.hoja.cnprapi.models.PaymentMode;


public interface PaymentModeService {

	public List<PaymentMode> getAllPaymentMode();

	public List<PaymentMode> getAllActivePaymentMode();

	public boolean saveOrUpdatePaymentMode(PaymentMode pers);

	public boolean deletePaymentModeById(long id);

	public void enableOrDisablePaymentModeById(long id);

	public PaymentMode getPaymentModeById(long id);
}
