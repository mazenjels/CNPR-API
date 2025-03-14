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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_cnpr_candidat_subscription",schema = "public")
public class CandidatSubscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	
	@Column(name="montant_a_payer")
	private double montantAPayer;
	
	@Column(name="devise")
	private String devise;
	
	@Column(name = "payment_status")
	private boolean paymentStatus=false;
	
	
	@Column(name = "created_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = false, nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name = "last_updated_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = true, nullable = false)
	@UpdateTimestamp
	private Timestamp lastUpdate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "candidat", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Candidat candidat;
	
	public CandidatSubscription() {

	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public double getMontantAPayer() {
		return montantAPayer;
	}


	public void setMontantAPayer(double montantAPayer) {
		this.montantAPayer = montantAPayer;
	}


	public boolean isPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
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


	public Candidat getCandidat() {
		return candidat;
	}


	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}


	public String getDevise() {
		return devise;
	}


	public void setDevise(String devise) {
		this.devise = devise;
	}

	
}
