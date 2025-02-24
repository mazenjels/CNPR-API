package com.hoja.cnprapi.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="tb_cnpr_payment",schema = "public")
public class CnprPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	
	@Column(name="reference")
	private String reference;
	
	@Column(name="amount")
	private long amount=0;
	
	@Column(name="currency_code")
	private String currencyCode;
	
	@Column(name="candidat_code")
	private String candidatCode;
	
	@Column(name="transaction_id")
	private String transactionId;
	
	@Column(name="bank_branch")
	private String bankBranch;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	
	@Column(name="bank")
	private String bank;	
	
	@Column(name="motif")
	private String motif;	
	
	@Column(name="bank_transaction_time")
	private String bankTransactionTime;
	
	@Column(name = "active_status")
	private boolean activeStatus=false;
	
	
	@Column(name = "created_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = false, nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name = "last_updated_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = true, nullable = false)
	@UpdateTimestamp
	private Timestamp lastUpdate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autoEcole", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private CnprAutoEcole autoEcole;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paymentMode", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private PaymentMode paymentMode;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdBy", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private CnprUser createdBy;
	

	public CnprUser getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(CnprUser createdBy) {
		this.createdBy = createdBy;
	}


	public String getBankTransactionTime() {
		return bankTransactionTime;
	}


	public void setBankTransactionTime(String bankTransactionTime) {
		this.bankTransactionTime = bankTransactionTime;
	}


	public CnprPayment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getAmount() {
		return amount;
	}


	public String getCandidatCode() {
		return candidatCode;
	}


	public void setCandidatCode(String candidatCode) {
		this.candidatCode = candidatCode;
	}


	public void setAmount(long amount) {
		this.amount = amount;
	}


	public String getCurrencyCode() {
		return currencyCode;
	}


	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getMotif() {
		return motif;
	}


	public void setMotif(String motif) {
		this.motif = motif;
	}


	public PaymentMode getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}


	public boolean isActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public Timestamp getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	public CnprAutoEcole getAutoEcole() {
		return autoEcole;
	}


	public void setAutoEcole(CnprAutoEcole autoEcole) {
		this.autoEcole = autoEcole;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getBankBranch() {
		return bankBranch;
	}


	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}

	
	
}
